import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
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


def consultar_plato():
    try:
        cur.execute("select * from Servicio;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
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


def consultar_lineaFactura():
    try:
        cur.execute("select * from LineaFactura;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_lineaFactura_mod(id):
    try:
        cur.execute("select * from LineaFactura where idFactura = '"+id+"';")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)


def consultar_mesas():
    try:
        cur.execute("select * from Mesa;")
        listado = cur.fetchall()

        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_servicios():
    try:
        cur.execute('select * from servicio;')
        listado = cur.fetchall()
        conex.commit()
        return listado

    except sqlite3.OperationalError as e:
        print(e)
        bbdd.conexion.rollback()


def insertar_cliente(fila):
    try:
        cur.execute("insert into cliente(dni, apelidos, nome, direccion, provincia, cidade) values(?,?,?,?,?,?);", fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()


def insertar_factura(fila):
    try:
        cur.execute("select max(id) from Factura;")
        listado=cur.fetchone()
        id=int(listado[0])+1
        cur.execute("insert into Factura(id,dniCliente,idCamareiro,idMesa,fecha,pagada) values('"+str(id)+"',?,?,?,?,?);", fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()


def insertar_plato(fila):
    try:
        cur.execute("select max(codigo) from Servicio;")
        listado=cur.fetchone()
        id=int(listado[0])+1
        cur.execute("insert into Servicio(codigo,producto,precio) values('"+str(id)+"',?,?);", fila)
        conex.commit()
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def insertar_lineaFactura(fila):
    try:
        cur.execute("insert into LineaFactura(idFactura, idServicio, cantidade) values(?,?,?);", fila)
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


def pagar_factura(id):
    try:
        cur.execute("update Factura set pagada= 'Si' where id='"+id+"' ;")
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()


def modificar_mesas(valor, id):
    try:
        cur.execute("update Mesa set Ocupada = '"+valor+"' where Id =" + id+";")
        conex.commit()
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def baixa_cliente(dni):
    try:
        cur.execute("delete from cliente where dni = '"+dni+"';")
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na baixa de cliente: "+e)
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


def cargar_facturas_activas(combo):
    try:
        i = 0
        cur.execute("SELECT id FROM Factura where pagada='No';")
        listado = cur.fetchall()
        list = Gtk.ListStore(str)
        for fila in listado:
            i = i + 1
            list.append(fila)
        for name in list:
            combo.append_text(name[0])
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)


def cargar_servicios(combo):
    try:
        i = 0
        cur.execute("SELECT producto FROM Servicio;")
        listado = cur.fetchall()
        list = Gtk.ListStore(str)
        for fila in listado:
            i = i + 1
            list.append(fila)
        for name in list:
            combo.append_text(name[0])
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)


def buscar_factura(id):
    try:
        cur.execute("SELECT dniCliente FROM Factura where id='"+str(id)+"';")
        listado = cur.fetchone()
        return listado[0]
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)


def buscar_cliente(id):
    try:
        cur.execute("SELECT * FROM Cliente where dni='"+str(id)+"';")
        listado = cur.fetchone()
        return listado
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)


def buscar_servicios(id):
    try:
        cur.execute("select c.idVenta, s.producto, c.cantidade, s.precio from LineaFactura as c inner join Servicio as s on s.codigo = c.idServicio  where c.idFactura = '"+str(id)+"';")
        listado = cur.fetchall()
        return listado
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)