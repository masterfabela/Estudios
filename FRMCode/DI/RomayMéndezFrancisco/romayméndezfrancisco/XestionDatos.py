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
        bbdd = 'DBBuses'
        conex = sqlite3.connect(bbdd)
        cur = conex.cursor()
        print("Conexion con BDBuses correcta.")

except sqlite3.OperationalError as e:
        print(e)


def pechar_conexion():
    """

        Método que se encarga de pechar a conexión coa BBDD principal.

    """
    try:
        conex.close()
        print("Pechando conexion con BDBuses.")
    except sqlite3.OperationalError as e:
        print(e)


def engadir_bus(fila):
    """

        Método que se encarga de insertar , mediante a fila proporcionada, datos novos na taboa Buses.

    """
    try:
        cur.execute("insert into Buses(matricula,plazas) values(?,?);",
                    fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de bus: " + e)
        conex.rollback()


def eliminar_bus(id):
    """

            Método que se encarga de eliminar , mediante o dni proporcionado, o cliente que coincida.

        """
    try:
        cur.execute("delete from Buses where matricula = '" + id + "';")
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na baixa de bus: " + e)
        conex.rollback()


def engadir_servicio(fila):
    """

            Método que se encarga de insertar , mediante a fila proporcionada, datos novos na taboa Buses.

        """
    try:
        cur.execute("insert into Servicios (matricula,plazas,kmInicio,kmFin,kmViaxe) values(?,?,?,?,?);",
                    fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de bus: " + e)
        conex.rollback()


def eliminar_servicio(id):
    """

                Método que se encarga de eliminar , mediante o dni proporcionado, o cliente que coincida.

            """
    try:
        cur.execute("delete from Servicios where numviaxe = '" + id + "';")
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na baixa de bus: " + e)
        conex.rollback()


def cargar_matriculas(combo):
    try:
        i = 0
        cur.execute("SELECT matricula FROM Buses;")
        listado = cur.fetchall()
        list = Gtk.ListStore(str)
        for fila in listado:
            i = i + 1
            list.append(fila)

        for name in list:
            combo.append_text(name[0])
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los autobuses: "+e)


def consultar_buses():
    try:
        cur.execute("select * from Buses;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)


def consultar_servicios():
    try:
        cur.execute("select * from Servicios;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)

def modificar_servicio(id,fila):
    """

            Método que se encarga de insertar , mediante a fila proporcionada, datos novos na taboa Buses.

        """
    try:
        cur.execute("update Servicios set kmInicio = ?, kmFin = ?, kmViaxe=? where numviaxe='"+id+"';", fila)
        conex.commit()
    except sqlite3.Error as e:
        print("Erro na inserción de bus: " + e)
        conex.rollback()


def buscar_plazas(id):
    """

        Método que se encarga de buscar as plazas do bus relacionado coa matricula indicada.

    """
    try:
        cur.execute("SELECT plazas FROM Buses where matricula='"+id+"';")
        listado = cur.fetchone()
        return listado[0]
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)


def contar():
    try:
        cur.execute("SELECT count(matricula) FROM Buses;")
        listado = cur.fetchone()
        return listado[0]
    except sqlite3.OperationalError as e:
        print("Erro a o carga-los clientes: "+e)