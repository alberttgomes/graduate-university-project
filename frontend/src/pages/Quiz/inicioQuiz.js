import Button from "../../components/UI/Button/Button";
import "../Quiz/quiz.css";

const InicioQuiz =() =>{
    return(
        <section Class="comecoQuiz">
            <div className="container">
                <h1>Comece seu quiz</h1>

                <div Class="btnQuizIncio">        
                    <Button
                    text={"Começar"}
                    btnClass={"btn-rigth"}
                    href={"/Quiz"} >
                    </Button> 
                </div>    
            </div>
        </section>
    );
} 

export default InicioQuiz;