from typing import List, Any

import bbdd
import locale

locale.setlocale(locale.LC_ALL, 'es_ES.UTF-8')


def altaser(servicio, precio):
    try:
        precio = round(float(precio), 2)
        precio = locale.currency(precio)
        servicio = servicio.title()
        fila = [servicio, precio]
        bbdd.cur.execute('insert into servicios (servicio, precio) values (?,?)', fila)
        bbdd.conexion.commit()

    except bbdd.sqlite3.OperationalError as e:
        print(e)
        bbdd.conexion.rollback()


def mostrarservicios():
    try:
        bbdd.cur.execute('select * from servicios order by servicio')
        listado = bbdd.cur.fetchall()
        bbdd.conexion.commit()
        return listado

    except bbdd.sqlite3.OperationalError as e:
        print(e)
        bbdd.conexion.rollback()


def cargarservicio(lista, treeservicio):
    try:
        model, iter = treeservicio.get_selection().get_selected()
        listserv = []
        if iter != None:
            for i in range(3):
                listserv.append(model.get_value(iter, i))
            for j in range(3):
                lista[j].set_text(str(listserv[j]))
    except:
        print('error carga servicio')


def bajaservicio(codigo):
    try:
        if codigo != None:
            bbdd.cur.execute('delete from servicios where id = ?', (codigo,))
            bbdd.conexion.commit()
    except bbdd.sqlite3.OperationalError as e:
        print(e)
        bbdd.conexion.rollback()


def modifservicios(filaser):
    try:
        var = filaser[2]
        var = var.split()[0]   #fuera el símbolo del euro
        filaser[2] = locale.atof(var)
        if filaser[0] != None:
            filaser[2] = round(float(filaser[2]), 2)
            filaser[2] = locale.currency(filaser[2])    #lo volvemos a poner como euro
            bbdd.cur.execute('update servicios set servicio = ?, precio = ? where id = ?', (str(filaser[1]), str(filaser[2]), str(filaser[0])))
            bbdd.conexion.commit()
    except bbdd.sqlite3.OperationalError as e:
        print(e)
        bbdd.conexion.rollback()






