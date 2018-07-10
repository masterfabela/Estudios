print("Programa de evaluacion de notas")


def evaluacion(nota):
    valoracion = "aprobado"
    if nota < 5 :
        valoracion = "suspenso"
    return valoracion

print(evaluacion(int(input("Introduzca la nota del alumno"))))
