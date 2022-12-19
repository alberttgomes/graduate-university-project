const grade = document.getElementById("grade");

for (var i = 0; i < 4; i = i + 1) {
  for (var j = 0; j < 6; j = j + 1) {
    var novaPeca = document.createElement("div");
    novaPeca.id = "x" + j + "y" + i;
    novaPeca.style.top = i * 50 + "px";
    novaPeca.style.left = j * 50 + "px";
    novaPeca.style.backgroundPositionX = ((j * 25) / (6 - 1)) * 100 + "%";
    novaPeca.style.backgroundPositionY = ((i * 25) / (4 - 1)) * 100 + "%";
    novaPeca.setAttribute("onclick", "clicarPeca(this)");
    grade.appendChild(novaPeca);
  }
}

var escolhido1 = null;
var escolhido2 = null;
function clicarPeca(argElemento) {
  if (escolhido1 == null) {
    escolhido1 = argElemento;
  } else if (escolhido2 == null) {
    escolhido2 = argElemento;
    trocarPeca();
  }
}

function embaralhar(argInteracoes) {
  for (var i = 0; i < argInteracoes; i = i + 1) {
    var escolhido1X = 0;
    var escolhido1Y = 0;
    var escolhido2X = 0;
    var escolhido2Y = 0;

    while (escolhido1X == escolhido2X && escolhido1Y == escolhido2Y) {
      escolhido1X = Math.round(Math.random() * (6 - 1));
      escolhido1Y = Math.round(Math.random() * (4 - 1));

      escolhido2X = Math.round(Math.random() * (6 - 1));
      escolhido2Y = Math.round(Math.random() * (4 - 1));
    }
    escolhido1 = document.getElementById("x" + escolhido1X + "y" + escolhido1Y);
    escolhido2 = document.getElementById("x" + escolhido2X + "y" + escolhido2Y);
    trocarPeca();
  }
}

function trocarPeca() {
  var escolhidoTrocadoTop = escolhido1.style.top;
  var escolhidoTrocadoLeft = escolhido1.style.left;
  escolhido1.style.top = escolhido2.style.top;
  escolhido1.style.left = escolhido2.style.left;
  escolhido2.style.top = escolhidoTrocadoTop;
  escolhido2.style.left = escolhidoTrocadoLeft;
  escolhido1 = null;
  escolhido2 = null;
  validar();
}

function validar() {
  var quebraCabecaOK = true;
  for (var i = 0; i < 4; i = i + 1) {
    for (var j = 0; j < 6; j = j + 1) {
      var posicaoXEsperada = j * 50 + "px";
      var posicaoYEsperada = i * 50 + "px";

      var pecaVerificada = document.getElementById("x" + j + "y" + i);
      if (
        pecaVerificada.style.left != posicaoXEsperada ||
        pecaVerificada.style.top != posicaoYEsperada
      ) {
        quebraCabecaOK = false;
      }
    }
  }
  if (quebraCabecaOK) {
    window.alert("Parabéns, você conseguiu!");
  }
}

embaralhar(100);
