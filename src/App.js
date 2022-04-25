import "./App.css";
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import {Navbar} from './components'
import Home from "./pages/Home";
import Materiais from "./pages/Materiais"

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
