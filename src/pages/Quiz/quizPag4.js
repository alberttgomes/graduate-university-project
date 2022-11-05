import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag4  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h3 class="letr" >Caso 02: Mário foi namorado de Joana por 1 ano. Um casal de adolescentes ainda hoje. Estudam na mesma escola e têm vários amigos em comum. Mário nunca ficou satisfeito com o fim do relacionamento e decidiu se vingar de Joana. Criou um perfil falso no Instagram e utilizou para divulgar todas as fotos que ele tinha de Joana no celular. Eram fotos de todos os tipos, inclusive fotos íntimas. As fotos foram tiradas na época em que eles estavam namorando, porém, não foram apagadas e Mário se aproveitou disso.</h3>
                <br></br>
                <h1>4) Sobre a atitude de Mário, o que você acha?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg4" class="lab">a) Mário pode divulgar todas as fotos em qualquer lugar da Internet, afinal de contas o celular é dele.</label>
                        <input type="radio" name="perg4" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg4" class="lab" >b) Mário teve uma conduta de raiva justificável pelo fim do namoro.</label>
                            <input type="radio" name="perg4" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg4" class="lab">c) Joana não pode reclamar, pois autorizou que Mário armazenasse as fotos em seu celular.</label>
                        <input type="radio" name="perg4" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg4" class="lab">d) Mário teve uma conduta recriminada não só por criar um perfil falso como também por divulgar imagens sem autorização de Joana, podendo responder judicialmente por tudo que fez nessa situação.</label>
                        <input type="radio" name="perg4" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz3"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz5"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag4;

