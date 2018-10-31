# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk
import xestionclientes

class Taller:
    def __init__(self):
        int_visual = Gtk.Builder();
        int_visual.add_from_file("XestionClientes.glade");
        self.but_alta=int_visual.get_object("but_alta")
        self.venPrincipal = int_visual.get_object("venPrincipal")
        self.listclientes = int_visual.get_object("listclientes")
        self.treeclientes = int_visual.get_object("treeclientes")
        self.entdni = int_visual.get_object("entdni")
        self.entapel = int_visual.get_object("entapel")
        self.entmat = int_visual.get_object("entmat")
        self.entnom = int_visual.get_object("entnom")
        self.entmail = int_visual.get_object("entmail")
        self.entmovil = int_visual.get_object("entmovil")
        self.lblavisos = int_visual.get_object("lblavisos")
        dic = {
            'on_venPrincipal_destroy': self.sair,
            'on_but_alta_clicked': self.altacliente
        }
        int_visual.connect_signals(dic)
        self.lblavisos.hide()
        self.venPrincipal.show()
        self.venPrincipal.maximize()
    def sair(self,widget):
        Gtk.main_quit()

    def altacliente(self,widget):
        try:
            self.lblavisos.show()
            self.dni = self.entdni.get_text()
            self.mat = self.entmat.get_text()
            self.apel = self.entapel.get_text()
            self.nom = self.entnom.get_text()
            self.mail = self.entmail.get_text()
            self.movil = self.entmovil.get_text()
            if self.dni != '' and self.mat != '' and self.apel != '':

                self.filacli = (self.dni, self.mat, self.apel, self.nom, self.mail, self.movil)
                xestionclientes.altacli(self.treeclientes, self.listclientes, self.filacli)
                self.limpacli()
            else:
                self.lblavisos.set_text("Faltan datos.")

        except:
            self.lblavisos.set_text("Erro na alta.")
    def limpacli(self):

        self.lmpcli = (self.entdni, self.entmat, self.entapel, self.entnom, self.entmail, self.entmovil)
        xestionclientes.limpiacli(self.lmpcli)


if __name__ == "__main__":
    print("Inicio")
    main=Taller()
    Gtk.main()
