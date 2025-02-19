import React from "react";
import { useNavigate } from "react-router-dom";
import "./Home.css";

const Home: React.FC = () => {
  const navigate = useNavigate();  // 

  return (
    <div className="game-menu">
      <button className="start-button" onClick={() => navigate("/mode")}>
        START
      </button>
    </div>
  );
};

export default Home;
