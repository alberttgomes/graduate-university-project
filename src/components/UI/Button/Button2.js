import React from "react";
import "./Button.css";

const Button2 = ({ text, btnClass, onClick }) => {
  return (
    <a className={`btn ${btnClass}`} onClick={() => onClick()}>
      {text}
    </a>
  );
};

export default Button2;
