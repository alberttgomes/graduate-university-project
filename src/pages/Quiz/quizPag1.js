import React from "react";
import "../../components/navbar/Navbar.css"
import "../Quiz/quiz.css"
import Button from "../../components/UI/Button/Button";


const QuizPag1  = () =>{
    return(
        <section className="quizHeader">
            <div className="container" id="headerquiz">
                <h3 class="letr" >Caso 01: Carla, adolescente de 14 anos, conseguiu tirar uma foto de Alyne, colega de sala, sem que ela soubesse. Além disso, Carla utilizou aplicativos de edição de fotos e fez algumas alterações na imagem para divulgar no grupo de Whatsapp de seus colegas mais próximos. Colocou figuras e fez alterações que Alyne não autorizou e que também a ridicularizavam. Assim que a foto foi postada no grupo, quase todos se divertiram bastante, cada um colocou um apelido em razão das características que foram montadas na foto. Porém, um desses componentes do grupo não concordou com a atitude de Carla e nem com as “brincadeiras” dos demais colegas. Assim, ele procurou Alyne, que estava sendo ridicularizada, para informar sobre o ocorrido. </h3>
                <br></br>
                <h1>1) Nesse caso, como você identifica o ato de Carla e demais colegas sobre a foto?</h1>
                <div id="inputs">
                    
                    <br></br>
                    <div Class="inp">
                        <label for="perg1" class="lab">a) É uma brincadeira de criança e adolescente que o adulto não deve interferir.</label>
                        <input type="radio" name="perg1" class="rad"/> 
                    </div>
                    
                    <div Class="inp">
                            <label for="perg1" class="lab" >b) Não é uma exposição da menina por se tratar de um grupo fechado de amigos. </label>
                            <input type="radio" name="perg1" class="rad"/>
                    </div>

                    <div Class="inp">
                        <label for="perg1" class="lab">c) É um comportamento comum de adolescentes nessa faixa etária e não causa problema para ninguém.</label>
                        <input type="radio" name="perg1" class="rad"/>
                    </div>
                    <div Class="inp">
                        <label for="perg1" class="lab">d) É uma violência praticada contra Alyne através da Internet chamada de cyberbullying e que pode gerar consequências judiciais, além de danos psicológicos nela.</label>
                        <input type="radio" name="perg1" class="rad"/>
                    </div>

                </div>
                <div class="headerbutton">
                    <Button text={"VOLTAR"} btnClass={"btn-left"} href={"#"} />
                    <Button text={"PROXIMO"} btnClass={"btn-rigth"} href={"/quiz2"} />
                </div>
            </div>
        </section>  
    );


}

export default QuizPag1;

