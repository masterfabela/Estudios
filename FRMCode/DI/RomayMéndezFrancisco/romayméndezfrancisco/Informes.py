from reportlab.pdfgen import canvas
from reportlab.lib.pagesizes import A4
import XestionDatos
import os
import sqlite3
def informe():
    """

        Método que se encarga de imprimir o ticket, cos datos dos servicios, coincidentes co id seleccionado.

    """
    try:
        cser = canvas.Canvas('servicios.pdf', pagesize=A4)
        cser.setTitle('Informes')
        cser.setAuthor('Femio23')
        cser.setFont('Helvetica', size=11)
        cser.line(50, 820, 525, 820)
        textnom = 'Informe Semanal'
        textlistado = 'Listado de Viaxes'
        cser.drawString(235, 795, textnom)
        total = 0.0
        x = 50
        y = 690
        cser.drawString(207, 735, textlistado)
        cser.drawString(50, 715, "Código")
        cser.drawString(140, 715, "Matricula")
        cser.drawString(230, 715, "Plazas")
        cser.drawString(320, 715, "Km.Iniciais")
        cser.drawString(410, 715, "Km.Finais")
        cser.drawString(500, 715, "Km.Totais")
        cser.line(50, 710, 525, 710)
        listado = carga_de_datos_viaxe()
        cser.line(50, 725, 525, 725)
        cser.line(50, 745, 525, 745)
        for registro in listado:
            for i in range(6):
                cser.drawString(x, y, str(registro[i]))
                x = x + 90
            y = y - 20
            x = 50
        cser.line(50, y-10, 525, y-10)
        cser.showPage()
        cser.save()
        dir = os.getcwd()
        os.system('/usr/bin/xdg-open ' + dir + '/servicios.pdf')
    except sqlite3.Error as e:
        print('error en informe: '+e)


def carga_de_datos_bus():
    """

        Método que se encarga de intermediar entre a clase informes e a clase xestiondatos, para permitir a carga dos datos de cliente.

    """
    listado=XestionDatos.consultar_buses()


    return listado

def carga_de_datos_viaxe():
    """

        Método que se encarga de intermediar entre a clase informes e a clase xestiondatos, para permitir a carga dos datos de servicio.

    """
    servicios = XestionDatos.consultar_servicios()
    return servicios


#cantidade=XestionDatos.contar()
#for registro in listado:
#for i in range(cantidade):
#cser.drawString(x, y, str(registro[0]))
#x = x + 90
#       y = y - 20
#        x = 50