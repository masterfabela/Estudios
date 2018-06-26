/*Vamos a simular unha perlea de Goku vs Superman cada un dos dous tera 100 puntos ao comezar e
 * iranse pegando mentras que os dous sigan vivos e daranse golpes de entre 5 e 12 puntos de dano
 */

 /**Puntos de vida restantes de goku */
let vidaGoku = 100
/**Puntos de vida restantes de superman */
let vidaSuperman = 100
/**Ataque minimo posible */
const MIN_POWER = 5
/**Ataque maximo posible */
const MAX_POWER = 12

/**Comproba se ambos combatentes continuan vivos */
const ambosSiguenVivos = () => vidaGoku > 0 && vidaSuperman > 0

/**Calcula un ataque de dano aleatorio entre 5 e 12 puntos de dano*/
const calcularGolpe = () => Math.round(
    Math.random() * (MAX_POWER - MIN_POWER) + MIN_POWER)
/**Dinos se goku segue vivo */
const gokuSigueVivo = () => vidaGoku > 0

/**Numero da ronda de combate */
let round = 0
while (ambosSiguenVivos() && round < 100) {
    round++
    console.log(`Round ${round}`)
    /**Puntos de dano do golpe de goku */
    const golpeGoku = calcularGolpe()
    /**Puntos de dano do golpe de superman */
    const golpeSuperman = calcularGolpe()

    if(golpeGoku > golpeSuperman) {
        console.log(`Goku ataca a Superman con un golpe de ${golpeGoku}`)
        vidaSuperman -= golpeGoku
        console.log(`Superman queda en ${vidaSuperman} de vida`)
    } else {
        console.log(`Superman ataca a Goku con un golpe de ${golpeSuperman}`)
        vidaGoku -= golpeSuperman
        console.log(`Goku queda en ${vidaGoku} de vida`)
    }
}

if(gokuSigueVivo()) {
    console.log(`Goku gano la pelea, Su vida es de: ${vidaGoku}`)
}else {
    console.log(`Superman gano la pelea su vida es de ${vidaSuperman}`)
}