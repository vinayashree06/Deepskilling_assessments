import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState('');

  const handleChange = (e) => {
    setRupees(e.target.value);
  };

  const handleSubmit = () => {
    const converted = (parseFloat(rupees) / 90).toFixed(2); 
    setEuro(converted);
  };

  return (
    <div>
      <h2>Currency Convertor</h2>
      <input
        type="number"
        placeholder="Enter amount in INR"
        value={rupees}
        onChange={handleChange}
      />
      <button onClick={handleSubmit}>Convert</button>
      <p>Amount in Euro: €{euro}</p>
    </div>
  );
}

export default CurrencyConvertor;
