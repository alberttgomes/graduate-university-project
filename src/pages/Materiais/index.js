

import { useEffect} from "react";
import "./Materiais.css";
import AOS from "aos";
import "aos/dist/aos.css";
import Button from "../../components/UI/Button/Button";
import { Link } from "react-router-dom";

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
              <h3>Materiais crianças e adolescentes</h3>
              <button type="button" id="expandir">Expandir</button>
          </div>
          <div className="box" >
              <h3>Materiais pais e responsáveis</h3>
              <button type="button" id="expandir" ><Link to='/materiais/paisresponsaveis'>Visualizar</Link></button>
          </div>
          <div className="box" >
              <h3>Materiais crianças e educadores</h3>
              <button type="button" id="expandir">Visualizar</button>
          </div>
        </div>
        <div className="btn-denuncia">
          <Button text={"Denuncie"} btnClass={"btn-light"} href={"#"} />
        </div>
     
    </section>
    
);

};
export default Materiais;

