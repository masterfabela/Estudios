# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk
class Vending:
    def __init__(self):

        intVisual = Gtk.Builder()
        intVisual.add_from_file('Vending.glade')

        self.venPrincipal = intVisual.get_object("venPrincipal")
        self.butbarSair = intVisual.get_object("butbarSair")
        self.butbarAbout = intVisual.get_object("butbarAbout")
        self.venAbout = intVisual.get_object("venAbout")
        self.venPrincipal.show()
        dic = {
            'on_venPrincipal_destroy': self.sair,
            'on_butbarSair_activate': self.sair,
            'on_butbarAbout_activate': self.showAbout,
            'on_venAbout_destroy': self.hideAbout
        }

        intVisual.connect_signals(dic)


    def sair(self,widget,data=None):
        Gtk.main_quit()
    def showAbout(self,widget):
        self.venAbout.show()
    def hideAbout(self,widget):
        self.venAbout.hide()
if __name__ == "__main__":
    print("Iniciando Vending:")
    main=Vending()
    Gtk.main()
