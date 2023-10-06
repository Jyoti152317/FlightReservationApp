package com.xyz.FlightReservationApp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.FlightReservationApp.entity.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
