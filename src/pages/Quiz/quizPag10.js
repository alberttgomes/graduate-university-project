import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag10  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h3 class="letr" >Perguntas avulsas:</h3>
                <br></br>
                <h1>10) O que é cyberbullying?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg10" class="lab">a) É manipular psicologicamente pessoas para executar ações na Internet. </label>
                        <input type="radio" name="perg10" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg10" class="lab" >b) É expor publicamente dados pessoais de usuários da Internet.</label>
                            <input type="radio" name="perg10" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg10" class="lab">c) É enganar pessoas na Internet e obter informações confidenciais.</label>
                        <input type="radio" name="perg10" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg10" class="lab">d) É a violência intencional repetitiva praticada contra alguém, através da internet ou de outras tecnologias relacionadas ao mundo virtual.</label>
                        <input type="radio" name="perg10" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz9"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz11"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag10;