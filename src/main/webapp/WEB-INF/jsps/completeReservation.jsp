<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Your Registration</title>
</head>
<body>
	<h2>Confirm Your Registration</h2>
	Flight Number:${flight.flightNumber}
	<br /> Operating Airlines:${flight.operatingAirlines}
	<br /> Departure City:${flight.departureCity}
	<br /> Arrival City:${flight.arrivalCity}
	<br /> Estimated Departure Time:${flight.estimatedDepartureTime}
	<br />

	<form action="confirmRegistration" method="post">
		<pre>
		<h2>Enter passenger details</h2>
		First Name<Input type="text" name="firstName" /> 
		Last Name<Input type="text" name="lastName" /> 
		Middle Name<Input type="text" name="middleName" />
		Email Id<Input type="text" name="email" /> 
		Mobile Number<Input type="text" name="phone" />
		<input type="hidden" name="flightId" value="${flight.id }"/>
		<h2>Enter card details</h2>
		card Number:<input type="text" name="cardNumber" />
		card holder name:<input type="text" name="cardHolderName" />
	    Expiration Date:<input type="text" name="expirationDate" />
	    cvv:<input type="text" name="cvvCode" />
	    Amount:<input type="text" name="amount"/>
	    <input type="hidden" name="flightId" value="${flight.id}" />
	    <input type="submit" value="confirm and pay" />
	    </pre>
	</form>
</body>
</html>