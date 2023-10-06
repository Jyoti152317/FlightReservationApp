package com.xyz.FlightReservationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.FlightReservationApp.entity.Passenger;



public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
