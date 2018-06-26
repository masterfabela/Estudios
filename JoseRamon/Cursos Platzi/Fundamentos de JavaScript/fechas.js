/*
Ejecicio en el que calcularemos canto tempo pasou dende a fecha de nacemento, ademais tamen calcularemos
o dia da semana na que cae este ano
*/

//16 de Octubre de 1994
//16 10 1994
/**Ano de nacemento */
const ano = 1994
/**Mes de nacemento */
const mes = 10
/**Dia de nacemento */
const dia = 16
/**A minha data de nacemento */
const nacemento = new Date(ano, mes - 1, dia)
/**A data actual */
const diaDeHoxe = new Date()
/**Tempo transcurrido dende que nacemos en ms */
const tempo = diaDeHoxe - nacemento
/**Tempo dende que naces ata agora en Segundos */
const tempoSegundos = tempo / 1000
/**Tempo dende que naces ata agora en Minutos */
const tempoMinutos = tempoSegundos / 60
/**Tempo dende que naces ata agora en Horas */
const tempoHoras = tempoSegundos / 60
/**Tempo dende que naces ata agora en Dias */
const tempoDias = tempoHoras / 24
/**Tempo dende que naces ata agora en Semanas */
const tempoSemanas = tempoDias / 7


//En que dia cadra o meu proximo cumpleanos?
/**Data do seguinte cumpleanos */
const proximoCumpleanos = new Date(diaDeHoxe.getFullYear(), nacemento.getMonth(), nacemento.getDate())

/**Nomes dos dias en galego comezando por domingo como dia 0*/
const diasSemana = [
    'Domingo',
    'Luns',
    'Martes',
    'Mercores',
    'Xoves',
    'Venrres',
    'Sabado'
]
/**Dia da semana no que cadra o meu cumple */
const diaDaSemanaDoCumple = diasSemana[proximoCumpleanos.getDay()]
console.log(diaDaSemanaDoCumple)