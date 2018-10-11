# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

#Importado de librerias:
import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk

#creacion da clase:
class Hola:
        def __init__(self):
            #iniciamos a libreria Gtk:
            b = Gtk.Builder()
            b.add_from_file('principal.glade')
        #cargamos os widgets asociados a un evento ou son referenciados
            self.venprincipal = b.get_object("venprincipal")
            self.lblsaudo = b.get_object("lblsaudo")
            self.btnmostrar = b.get_object("btnmostrar")

            dic = {'on_venprincipal_destroy':self.sair,'on_btnmostrar_clicked':self.mostrar,}
            b.connect_signals(dic)
            
            self.venprincipal.show()
        #aqui comeza a codificacion das funcions
        def mostrar(self, widget, data=None):
            self.lblsaudo.set_text("Son fran")
        
        def sair(self,widget,data=None):
            Gtk.main_quit()

#Lanzamendo do programa:
if __name__ == '__main__':
    main = Hola()
    Gtk.main()
