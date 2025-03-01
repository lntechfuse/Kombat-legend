import React, { useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import "./Select.css";

const roles = ["MAGE", "WARRIOR", "TANK", "ASSASSIN", "CARRY"];
const images = [
  `${process.env.PUBLIC_URL}/Minion/Mage.png`,
  `${process.env.PUBLIC_URL}/Minion/Warrior.png`,
  `${process.env.PUBLIC_URL}/Minion/Tank.png`,
  `${process.env.PUBLIC_URL}/Minion/Assassin.png`,
  `${process.env.PUBLIC_URL}/Minion/Carry.png`
];

const Select: React.FC = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [selectedRoles, setSelectedRoles] = useState<string[]>([]);
  const [showModal, setShowModal] = useState(false); // สร้าง State สำหรับ Modal

  useEffect(() => {
    if (location.state?.resetFromMode) {
      console.log("Resetting selected roles from Mode...");
      localStorage.removeItem("selectedRoles");
      setSelectedRoles([]);
    } else {
      const storedSelected = localStorage.getItem("selectedRoles");
      if (storedSelected) {
        setSelectedRoles(JSON.parse(storedSelected));
      }
    }
  }, [location.state]);

  const handleSelect = (role: string, image: string) => {
    if (selectedRoles.includes(role)) return;

    const updatedSelectedRoles = [...selectedRoles, role];
    setSelectedRoles(updatedSelectedRoles);
    localStorage.setItem("selectedRoles", JSON.stringify(updatedSelectedRoles));

    navigate(`/strategy/${role.toLowerCase()}`, { state: { role, image } });
  };

  const handleReset = () => {
    localStorage.removeItem("selectedRoles");
    setSelectedRoles([]);
  };

  const handleBack = () => {
    navigate("/mode", { state: { resetFromSelect: true } });
  };

  const handleConfirm = () => {
    if (selectedRoles.length === 0) {
      setShowModal(true); // แสดง Modal แทน Alert
      return;
    }
    navigate("/wait");
  };

  return (
    <div className="select-container">
      <div className="character-grid">
        {roles.map((role, index) => (
          <div
            key={role}
            className={`character-card ${selectedRoles.includes(role) ? "selected" : ""}`}
          >
            <img
              src={images[index]}
              alt={role}
              className="character-image"
              onError={(e) => (e.currentTarget.src = "fallback.png")}
            />
            <p className="character-name">{role}</p>
            <button
              className="select-button"
              onClick={() => handleSelect(role, images[index])}
              disabled={selectedRoles.includes(role)}
            >
              {selectedRoles.includes(role) ? "TAKEN" : "SELECT"}
            </button>
          </div>
        ))}
      </div>

      <div className="button-container">
        <button className="back-button" onClick={handleBack}>BACK</button>
        <button className="reset-button" onClick={handleReset}>RESET</button>
        <button className="confirm-button" onClick={handleConfirm}>CONFIRM</button>
      </div>

      {/* Custom Modal แจ้งเตือน */}
      {showModal && (
        <div className="modal-overlay">
          <div className="modal">
            <h2>⚠️ Warning!</h2>
            <p>Please select at least one character before confirming.</p>
            <button className="modal-button" onClick={() => setShowModal(false)}>OK</button>
          </div>
        </div>
      )}
    </div>
  );
};

export default Select;
