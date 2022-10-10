import React from "react";
import "./Login.css";
import Button from "../../components/UI/Button/Button";
import Denuncia from "../../components/denuncia/Denuncia"

const Login = () => {

    return (
        <section className="login">
            <div className="containerLogin">
                <h1 id="fonte">Login</h1>
                <div className="campos">
                    <input type="text" placeholder="E-mail"></input>
                    <input type="text" placeholder="Senha"></input>
                </div>
                <p >Esqueceu sua senha ?</p>

                <button>Entrar</button>
            </div>

            <div className="btn-denuncia">
          <Denuncia></Denuncia>
        </div>
        </section>
    )
};

export default Login