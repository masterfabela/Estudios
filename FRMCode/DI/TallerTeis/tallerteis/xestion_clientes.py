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
    try:
        listclientes.append(filacli)
        treeclientes.show()

    except sqlite3.OperationalError as e:
        print(e)



def limpiacli(caixas):
    for fila in caixas:
        fila.set_text('')


def consultar_clientes():
    try:
        cur.execute("select * from clientes")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def edicion(fila,dni,lblavisos):
    try:
        cur.execute("update clientes set dni = ?, mat = ?, apel =?, nom = ?, mail = ?, movil = ?, data = ? where dni = ?"+dni+";", fila)
        lblavisos.set_text('Fila ' + fila[0] + ' actualizada.')
    except sqlite3.OperationalError as e:
        print(e);
        conex.rollback()


def eliminacion(fila,lblavisos):
    try:
        cur.execute('delete from clientes where dni = ? and mat = ? and apel = ? and nom = ? and mail = ? and movil = ? and data = ? ;',fila)
        conex.commit
        lblavisos.set_text('Fila '+fila[0]+' eliminada.')
    except sqlite3.OperationalError as e:
        print(e);
        conex.rollback()


def altacliente(fila,lblavisos):
    try:
        cur.execute("insert into clientes(dni,mat,apel,nom,mail,movil,data) values (?,?,?,?,?,?,?)", fila)
        conex.commit()
        lblavisos.set_text('Fila ' + fila[0] + ' engadida.')
    except sqlite3.OperationalError as e:
        print(e)
        conex.rollback()


def pechar_conexion():
    try:
        conex.close()
        print("Pechando conexion coa BD.")
    except sqlite3.OperationalError as e:
        print(e)



