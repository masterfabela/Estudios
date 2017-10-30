//-------------------------------------------------------------
// Función formaFecha(fecha, formato)
// Devuelve fecha 'dd/mm/aaaa' según formato indicado
// 2 parámetros: la fecha y el formato: corto, largo, diasemana

var formaFecha = function(fecha, formato) {
	if (esFecha(fecha)) {
		var f = new Date(fecha.split('/').reverse().join('/'));
		var ldia = f.getDay(); // Dia de la semana (0-6)
		var ndia = f.getDate(); // Dia del mes (1-31)
		var nmes = f.getMonth(); // Mes
		var nano = f.getFullYear(); // Año 4 dígitos

		switch (formato) {
			case 'corto':
				return ceros(ndia) + '/' + mesLet(nmes).substr(0, 3).toUpperCase() + '/' + nano;
				break;
			case 'largo':
				return ceros(dia) + ' de ' + mesLet(nmes) + ' de ' + nano;
				break;
			case 'diasemana':
				return diaSem(ldia) + ', ' + ceros(ndia) + ' de ' + mesLet(nmes) + ' de ' + nano;
				break;
			default:
				return ceros(ndia) + '/' + ceros(nmes +1) + '/' + nano;
				break;
		} //Fin del switch
	} else {
		return 'Fecha incorrecta';
	} // Fin del if
}

var divres1 = document.getElementById('resu1');
var divres2 = document.getElementById('resu2');
var divres3 = document.getElementById('resu3');
var divres4 = document.getElementById('resu4');
var divres5 = document.getElementById('resu5');

divres1.innerHTML = '28/02/2017' + ' + 20 días = ' + sumarDias('28/02/2017',20);
divres2.innerHTML = formaFecha('12/10/2017',corto);
divres3.innerHTML = formaFecha('12/10/2017',largo);
divres4.innerHTML = formaFecha('12/10/2017',diasemana);
divres5.innerHTML = '<i>' + formaFecha('12/10/2017') + '</i>';