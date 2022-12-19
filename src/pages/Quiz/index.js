import { useState, useEffect } from "react";
import perguntas from "./arrayQuiz";
import Button2 from "../../components/UI/Button/Button2";
import "../Quiz/quiz.css";
import Button from "../../components/UI/Button/Button";
import { useStoreState, useStoreActions } from 'easy-peasy'




const Quiz = () => {

  const FormStore = useStoreState(state => state);
  const SetFormStore = useStoreActions(state => state.setForm);

  const [pergunta, setPergunta] = useState(perguntas[0]);
  const [cont, setCont] = useState(0);
  const [resp, setResp] = useState("");
  const [ponto , setPonto] = useState(FormStore.Pontuacao ? FormStore.Pontuacao : 0);  


  useEffect(() => {
      setCont((cont) => cont + 0);
  }, []);


  var A ,B,C,D = "";

  if(cont == 0){
    D = "Letra D";
  }else if(cont == 1){
    A = "Letra A";
  }else if(cont == 2){
    D = "Letra D";
  }else if(cont == 3){
    D = "Letra D";  
  }else if(cont == 4){
    C = "Letra C";  
  }else if(cont == 5){
    A = "Letra A";  
  }else if(cont == 6){
    C = "Letra C";  
  }else if(cont == 7){
    B = "Letra B";  
  }else if(cont == 8){
    C = "Letra C";  
  }else if(cont == 9){
    D = "Letra D";  
  }else if(cont == 10){
    A = "Letra A";
  }else if(cont == 11){
    A = "Letra E"; 
    B = "Letra E"; 
    C = "Letra E";  
    D = "Letra E";  
  }


  const atribuirPonto =()=>{
    if(resp === perguntas[cont].Ansower){
      setPonto(ponto + 1);
    }else{
      setPonto(ponto + 0);
    }

  }


  const proximo = () => {
    setPergunta(perguntas[cont + 1]);
    setCont(cont + 1);
    atribuirPonto()

    FormStore.Pontuacao = ponto;
    SetFormStore(FormStore);
    console.log("Pontuação final:",ponto)
  };



  const voltar = () => {
    setPergunta(perguntas[cont - 1]);
    setCont(cont - 1);

  };

  console.log("resultado", resp)




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
            <input type="radio" name="perg1" class="rad" checked={resp === A}  onChange={()=>setResp(A)}/>
          </div>

          <div Class="inp">
            <label for="perg1" class="lab">
              {pergunta.letraB}
            </label>
            <input type="radio" name="perg1" class="rad" checked={resp === B}  onChange={()=>setResp(B)} />
          </div>

          <div Class="inp">
            <label for="perg1" class="lab">
              {pergunta.letraC}
            </label>
            <input type="radio" name="perg1" class="rad" checked={resp === C}   onChange={()=>setResp(C)}/>
          </div>
          <div Class="inp">
            <label for="perg1" class="lab">
              {pergunta.letraD}
            </label>
            <input type="radio" name="perg1" class="rad" checked={resp === D}   onChange={()=>setResp(D)} />
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
              onClick={proximo}
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
