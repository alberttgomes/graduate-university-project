import React from "react";
import "./Sobre.css";
import Button from "../../components/UI/Button/Button";
import Denuncia from "../../components/denuncia/Denuncia";
import sobgreImage from "../../assets/image-sobre.png";
import blackSobre from "../../assets/blackSobre.png";
import Aos from "aos";
import { useStoreState } from "easy-peasy";

const Sobre = () => {
  const light = useStoreState((state) => state.light);

  Aos.init();
  return (
    <section
      class="header1"
      style={{ backgroundImage: `url(${light ? sobgreImage : blackSobre})` }}
    >
      <div>
        <div
          className="header-left"
          data-aos="fade-right"
          data-aos-offset="300"
        >
          <h1>Sobre</h1>

          <div className="container">
            <div className="ladinho1">
              <p className="sobre" style={{ color: light ? "black" : "white" }}>
                Placa Mãe.Org, é uma empresa de impacto social que busca
                informação, reflexão (o lado “placa”), sem abrir mão da arte de
                ser humano, da procura por aquilo que nos conecta
                reciprocamente, e nos conecta ao planeta e à existência nele (o
                lado “mãe”).
                <br />
                <br />
                A partir da disponibilização de conteúdo de qualidade e de
                utilidade pública, sendo todos de autoria dos nossos
                colaboradores, participamos da construção saudável de um cultura
                de proteção de dados pessoais em prol de um cidadania digital de
                excelência. Isto porque, construímos informação a partir de
                debates, palestras, grupos de estudo e pesquisa, projetos de
                extensão, entrevistas, livros e cartilhas, dentre outras
                atividades que proporcionem o desenvolvimento crítico e de
                aplicabilidade social sobre temas relacionados ao Direito, à
                Tecnologia e à Sociedade.
                <br />
                <br />
                Além da atuação na pesquisa e extensão no cenário pernambucano,
                a PlacaMãe.Org_ promove a educação digital por meio de cursos,
                palestras, mentorias, treinamentos, consultorias e atividades de
                intervenção in loco considerando os núcleos integrados: família,
                escola e comunidade.
              </p>
            </div>

            <div className="ladinho2">
              <p className="sobre" style={{ color: light ? "black" : "white" }}>
                Ou seja, desenvolvemos atividades, em escolas públicas e
                privadas, da região metropolitana do Recife, levando a discussão
                de temas como “Internet: contexto, limites e
                responsabilidades'', "Qual é o nosso papel no ambiente
                virtual?", "Cyberbullying", "Como falar de direitos, deveres e
                internet em minha sala de aula?", para crianças e adolescentes a
                partir do 5º ano do ensino fundamental.
                <br />
                <br />
                Assim, construímos informação acessível e de qualidade para
                todos/as, por acreditar que setorizar seu destinatário é negar a
                existência de um novo contexto: a sociedade da informação.
                <br />
                <br />
                Nossa missão: Ser referência nacional e internacional em ensino,
                pesquisa e extensão no ramo do direito e da tecnologia da
                informação. Nossa visão: Nós vamos hackear o mundo! Nossos
                valores: Ciência; Coletividade; Comprometimento; Criatividade;
                Diversidade e Empatia; Ética; Humanidades; Resultado; Segurança;
                Privacidade e Transparência
              </p>
            </div>
          </div>

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
