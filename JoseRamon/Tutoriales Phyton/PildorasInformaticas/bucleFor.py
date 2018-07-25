def primerFor():
    for i in ["primavera","verano","otoño","invierno"]:
        print(i)

def terminarSinSaltoDeLinea():
    for i in ["Pildoras", "Informaticas", 33]:
        # end indica como termina de imprimir lo que mandas
        print("Hola", end=" ")

def comprobarEmail():
    email = input("Introduce direccion de email: ")
    palabraConArroba = False
    palabraConPunto = False
    #Recorre caracter a caracter
    for i in range(len(email)):
        if email[i]=="@":
            palabraConArroba = True
        if email[i] == '.':
            palabraConPunto = True
    if palabraConArroba and palabraConPunto:
        print("Email correcto")
    else:
        print("Email no correcto")


def rangos():
    for i in range(5,50,3):
        print(f"valor de la variable {i}")
