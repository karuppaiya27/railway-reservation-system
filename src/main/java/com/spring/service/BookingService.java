package com.spring.service;

import com.spring.model.Booking;

import java.util.List;

public interface BookingService {
    void bookTrain(Long trainId, int seats);
    Booking saveBooking(Booking booking);
    List<Booking> getBookingsByUsername(String username);
    
    // This is the missing method:
    List<Booking> getAllBookings();
}
