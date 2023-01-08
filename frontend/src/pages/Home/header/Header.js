import React, { useEffect } from "react";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from "react-responsive-carousel";
import "./Header.css";
import Denuncia from "../../../components/denuncia/Denuncia";
import cyberbullying from "../../../assets/cyberbullying.svg";
import placamaeIG from "../../../assets/placamaeIg.png";
import placamaeIG1 from "../../../assets/brinquedodesucata.png";
import placamaeIG2 from "../../../assets/gamesacessibilidade.png"
import AOS from "aos";
import "aos/dist/aos.css";

const Header = () => {
  
  useEffect(() => {
    AOS.init({
      duration: 1000,
    });
  }, []);

  const data = {
    item:{
      dumb: placamaeIG2,
      id: 2,
      url:"https://www.instagram.com/p/CbxXJPWtepN/"
    },
    item1:{
      dumb: placamaeIG,
      id: 1,
      url:"https://www.instagram.com/p/CcF9VxrMCaJ/"
    },
    item2:{
      dumb: placamaeIG1,
      id: 2,
      url:"https://www.instagram.com/p/Cgo7IB2sW8e/"
    },
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
              <a href={data.item.url} target="_blank">
                <div>
                  <img src={data.item.dumb} alt="phone" />
                </div>
              </a>
              <a href={data.item1.url} target="_blank">
                <div>
                  <img src={data.item1.dumb} alt="instagram" />
                </div>
              </a>
              <a href={data.item2.url} target="_blank">
                <div>
                  <img src={data.item2.dumb} alt="phone" />
                </div>
              </a>
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
