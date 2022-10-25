import React from "react";
import "./Sobre.css";
import Button from "../../components/UI/Button/Button";
import Denuncia from "../../components/denuncia/Denuncia";
import Aos from 'aos';


const Sobre = () => {
  Aos.init();
  return (
    <section id="header" class="header1 ">
      <div className="container header">
        <div
          className="header-left"
          data-aos="fade-right"
          data-aos-offset="300"
          data-aos-easing="ease-in-sine">
          <h1>
            <span>SOBRE</span>
          </h1>
          <p className="sobre">
            Lorem Ipsum is simply dummy text of the printing and typesetting
            industry. Lorem Ipsum has been the industry's standard dummy text
            ever since the 1500s, when an unknown printer took a galley of type
            and scrambled it to make a type specimen book. It has survived not
            only five centuries, but also the leap into electronic typesetting,
            remaining essentially unchanged. It was popularised in the 1960s
            with the release of Letraset sheets containing Lorem Ipsum passages,
            and more recently with desktop publishing software like Aldus
            PageMaker including versions of Lorem Ipsum
          </p>
          <div className="header-cta">
            <Button text={"Ver mais"} btnClass={"btn-verMais"} href={"#"} />
          </div>
        </div>
      </div>
      <div class="btn-denuncia">
        <Denuncia></Denuncia>
      </div>
    </section>
  );
};

export default Sobre;
