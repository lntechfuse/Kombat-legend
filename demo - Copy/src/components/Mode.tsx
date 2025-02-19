import React from "react";
import "./Mode.css";

const Mode: React.FC = () => {
  return (
    <div className="container">
     
      {/* Buttons */}
      <div className="button-group">
        <button className="button primary">PLAYER VS GM</button>
        <button className="button secondary">Auto</button>
        <button className="button secondary">Multiplayer</button>
      </div>
    </div>
  );
};

export default Mode;
