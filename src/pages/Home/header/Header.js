import React, { useEffect } from "react";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from "react-responsive-carousel";

import "./Header.css";
import Button from "../../../components/UI/Button/Button";
import Denuncia from "../../../components/denuncia/Denuncia";
import cyberbullying from "../../../assets/cyberbullying.png";

import AOS from "aos";
import "aos/dist/aos.css";

const Header = () => {
  useEffect(() => {
    AOS.init({
      duration: 1000,
    });
  }, []);
  return (
    <section id="header">
      <div className="container header">
        {/* <div className="header-left" data-aos="fade-right">
          <h1>
            <span>Você sabe o que é</span>
            <span>CYBERBULLYING?</span>
          </h1>
          <p className="u-text-small">
          Cyberbullying é o bullying realizado por meio das tecnologias digitais. 
          Pode ocorrer nas mídias sociais, plataformas de mensagens, 
          plataformas de jogos e celulares. É o comportamento repetido, 
          com intuito de assustar, enfurecer ou envergonhar aqueles que 
          são vítimas.
          </p>
          <div className="header-cta">
            <Button text={"Conheça a legislação"} btnClass={"btn-dark"} href={"#"}/>
            
          </div>
        </div>  */}
        <div className="header-right" data-aos="fade-left">
          <div className="carrossel">
            <Carousel
              showArrows={false}
              showStatus={false}
              showThumbs={false}
              ind
            >
              <div>
                <img className="imagem" src={cyberbullying} alt="phone" />
              </div>
              <div>
                <img className="imagem" src={cyberbullying} alt="phone" />
              </div>
              <div>
                <img className="imagem" src={cyberbullying} alt="phone" />
              </div>
            </Carousel>
          </div>
        </div>
      </div>
      <div class="btn-denuncia">
        <Denuncia></Denuncia>
      </div>
    </section>
  );
};

export default Header;
