#-*- coding: utf-8 -*-
#Este e un xogo de adivinar un numero

import random

intentos = 0
print('Hola, Como te chamas?')
meuNome = raw_input()
numero = random.randint(1, 20)
print('Bueno '+meuNome+' estou pensando nun numero do 1 ao 20.')
while (intentos < 6):
    print('Adivinao!')
    candidato = int(raw_input())
    intentos = intentos+1
    if (candidato < numero):
        print('O meu numero e mais grande')
    if (candidato > numero):
        print('O meu numero e mais pequeno')
    if (candidato == numero):
        break

if (candidato == numero):
    intentos = str(intentos)
    print('Noraboa '+meuNome+' Adivinache o numero en '+intentos+' intentos!')

if (candidato != numero):
    numero = str(intentos)
    print('¡NOOOON, xa vale!!, O numero que estaba pensando era '+numero+' .')