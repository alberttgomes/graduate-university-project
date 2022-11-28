import React, {useEffect, useState, useContext} from "react";
import CardComponent from "../../components/cards";
import image1 from "../../imagens/imagem1.png";
import { getAdolescents, getAdults, getKids } from "./requests";
import {  AGE_KIDS_BASE, AGE_ADOLESCENTS_BASE, AGE_ADULTS_BASE } from './../Cadastro/Cadastro'
import "./verMateriais.css";
import { AuthContext } from "../../contexts/userContext"

const VerMateriais = () => {
  const {result, setResult} = useContext(AuthContext);

  const [getMateriais, setGetMateriais] = useState([]);

  let adolescentsCategory = false;
  let adultCategory = false;
  let kidsCategory = false;
  
  useEffect(() => {
        if (result.user.age <= AGE_KIDS_BASE) {
            adolescentsCategory = true;
            getKids().then(res => {
                setGetMateriais(res.item)
            })
        }
        else if (result.user.age > AGE_KIDS_BASE && result.user.age <= AGE_ADOLESCENTS_BASE) {
            adultCategory = true;
            getAdolescents().then(res => {
                setGetMateriais(res.item)
            })
        }
        else if (result.user.age  >= AGE_ADULTS_BASE) {
            kidsCategory = true;
            getAdults().then(res => {
                setGetMateriais(res.item)
            })
        }
        else {
            alert("Usuario nao identificado")
            
            window.location.reload(true);
        }

  }, [getAdolescents, getAdults, getKids]);

  return (
        <div className="container-materiais">
        
            {adolescentsCategory?
                getMateriais.map((material, index) => {
                <div key={index}>
                        <CardComponent 
                            image={material.pathImage}
                            text={material.fieldText}
                            link={material.url}
                            title={material.title}
                        />
                </div>
                })
                
                : null
            }
            {adultCategory?
                getMateriais.map((material, index) => {
                <div key={index}>
                        <CardComponent 
                            image={material.pathImage}
                            text={material.fieldText}
                            link={material.url}
                            title={material.title}
                        />
                </div>
                })
                
                : null
            }
            {kidsCategory?
                getMateriais.map((material, index) => {
                <div key={index}>
                        <CardComponent 
                            image={material.pathImage}
                            text={material.fieldText}
                            link={material.url}
                            title={material.title}
                        />
                </div>
                })
                
                : null
            }
            
        </div>
  );
};

export default VerMateriais;
