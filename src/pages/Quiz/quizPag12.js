import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag12  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h3 class="letr" >Perguntas avulsas:</h3>
                <br></br>
                <h1>12) Quais são os personagens de um caso de Bullying e/ou Cyberbullying?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg12" class="lab">a) Vítima</label>
                        <input type="radio" name="perg12" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg12" class="lab" >b) praticante.</label>
                            <input type="radio" name="perg12" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg12" class="lab">c) plateia passiva.</label>
                        <input type="radio" name="perg12" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg12" class="lab">d) plateia ativa.</label>
                        <input type="radio" name="perg12" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz11"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"#"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag12;