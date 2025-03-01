import React, { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "./Strategy.css";

const StrategyForm: React.FC = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const { role, image } = location.state || {}; // รับค่าจาก state ที่ถูกส่งมา

  const [name, setName] = useState("");
  const [strategy, setStrategy] = useState("");
  const [defense, setDefense] = useState("");

  const handleSelect = () => {
    localStorage.setItem("playerName", name); // เก็บชื่อไว้ใน localStorage
    navigate("/select", { state: { name } }); // ส่งค่าไปที่หน้า Select
  };
  
  return (
    <div className="container">
      <div className="form-box">
        <div className="avatar-section">
          {image && <img src={image} alt={role} className="avatar" />} 
          <input
            type="text"
            placeholder="ENTER YOUR NAME"
            className="input-box"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <button className="select-button" onClick={handleSelect}>
            SELECT
          </button>
        </div>

        <div className="text-area-section">
          <div className="text-area-box">
            <h2 className="title">STRATEGY</h2>
            <textarea
              placeholder="ENTER YOUR STRATEGY"
              className="text-area"
              value={strategy}
              onChange={(e) => setStrategy(e.target.value)}
            />
          </div>
          <div className="text-area-box">
            <h2 className="title">DEFENSE</h2>
            <textarea
              placeholder="ENTER YOUR DEFENSE"
              className="text-area"
              value={defense}
              onChange={(e) => setDefense(e.target.value)}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default StrategyForm;
