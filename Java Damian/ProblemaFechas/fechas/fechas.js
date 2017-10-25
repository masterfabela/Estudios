// ---------------------------------------------
// Funciones de fechas
// ---------------------------------------------
// Funcion ceros()
// 	Completa con ceros por la izquierda un número
// 	1 parámetro - número a completar
// 	Devuelve string con cero a la izquierda
var ceros = function(nro) {	return ('0' + nro).slice(-2); }
// ---------------------------------------------
// Función diaSem(nrodia)
//  Devuelve día de semana en letra
//  1 parámetro . nro de día de 0 - Domingo a 6 - Sábado
var diaSem = function(nrodia) {
	var aDias = ['Domingo', 'Luns','Martes','Mércores','Xoves','Venres','Sábado'];
	return aDias[nrodia];
}
// ---------------------------------------------
// Función mesLet(nmes)
//  Devuelve mes en letra
//  1 parámetro . nro de mes
var mesLet = function(nromes) {
	var aMeses = ['xaneiro', 'febreiro','marzo','abril','maio','xunio','agosto',
				 'setembro','outubro','novembro','decembro'];
	return aMeses[nromes];
}
// ---------------------------------------------
// Función esFecha(fecha)
//  Comprueba si una fecha es correcta o no
//  1 parámetro: string con formato 'dd/mm/aaaa'
//  Devuelve true si fecha correcta
// 	         false si fecha incorrecta
var esFecha = function(fecha) {
	// Da la vuelta a la fecha y obtiene objeto fecha
	var f = new Date(fecha.split('/').reverse().join('/'));
	// Separa dia, mes, año
	var ndia = f.getDate();   // Dia del mes (1 - 31)
	var nmes = f.getMonth();  // Mes
	var nano = f.getFullYear(); // Año 4 dígitos
	// Obtener array con la fecha
	var aFec = fecha.split('/'); // Array con la fecha
	var nndia = parseInt(aFec[0]);
	var nnmes = parseInt(aFec[1]) - 1;
	var nnano = parseInt(aFec[2]);
	// Compara
	if (ndia == nndia && nmes == nnmes && nano == nnano) {
		return true;    // Si coincide, fecha correcta
	} else {
		return false;	// No coinciden, fecha incorrecta
	}
}
// ---------------------------------------------
// Funcion sumarDias(fecha, dias)
//  Suma dias a una fecha dada
//  2 parámetros - la fecha 'dd/mm/aaaa' y el número de días
//  Devuelve fecha 'dd/mm/aaaa' con los días sumados.
var sumarDias = function(fecha, nrodias){
		if (esFecha(fecha)) {
			var f = new Date(fecha.split('/').reverse().join('/'));
			f.setDate(f.getDate() + nrodias);
			var ndia = f.getDate();   // Dia del mes (1 - 31)
			var nmes = f.getMonth();  // Mes
			var nano = f.getFullYear(); // Año 4 dígitos
			return ceros(ndia) + '/' + ceros(nmes+1) + '/' + nano;   			
		} else {
			return 'Fecha incorrecta';
		}
}
// ---------------------------------------------
// Función formaFecha(fecha, formato)
// Devuelve fecha 'dd/mm/aaaa' según formato indicado
// 2 parámetros: la fecha 
// 		y el formato: corto, largo, diasemana
var formaFecha = function(fecha, formato) {
	if (esFecha(fecha)) {
		var f = new Date(fecha.split('/').reverse().join('/'));
		var ldia = f.getDay();    // Dia de la semana (0 - 6)
		var ndia = f.getDate();   // Dia del mes (1 - 31)
		var nmes = f.getMonth();  // Mes
		var nano = f.getFullYear(); // Año 4 dígitos

		switch (formato) {
			case 'corto':
				return ceros(ndia) + '/' + 
					   mesLet(nmes).substr(0,3).toUpperCase() + '/' + 
					   nano;
				break;
			case 'largo':
				return ceros(ndia) + ' de ' + mesLet(nmes) + ' de ' + nano;
				break;
			case 'diasemana':
				return diaSem(ldia) + ', ' + 
					   ceros(ndia) + ' de ' + 
					   mesLet(nmes) + ' de ' + 
					   nano;
				break;
			default:
				return ceros(ndia) + '/' + ceros(nmes + 1) + '/' + nano;
				break;
		} // Fin de switch
	} else {
		return 'Fecha incorrecta';
	} // Fin del if
}

// ------------------------------------------------------
// Principal
// Llamar a las funciónes

	var divres1 = document.getElementById('resu1');
	var divres2 = document.getElementById('resu2');
	var divres3 = document.getElementById('resu3');
	var divres4 = document.getElementById('resu4');
	var divres5 = document.getElementById('resu5');

	// divres1.innerHTML = '28/02/2017' + ' + 20 días = ' + sumarDias('28/02/2017', 20);
	// divres2.innerHTML = formaFecha('12/10/2017', 'corto');
	// divres3.innerHTML = formaFecha('12/10/2017', 'largo');
	// divres4.innerHTML = formaFecha('12/10/2017', 'diasemana');
	// divres5.innerHTML = '<i>' + formaFecha('12/10/2017') + '</i>';
// Fin javaScript
