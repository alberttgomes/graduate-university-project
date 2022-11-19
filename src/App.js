import "./App.css";
import React, {useContext} from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Navbar, Footer } from "./components";
import Home from "./pages/Home";
import Materiais from "./pages/Materiais";
import QuemSomos from "./pages/Jogos/index";
import VerMateriais from "./pages/verMateriais";
import Cadastro from "./pages/Cadastro/Cadastro";
import Login from "./pages/Login/Login";
import Sobre from "./pages/Sobre/Sobre";
import Quiz from "../src/pages/Quiz";
import InicioQuiz from "../src/pages/Quiz/inicioQuiz";
import Pontuacao from "./pages/Quiz/pontuacao";
import Warning from "./components/warningPolitica/PoliticaWarning";
import { AuthContext } from './contexts/userContext';

import Vlibras from "@djpfs/react-vlibras"

function App() {
  const {result, setResult} = useContext(AuthContext);
  
  return (
    <>
      <BrowserRouter>
        {/* Menu princiapal do Site */}
        <Navbar />
        
        {/* Rotas do Site */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/materiais" element={<Materiais />} />
          <Route
            path="/materiais/paisresponsaveis"
            element={<VerMateriais />}
          />
          <Route path="/quiz" element={<Quiz />} />
          <Route path="/inicioQuiz" element={<InicioQuiz />} />

          <Route path="/quemsomos" element={<QuemSomos />} />
          <Route path="/cadastro" element={<Cadastro />} />
          <Route path="/login" element={<Login />} />
          <Route path="/sobre" element={<Sobre />} />
          <Route path="/pontuacao" element={<Pontuacao />} />
        </Routes>
        
        {/* API para o VLibras acessbilidade */}
        <Vlibras />
        
        {/* Aviso de potilica de dados e privacidade */}
        <Warning />
        
        {/* Rodapé do Site */}
        <Footer />
      
      </BrowserRouter>
    </>
  );
}

export default App;
