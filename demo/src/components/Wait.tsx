import React from "react";
import { useNavigate } from "react-router-dom";
import "./Wait.css";

const Wait: React.FC = () => {
  const navigate = useNavigate();

  return (
    <div className="wait-container">
      <h1>Waiting for Other Players...</h1>
      <p>Please wait while other players join the game.</p>

      <button className="back-button" onClick={() => navigate("/mode")}>
        Back to Mode Selection
      </button>
    </div>
  );
};

export default Wait;
