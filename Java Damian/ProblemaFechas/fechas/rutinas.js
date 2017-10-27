var ceros = function (nro) {
			return ('0'+nro).slice(-2);
		}

		var esFecha = function (sFec) {
			
			var aFecha = sFec.split('/').reverse();

			f = aFecha.join('/');

			var f1 = new Date(f);
			var dia = f1.getDate();
			var mes = f1.getMonth();
			var anho = f1.getFullYear();


			var nnDia = parseInt(aFecha[2]);
			var nnMes = parseInt(aFecha[1])-1;
			var nnAno = parseInt(aFecha[0]);

			if (dia == nnDia && mes == nnMes && anho == nnAno) {
				return true;
			} else {
				return false;
			}
		}
		

	/*	if(esFecha('28/02/2017')) {
			alert('Fecha correcta')
		} else {
			alert('Fecha incorrecta');
		}

		var ssFecha = '01/02/2017';

		aaFecha = ssFecha.split('/').reverse();

		nuevoArray = aaFecha;

		a=''; */


		//Crear una función para sumar número de días

		var meses = ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Set','Out','Nov','Dec'];

		//fecha larga, fecha corta, fecha non nombre.
		var sumarDias = function (sFec, ndias) {

			ssDias = ndias;
			ssFecha = sFec.split('/').reverse().join('/');

			if(esFecha(sFec)) {

				fechaInt = new Date (ssFecha);

			//	var suma = fechaInt.valueOf() + (ndias * 24 * 60 * 60 * 1000);
			//	var nuevaFecha = new Date(suma);

				fechaInt.setDate(fechaInt.getDate()+ndias);

				var dia = fechaInt.getDate();
				var mes = fechaInt.getMonth()+1;
				var anho = fechaInt.getFullYear();
				
				return ceros(dia) + '/' + ceros(mes) + '/' + anho;


			} else {
				return false;
			}

		}

		
		document.getElementById("fecha").innerHTML='Fecha final: ' + sumarDias('15/10/2017',7);
		document.getElementById("fechaInicial").innerHTML='Fecha incial: ' + ssFecha.split('/').reverse().join('/') + ' + ' + ssDias + ' dias';

// *********************
// ****  Funciones  ****
// *********************

// Función meses
var mesLet = function(nromes) {
	var aMeses = ['xaneiro', 'febreiro','marzo','abril','maio','xunio','agosto',
				 'setembro','outubro','novembro','decembro'];
	return aMeses[nromes];
}
// Función días de la semana
var diaSem = function(nrodia) {
	var aDias = ['Domingo', 'Luns','Martes','Mércores','Xoves','Venres','Sábado'];
	return aDias[nrodia];
}


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
				return ceros(ndia) + ' de ' + mesLet(nmes) + ' de ' + nano;
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
divres2.innerHTML = formaFecha('12/10/2017', 'corto');
divres3.innerHTML = formaFecha('12/10/2017', 'largo');
divres4.innerHTML = formaFecha('12/10/2017', 'diasemana');
divres5.innerHTML = '<i>' + formaFecha('12/10/2017') + '</i>';