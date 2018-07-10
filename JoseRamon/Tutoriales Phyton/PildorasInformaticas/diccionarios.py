# Nos permite almacenar datos con clave:valor
miDiccionario = {
    "Alemania": "Berlin",
    "Francia": "Paris",
    "Reino Unido": "Londres",
    "España": "Madrid"
    }

# Escribir un elemento de dicionario
print(miDiccionario["Francia"])

# Añade un elemento al diccionario
miDiccionario["Italia"] = "Lisboa"

# Edita un dato en el diccionario, nunca se guardan 2 claves iguales
miDiccionario["Italia"] = "Roma"

# Elimina un elemento del diccionario 
del miDiccionario["Reino Unido"]

#Usar una tupla para llenar un dicionario
miTupla = ("España", "Francia", "Alemania")
diccionarioDeTupla = {
    miTupla[0]: "Madrid",
    miTupla[1]: "Paris",
    miTupla[2]: "Berlin"
    }
print(diccionarioDeTupla)

# Introducir una tupla en un diccionario
dicionarioNuevo = {
    23: "Jordan",
    "Nombre": "Michael",
    "Equipo": "Chicago",
    "Anillos": [
        1991,
        1992,
        1993,
        1996,
        ]
    }

# Imprime las claves de diccionario
print(miDiccionario.keys())

# Imprime los valores
print(miDiccionario.values())

# Numero de valores del diccionario
print(len(miDiccionario))