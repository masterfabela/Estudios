import sqlite3

from gi.repository import Gtk


try:
    bbdd = 'provinciaslocalidades'
    conex = sqlite3.connect(bbdd)
    cur = conex.cursor()
    print('Conexion con BDProvinciasLocalidades correcta')

except sqlite3.OperationalError as e:
    print("Erro ó intentala conexion coa base BDProvinciasLocalidades: "+e)


def pechar_conexion():

    try:
        conex.commit()
        conex.close()
        print('cerrando base de provincias y municipios')
    except sqlite3.OperationalError as e:
        print("Erro no peche da conexion con BDProvinciasLocalidades: "+e)

def cargar_provincias(combo):
    try:
        i = 0
        cur.execute("SELECT provincia FROM Provincias;")
        listado = cur.fetchall()
        list = Gtk.ListStore(str)
        for fila in listado:
            i = i + 1
            list.append(fila)

        for name in list:
            combo.append_text(name[0])
    except sqlite3.OperationalError as e:
        print("Erro a o carga-las provincias: "+e)

def cargar_localidades(combo,provincia):
    try:
        i = 0
        cur.execute(
            "SELECT M.Municipio FROM Municipios as M INNER JOIN Provincias as P on M.provincia_id = P.id where P.Provincia=?",
            (provincia,))
        list = Gtk.ListStore(str)
        all_rows = cur.fetchall()
        for row in all_rows:
            i = i + 1
            list.append([row[0]])
        for name in list:
            combo.append_text(name[0])
    except sqlite3.OperationalError as e:
        print("Erro na carga das localidades: "+e)