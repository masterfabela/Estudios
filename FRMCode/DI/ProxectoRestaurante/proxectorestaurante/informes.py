from reportlab.pdfgen import canvas
from reportlab.lib.pagesizes import A4
import os
import XestionDatos
import servicios
import sqlite3



def reportservicios(id):
    """

        Método que se encarga de imprimir a factura completa, cos datos de cliente e servicios, coincidentes co id seleccionado.

    """
    try:
        cser = canvas.Canvas('servicios.pdf', pagesize=A4)
        cser.setTitle('Informes')
        cser.setAuthor('Femio23')
        cser.setFont('Helvetica', size=11)
        cser.line(50, 820, 525, 820)
        cser.line(50, 745, 525, 745)
        cser.line(50, 725, 525, 725)
        textnom = 'RESTAURANTE TEIS'
        textdir = 'Avenida Galicia, 101 - Vigo'
        texttlfo = '986 12 04 64'
        textlistado = 'LISTADO DE SERVICIOS'
        textcliente = 'DATOS DE CLIENTE'
        cser.drawString(235, 795, textnom)
        cser.drawString(225, 775, textdir)
        cser.drawString(255, 755, texttlfo)
        cser.drawString(235, 735, textcliente)
        x = 50
        y = 705
        total=0.0
        listadocliente = carga_de_datos_cliente(id)
        base = ["DNI: ", "Apelidos: ", "Nome: ", "Dirección: ", "Provincia: ", "Localidade: "]
        contador=0
        for registro in listadocliente:
            cser.drawString(x, y, base[contador]+str(registro))
            x = x + 220
            y = y - 20
            x = 50
            contador=contador+1
        cser.drawString(227, 585, textlistado)
        listado = carga_de_datos_servicios(id)
        cser.line(50, 595, 525, 595)
        cser.line(50, 575, 525, 575)
        x = 50
        y = 555
        for registro in listado:
            for i in range(4):
                cser.drawString(x, y, str(registro[i]))
                x = x + 90
            subtotal = registro[2]*servicios.recortarEuro(registro[3])
            total=total+subtotal
            cser.drawString(x, y, servicios.colocarEuro(subtotal))
            y = y -20
            x = 50
        cser.line(50, y-10, 525, y-10)
        cser.drawString(400, y-20, "Total: "+servicios.colocarEuro(total))
        cser.line(50, y - 30, 525, y - 30)
        cser.drawString(220, y - 50, "GRACIAS POLA SÚA VISITA")
        cser.showPage()
        cser.save()
        dir = os.getcwd()
        os.system('/usr/bin/xdg-open ' + dir + '/servicios.pdf')
    except sqlite3.Error as e:
        print('error en informe: '+e)


def reportservicios2(id):
    """

        Método que se encarga de imprimir o ticket, cos datos dos servicios, coincidentes co id seleccionado.

    """
    try:
        cser = canvas.Canvas('servicios.pdf', pagesize=A4)
        cser.setTitle('Informes')
        cser.setAuthor('Femio23')
        cser.setFont('Helvetica', size=11)
        cser.line(50, 820, 525, 820)
        textnom = 'RESTAURANTE TEIS'
        textdir = 'Avenida Galicia, 101 - Vigo'
        texttlfo = '986 12 04 64'
        textlistado = 'LISTADO DE SERVICIOS'
        cser.drawString(235, 795, textnom)
        cser.drawString(225, 775, textdir)
        cser.drawString(255, 755, texttlfo)
        total = 0.0
        x = 50
        y = 700
        cser.drawString(227, 735, textlistado)
        listado = carga_de_datos_servicios(id)
        cser.line(50, 725, 525, 725)
        cser.line(50, 745, 525, 745)

        for registro in listado:
            for i in range(4):
                cser.drawString(x, y, str(registro[i]))
                x = x + 90
            subtotal = registro[2]*servicios.recortarEuro(registro[3])
            total = total+subtotal
            cser.drawString(x, y, servicios.colocarEuro(subtotal))
            y = y -20
            x = 50
        cser.line(50, y-10, 525, y-10)
        cser.drawString(400, y-20, "Total: "+servicios.colocarEuro(total))
        cser.line(50, y - 30, 525, y - 30)
        cser.drawString(220, y - 50, "GRACIAS POLA SÚA VISITA")
        cser.showPage()
        cser.save()
        dir = os.getcwd()
        os.system('/usr/bin/xdg-open ' + dir + '/servicios.pdf')
    except sqlite3.Error as e:
        print('error en informe: '+e)


def carga_de_datos_cliente(id):
    """

        Método que se encarga de intermediar entre a clase informes e a clase xestiondatos, para permitir a carga dos datos de cliente.

    """
    dni = XestionDatos.buscar_factura(id)
    cliente = XestionDatos.buscar_cliente(dni)
    return cliente


def carga_de_datos_servicios(id):
    """

        Método que se encarga de intermediar entre a clase informes e a clase xestiondatos, para permitir a carga dos datos de servicio.

    """
    servicios = XestionDatos.buscar_servicios(id)
    return servicios



