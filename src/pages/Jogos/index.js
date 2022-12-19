import "./jogos.css";
import Denuncia from "../../components/denuncia/Denuncia";
import Button from "../../components/UI/Button/Button";
import { background } from "@chakra-ui/react";
import memoria from "../../assets/jogo1.svg";
import { GiBrain, FaPuzzlePiece, FaChessBoard } from "react-icons/all";
import jogos from "../../assets/image-jogo.png";
import blackJogos from "../../assets/blackJogos.png";
import { useStoreState } from "easy-peasy";
import { Link } from "react-router-dom";

const Jogos = () => {
  const light = useStoreState((state) => state.light);
  return (
    <div
      className="cont"
      style={{ backgroundImage: `url(${light ? jogos : blackJogos})` }}
    >
      <section id="Jogos">
        <div className="container">
          <div className="box">
            <Link to="/quebracabeca">
              <FaChessBoard className="img1" color="#6C86FE" />
              <h3>PALAVRA CRUZADA</h3>
              <h1>
                lorem ipsu lorem ipsulorem ipsulorem lorem ipsulorem ipsu lorem
                ipsu
              </h1>
            </Link>
          </div>
          <div className="box">
            <Link to="/quebracabeca">
              <div>
                <GiBrain className="img1" color="#DC267F" />
                <h3>JOGO DA MEMORIA</h3>
                <h1>
                  lorem ipsu lorem ipsulorem ipsulorem lorem ipsulorem ipsu
                  lorem ipsu
                </h1>
              </div>
            </Link>
          </div>

          <div className="box">
            <Link to="/quebracabeca">
              <FaPuzzlePiece className="img1" color="#FFB000" />
              <h3>QUEBRA CABEÇA</h3>
              <h1>
                lorem ipsu lorem ipsulorem ipsulorem lorem ipsulorem ipsu lorem
                ipsu
              </h1>
            </Link>
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
