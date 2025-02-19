import React from "react";
import { Routes, Route } from "react-router-dom";  // ไม่ต้อง import Router อีก
import Home from "./components/Home";
import Mode from "./components/Mode";

const App: React.FC = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/mode" element={<Mode />} />
    </Routes>
  );
};

export default App;
