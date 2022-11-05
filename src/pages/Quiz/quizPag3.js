import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag3  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h1>3) Qual é a recomendação indicada à Alyne após ter conhecimento que sua foto estava sendo ridicularizada? </h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg3" class="lab">a) Responder para as pessoas que estão cometendo cyberbullying que elas são monstros.</label>
                        <input type="radio" name="perg3" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg3" class="lab" >b)  Alyne deve marcar um encontro para brigar com Carla, pois isso não pode ficar barato.</label>
                            <input type="radio" name="perg3" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg3" class="lab">c)  Revidar a conduta, criando um novo grupo e divulgando fotos de Carla.</label>
                        <input type="radio" name="perg3" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg3" class="lab">d) Conversar com algum profissional da escola, podendo comunicar ao Conselho Tutelar, ao Ministério Público ou à delegacia de polícia quando houver a prática desse tipo de conduta.</label>
                        <input type="radio" name="perg3" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz3"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz4"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag3;

