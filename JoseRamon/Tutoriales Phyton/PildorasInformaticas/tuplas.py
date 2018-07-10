# Las tuplas son listas inmutables (no se pueden modificar)
# se usan porque son mas rapidas, ocupan mucho menos
# espacio

tupaUnitaria = ("Juan",)
miTupla = ("Juan", 13, 1, 1995)

miLista = list(miTupla)

tuplaNueva = tuple(miLista)

print(miTupla[2])

#Nos dice si un elemento esta en una tupla
print("Juan" in miTupla)

#Nos dice cuantas veces se encuentra un elemento en la tupla
print(miTupla.count(13))

#Dice el numero de elemtos de la tupla
print(len(miTupla))

#Desempaquetado de tupla, asigna cada valor a una variable
nombre, dia, mes, year = miTupla
print(nombre)
print(dia)
print(mes)
print(year)
