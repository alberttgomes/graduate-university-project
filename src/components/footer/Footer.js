import React from "react";
import "./Footer.css";
import {
  FaGlobe,
  FaInstagram
} from "react-icons/fa";

const Footer = () => {
  return (
    <section id="footer">
      <div className="container footer">
        <div className="footer-box">
          <h3>Social</h3>
          <div className="footer-contact u-text-small">
            <p>
              <FaInstagram size="20px"/> &nbsp; https://www.instagram.com/placamae.org_/
            </p>
            <p>
              <FaGlobe size="20px" /> &nbsp; Website: placamae.org
            </p>
          </div>
        </div>
        <div className="footer-box">
          <h3>Contato</h3>
          <h1>contato@placamae.org <br></br>
              Rua Marques do Herval, 167/902 Box 31, <br></br>
              CEP 50020-30 
          </h1>
          <p className="u-text-small">&copy; Copyright 2021. PlacaMãe.com</p>
        </div>
      </div>
    </section>
  );
};

export default Footer;
