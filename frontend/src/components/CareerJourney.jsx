// src/components/CareerJourney.jsx
import React from "react";
import InputBox from "./InputBox.jsx";
import styled from "styled-components";
import WesternLogo from "../assets/western-university-logo.png";

const CareerJourney = () => {
  const handleSubmit = (career) => {
    console.log(`Generating course journey for: ${career}`);
  };

  return (
    <JourneyContainer>
      <Logo src={WesternLogo} alt="Western University Logo" />
      <Title>Discover Your Path</Title>
      <Subtitle>Enter your career goal to start your journey</Subtitle>
      <InputBox onSubmit={handleSubmit} />
    </JourneyContainer>
  );
};

export default CareerJourney;

const JourneyContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  padding: 40px;
  background: #ffffff;
  border-radius: 12px;
  width: 100%;
  max-width: 500px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2), 0 6px 20px rgba(0, 0, 0, 0.19); /* Material-inspired shadow */
`;

const Logo = styled.img`
    width: 100px;
    height: auto;
    margin-bottom: 20px;
`;

const Title = styled.h1`
    font-size: 2.4rem;
    color: #4f2683; /* Western purple */
    font-family: 'Roboto', sans-serif;
    margin: 0;
`;

const Subtitle = styled.p`
    font-size: 1rem;
    color: #333;
    margin-top: 10px;
    margin-bottom: 30px;
    font-family: 'Roboto', sans-serif;
`;
