# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk

class Compresor:
    def __init__(self):
        intVisual=Gtk.Builder()
        intVisual.add_from_file('Conversor.glade')

        self.venPrincipal= intVisual.get_object('venPrincipal')
        self.venPrincipal.show()


if __name__ == "__main__":
    main = Compresor()
    Gtk.main()
    print("Hello World")
