<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Msg</title>
</head>
<body>
	<h2>You reservation is confirmed And the reservation id is ${reservation.id} .</h2>
	<%-- ${msg} --%>
	First Name : ${firstName}<br/> 
	Last Name : ${lastName }<br/> 
	MiddleName:${middleName }<br/>
	email:${email }<br/>
    phone:${phone }<br/>
	<br /> Operating Airlines:${flight.operatingAirlines}
	<br /> Departure City:${flight.departureCity}
	<br /> Arrival City:${flight.arrivalCity}
	<br /> dateOfDeparture :${flight.dateOfDeparture }
	<br />estimatedDepartureTime:${flight.estimatedDepartureTime}

</body>
</html>