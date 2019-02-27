import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
import sqlite3

"""

    Clase Principal que se encarga da xestión dos datos da BBDD principal.
    Neste metodo principal, realizase a conexión coa BBDD.

"""
try:
        """datos conexion"""
        bbdd = 'BDRestaurante'
        conex = sqlite3.connect(bbdd)
        cur = conex.cursor()
        print("Conexion con BDRestaurante correcta.")

except sqlite3.OperationalError as e:
        print(e)


def pechar_conexion():
    """

        Método que se encarga de pechar a conexión coa BBDD principal.

    """
    try:
        conex.close()
        print("Pechando conexion con BDRestaurante.")
    except sqlite3.OperationalError as e:
        print(e)


def login(usuario, contraseña, venta):

    """

        Método que se encarga de asegurar que o login se realiza correctamente.
        Mais concretamente,compara o contrasinal e o usuario proporcionados cos almacenados na BBDD.

    """
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

    """

        Método que se encarga de devolver todos os datos referentes á taboa Servicio, para a sua posterior insercion na ListView correspondente.

    """
    try:
        cur.execute("select * from Servicio;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)



def consultar_servicio():
    """

        Método que se encarga de devolver todos os datos referentes á taboa LineaFactura, para a sua posterior insercion na ListView correspondente.

    """
    try:
        cur.execute("select * from LineaFactura;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)


def consultar_cliente():

    """

        Método que se encarga de devolver todos os datos referentes á taboa Cliente, para a sua posterior insercion na ListView correspondente.

    """
    try:
        cur.execute("select * from Cliente;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)


def consultar_facturas():


    """

        Método que se encarga de devolver todos os datos referentes á taboa Factura, para a sua posterior insercion na ListView correspondente.

    """
    try:
        cur.execute("select * from Factura;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_lineaFactura():
    """

        Método que se encarga de devolver todos os datos referentes á taboa LineaFactura, para a sua posterior insercion na ListView correspondente.

    """
    try:
        cur.execute("select * from LineaFactura;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_lineaFactura_mod(id):
    """

        Método que se encarga de devolver todos os datos referentes á taboa LineaFactura cuxo ID coindide co id proporcionado, para a sua posterior insercion na ListView correspondente.

    """
    try:
        cur.execute("select * from LineaFactura where idFactura = '"+id+"';")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)


def consultar_mesas():
    """

        Método que se encarga de devolver todos os datos referentes á taboa Mesa, para a sua posterior insercion na ListView correspondente.

    """
    try:
        cur.execute("select * from Mesa;")
        listado = cur.fetchall()

        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_servicios():

    """

        Método que se encarga de devolver todos os datos referentes á taboa Servicio, para a sua posterior insercion na ListView correspondente.

    """
    try:
        cur.execute('select * from servicio;')
        listado = cur.fetchall()
        conex.commit()
        return listado

    except sqlite3.OperationalError as e:
        print(e)
        bbdd.conexion.rollback()


def insertar_cliente(fila):
    """

        Método que se encarga de insertar , mediante a fila proporcionada, datos novos na taboa Cliente.

    """
    try:
        cur.execute("insert into cliente(dni, apelidos, nome, direccion, provincia, cidade) values(?,?,?,?,?,?);", fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()


def insertar_factura(fila):
    """

        Método que se encarga de insertar , mediante a fila proporcionada, datos novos na taboa Fila.

    """
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
    """

        Método que se encarga de insertar , mediante a fila proporcionada, datos novos na taboa Servicio.

    """
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
    """

        Método que se encarga de insertar , mediante a fila proporcionada, datos novos na taboa LineaFactura.

    """
    try:
        cur.execute("insert into LineaFactura(idFactura, idServicio, cantidade) values(?,?,?);", fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()


def modificar_cliente(fila):
    """

        Método que se encarga de modificar , mediante a fila proporcionada, datos novos na taboa Cliente.

    """
    try:
        cur.execute("update cliente set dni=?, apelidos = ?, nome = ?, direccion = ?, provincia = ?, cidade = ? where dni= ? ;", fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()


def pagar_factura(id):
    """

        Método que se encarga de modificar , mediante o id proporcionado, o campo "pagada" da taboa Factura.

    """
    try:
        cur.execute("update Factura set pagada= 'Si' where id='"+id+"' ;")
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de cliente: "+e)
        conex.rollback()


def modificar_mesas(valor, id):
    """

        Método que se encarga de modificar , mediante o id proporcionado, o campo "Ocupada" da taboa Mesa.

    """
    try:
        cur.execute("update Mesa set Ocupada = '"+valor+"' where Id =" + id+";")
        conex.commit()
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def baixa_cliente(dni):
    """

        Método que se encarga de eliminar , mediante o dni proporcionado, o cliente que coincida.

    """
    try:
        cur.execute("delete from cliente where dni = '"+dni+"';")
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na baixa de cliente: "+e)
        conex.rollback()


def cargar_clientes(combo):
    """

        Método que se encarga de cargar no combo proporcionado, os clientes existentes.

    """
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
    """

        Método que se encarga de cargar no combo proporcionado, as mesas existentes.

    """
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
    """

        Método que se encarga de cargar no combo proporcionado, os camareiros existentes.

    """
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
    """

        Método que se encarga de cargar no combo proporcionado, as facturas non pagadas.

    """
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

    """

        Método que se encarga de cargar no combo proporcionado, os servicios(Platos) existentes.

    """
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
    """

        Método que se encarga de buscar o dni do cliente relacionado co id da factura indicado.

    """
    try:
        cur.execute("SELECT dniCliente FROM Factura where id='"+str(id)+"';")
        listado = cur.fetchone()
        return listado[0]
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)


def buscar_cliente(id):
    """

        Método que se encarga de buscar o cliente relacionado co id indicado.

    """
    try:
        cur.execute("SELECT * FROM Cliente where dni='"+str(id)+"';")
        listado = cur.fetchone()
        return listado
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)


def buscar_servicios(id):
    """

        Método que se encarga de buscar os Id da FilaFactira, o nome do producto, a cantidade,e o prezo, das taboas FilaFactura e Servicio,co id da factura indicado.

    """
    try:
        cur.execute("select c.idVenta, s.producto, c.cantidade, s.precio from LineaFactura as c inner join Servicio as s on s.codigo = c.idServicio  where c.idFactura = '"+str(id)+"';")
        listado = cur.fetchall()
        return listado
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)