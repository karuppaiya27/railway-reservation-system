package com.spring.controller;

import com.spring.model.Booking;
import com.spring.model.Train;
import com.spring.model.User;
import com.spring.repository.UserRepository;
import com.spring.service.BookingService;
import com.spring.service.TrainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/book")
    public String bookTrainForm(@RequestParam("trainId") Long trainId, Model model) {
        Train train = trainService.getTrainById(trainId);
        model.addAttribute("train", train);
        return "book";
    }

    @PostMapping("/book")
    public String bookTrain(@RequestParam("trainId") Long trainId,
                            @RequestParam("seats") int seats,
                            Authentication authentication,
                            Model model) {

        String username = authentication.getName();
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + username));

        Train train = trainService.getTrainById(trainId);

        if (train.getSeatsAvailable() >= seats) {
            Booking booking = new Booking();
            booking.setTrain(train);
            booking.setUser(user);
            booking.setSeats(seats); 

            bookingService.saveBooking(booking);

            // Update available seats
            train.setSeatsAvailable(train.getSeatsAvailable() - seats);
            trainService.saveTrain(train);

            model.addAttribute("message", "Booking successful!");
            return "redirect:/my-bookings";
        } else {
            model.addAttribute("error", "Not enough seats available.");
            model.addAttribute("train", train);
            return "book";
        }
    }
    
    @GetMapping("/my-bookings")
    public String viewMyBookings(Model model, Authentication authentication) {
        String username = authentication.getName();
        List<Booking> bookings = bookingService.getBookingsByUsername(username);
        model.addAttribute("bookings", bookings);
        return "my-bookings";
    }

}
