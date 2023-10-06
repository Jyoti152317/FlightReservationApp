package com.xyz.FlightReservationApp.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.FlightReservationApp.entity.Flight;
import com.xyz.FlightReservationApp.entity.Passenger;
import com.xyz.FlightReservationApp.entity.Reservation;
import com.xyz.FlightReservationApp.repository.FlightRepository;
import com.xyz.FlightReservationApp.repository.PassengerRepository;
import com.xyz.FlightReservationApp.repository.ReservationRepository;
import com.xyz.FlightReservationApp.util.PDFgenerator;
import com.xyz.FlightReservationApp.util.SendEmail;


@Controller
public class ReservationController {
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationController.class);
	private static String folderPath="D:\\SpringBoot_workspace\\FlightReservationApp\\tickets\\";
	@Autowired
	FlightRepository flightRepo;

	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	PassengerRepository passengerRepo;
	
	@Autowired
    PDFgenerator pdfGen;
	
	@Autowired
	SendEmail sendEmail;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("inside showCompleteReservation()");
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

	@RequestMapping("/confirmRegistration")
	public String confirmRegistration( @RequestParam("flightId") Long flightId,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			 @RequestParam("middleName" ) String middleName,  @RequestParam("email") String email, @RequestParam("phone") String phone,  ModelMap modelMap) {
		LOGGER.info("inside confirmRegistration()");
		

		Passenger passenger=new Passenger();
		passenger.setFirstName(firstName);
		passenger.setLastName(lastName);
		passenger.setMiddleName(middleName);
		passenger.setEmail(email);
		passenger.setPhone(phone);
		
		passengerRepo.save(passenger);
		
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		Reservation reservation=new Reservation();
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		
		reservationRepo.save(reservation);
		
		modelMap.addAttribute("firstName", firstName);
		modelMap.addAttribute("lastName", lastName);
		modelMap.addAttribute("middleName", middleName);
		modelMap.addAttribute("email", email);
		modelMap.addAttribute("phone", phone);
		modelMap.addAttribute("flight", flight);
		modelMap.addAttribute("reservation", reservation);
//		String estimatedDepartureTime=flight.getEstimatedDepartureTime().toString();
//		pdfGen.generatePDF("D:/firstPdf1.pdf",passenger.getFirstName(),passenger.getEmail(),passenger.getPhone(),flight.getOperatingAirlines(),estimatedDepartureTime,flight.getArrivalCity(),flight.getDepartureCity());
		String estimatedDepartureTime=flight.getEstimatedDepartureTime().toString();
		pdfGen.generatePDF(folderPath+"ticket"+passenger.getId()+".pdf",passenger.getFirstName(),passenger.getEmail(),passenger.getPhone(),flight.getOperatingAirlines(),estimatedDepartureTime,flight.getArrivalCity(),flight.getDepartureCity());
//		sendEmail.sendTicketEmail(passenger.getEmail(),"xyz","pls gt your tikt",folderPath+"ticket"+passenger.getId()+".pdf");
		return "finalConfirmation";
	}

}
