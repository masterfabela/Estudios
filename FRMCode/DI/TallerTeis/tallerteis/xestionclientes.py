
def altacli(treeclientes,listclientes,filacli):
    listclientes.append(filacli)
    treeclientes.show()
def limpiacli(caixas):
    for fila in caixas:
        fila.set_text('')
