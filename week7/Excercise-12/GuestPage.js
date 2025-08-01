import React from 'react';

function GuestPage() {
  const flights = [
    { id: 1, from: 'Bangalore', to: 'Delhi', time: '10:00 AM' },
    { id: 2, from: 'Mumbai', to: 'Chennai', time: '12:30 PM' },
    { id: 3, from: 'Hyderabad', to: 'Kolkata', time: '03:45 PM' }
  ];

  return (
    <div>
      <h2>Guest Page</h2>
      <h3>Available Flights:</h3>
      <ul>
        {flights.map(flight => (
          <li key={flight.id}>
            {flight.from} → {flight.to} at {flight.time}
          </li>
        ))}
      </ul>
      <p>Please login to book tickets.</p>
    </div>
  );
}

export default GuestPage;
