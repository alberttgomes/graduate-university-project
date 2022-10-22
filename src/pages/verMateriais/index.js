import React from "react";
import CardComponent from "../../components/cards";
import image1 from "../../imagens/imagem1.png";

import "./verMateriais.css";
const VerMateriais = () => {
  return (
    <div className="container-materiais">
      <CardComponent
        image={image1}
        text={"dfsdfsfsdfsdfsdf"}
        link={"https://www.instagram.com/p/CbcwnRRu0ds/?igshid=YmMyMTA2M2Y%3D"}
        title={"titulo qualquer"}
      />
    </div>
  );
};

export default VerMateriais;
