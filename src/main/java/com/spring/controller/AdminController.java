package com.spring.controller;

import com.spring.model.Train;
import com.spring.service.BookingService;
import com.spring.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TrainService trainService;

    @Autowired
    private BookingService bookingService;

    // ✅ Admin dashboard
    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin-dashboard";
    }

    // ✅ Show add train form
    @GetMapping("/add-train")
    public String showAddTrainForm(Model model) {
        model.addAttribute("train", new Train());
        return "admin-add-train";
    }

    // ✅ Submit train form
    @PostMapping("/add-train")
    public String addTrain(@ModelAttribute("train") Train train) {
        trainService.saveTrain(train);
        return "redirect:/admin/manage-trains";
    }

    // ✅ Manage trains page
    @GetMapping("/manage-trains")
    public String manageTrains(Model model) {
        model.addAttribute("trains", trainService.getAllTrains());
        return "admin-manage-trains";
    }

    // ✅ Edit train
    @GetMapping("/edit-train/{id}")
    public String editTrain(@PathVariable Long id, Model model) {
        Train train = trainService.getTrainById(id);
        model.addAttribute("train", train);
        return "admin-edit-train";
    }

    // ✅ Update train
    @PostMapping("/update-train")
    public String updateTrain(@ModelAttribute Train train) {
        trainService.saveTrain(train);
        return "redirect:/admin/manage-trains";
    }

    // ✅ View all bookings
    @GetMapping("/bookings")
    public String viewBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "admin-bookings";
    }
    @GetMapping("/delete-train/{id}")
    public String deleteTrain(@PathVariable Long id) {
        trainService.deleteTrainById(id);
        return "redirect:/admin/manage-trains";
    }

}
