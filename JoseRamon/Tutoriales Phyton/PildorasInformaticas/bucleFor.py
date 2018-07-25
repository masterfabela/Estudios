def primerFor():
    for i in ["primavera","verano","otoño","invierno"]:
        print(i)

def terminarSinSaltoDeLinea():
    for i in ["Pildoras", "Informaticas", 33]:
        # end indica como termina de imprimir lo que mandas
        print("Hola", end=" ")

def comprobarEmail(email):
    palabraConArroba = False
    palabraConPunto = False
    #Recorre caracter a caracter
    for i in email:
        if i=="@":
            palabraConArroba = True
        if i == '.':
            palabraConPunto = True
    if palabraConArroba and palabraConPunto:
        print("Email correcto")
    else:
        print("Email no correcto")

comprobarEmail(input("Introduce tu direcion de email: "))

def rangos():
    for i in range(5):
        print("hola")
        print(i)