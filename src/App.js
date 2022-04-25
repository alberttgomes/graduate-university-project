import "./App.css";
// import Navbar from "./components/navbar/Navbar";
// import Header from "./components/header/Header";
// import Features from "./components/features/Features";
// import Download from "./components/download/Download";
// import Subscribe from "./components/subscribe/Subscribe";
// import Footer from "./components/footer/Footer";
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom'
import {Navbar} from './components'
import Home from "./pages/Home";
import Materiais from "./pages/Materiais";

function App() {
  return (
    <>
    <BrowserRouter>
       <Navbar />
           <Routes>
                <Route  path="/" element={<Home/>}/>
                <Route  path="/materiais" element={<Materiais/>}/>
               
           </Routes>
       </BrowserRouter>
    </>
  );
}

export default App;
