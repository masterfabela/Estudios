# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk
class CompDNI:
    def __init__(self):
    # iniciamos la libreria GTK
        intVisual = Gtk.Builder()
        intVisual.add_from_file('DNI.glade')

        self.venPrincipal = intVisual.get_object("venPrincipal")
        self.butGrabar = intVisual.get_object("butGrabar")
        self.texBox = intVisual.get_object("texBox")
        self.texView = intVisual.get_object("texView")
        self.venPrincipal.show()

        dic = {
        'on_venPrincipal_destroy': self.salir,
        'on_butGrabar_clicked': self.imprimir
    }

        intVisual.connect_signals(dic)

    def salir(self, widget, data=None):
        Gtk.main_quit()

    def comprobar(self):
        tabla = "TRWAGMYFPDXBNJZSQVHLCKE"  # letras del dni
        extrange = "XYZ"
        taboaextrange = {'X': '0', 'Y': '1', 'Z': '2'}
        numeros = "1234567890"
        dni=self.texBox.get_text()
        dni = dni.upper()  # pasa letras a mayúsculas
        if len(dni) == 9:
            letra = dni[8]
        dni = dni[:8]  # el número que son los 8 primeros
        if dni[0] in extrange:  # comprueba que es extranjero
            dni = dni.replace(dni[0], taboaextrange[dni[0]])
        return len(dni) == len([n for n in dni if n in numeros]) and tabla[int(dni)% 23] == letra
    def imprimir(self,widget):
        boolean=self.comprobar()
        if boolean==1:
            self.texView.set_text("Dni correcto")
            self.texView.set_text_color(green)
        else:
            self.texView.set_text("Dni incorrecto")




if __name__ == "__main__":
    main=CompDNI()
    Gtk.main()
    print("Hello World")
