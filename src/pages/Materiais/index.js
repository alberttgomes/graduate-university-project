import { useEffect } from "react";
import "./Materiais.css";
import AOS from "aos";
import "aos/dist/aos.css";
import Button from "../../components/UI/Button/Button";
import Denuncia from "../../components/denuncia/Denuncia";

const Materiais = () => {
  useEffect(() => {
    AOS.init({
      duration: 1000,
    });
  }, []);

  return (
    <section id="materiais">
      <div className="container">
        <div className="box">
          <h3></h3>
        </div>
        <div className="box">
          <h3></h3>
        </div>
        <div className="box">
          <h3></h3>
        </div>
        <div className="verMais">
          <Button text={"Ver Mais"} btnClass={"btn-verMais"} />
        </div>
      </div>

      <div className="btn-denuncia">
        <Denuncia></Denuncia>
      </div>
    </section>
  );
};
export default Materiais;
