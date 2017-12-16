//Ejercico para calcular cuanto corre en promedio una persona en una semana
/**Nome da persoa que corre */
const nombre = 'Sacha'
/**Lista cos dias da semana */
const dias = [
    'Lunes',
    'Martes',
    'Mercores',
    'Xoves',
    'Venrres',
    'Sabado',
    'Domingo'
]

/**Funcion que nos da un numero aleatorio de kilomentros corridos cun valor de entre 5 e 15
 * @returns Numero aleatorio entre 5 e 15
*/
const correr = () => {
    /**Numero minimo de Kms por dia*/
    const min = 5
    /**Numero maximo de Kms por dia */
    const max = 15
    return Math.round(Math.random() * (max - min) + min)
}

/**Numero total de Kms corridos */
let totalKms = 0
/**Numero de dias da semana */
const length = dias.length
for(let i = 0; i < length ; i++) {
    console.log(`El dia ${i} es el ${dias[i]}`)
    /**Kilometros corridos nun dia */
    const kms = correr()
    totalKms += kms
    console.log(`El dia ${dias[i]} ${nombre} corrio ${kms}kms`)
}

/**Promedio de kilometros corridos nunha semana */
const promedioKms = totalKms / length
console.log(`En promedio, ${nombre} corrio ${promedioKms.toFixed(2)} Kms`)