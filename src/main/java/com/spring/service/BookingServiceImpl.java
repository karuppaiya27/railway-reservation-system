package com.spring.service;

import com.spring.model.Booking;
import com.spring.model.Train;
import com.spring.model.User;
import com.spring.repository.BookingRepository;
import com.spring.repository.TrainRepository;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private TrainRepository trainRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public void bookTrain(Long trainId, int seats) {
        Train train = trainRepo.findById(trainId).orElse(null);
        if (train != null && train.getSeatsAvailable() >= seats) {
            train.setSeatsAvailable(train.getSeatsAvailable() - seats);
            trainRepo.save(train);
        }
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUsername(String username) {
        return bookingRepo.findByUserEmail(username); // Make sure this exists
    }
    
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

}
