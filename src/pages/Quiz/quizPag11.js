import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag11  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h3 class="letr" >Perguntas avulsas:</h3>
                <br></br>
                <h1>11) Sabemos que há várias formas de sofrer com ataques de Cyberbullying. Assim, quais são os tipos mais comuns?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg11" class="lab">a) Ameaça, Calúnia, Difamação e Falsa Identidade. </label>
                        <input type="radio" name="perg11" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg11" class="lab" >b) Ameaça, Calúnia, Desinformação e Falsa Identidade.</label>
                            <input type="radio" name="perg11" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg11" class="lab">c) Ameaça, Constrangimento, Desinformação e Perturbação da Tranquilidade.</label>
                        <input type="radio" name="perg11" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg11" class="lab">d) Calúnia, Difamação, Falsa Identidade e Desinformação .</label>
                        <input type="radio" name="perg11" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz10"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz12"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag11;