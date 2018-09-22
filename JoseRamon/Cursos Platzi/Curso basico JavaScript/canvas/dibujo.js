/**Elemento canvas */
var d = document.getElementById('dibujoCanvas');
/**Contexto 2D del canvas */
var lienzo = d.getContext('2d');
console.log(lienzo);

var lineas = 30;
var l = 0;
var yi, xf;

while(l < lineas){
  calculoYInicial = 10 * l;
  calculoXFinal = 10 * (l + 1);
  dibujarLinea('blue', 0, yi, xf, 0);
  console.log(l);
  l = l + 1;
}

function dibujarLinea(color, xInicial, yInicial, xFinal, yFinal){
  lienzo.beginPath();
  lienzo.strokeStyle = color;
  lienzo.moveTo(xInicial, yInicial);
  lienzo.lineTo(xFinal, yFinal);
  lienzo.stroke();
  lienzo.closePath();
}
