import "./jogos.css";
import Denuncia from "../../components/denuncia/Denuncia";
import Button from "../../components/UI/Button/Button";
import { background } from "@chakra-ui/react";
import memoria from "../../assets/jogo1.svg"
import { GiBrain, FaPuzzlePiece, FaChessBoard} from "react-icons/all"

const Jogos = () => {
  return (
    <div className="cont">
    <section id="Jogos">
      <div className="container">
        <div className="box">
          <FaChessBoard className="img1" color="#6C86FE"/>
          <h3>PALAVRA CRUZADA</h3>
          <h1>lorem ipsu lorem ipsulorem ipsulorem lorem ipsulorem ipsu  lorem ipsu</h1>
        </div>
        <div  className="box">
          <div>
            <GiBrain className="img1" color="#DC267F"/>
            <h3>JOGO DA MEMORIA</h3>
            <h1>lorem ipsu lorem ipsulorem ipsulorem lorem ipsulorem ipsu  lorem ipsu</h1>
          </div>
        </div>
        <div className="box">
        <FaPuzzlePiece className="img1" color="#FFB000"/>
          <h3>QUEBRA CABEÇA</h3>
          <h1>lorem ipsu lorem ipsulorem ipsulorem lorem ipsulorem ipsu  lorem ipsu</h1>
        </div>
      </div>

      <div className="btn-denuncia">
        <Denuncia></Denuncia>
      </div>
    </section>
    </div>
  );
};

export default Jogos;
