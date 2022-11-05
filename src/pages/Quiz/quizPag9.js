import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag9  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h3 class="letr" >Caso 05: Beatriz e Nilson eram namorados há muitos anos e tinham uma relação de muita confiança. Acontece que, com o intercâmbio de Beatriz para o Canadá, Nilson começou a brigar constantemente por ciúmes, a relação se desgastou e resolveram terminar. Pouco tempo depois, Beatriz posta foto com um novo namorado também intercambista. Furioso com a postagem, Nilson resolve praticar cyberbullying nos comentários.</h3>
                <br></br>
                <h1>9) Em qual dessas situações você visualiza cyberbullying?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg9" class="lab">a) Comentar desaprovando o namoro e desejando infelicidade aos dois</label>
                        <input type="radio" name="perg9" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg9" class="lab" >b) Publicar foto da época do namoro deles e dizer que eram muito melhores.</label>
                            <input type="radio" name="perg9" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg9" class="lab">c) Compartilhar fotos íntimas do dois e proferir ameaças a ex namorada.</label>
                        <input type="radio" name="perg9" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg9" class="lab">d) Comentar tamanho desapontamento com início tão rápido de outro relacionamento.</label>
                        <input type="radio" name="perg9" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"/quiz8"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz10"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag9;