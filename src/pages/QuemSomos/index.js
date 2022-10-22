import "./quemsomos.css";

const QuemSomos = () => {
  return (
    <div className="cont">
      <div className="quemSomos">
        <h1>Quem somos</h1>
      </div>

      <div className="contate">
        <h1>Contate-nos</h1>

        <div className="form">
          <div className="inputs">
            <div className="col" style={{ margin: 5 }}>
              <input
                type="text"
                className="form-control"
                placeholder="Nome"
                aria-label="nome"
              />
            </div>

            <div className="col" style={{ margin: 5 }}>
              <input
                type="text"
                className="form-control"
                placeholder="Sobrenome"
                aria-label="sobrenome"
              />
            </div>
          </div>
          <div className="inputs">
            <div className="col" style={{ margin: 5 }}>
              <input
                type="number"
                className="form-control"
                placeholder="Celular"
                aria-label="First name"
              />
            </div>

            <div className="col" style={{ margin: 5 }}>
              <input
                type="text"
                className="form-control"
                placeholder="E-mail"
                aria-label="Last name"
              />
            </div>
          </div>
          <textarea
            style={{
              width: 250,
              marginTop: 10,
              borderColor: "grey",
              borderRadius: 5,
            }}
            placeholder="Mensagem"
          />
        </div>
      </div>
    </div>
  );
};

export default QuemSomos;
