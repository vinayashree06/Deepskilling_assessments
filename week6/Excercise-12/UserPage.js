import React from 'react';

function UserPage() {
  const flights = [
    { id: 1, from: 'Bangalore', to: 'Delhi', time: '10:00 AM' },
    { id: 2, from: 'Mumbai', to: 'Chennai', time: '12:30 PM' },
    { id: 3, from: 'Hyderabad', to: 'Kolkata', time: '03:45 PM' }
  ];

  const handleBooking = (flight) => {
    alert(`Ticket booked for flight from ${flight.from} to ${flight.to} at ${flight.time}`);
  };

  return (
    <div>
      <h2>User Page</h2>
      <h3>Available Flights (Click to Book):</h3>
      <ul>
        {flights.map(flight => (
          <li key={flight.id}>
            {flight.from} → {flight.to} at {flight.time}
            {' '}
            <button onClick={() => handleBooking(flight)}>Book Ticket</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UserPage;
