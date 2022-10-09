import React from "react";
import "./Cadastro.css";
import Button from "../../components/UI/Button/Button";
import Denuncia from "../../components/denuncia/Denuncia"

const Cadastro = () => {

    return (
        <section className="cadastro">
            <div className="containerCadastro">
                <h1 id="fonte">Cadastre-se</h1>
                <div className="campos">
                    <input type="text" placeholder="Nome"></input>
                    <input type="text" placeholder="E-mail"></input>
                    <input type="text" placeholder="Data de nascimento"></input>
                    <input type="text" placeholder="Senha"></input>
                </div>
                <div className="cadastrar">
                    <Button text={"Cadastrar"} btnClass={"btn-verMais"}/>
                </div>
            </div>

            <div className="btn-denuncia">
          <Denuncia></Denuncia>
        </div>
        </section>
    )
};

export default Cadastro