import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Navbar, Footer } from "./components";
import Home from "./pages/Home";
import Materiais from "./pages/Materiais";
import QuemSomos from "./pages/Jogos/index";
import VerMateriais from "./pages/verMateriais";
import Cadastro from "./pages/Cadastro/Cadastro";
import Login from "./pages/Login/Login";
import Sobre from "./pages/Sobre/Sobre";

import QuizPag1 from "./pages/Quiz/quizPag1";
import QuizPag2 from "./pages/Quiz/quizPag2";
import QuizPag3 from "./pages/Quiz/quizPag3";
import QuizPag4 from "./pages/Quiz/quizPag4";
import QuizPag5 from "./pages/Quiz/quizPag5";
import QuizPag6 from "./pages/Quiz/quizPag6";
import QuizPag7 from "./pages/Quiz/quizPag7";
import QuizPag8 from "./pages/Quiz/quizPag8";
import QuizPag9 from "./pages/Quiz/quizPag9";
import QuizPag10 from "./pages/Quiz/quizPag10";
import QuizPag11 from "./pages/Quiz/quizPag11";
import QuizPag12 from "./pages/Quiz/quizPag12";

import Vlibras from "@djpfs/react-vlibras"





function App() {
  return (
    <>
      <BrowserRouter>
      <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/materiais" element={<Materiais />} />
          <Route
            path="/materiais/paisresponsaveis"
            element={<VerMateriais />}
          />
          <Route path="/quemsomos" element={<QuemSomos />} />
          <Route path="/cadastro" element={<Cadastro />} />
          <Route path="/login" element={<Login />} />

          <Route path="/quiz1" element={<QuizPag1 />} />
          
          <Route path="/quiz2" element={<QuizPag2 />} />
          <Route path="/quiz3" element={<QuizPag3 />} />
          <Route path="/quiz4" element={<QuizPag4 />} />
          <Route path="/quiz5" element={<QuizPag5 />} />
          <Route path="/quiz6" element={<QuizPag6 />} />
          <Route path="/quiz7" element={<QuizPag7 />} />
          <Route path="/quiz8" element={<QuizPag8 />} />
          <Route path="/quiz9" element={<QuizPag9 />} />
          <Route path="/quiz10" element={<QuizPag10 />} />
          <Route path="/quiz11" element={<QuizPag11 />} />
          <Route path="/quiz12" element={<QuizPag12 />} />

          <Route path="/sobre" element={<Sobre />} />
          <Route path="/quiz" element={<QuizPag2 />} />
        </Routes>
        <Vlibras/>
        
        < Footer/>
      </BrowserRouter>
    </>
  );
}

export default App;
