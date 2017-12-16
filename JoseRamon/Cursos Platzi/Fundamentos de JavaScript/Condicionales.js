//Titu
// Archivo do video 2 do curso de fundamentos de JS de Platzi

/**Nome da pelicula de Star Wars */
const starwars7 = 'Star Wars: El Despertar de la Fuerza'
/**Edad minima para ver star wars */
const pgStarWars7 = 13
/**Nome de Sacha */
const nameSacha = 'Sacha'
/**Idade de Sacha */
const ageSacha = '26'
/**Nome de Santi */
const nameSanti = 'Santi'
/**Idade de Santi */
const ageSanti = '12'

/** Funcion para ver se alguen pode ou non ir a ver star wars 7
 * @param age Idade da persoa que quere ver a pelicula
 * @param name Nome da persoa que quere ir a ver a pelicula
 * @param isWithAdult Boolean que indica se esta cun adulto
 */
const canWatchStarWars7 = (name, age, isWithAdult) => {
    if (age >= pgStarWars7){
        alert(`${name} puede pasar a ver ${starwars7}`)
    } else if (isWithAdult){
        alert(`${name} puede pasar a ver ${starwars7}.
        Aunque su edad es ${age}, se encuentra con un adulto`)
    } else {
        alert(`${name} no puede pasar a ver ${starwars7}. 
        Tiene ${age} y necesita tener ${pgStarWars7}`)
    } 
}

canWatchStarWars7(nameSacha,ageSacha)
canWatchStarWars7(nameSanti,ageSanti)
canWatchStarWars7(nameSanti,ageSanti,true)

