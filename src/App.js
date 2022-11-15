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
import Quiz from "../src/pages/Quiz";
import InicioQuiz from "../src/pages/Quiz/inicioQuiz";
import Pontuacao from "./pages/Quiz/pontuacao";

// import QuizPag1 from "./pages/Quiz/quizPag1";
// import QuizPag2 from "./pages/Quiz/quizPag2";
// import QuizPag3 from "./pages/Quiz/quizPag3";
// import QuizPag4 from "./pages/Quiz/quizPag4";
// import QuizPag5 from "./pages/Quiz/quizPag5";
// import QuizPag6 from "./pages/Quiz/quizPag6";
// import QuizPag7 from "./pages/Quiz/quizPag7";
// import QuizPag8 from "./pages/Quiz/quizPag8";
// import QuizPag9 from "./pages/Quiz/quizPag9";
// import QuizPag10 from "./pages/Quiz/quizPag10";
// import QuizPag11 from "./pages/Quiz/quizPag11";
// import QuizPag12 from "./pages/Quiz/quizPag12";

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
          <Route path="/quiz" element={<Quiz />} />
          <Route path="/inicioQuiz" element={<InicioQuiz />} />

          <Route path="/quemsomos" element={<QuemSomos />} />
          <Route path="/cadastro" element={<Cadastro />} />
          <Route path="/login" element={<Login />} />
          <Route path="/sobre" element={<Sobre />} />
          <Route path="/pontuacao" element={<Pontuacao />} />
        </Routes>
        <Vlibras />

        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
