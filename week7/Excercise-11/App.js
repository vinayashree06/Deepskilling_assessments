import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(count + 1);
  };

  const sayHello = () => {
    console.log('Hello! Have a great day!');
    alert('Hello! Have a great day!');
  };

  const handleIncrementClick = () => {
    increment();
    sayHello();
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleSyntheticEvent = () => {
    alert('I was clicked');
  };

  return (
    <div className="App">
      <h1>Event Examples App</h1>

      <h2>Counter: {count}</h2>
      <button onClick={handleIncrementClick}>Increment</button>
      <button onClick={decrement}>Decrement</button>

      <br /><br />

      <button onClick={() => sayWelcome('Welcome!')}>Say Welcome</button>

      <br /><br />

      <button onClick={handleSyntheticEvent}>Click Me (Synthetic Event)</button>

      <br /><br />

      <CurrencyConvertor />
    </div>
  );
}

export default App;
