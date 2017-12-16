let base = 5
let height = 7
let radio = 30

//Calcualar area triangulo
const triangleArea = (base, altura) => base * altura / 2

//Calcular area circulo
const circleArea = (radio) => 3.1416 * (radio * radio)

//Calcular area rectangulo
const rectangleArea = (base,height) => (base * height)

//Calcular area cuadrado
const squareArea = (base) => rectangleArea(base, base)


console.log(`El area de un triangulo de base ${base} y altura ${height} es:  ${triangleArea(base, height)}`)
console.log(`El area de un circulo de radio ${radio} es: ${circleArea(radio)}`)
console.log(`El area de un rectangulo de base ${base} y altura ${height} es: ${rectangleArea(base, height)}`)
console.log(`El area de un cuadrado de base ${base} es: ${squareArea(base)}`)