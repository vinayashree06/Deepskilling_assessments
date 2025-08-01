import React from 'react';

function IndianPlayers() {
  const players = [
    'Virat Kohli',
    'Rohit Sharma',
    'KL Rahul',
    'Shubman Gill',
    'Rishabh Pant',
    'Hardik Pandya'
  ];

  const oddPlayers = [];
  const evenPlayers = [];

  players.forEach((player, index) => {
    if ((index + 1) % 2 === 0) {
      evenPlayers.push(player);
    } else {
      oddPlayers.push(player);
    }
  });


  const [odd1, odd2, odd3] = oddPlayers;
  const [even1, even2, even3] = evenPlayers;

  const T20players = ['Suryakumar Yadav', 'Ishan Kishan'];
  const RanjiTrophyPlayers = ['Prithvi Shaw', 'Mayank Agarwal'];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players:</h2>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        <li>{odd3}</li>
      </ul>

      <h2>Even Team Players:</h2>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        <li>{even3}</li>
      </ul>

      <h2>List of Merged Players:</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;
