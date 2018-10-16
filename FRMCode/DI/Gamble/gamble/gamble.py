# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import gi
import random
from random import randrange
gi.require_version('Gtk','3.0')
from gi.repository import Gtk

class Gamble:
    def __init__(self):
    # iniciamos la libreria GTK
        intVisual = Gtk.Builder()
        intVisual.add_from_file('Gamble.glade')

    #cargamos los widgets asociados a un evento o son referenciados
        self.venPrincipal = intVisual.get_object("venPrincipal")
        self.venPrimitiva = intVisual.get_object("venPrimitiva")
        self.venQuiniela = intVisual.get_object("venQuiniela")
        self.butLoteria = intVisual.get_object("butPrimitiva")
        self.butQuiniela = intVisual.get_object("butQuiniela")
        self.butXogarQuiniela = intVisual.get_object("butXogarQuiniela")
        self.butXogarPrimitiva = intVisual.get_object("butXogarPrimitiva")
        self.texPrimitiva = intVisual.get_object("texPrimitiva")
        self.texQuiniela = intVisual.get_object("texQuiniela")
        self.venPrincipal.show()
        dic = {
            'on_venPrincipal_destroy': self.salir,
            'on_venQuiniela_destroy': self.pechaQ,
            'on_butQuiniela_clicked': self.abreQ,
            'on_venPrimitiva_destroy': self.pechaP,
            'on_butPrimitiva_clicked': self.abreP,
            'on_butXogarPrimitiva_clicked': self.xogarPrimitiva,
            'on_butXogarQuiniela_clicked':self.xogarQuiniela
        }
        intVisual.connect_signals(dic)
    def abreQ(self,widget):
        self.venQuiniela.show()
            
    def pechaQ(self,widget):
        self.venQuiniela.hide()
        
    def abreP(self,widget):
        self.venPrimitiva.show()
            
    def pechaP(self,widget):
        self.venPrimitiva.hide()
            
    def salir(self,widget,data=None):
        Gtk.main_quit()
        
    def xogarPrimitiva(self, widget):
        self.listaresultados=[]
        for i in range (6):
            self.listaresultados.append(randrange(49))
        self.texPrimitiva.set_text("")
        self.impresor1=str(self.listaresultados)
        self.impresor2=str(randrange(9))
        self.texPrimitiva.set_text("Numero premiado: "+self.impresor1+'\n'+"Reintegro: "+self.impresor2)
        
    def xogarQuiniela(self, widget):
        self.texQuiniela.set_text("")
        self.opcions=['1','X','2']
        self.listaresultados=[]
        for i in range (15):
            self.listaresultados.append(random.choice(self.opcions))
        self.impresor=str(self.listaresultados)
        self.texQuiniela.set_text(self.impresor)
        
        
if __name__ == "__main__":
    main = Gamble()
    Gtk.main()
