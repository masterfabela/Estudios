# Ejercicio 1
# Devuleve el mayor numero de 2 introducidos

#------------- EXERCICIO 1 ----------
def devuelveMax(num1, num2):
    if num2 > num1:
        return num2
    else:
        return num1

def ejercicio1():
    devuelveMax(
        int(input("Inserta numero 1")),
        int(input("Inserta numero 1"))
    )

#---------- EXERCICIO 2 -----------
def guardarEnListaYMostrar (nombre, direccion, telefono):
    listaContacto = [nombre, direccion, telefono]
    print("Los datos personales son: "+listaContacto[0] +" "+ listaContacto[2])

def ejercicio2():
    guardarEnListaYMostrar (
        input("Inserta tu Nombre: "),
        input("Inserta direccion: "),
        input("Numero de telefono: ")
    )

#-------- EXERCICIO 3 -----------
def calcularMediaYMostrar(num1, num2, num3):
    media = (num1+num2+num3)/3
    print("La media aritmetica es: " + str(media))

def ejercicio3():
    calcularMediaYMostrar(
        float(input("Inserta numero 1: ")),
        float(input("Inserta numero 2: ")),
        float(input("Inserta numero 3: "))
    )


ejercicio3()