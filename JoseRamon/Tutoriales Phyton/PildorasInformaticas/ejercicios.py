# Ejercicio 1
# Devuleve el mayor numero de 2 introducidos
def devuelveMax(num1, num2):
    if num2 > num1:
        return num2
    else:
        return num1

def guardarEnListaYMostrar (nombre, direccion, telefono):
    listaContacto = [nombre, direccion, telefono]
    print("Los datos personales son: "+listaContacto[0] +" "+ listaContacto[2])

guardarEnListaYMostrar("Jose Ramon Vieites", "Xil Picon N7", 633072778)