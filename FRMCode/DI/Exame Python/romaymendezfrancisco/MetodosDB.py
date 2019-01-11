import sqlite3
try:
        """datos conexion"""
        bbdd = 'frm'
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


def consultar_pacientes():
    try:
        cur.execute("select * from paciente")
        listado = cur.fetchall()
        conex.commit()
        print("Pacientes")
        return listado
    except sqlite3.Error as e:
        print("Erro na recuperacion dos pacientes")
        print(e)
        conex.rollback()


def consultar_medidas():
    try:
        cur.execute("select * from medida")
        listado = cur.fetchall()
        conex.commit()
        print("Medidas")
        return listado
    except sqlite3.Error as e:
        print("Erro na recuperacion das medidas")
        print(e)
        conex.rollback()


def insert_paciente(fila,lblavisos):
    try:
        cur.execute("insert into paciente(dni,nome,sexo) values (?,?,?)", fila)
        conex.commit()
        lblavisos.show()
        lblavisos.set_text('Fila ' + fila[0] + ' engadida.')
    except sqlite3.OperationalError as e:
        print(e)
        conex.rollback()


def insert_medida(fila,lblavisos):
    try:
        cur.execute("insert into medida (dni,peso,talla,imc,fecha,clasificacion) values (?,?,?,?,?,?)", fila)
        conex.commit()
        lblavisos.show()
        lblavisos.set_text('Fila ' + fila[0] + ' engadida.')
    except sqlite3.OperationalError as e:
        print(e)
        conex.rollback()


def update_paciente(fila, lblavisos):
    try:
        cur.execute("update paciente set nome = ?, sexo = ? where dni = ? ;",fila)
        conex.commit()
        lblavisos.show()
        lblavisos.set_text('Fila ' + fila[2] + ' modificada.')
    except sqlite3.OperationalError as e:
        print(e)
        conex.rollback()


def delete_paciente(fila,lblavisos):
    try:
        cur.execute('delete from paciente where dni = ? and nome = ? and sexo = ?;',fila)
        conex.commit
        lblavisos.show()
        lblavisos.set_text('Fila '+fila[0]+' eliminada.')
    except sqlite3.OperationalError as e:
        print(e);
        conex.rollback()