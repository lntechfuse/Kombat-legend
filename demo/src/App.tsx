import React from "react";
import { Routes, Route } from "react-router-dom";  
import Home from "./components/Home";
import Mode from "./components/Mode";
import Select from "./components/Select";
import Strategy from "./components/Strategy";  
import Wait from"./components/Wait";

const App: React.FC = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/mode" element={<Mode />} />
      <Route path="/select" element={<Select />} />
      <Route path="/strategy/:role" element={<Strategy />} />  
      <Route path="/wait" element={<Wait />} />  {/* เส้นทางไปหน้า Wait */}
    </Routes>
  );
};

export default App;
