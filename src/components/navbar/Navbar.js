import React, { useState } from "react";
import { AiOutlineBars } from "react-icons/ai";
import { RiCloseLine } from "react-icons/ri";
import Button from "../UI/Button/Button";
import "../UI/Button/Button.css";
import logo from "../../assets/logo.png";
import { Link } from "react-router-dom";

import "./Navbar.css";

const Navbar = () => {
  const [showMenu, setShowMenu] = useState(false);

  const toggleMenu = () => {
    setShowMenu(!showMenu);
  };
  return (
    <nav className="navbar">
      
      <menu className="menu">
        <ul
          className="nav-links"
          id={showMenu ? "nav-links-mobile" : "nav-links-mobile-hide"}
        >
          <li>
          <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/materiais">Materiais</Link>
          </li>
          <li>
          <Link to="/quemsomos">Jogos</Link>
          </li>
          <li>
            <Link to="#download">Sobre</Link>
          </li>
          
          <li>
            <Button text={"Login"} href={"#faq"} />
          </li>
          <li className="nav-btn">
            <Button text={"Cadastre-se"} btnClass={"btn-dark"} href={"#faq"} />
          </li>
          </ul>
      </menu>
      <div className="menu-icons" onClick={toggleMenu}>
        {showMenu ? (
          <RiCloseLine color="#fff" size={30} />
        ) : (
          <AiOutlineBars color="#fff" size={27} />
        )}
      </div>
    </nav>
  );
};

export default Navbar;
