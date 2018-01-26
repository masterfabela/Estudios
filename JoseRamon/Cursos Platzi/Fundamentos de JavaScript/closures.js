
function saludarFamilia(apellido){
    return function saludarMiembroDeFamilia (nombre){
        console.log(`Hola ${nombre} ${apellido}`)
    }
}

const saludarGomez = saludarFamilia("Gomez")
const saludarPerez = saludarFamilia("Perez")
const saludarFernandez = saludarFamilia("Romero")


saludarPerez("Marta")
saludarPerez("Monica")
saludarPerez("Alexa")

saludarGomez("Monica")
saludarGomez("Nico")
saludarGomez("Carlos")

saludarFernandez("David")
saludarFernandez("Denis")
saludarFernandez("Raquel")

// EXERCICIO Tener una funcion que permita tener prefijos para las palabras



function makePrefixer(prefijo){
    return function ponerPrefijo (palabra){
        console.log(prefijo + palabra)
    }
}

const prefijoRe = makePrefixer("re")
prefijoRe("Bueno")