/**Traduce unha palabra a nosa nova lingua cunha serie de normas especificadas */
function platzom(str) {
    /**A traduccion que obtemos */
    let translation = str

    //Se a palabra orixinal e un palindromo ningunha regra anterior conta e devolvese a mesma palabra
    /**Palabra entrante dada de volta */
    const reverse = (str) => str.split('').reverse().join('')
    /**Funcion que nunha palabra intercambia maysculas e minusculas en todas as letras */
    const minMay = (str) => {
        /**Tamanho da palabra a traducir */
        const length = str.length
        /**Traduccion */
        let translation = ''
        /**Boolean que marca se unha letra debe estar en maiuscula ou non */
        let capitalize = true
        for (let i = 0; i < length; i++){
            /**Letra individual da palabra a traducir */
            const char = str.charAt(i)
            translation += capitalize ? char.toUpperCase() : char.toLowerCase()
            capitalize = !capitalize
        }
        return translation
    }

    if (str == reverse(str)) {
        return minMay(str)
    }

    //Si la palabra termina en ar quitanselle 2 caracteres
    if(str.toLowerCase().endsWith('ar')) {
        translation = str.slice(0, -2) 
    }

    //Se a palabra de inicia con z anhadese p ao final
    if(str.toLowerCase().startsWith('z')){
        translation += 'pe'
    }

    //Se a palabra traducida ten 10 ou mais letras debese partir pola metade unir con un - enmedio
    /**Tamanho da traduccion resultante */
    const lenght = translation.lenght
    if(lenght >= 10) {
        /**Primeira metade da palabra a dividir */
        const firstHalf = translation.slice(0, Math.round(lenght / 2))
        /**Segunda metade da palabra a dividir */
        const secondHalf = translation.slice(Math.round(lenght / 2))
        translation = `${firstHalf}-${secondHalf}`
    }

    
    return translation
}

console.log(platzom('Programar')) 
console.log(platzom('Zorro'))
console.log(platzom('Zarpar'))
console.log(platzom('abecedario'))
console.log(platzom('sometemos'))
