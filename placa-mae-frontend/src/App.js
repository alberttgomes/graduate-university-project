import "./App.css";
// import Navbar from "./components/navbar/Navbar";
// import Header from "./components/header/Header";
// import Features from "./components/features/Features";
// import Download from "./components/download/Download";
// import Subscribe from "./components/subscribe/Subscribe";
// import Footer from "./components/footer/Footer";
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import {Navbar} from './components'
import Home from "./pages/Home";

function App() {
  return (
    <>
       <Navbar />
       <BrowserRouter>
           <Routes>
                <Route  path="/" element={<Home/>}/>
           </Routes>
       </BrowserRouter>
    </>
  );
}

export default App;
