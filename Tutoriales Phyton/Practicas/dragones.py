# -*- coding: utf-8 -*- 

import random
import time


xogar_outra_vez = 's'

def muestra_intro():
    """Mostra a cabeceira do programa"""
    print 'Estas nun planeta cheo de dragons. Ao teu frente.'
    print 'hay 2 covas. nunha delas o dragon e bo e '
    print 'compartira o seu tesouro contigo. O outro dragon '
    print 'esta famelico e devorarate en canto te vexa.'
    print

def elixe_cova():
    """ Elixe o tipo de cova entre o numero 1 e 2"""
    cova = ""
    while cova != '1' and cova != '2':
        print("A que cova queres ir? (1 or 2)")
        cova = raw_input()
        return cova
    
def mirar_cova(que_cova):
    """Comprova se a cova elixida e perigosa ou non aleatoriamente"""
    print "Aproximaste a cova"
    time.sleep(2)
    print("Esta escuro e misterioso")
    time.sleep(2)
    print "Un gran dragon aparece diante de ti! Abre as suas fauces e..."
    print
    time.sleep(2)
    cova_salvadora = random.randint(1,2)
    if que_cova == str(cova_salvadora):
        print "Te da su tesoro"
    else:
        print "Devorate de un so bocado!"

while xogar_outra_vez == 's' or xogar_outra_vez == 'S':
    muestra_intro()
    numero_cova = elixe_cova()
    mirar_cova(numero_cova)
    print "Queres xogar outra vez? (s or n)"
    xogar_outra_vez = raw_input()
    if xogar_outra_vez == 's' or xogar_outra_vez == 'S':
        elixe_cova()
    