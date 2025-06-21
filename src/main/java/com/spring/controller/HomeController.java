package com.spring.controller;

import com.spring.model.Train;
import com.spring.repository.TrainRepository;
import com.spring.service.BookingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private TrainRepository trainRepo;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<Train> trains = trainRepo.findAll(); // Ensure this returns data
        model.addAttribute("trains", trains);
        return "home"; // Should map to home.html
    }


  
}
