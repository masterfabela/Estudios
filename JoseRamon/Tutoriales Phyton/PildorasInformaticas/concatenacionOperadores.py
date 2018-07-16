def primerEjemplo():
    edad = -7
    if 0 < edad < 100:
        print("La edad es correcta")
    else:
        print("Edad incorrecta")


def ejemploSalariosEmpresa():
    salarioPresidente = int(input("Introduce salario del presidente: "))
    print("Salario presidente: " + str(salarioPresidente))

    salarioDirector = int(input("Introduce salario del director: "))
    print("Salario director: " + str(salarioDirector))

    salarioJefeArea = int(input("Introduce salario del Jefe de area: "))
    print("Salario Jefe de area: " + str(salarioJefeArea))

    salarioAdministrativo = int(
        input("Introduce salario del administrativo: "))
    print("Salario administrativo: " + str(salarioAdministrativo))

    if salarioAdministrativo < salarioJefeArea < salarioDirector < salarioPresidente:
        print("Los salarios son correctos")
    else:
        print("Algo falla en esta empresa")


def asignadorDeBecas():
    print("Programa de becas año 2017: ")
    distanciaEscuela = int(input("Introduce la distancia en KMs: "))
    numeroHermanos = int(input("Introduce numero de hermanos en el centro: "))
    salarioFamiliar = float(input("Introduce salario anual bruto: "))
    if tieneDerechoABeca(distanciaEscuela, numeroHermanos, salarioFamiliar):
        print("Tiene derecho a beca")
    else:
        print("No tiene derecho a beca")


def tieneDerechoABeca(distanciaEscuela, numeroHermanos, salarioFamiliar):
    if distanciaEscuela > 40 and numeroHermanos > 2 or salarioFamiliar <= 20000:
        return True
    else:
        return False

def ejemploAsignaturas():
    listaDeAsignaturas = (
        "informatica grafica",
        "pruebas de software",
        "usabilidad y accesibilidad"
    )
    print("Asignaturas a escojer: " + str(listaDeAsignaturas))
    
    if estaAsignatura(
        input("Que asignatura desea?: "),
        list(listaDeAsignaturas)
    ):
        print("Asignatura Asignada")
    else:
        print("La asignatura no existe en la lista")

def estaAsignatura(asignatura, asignaturas):
    asignatura = asignatura.lower()
    return asignatura in asignaturas

ejemploAsignaturas()
 
