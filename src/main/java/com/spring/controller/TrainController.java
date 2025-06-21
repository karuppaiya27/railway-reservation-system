package com.spring.controller;

import com.spring.model.Train;
import com.spring.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/trains")
    public String showTrainsPage(Model model,
                                  @RequestParam(value = "source", required = false) String source,
                                  @RequestParam(value = "destination", required = false) String destination) {

        List<Train> trains;
        if (source != null && destination != null) {
            trains = trainService.findBySourceAndDestination(source, destination);
        } else {
            trains = trainService.getAllTrains();
        }

        model.addAttribute("trains", trains);
        return "trains"; // ➡ templates/trains.html
    }
    @GetMapping("/search")
    public String showSearchPage() {
        return "search-train";
    }

    @GetMapping("/search-trains")
    public String searchTrains(@RequestParam String source,
                               @RequestParam String destination,
                               Model model) {
        List<Train> trains = trainService.findBySourceAndDestination(source, destination);
        model.addAttribute("trains", trains);
        return "search-train";
    }

}
