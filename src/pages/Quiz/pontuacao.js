import React from "react";
import Table from 'react-bootstrap/Table';
import "../Quiz/quiz.css";
import Button from "../../components/UI/Button/Button";
import { color } from "@chakra-ui/react";
import { padding } from "@mui/system";

const Pontuacao = () =>{
    return(
    <section class="headerTable">
    <div class="container">
        <h1>Pontuação</h1>
        <div class="tableMain">
        <Table striped bordered hover variant="dark" responsive class="table">
        <tbody >
                <tr class="titleTable">
                    <th></th>
                    <th></th>
                    <th>Acertos</th>
                    <th>Erros</th>
                    <th>Pontuação</th>
                </tr>
                <tr>
                    <td><h2 style={{fontSize:"40px"}}>1</h2></td>
                    <td class="imgtable">
                        <td className="boxTable"></td>
                        <td className="nick" >JARARACA DOCE</td>
                    </td>
                    <td>10</td>
                    <td>1</td>
                    <td>90%</td>
                    <td>
                        <Button
                        text={">"}
                        btnClass={"btn-rigth"}
                        href={"/pontuacao"}
                        />
                    </td>   
                </tr>
            </tbody>

        </Table>  
        </div>
        </div>
    </section>
    );

}

export default Pontuacao;