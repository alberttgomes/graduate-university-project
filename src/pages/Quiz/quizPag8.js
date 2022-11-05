import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag8  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h3 class="letr" >Caso 04: José brigou com seu amigo da rua. Estavam jogando videogame e o seu amigo perdeu a partida e não aceitou. Disse que iria se vingar. Ao chegar em casa o amigo pegou o celular e criou uma conta no youtube e começou a fazer vídeos sobre José. Todas as gravações traziam mentiras sobre José, diziam que José era ladrão, que roubava os amigos, que machucava os amigos nas escola, dentre outras coisas. José ficou sabendo por um outro amigo que o avisou, pois, toda a rua já sabia do fato.</h3>
                <br></br>
                <h1>8) José não está sabendo o que fazer, o que você orientaria:</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg8" class="lab">a) Eu diria que faz parte, todo mundo já passou por isso.</label>
                        <input type="radio" name="perg8" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg8" class="lab" >b) Eu o aconselharia a informar à mãe, ao pai ou ao seu responsável para que um adulto tome as medidas cabíveis, inclusive judiciais.</label>
                            <input type="radio" name="perg8" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg8" class="lab">c) Criar um perfil no Youtube para fazer o mesmo e dar o troco.</label>
                        <input type="radio" name="perg8" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg8" class="lab">d) Procurar o amigo e pedir desculpas pelo ocorrido no jogo de videogame</label>
                        <input type="radio" name="perg8" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz7"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz9"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag8;