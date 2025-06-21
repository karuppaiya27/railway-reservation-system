package com.spring.service;

import com.spring.model.Train;
import com.spring.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    // ✅ Correctly defined delete method
    public void deleteTrainById(Long id) {
        trainRepository.deleteById(id);
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public List<Train> findBySourceAndDestination(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }

    public Train getTrainById(Long id) {
        return trainRepository.findById(id).orElse(null);
    }

    public void saveTrain(Train train) {
        trainRepository.save(train);
    }
}
