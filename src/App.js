import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Navbar } from "./components";
import Home from "./pages/Home";
import Materiais from "./pages/Materiais";
import QuemSomos from "./pages/Jogos/index";
import VerMateriais from "./pages/verMateriais";
import Cadastro from "./pages/Cadastro/Cadastro";
import Login from "./pages/Login/Login";
import Sobre from "./pages/Sobre/Sobre";

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

          <Route path="/sobre" element={<Sobre />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
