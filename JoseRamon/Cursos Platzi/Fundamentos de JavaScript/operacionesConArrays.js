function suma(...numeros) {
    console.log(numeros)
    let acum = 0
    return numeros.reduce(function (acum, numero){
        acum += numeros
        return acum
    }, 0)
}

//Devuelve un array de dobles del introducido
function dobles (...numeros){ 
    return numeros.map(numero => numero * 2)
}

//Funcion pares tradicional
function pares(...numeros){
    const resultado = []
    const lenght = numeros.length
    for(let i = 0;i<lenght;i++){
        const numero = numeros[i]
        if (numero % 2 == 0){
            resultado.push(numero)
        }
    }
    return resultado
}

//Funcion pares de pros
const pares = (...numeros) => numeros.filter(numero => numero % 2 == 0)

suma(4, 8, 12, 8954, 7, 9)
pares(17, 15, 4 ,0)