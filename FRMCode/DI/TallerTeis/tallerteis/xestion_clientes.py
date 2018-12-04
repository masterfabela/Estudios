import sqlite3
try:
        """datos conexion"""
        bbdd = 'DBTaller'
        conex = sqlite3.connect(bbdd)
        cur = conex.cursor()
        print("Base de datos conectada.")
except sqlite3.OperationalError as e:
        print(e)


def pechar_conexion():
    try:
        conex.close()
        print("Pechando conexion coa BD.")
    except sqlite3.OperationalError as e:
        print(e)


def limpiacli(caixas):
    for fila in caixas:
        fila.set_text('')


def altacli(treeclientes,listclientes,filacli):
    try:
        listclientes.append(filacli)
        treeclientes.show()

    except sqlite3.OperationalError as e:
        print(e)


def consultar_clientes():
    try:
        cur.execute("select * from clientes")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_reparacion():
    try:
        cur.execute("select * from reparacions")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_factura():
    try:
        cur.execute("select * from facturas")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def edicioncliente(fila,lblavisos):
    try:
        cur.execute("update clientes set dni = ?, mat = ?, apel =?, nom = ?, mail = ?, movil = ?, data = ? where dni = ?;", fila)
        conex.commit
        lblavisos.show()
        lblavisos.set_text('Fila ' + fila[0] + ' actualizada.')
    except sqlite3.OperationalError as e:
        print(e);
        conex.rollback()

def edicionreparacion(fila,lblavisos):
    try:
        cur.execute("update reparacions set mobra = ?, bat = ?, ac =?, pneu = ?, past = ?, fil = ? where nfact = ?;", fila)
        conex.commit
        lblavisos.show()
        lblavisos.set_text('Fila ' + str(fila[6]) + ' actualizada.')
    except sqlite3.OperationalError as e:
        print(e);
        conex.rollback()


def eliminacioncliente(fila,lblavisos):
    try:
        cur.execute('delete from clientes where dni = ? and mat = ? and apel = ? and nom = ? and mail = ? and movil = ? and data = ? ;',fila)
        conex.commit
        lblavisos.show()
        lblavisos.set_text('Fila '+fila[0]+' eliminada.')
    except sqlite3.OperationalError as e:
        print(e);
        conex.rollback()


def eliminacionreparacion(int,lblavisos):
    try:
        cur.execute('delete from reparacions where nfact = '+str(int)+';')
        conex.commit
        lblavisos.show()
        lblavisos.set_text('Fila '+str(int)+' eliminada.')
    except sqlite3.OperationalError as e:
        print(e);
        conex.rollback()


def altacliente(fila,lblavisos):
    try:
        cur.execute("insert into clientes(dni,mat,apel,nom,mail,movil,data) values (?,?,?,?,?,?,?)", fila)
        conex.commit()
        lblavisos.show()
        lblavisos.set_text('Fila ' + fila[0] + ' engadida.')
    except sqlite3.OperationalError as e:
        print(e)
        conex.rollback()


def altareparacion(fila,lblavisos):
    try:
        cur.execute("insert into reparacions(mobra, bat, ac, pneu, past, fil) values (?,?,?,?,?,?)", fila)
        conex.commit()
        lblavisos.show()
        lblavisos.set_text('Fila engadida.')
    except sqlite3.OperationalError as e:
        print(e)
        conex.rollback()


def altafactura(fila,lblavisos):
    try:
        cur.execute("insert into facturas (nfac, mat, datafact) values (?,?,?)", fila)
        conex.commit()
        lblavisos.show()
        lblavisos.set_text('Fila '+str(fila[0])+'engadida.')
    except sqlite3.OperationalError as e:
        print(e)
        conex.rollback()

