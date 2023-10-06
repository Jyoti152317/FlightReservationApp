<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Flights</title>
</head>
<body>
	<h2>Available Flights</h2>
	<table border="1">
		<tr>
		<th>Flight Number</th>
		<th>Operating Airline</th>
		<th>Arrival City</th>
		<th>Departure City</th>
		<th>Departure Date</th>
		<th>Select Flight</th>
		</tr>
	<c:forEach items="${flights}" var="flight">
		<tr>
			<td>${flight.flightNumber}</td>
			<td>${flight.operatingAirlines}</td>
			<td>${flight.departureCity}</td>
			<td>${flight.arrivalCity}</td>
			<td>${flight.estimatedDepartureTime}</td>
			<td><a href="showCompleteReservation?flightId=${flight.id}">select</a></td>
		</tr>
	
	</c:forEach> 
	</table>
</body>
</html>