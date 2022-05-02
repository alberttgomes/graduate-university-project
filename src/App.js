import "./App.css";


import {BrowserRouter, Routes, Route} from 'react-router-dom'
import {Navbar} from './components'
import Home from "./pages/Home";
import Materiais from "./pages/Materiais";
import QuemSomos from "./pages/QuemSomos/index";


function App() {
  return (
    <>


       
       <BrowserRouter>

       <Navbar />
           <Routes>
                <Route  path="/" element={<Home/>}/>
                <Route  path="/materiais" element={<Materiais/>}/>
                <Route  path="/quemsomos" element={<QuemSomos/>}/>
           </Routes>
       </BrowserRouter>
    </>
  );
}

export default App;
