import { createRoot } from "react-dom/client";

const QuebraCabeca = () => {
  return (
    <div className="container-quebraCabeca">
      <h3>Puzzle 🥳🤩😜✍️</h3>
      <div>
        <img id="img" src={puzzle} />
      </div>

      <div id="grade"></div>
    </div>
  );
};
export default QuebraCabeca;
