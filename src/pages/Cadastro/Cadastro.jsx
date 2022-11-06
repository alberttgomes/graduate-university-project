import React, { useCallback, useContext, useState } from "react";
import "./Cadastro.css";
import Button from "../../components/UI/Button/Button";
import Denuncia from "../../components/denuncia/Denuncia";
import AuthContext from "../../contexts/userContext";

const Cadastro = () => {
  const {result, setResult} = useContext(AuthContext);

  const AGE_KIDS_BASE = 13;
  const AGE_ADOLESCENTS_BASE = 17;
  const AGE_ADULTS_BASE = 18;

  const [checkSenha, setCheckSenha] = useState("");

  const [userSignUP, setUserSignUP] = useState({
      age: '',
      email:'',
      password:'',
      username:''
  });

  const checkerEmail = (email) => {
      const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
      
      return emailRegex.test(email)
  }

  const handleSave = () => {
    let ageValue = parseInt(userSignUP.age);

    let checkEmail = false;
    
    if(checkerEmail(userSignUP.email)) {
        checkEmail = true;
        console.log('Válido')
    }
    else {
        console.log('Por favor, digite um email válido.')
    }

    if (checkEmail && checkSenha.equals(userSignUP.password)) {
        if(ageValue <= AGE_KIDS_BASE) {
            fetch.post('https://localhost:8080/kids', userSignUP)
                .then(() => {
                    setResult({user: userSignUP, registered: true})
                })
                .catch((error) => {
                    console.log(`An error current ${error}`)
                });
        } 
        else if (ageValue > AGE_KIDS_BASE && ageValue <= AGE_ADOLESCENTS_BASE) {
            fetch.post('https://localhost:8080/adolescents', userSignUP)
                .then(() => {
                    setResult({user: userSignUP, registered: true})
                })
                .catch((error) => {
                    console.log(`An error current ${error}`)
                });
        }
        else if (ageValue >= AGE_ADULTS_BASE) {
            fetch.post('https://localhost:8080/adults', userSignUP)
                .then(() => {
                    setResult({user: userSignUP, registered: true})
                })
                .catch((error) => {
                    console.log(`An error current ${error}`)
                });
        } else {
            console.log('Ops')
        }
    }
  };

  return (
    <section className="cadastro">
      <div className="containerCadastro">
        <h1 id="fonte">Cadastre-se</h1>
        <div className="campos">
          <input 
            type="numeric" 
            placeholder="Idade"
            value={userSignUP.age}
            onChange={(event) => {
              setUserSignUP({...userSignUP, age: event.target.value});
            }}
          >
          </input>
          <input 
              type="text" 
              placeholder="Nome de usuário"
              value={userSignUP.username}
              onChange={(event) => {
                setUserSignUP({...userSignUP, username: event.target.value});
              }}
          >
          </input>
          <input 
              type="text" 
              placeholder="E-mail"
              value={userSignUP.email}
              onChange={(event) => {
                setUserSignUP({...userSignUP, email: event.target.value});
              }}
          >
          </input>
          <input 
              type="text" 
              placeholder="Senha"
              value={userSignUP.password}
              onChange={(event) => {
                setUserSignUP({...userSignUP, password: event.target.value});
              }}
          >
          </input>
          <input 
              value={checkSenha} 
              placeholder="Confirme senha"
              onChange={(event) => {
                setCheckSenha(event.target.value)
              }}
          >
          </input>
        </div>
        <div className="cadastrar">
          <Button 
              text={"Cadastrar"} 
              btnClass={"btn-verMais"} 
              onClick={handleSave}
          />
        </div>
      </div>

      <div className="btn-denuncia">
        <Denuncia></Denuncia>
      </div>
    </section>
  );
};

export default Cadastro;
