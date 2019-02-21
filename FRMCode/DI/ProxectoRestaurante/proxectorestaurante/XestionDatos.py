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
        cur.execute("select * from LineaFactura;")
        listado = cur.fetchall()
        conex.commit()
        return listado
    except sqlite3.Error as e:
        print(e)
        conex.rollback()


def consultar_cliente():
    try:
        cur.execute("select * from Cliente;")
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
