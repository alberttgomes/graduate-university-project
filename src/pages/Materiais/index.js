
import {
    Footer
  } from "../../components";
import React, { useEffect } from "react";
import "./Materiais.css";
import AOS from "aos";
import "aos/dist/aos.css";

const Materiais = () => {
  useEffect(() => {
    AOS.init({
      duration: 1000,
    });
  }, []);

return (
    <section id="materiais">
        <div class="container">
          <div class="box">
              <h3>Materiais crianças e adolescentes</h3>
              <button type="button" id="expandir">Expandir</button>
          </div>
          <div class="box">
              <h3>Materiais pais e responsáveis</h3>
              <button type="button" id="expandir">Expandir</button>
          </div>
          <div class="box">
              <h3>Materiais crianças e educadores</h3>
              <button type="button" id="expandir">Expandir</button>
          </div>
        </div>
        
        <Footer/>
    </section>
    
);

};
export default Materiais;
