package com.xyz.FlightReservationApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xyz.FlightReservationApp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query
	User findByEmail(String email);

}
