import {
    Denuncia,
    Footer
  } from "../../components";
  import Header from "./header/Header";
  import '../../../src/App.css'
  import fundo from "../../assets/image-home.png";

const Home = () =>{
    return(
        <>
      <header className="header-bg" style={{backgroundImage: `url(${fundo})`,backgroundSize: "100% " ,position:"relative" , backgroundRepeat: 'no-repeat' }}>
        <Header />
      </header>
      
    </>
    )
}

export default Home