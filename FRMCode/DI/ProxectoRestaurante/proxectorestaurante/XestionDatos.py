import sqlite3
from gi.repository import Gtk
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
        cur.execute("select * from LineaFactura;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)


def consultar_cliente():
    try:
        cur.execute("select * from Cliente;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)


def consultar_facturas():
    try:
        cur.execute("select * from Factura;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_mesas():
    try:
        cur.execute("select * from Mesa;")
        listado = cur.fetchall()

        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def mostrarservicios():
    try:
        cur.execute('select * from servicio;')
        listado = cur.fetchall()
        conex.commit()
        return listado

    except sqlite3.OperationalError as e:
        print(e)
        bbdd.conexion.rollback()


def login(usuario, contraseña, venta):
    try:
        cur.execute('select * from Camarero;')
        listado = cur.fetchall()
        for columna in listado:
            if columna[1] == usuario and columna[2] == contraseña:
                venta.hide()
                print("Acceso concedido")
                return True
            else:
                print("Acceso denegado")
                return False
    except sqlite3.OperationalError as e:
        print(e)


def insertar_cliente(fila):
    try:
        cur.execute("insert into cliente(dni, apelidos, nome, direccion, provincia, cidade) values(?,?,?,?,?,?);", fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()


def modificar_cliente(fila):
    try:
        cur.execute("update cliente set dni=?, apelidos = ?, nome = ?, direccion = ?, provincia = ?, cidade = ? where dni= ? ;", fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()


def baixa_cliente(dni):
    try:
        cur.execute("delete from cliente where dni = '"+dni+"';")
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na baixa de cliente: "+e)
        conex.rollback()


def modificar_mesas(valor, id):
    try:
        cur.execute("update Mesa set Ocupada = '"+valor+"' where Id =" + id+";")
        conex.commit()
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def cargar_clientes(combo):
    try:
        i = 0
        cur.execute("SELECT dni FROM Cliente;")
        listado = cur.fetchall()
        list = Gtk.ListStore(str)
        for fila in listado:
            i = i + 1
            list.append(fila)
        for name in list:
            combo.append_text(name[0])
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)


def cargar_mesa(combo):
    try:
        i = 0
        cur.execute("SELECT Id FROM Mesa;")
        listado = cur.fetchall()
        list = Gtk.ListStore(str)
        for fila in listado:
            i = i + 1
            list.append(fila)
        for name in list:
            combo.append_text(name[0])
    except sqlite3.OperationalError as e:
        print("Erro a o carga-las mesas: "+e)


def cargar_camareiro(combo):
    try:
        i = 0
        cur.execute("SELECT id FROM Camarero;")
        listado = cur.fetchall()
        list = Gtk.ListStore(str)
        for fila in listado:
            i = i + 1
            list.append(fila)
        for name in list:
            combo.append_text(name[0])
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los camareiros: "+e)


def insertar_factura(fila):
    try:
        cur.execute("insert into Factura(dniCliente,idCamareiro,idMesa,fecha,pagada) values(?,?,?,?,?);", fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()

def pagar_factura(id):
    try:
        cur.execute("update Factura set pagada= 'Si' where id='"+id+"' ;")
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()