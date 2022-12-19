import Header from "./header/Header";
import "../../../src/App.css";
import { useStoreState } from "easy-peasy";
import home from "../../assets/image-home.png";
import blackHome from "../../assets/Home-black.png";

const Home = () => {
  const light = useStoreState((state) => state.light);
  let header = {
    width: "100%",
    height: "100vh",
    backgroundImage: `url(${light ? home : blackHome})`,
    backgroundSize: "100% 100%",
  };
  return (
    <>
      <header style={header}>
        <Header />
      </header>
    </>
  );
};

export default Home;
