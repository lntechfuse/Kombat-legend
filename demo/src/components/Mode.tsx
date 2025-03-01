import React from "react";
import { useNavigate } from "react-router-dom"; // ✅ Import useNavigate
import "./Mode.css";

const Mode: React.FC = () => {
  const navigate = useNavigate(); // ✅ สร้างตัวแปร navigate

  return (
    <div className="container">
      {/* Buttons */}
      <div className="button-group">
        <button className="button primary" onClick={() => navigate("/select")}>Duel</button>
        <button className="button secondary" onClick={() => navigate("/select")}>Solitaire</button>
        <button className="button secondary" onClick={() => navigate("/select")}>Auto</button>
      </div>
    </div>
  );
};

export default Mode;
