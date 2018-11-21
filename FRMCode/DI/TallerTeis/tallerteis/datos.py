import re


def comprobarDNI(caixa):
    try:
        tabla = "TRWAGMYFPDXBNJZSQVHLCKE"  # letras del dni
        extrange = "XYZ"
        taboaextrange = {'X': '0', 'Y': '1', 'Z': '2'}
        numeros = "1234567890"
        dni = caixa.get_text()
        dni = dni.upper()  # pasa letras a mayúsculas
        if len(dni) == 9:
            letra = dni[8]
        dni = dni[:8]  # el número que son los 8 primeros
        if dni[0] in extrange:  # comprueba que es extranjero
            dni = dni.replace(dni[0], taboaextrange[dni[0]])
        return len(dni) == len([n for n in dni if n in numeros]) and tabla[int(dni) % 23] == letra
    except:
        return False


def comprobarMail(mail):
    if re.match('^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$', mail.lower()):
        return True
    else:
        return False

