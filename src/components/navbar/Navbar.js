import React, { useState } from "react";
import { AiOutlineBars } from "react-icons/ai";
import { RiCloseLine } from "react-icons/ri";
import Button from "../UI/Button/Button";
import "../UI/Button/Button.css";
import Lua from "../../assets/lua.svg";

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
            <Button text={"Home"} href={"/"} /> 
          </li>
          <li>
            <Button text={"Materiais"} href={"/materiais"} />
          </li>
          <li>
            <Button text={"Jogos"} href={"/quemsomos"} /> 
          </li>
          <li>
            <Button text={"Sobre"} href={"/sobre"} />
          </li>

          <li>
            <Button text={"Login"} href={"/login"} />
          </li>
          <li className="nav-btn">
            <Button
              text={"Cadastre-se"}
              btnClass={"btn-dark"}
              href={"/cadastro"}
            />
          </li>
          <li>
            <img className="lua" src={Lua}></img>
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
