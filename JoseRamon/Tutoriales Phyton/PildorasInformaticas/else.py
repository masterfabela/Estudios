print("Verificacion de acceso")


def comprobacionEdad(edad) :
    if edad_usuario < 18 :
        print("No puedes pasar")
    elif edad_usuario > 100:
        print("Edad incorrecta")
    else :
        print("Puedes pasar")
    print("El programa ha finalizado")

def comprobarNota(nota) :
    if nota < 5 :
        return "Insuficiente"
    elif nota < 6 :
        return "Suficiente"
    elif nota < 7 :
        return("Bien")
    elif nota < 9 :
        return "notable"
    else:
        return "sobresaliente"

print(comprobarNota(int(input("Inserta nota de alumno: "))))

