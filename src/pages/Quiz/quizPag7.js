import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag7  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h3 class="letr" >Caso 03: João tem 12 anos e está cometendo cyberbullying na Internet contra Maria de 13 anos. Ele não se preocupa com as consequências dos seus atos, pois acredita que por ser menor de idade nada acontecerá.</h3>
                <br></br>
                <h1>7) João está correto?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg7" class="lab">a) Sim! Somente as pessoas maiores de idade podem ser enquadradas no Código Penal.</label>
                        <input type="radio" name="perg7" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg7" class="lab" >b) Não! Pessoas menores de idade podem ser enquadradas no Código Penal.</label>
                            <input type="radio" name="perg7" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg7" class="lab">c) Não! Adolescentes acima de 12 anos respondem pelo ato infracional equivalente aos crimes previstos em lei.</label>
                        <input type="radio" name="perg7" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg7" class="lab">d) Sim!  O crime de cyberbullying não estar previsto na legislação brasileira, as vítimas não podem denunciar e processar.</label>
                        <input type="radio" name="perg7" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz6"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz8"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag7;

