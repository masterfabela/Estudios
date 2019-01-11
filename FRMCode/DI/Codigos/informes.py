from reportlab.pdfgen import canvas
from reportlab.lib.pagesizes import A4
import os
import servicios    #conexion tabla de servicios


def reportservicios():
    try:
        cser = canvas.Canvas('servicios.pdf', pagesize = A4)
        cser.setTitle('Informes')
        cser.setAuthor('El profesor')
        cser.setFont('Helvetica', size=11)
        cser.line(50,820,525,820)
        cser.line(50, 745, 525, 745)
        textnom = 'RESTAURANTE TEIS'
        textdir = 'Avenida Galicia, 101 - Vigo'
        texttlfo = '886 12 04 64'
        textlistado = 'LISTADO DE SERVICIOS'
        cser.drawString(255,795, textnom)
        cser.drawString(245,775, textdir)
        cser.drawString(280, 755, texttlfo)
        cser.drawString(255,705, textlistado)
        cser.line(50,700,525,700)
        x = 50
        y = 680
        listado = servicios.mostrarservicios()
        for registro in listado:
            for i in range(3):
                cser.drawString(x,y,str(registro[i]))
                x = x + 220
            y = y -20
            x = 50
        cser.showPage()
        cser.save()
        dir = os.getcwd()
        os.system('/usr/bin/xdg-open ' + dir + '/servicios.pdf')
    except:
        print('error en informe')