import {
    
    Subscribe,
    Footer
  } from "../../components";
  import Header from "./header/Header";
  import '../../../src/App.css'


const Home = () =>{
    return(
        <>
      <header className="header-bg">
    
        <Header />
      </header>
      <Subscribe />
      <Footer />
    </>
    )
}

export default Home