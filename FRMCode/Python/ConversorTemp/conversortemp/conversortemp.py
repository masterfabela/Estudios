# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk

class Conversor:
    def __init__(self):
        b = Gtk.Builder()
        b.add_from_file('Conversor.glade')
        self.venConversor = b.get_object("venConversor")
        dic = {
            'on_venConversor_destroy': self.salir
               }
        b.connect_signals(dic)
        self.venConversor.show()
    def salir(self,widget, data = None):
        Gtk.main_quit()
    
if __name__ == '__main__':
    main = Conversor()
    Gtk.main()
