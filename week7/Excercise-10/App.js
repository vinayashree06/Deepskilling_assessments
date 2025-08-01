import React from 'react';
import './App.css';

function App() {
  const officeImage ='https://tse1.mm.bing.net/th/id/OIP.WmTjgU3p75hTry9JlIBVmwHaFW?rs=1&pid=ImgDetMain&o=7&rm=3';
  const office = {
    name: 'Prestige Tech Park',
    rent: 55000,
    address: 'Whitefield, Bangalore'
  };

  const officeSpaces = [
    { id: 1, name: 'Embassy Golf Links', rent: 75000, address: 'Domlur, Bangalore' },
    { id: 2, name: 'Manyata Tech Park', rent: 50000, address: 'Hebbal, Bangalore' },
    { id: 3, name: 'RMZ EcoWorld', rent: 90000, address: 'Bellandur, Bangalore' },
    { id: 4, name: 'Bagmane Tech Park', rent: 45000, address: 'CV Raman Nagar, Bangalore' }
  ];

  return (
    <div className="App">
     
      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office Space"
        style={{ width: '500px', height: '300px', objectFit: 'cover' }}
      />

      
      <h2>Featured Office:</h2>
      <p><strong>Name:</strong> {office.name}</p>
      <p>
        <strong>Rent:</strong>{' '}
        <span
          style={{ color: office.rent < 60000 ? 'red' : 'green' }}
        >
          ₹{office.rent}
        </span>
      </p>
      <p><strong>Address:</strong> {office.address}</p>

      
      <h2>Other Office Spaces:</h2>
      {officeSpaces.map(space => (
        <div key={space.id} style={{ border: '1px solid #ccc', margin: '10px', padding: '10px' }}>
          <p><strong>Name:</strong> {space.name}</p>
          <p>
            <strong>Rent:</strong>{' '}
            <span
              style={{ color: space.rent < 60000 ? 'red' : 'green' }}
            >
              ₹{space.rent}
            </span>
          </p>
          <p><strong>Address:</strong> {space.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
