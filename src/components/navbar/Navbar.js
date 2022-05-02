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
      <div className="logo">      
        <img src={logo} alt="logo" /> 
      </div>
      <menu className="menu">
        <ul
          className="nav-links"
          id={showMenu ? "nav-links-mobile" : "nav-links-mobile-hide"}
        >
          <li>
          <Link to="/">Home</Link>
          </li>
          <li>
          <Link to="/quemsomos">Quem Somos</Link>
          </li>
          <li>
            <a href="#download">Nossas ações</a>
          </li>
          <li>


            <Link to="/materiais">Materiais</Link>

          </li>

          <li className="nav-btn">
            <Button text={"Atividades pedagógicas"} btnClass={"btn-dark"} href={"#faq"} />
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
