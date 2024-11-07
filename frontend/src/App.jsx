// src/App.jsx
import React from "react";
import CareerJourney from "./components/CareerJourney.jsx";
import { GlobalStyles } from "./styles/GlobalStyles.js";

const App = () => {
  return (
    <>
      <GlobalStyles />
      <CareerJourney />
    </>
  );
};

export default App;
