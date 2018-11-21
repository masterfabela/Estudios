import sqlite3
try:
        """datos conexion"""
        bbdd = 'DBTaller'
        conex = sqlite3.connect(bbdd)
        cur = conex.cursor()
        print("Base de datos conectada.")
except sqlite3.OperationalError as e:
        print(e)


def altacli(treeclientes,listclientes,filacli):
    listclientes.append(filacli)
    treeclientes.show()


def limpiacli(caixas):
    for fila in caixas:
        fila.set_text('')


def consultar_clientes():
    try:
        cur.execute("select * from clientes")
        listado = cur.fetchall()
        conex.commit()
        print("Hei")
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def edicion(fila):
    try:
        print('click en editar')
    except sqlite3.OperationalError as e:
        print(e);
        conex.rollback()


def eliminacion(fila):
    try:
        cur.execute('delete from clientes where dni = ? and mat = ? and apel = ? and nom = ? and mail = ? and movil = ? and data = ? ;',fila)
        conex.commit
        print('Fila '+fila[0]+' eliminada.')
    except sqlite3.OperationalError as e:
        print(e);
        conex.rollback()


def altacliente(fila):
    try:
        cur.execute("insert into clientes(dni,mat,apel,nom,mail,movil,data) values (?,?,?,?,?,?,?)", fila)
        conex.commit()
    except sqlite3.OperationalError as e:
        print(e)
        conex.rollback()


def pechar_conexion():
    try:
        conex.close()
        print("Pechando conexion coa BD.")
    except sqlite3.OperationalError as e:
        print(e)



