import React from 'react';

function ListofPlayers() {
  const players = [
    { name: 'Virat Kohli', score: 95 },
    { name: 'Rohit Sharma', score: 85 },
    { name: 'KL Rahul', score: 45 },
    { name: 'Shubman Gill', score: 65 },
    { name: 'Rishabh Pant', score: 75 },
    { name: 'Hardik Pandya', score: 55 },
    { name: 'Suryakumar Yadav', score: 88 },
    { name: 'Ravindra Jadeja', score: 35 },
    { name: 'Jasprit Bumrah', score: 72 },
    { name: 'Mohammed Shami', score: 60 },
    { name: 'Yuzvendra Chahal', score: 50 }
  ];

  const lowScorePlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players:</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - Score: {player.score}
          </li>
        ))}
      </ul>

      <h2>Players with score below 70:</h2>
      <ul>
        {lowScorePlayers.map((player, index) => (
          <li key={index}>
            {player.name} - Score: {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;
