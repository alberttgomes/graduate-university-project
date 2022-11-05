import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag5  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h1>5) O que Joana pode fazer para resolver a situação do perfil falso?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg5" class="lab">a) Nada, pois o celular não é dela.</label>
                        <input type="radio" name="perg5" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg5" class="lab" >b) Não pode buscar ajuda, pois as fotos foram tiradas com sua autorização</label>
                            <input type="radio" name="perg5" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg5" class="lab">c) Poderá denunciar comentários, mensagens e fotos maldosas e solicitar para que sejam removidos pelas ferramentas das redes sociais. Poderá, também, buscar ajuda na escola, com os pais ou responsáveis, autoridades competentes e delegacia..</label>
                        <input type="radio" name="perg5" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg5" class="lab">d) Terá que resolver sozinha com Mário, sem ajuda de ninguém.</label>
                        <input type="radio" name="perg5" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz4"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz6"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag5;
