var d = document.getElementById("dibujito");
var lienzo = d.getContext("2d");
lienzo.beginPath();
lienzo.strokeStyle = "blue";
lienzo.moveTo(50, 10);
lienzo.lineTo(250, 2);
lienzo.stroke();
lienzo.closePath();
 