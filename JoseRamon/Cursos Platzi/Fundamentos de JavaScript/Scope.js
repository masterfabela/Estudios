//Scope global
function saludar10(nombre) {
  //Scope local
  for (var i = 0; i < 10; i++){
    console.log(`Hola ${nombre}`)
  }
  console.log(`El valor de i es ${i}`)
}

saludar10("Sacha")
