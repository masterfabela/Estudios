const numeroDeXogadores = 0;
const xogadoresArray = [];

class Xogador {
  constructor(nomeDeXogador) {
    this.nome = nomeDeXogador;
  }
}

function darRangos(...xogadores) {
  numeroDeXogadores = xogadores.length;
  for (let i = 0; i < xogadores.length; i++) {
    xogadores[i].rango = i;
  }
}

function sacarXogadorAleatorio(...xogadores) {
  darRangos(xogadores);
  let resultado = 
  Math.round(Math.random() * xogadores.length);
}

const xogador1 = new Xogador("Damian");
const xogador2 = new Xogador("David");
const xogador3 = new Xogador("JoseRamon");

sacarXogadorAleatorio(xogador1, xogador2, xogador3)
