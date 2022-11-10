import { dividerClasses } from "@mui/material";
import { useState } from "react";
import perguntas from "./arrayQuiz";
import Button2 from "../../components/UI/Button/Button2";
import "../Quiz/quiz.css";
import { width } from "@mui/system";
import Button from "../../components/UI/Button/Button";



const Quiz = () => {
  const [pergunta, setPergunta] = useState(perguntas[0]);
  const [cont, setCont] = useState(0);

  const proximo = () => {
    setPergunta(perguntas[cont + 1]);
    setCont(cont + 1);

  };
  const voltar = () => {
    setPergunta(perguntas[cont - 1]);
    setCont(cont - 1);
  };





  return (
    <section className="quizHeader">
      <div className="container" id="headerquiz">
        <h3 class="letr">{pergunta.caso}</h3>
        <br></br>
        <h1>{pergunta.titulo}</h1>
        <div id="inputs">
          <br></br>
          <div Class="inp">
            <label for="perg1" class="lab">
              {pergunta.letraA}
            </label>
            <input type="radio" name="perg1" class="rad" />
          </div>

          <div Class="inp">
            <label for="perg1" class="lab">
              {pergunta.letraB}
            </label>
            <input type="radio" name="perg1" class="rad" />
          </div>

          <div Class="inp">
            <label for="perg1" class="lab">
              {pergunta.letraC}
            </label>
            <input type="radio" name="perg1" class="rad" />
          </div>
          <div Class="inp">
            <label for="perg1" class="lab">
              {pergunta.letraD}
            </label>
            <input type="radio" name="perg1" class="rad" />
          </div>
        </div>
        <div class="headerbutton">
          {cont > 0 && (
            <Button2 text={"VOLTAR"} btnClass={"btn-left"} onClick={voltar} />
          )}
          {cont < 11 && (
            <Button2
              text={"PROXIMO"}
              btnClass={"btn-rigth"}
              onClick={proximo}
            />
          )}
           {cont == 11 && (
            <Button
              text={"Finalizar"}
              btnClass={"btn-rigth"}
              href={"/pontuacao"}
            />  
          )}
        </div>
        <input style={{width:"100%"}} class="traço"  type="range"  min={0} max={11} value={cont}  />
      </div>

    </section>
  );
};

export default Quiz;
