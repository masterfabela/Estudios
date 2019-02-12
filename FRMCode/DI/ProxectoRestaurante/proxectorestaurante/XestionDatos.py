import sqlite3
try:
        """datos conexion"""
        bbdd = 'BDRestaurante'
        conex = sqlite3.connect(bbdd)
        cur = conex.cursor()
        print("Conexion con BDRestaurante correcta.")
except sqlite3.OperationalError as e:
        print(e)


def pechar_conexion():
    try:
        conex.close()
        print("Pechando conexion con BDRestaurante.")
    except sqlite3.OperationalError as e:
        print(e)


def consultar_servicio():
    try:
        cur.execute("select * from Servicio")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_cliente():
    try:
        cur.execute("select * from Cliente")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()



def consultar_camarero():
    try:
        cur.execute("select * from Camarero")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def mostrarservicios():
    try:
        cur.execute('select * from servicio')
        listado = cur.fetchall()
        conex.commit()
        return listado

    except sqlite3.OperationalError as e:
        print(e)
        bbdd.conexion.rollback()

