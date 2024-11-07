// src/components/InputBox.jsx
import React, { useState } from "react";
import styled from "styled-components";

const InputBox = ({ onSubmit }) => {
  const [career, setCareer] = useState("");

  const handleChange = (e) => setCareer(e.target.value);

  const handleSubmit = () => {
    if (career) onSubmit(career);
  };

  return (
    <Container>
      <StyledInput
        type="text"
        value={career}
        onChange={handleChange}
        placeholder="Enter your dream career"
      />
      <StyledButton onClick={handleSubmit}>Create My Course Journey</StyledButton>
    </Container>
  );
};

export default InputBox;

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
`;

const StyledInput = styled.input`
    width: 100%;
    max-width: 400px;
    padding: 12px;
    font-size: 1rem;
    border-radius: 8px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    text-align: center;
    outline: none;
    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
    &:focus {
        border-color: #4f2683; /* Western purple */
        box-shadow: 0px 0px 8px rgba(79, 38, 131, 0.3);
    }
`;

const StyledButton = styled.button`
    width: 100%;
    max-width: 400px;
    padding: 10px;
    font-size: 1rem;
    color: #ffffff;
    background-color: #4f2683; /* Western purple */
    border: none;
    border-radius: 8px;
    cursor: pointer;
    box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
    transition: background-color 0.3s;
    font-weight: bold;
    &:hover {
        background-color: #3a1c63;
    }
`;
