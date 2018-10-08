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
        self.aviso = b.get_object("lblaviso")
        self.resultado = b.get_object("lblresul")
        self.entdato = b.get_object("txtTemp1")
        self.cmbuno = b.get_object("cmbEscala1")
        self.cmbdos = b.get_object("cmbEscala2")

        dic = {
            'on_venConversor_destroy': self.salir,
            'on_btncalcular_clicked' :self.calcula
               }
        b.connect_signals(dic)
        self.venConversor.show()

    def salir(self, widget, data = None):
        Gtk.main_quit()

    def celtofah(self):
        temp = self.entdato.get_text()
        fah = 1.4*float(temp) + 32.0
        var= fah
        return (var)

    def calcula(self, widget):
        self.select1 = self.cmbuno.get_active_text()
        self.select2 = self.cmbdos.get_active_text()


        if self.select1 == "Celsius" and self.select2 == "Farenheit":
            self.resultado.set_text(self.celtofah())
        if self.select1 == "Kelvin":
            self.resultado.set_text(self.select2)
        if self.select1 == "Farenheit":
            self.resultado.set_text(self.select2)



if __name__ == '__main__':
    main = Conversor()
    Gtk.main()
