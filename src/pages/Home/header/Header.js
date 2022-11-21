import React, { useEffect } from "react";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from "react-responsive-carousel";
import "./Header.css";
import Denuncia from "../../../components/denuncia/Denuncia";
import cyberbullying from "../../../assets/cyberbullying.svg";
import placamaeIG from "../../../assets/placamaeIg.png";
import AOS from "aos";
import "aos/dist/aos.css";

const Header = () => {
  
  useEffect(() => {
    AOS.init({
      duration: 1000,
    });
  }, []);

  const data = {
    item: {
      dumb: placamaeIG,
      id: 1,
      url:"https://www.instagram.com/p/CcF9VxrMCaJ/"
    }
  }
  return (
    <section id="header">
      <div className="container header">
        <div className="header-right" data-aos="fade-left">
          <div className="carrossel" style={{ width: 500, margin: 30 }}>
            <Carousel
              showArrows={false}
              showStatus={false}
              showThumbs={false}
              touches={true}
              ind
            >
              <div>
                <img src={cyberbullying} alt="phone" />
              </div>
              <a href={data.item.url} target="_blank">
                <div>
                  <img src={data.item.dumb} alt="instagram" />
                </div>
              </a>
              
              <div>
                <img src={cyberbullying} alt="phone" />
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
