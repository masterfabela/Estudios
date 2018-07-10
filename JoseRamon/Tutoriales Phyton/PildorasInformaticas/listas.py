miLista = ["Maria", 5, True, 78.35]

#Imprime toda la lista
print(miLista[:])

#Imprime cada elemento
print(miLista[0])
print(miLista[1])
print(miLista[2])
print(miLista[3])

#El numero se cuenta desde el final al ser negativo
print(miLista[-2])

#Acceder a una porcion de la lista
print(miLista[0:3])
print(miLista[:3])
print(miLista[2:])

#Añade un elemento al final de la lista
miLista.append("Sandra")

#Incluye un elemento en una posicion concreta
miLista.insert(2, "Sandra")

#Concatena la lista con otra
miLista.extend(["Jose", "Manuel", "Damian"])

#Indica el indice del elemento seleccionado si
# existen repetidos nos devolvera el primero
print(miLista.index("Jose"))

#Elimina un elemento de la lista
miLista.remove("Ana")

print(miLista[:])

#Elimina el ultimo elemento de una lista
miLista.pop()

#Con el operador + las listas se suman
miLista2 = ["Sandra", "Lucia"]
miLista3 = miLista + miLista2
print(miLista3)