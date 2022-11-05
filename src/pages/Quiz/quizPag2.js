import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";

const QuizPag2  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h1>2) Nesse caso, quais são as consequências judiciais dos atos de Carla e demais colegas?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg2" class="lab">a) Carla e os colegas poderão responder a um processo judicial e receber as medidas judiciais cabíveis, como, por exemplo, obrigação de reparar o dano causado à Alyne.</label>
                        <input type="radio" name="perg2" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg2" class="lab" >b) Carla e os colegas não sofrerão consequências.</label>
                            <input type="radio" name="perg2" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg2" class="lab">c) Não há medida judicial cabível e nem possibilidade de interferência dos responsáveis e escola.</label>
                        <input type="radio" name="perg2" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg2" class="lab">d) Os adolescentes não respondem judicialmente, apenas os responsáveis ou pais e mães.</label>
                        <input type="radio" name="perg2" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz3"} />
                </div>
            </div>
        </section>  
    );
}

export default QuizPag2;