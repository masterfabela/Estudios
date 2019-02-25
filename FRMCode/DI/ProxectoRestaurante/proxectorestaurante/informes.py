from reportlab.pdfgen import canvas
from reportlab.lib.pagesizes import A4
import os
import XestionDatos
import sqlite3



def reportservicios(id):
    try:
        cser = canvas.Canvas('servicios.pdf', pagesize=A4)
        cser.setTitle('Informes')
        cser.setAuthor('Femio23')
        cser.setFont('Helvetica', size=11)
        cser.line(50, 820, 525, 820)
        cser.line(50, 745, 525, 745)
        textnom = 'RESTAURANTE TEIS'
        textdir = 'Avenida Galicia, 101 - Vigo'
        texttlfo = '986 12 04 64'
        textlistado = 'LISTADO DE SERVICIOS'
        cser.drawString(235, 795, textnom)
        cser.drawString(225, 775, textdir)
        cser.drawString(255, 755, texttlfo)
        cser.drawString(227, 705, textlistado)
        cser.line(50, 700, 525, 700)
        x = 50
        y = 680
        listado = XestionDatos.consultar_servicios()
        for registro in listado:
            for i in range(3):

                cser.drawString(x, y, str(registro[i]))
                x = x + 220
            y = y -20
            x = 50
        cser.showPage()
        cser.save()
        dir = os.getcwd()
        os.system('/usr/bin/xdg-open ' + dir + '/servicios.pdf')
    except sqlite3.Error as e:
        print('error en informe: '+e)


def carga_de_datos(id):
    factura=XestionDatos.buscar_factura(id)
    cliente=XestionDatos.buscar_cliente(factura[1])
    servicios=XestionDatos.buscar_fFactura(id)
