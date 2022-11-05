import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag6  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h1>6) Diante da dor sofrida por Joana, o que ela pode fazer?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg6" class="lab">a) Conversar com os pais e/ou responsáveis esclarecendo a sua dor para, então, buscar acompanhamento psicológico.</label>
                        <input type="radio" name="perg6" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg6" class="lab" >b) Cancelar a rede social para evitar esse tipo de problema, pois ela se expõe bastante e esse foi o verdadeiro motivo do problema.</label>
                            <input type="radio" name="perg6" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg6" class="lab">c) Evitar fazer publicações nas redes sociais. </label>
                        <input type="radio" name="perg6" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg6" class="lab">d) Desistir de denunciar o agressor para poupá-la de mais atritos na Internet.</label>
                        <input type="radio" name="perg6" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz5"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz7"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag6;
