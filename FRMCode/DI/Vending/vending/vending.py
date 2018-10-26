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

        self.saldo=0.0
        self.cambio=0.0


        self.venPrincipal = intVisual.get_object("venPrincipal")
        self.venCarteira = intVisual.get_object("venCarteira")
        self.butbarSair = intVisual.get_object("butbarSair")
        self.butbarAbout = intVisual.get_object("butbarAbout")
        self.venAbout = intVisual.get_object("venAbout")
        self.butPagar = intVisual.get_object("butPagar")
        self.butSaldo = intVisual.get_object("butSaldo")
        self.butRetirar = intVisual.get_object("butRetirar")
        self.texComprado = intVisual.get_object("texComprado")
        self.texCambio =intVisual.get_object("texCambio")
        self.texAvisos = intVisual.get_object("texAvisos")

        self.but2 =intVisual.get_object("but2")
        self.but1 = intVisual.get_object("but1")
        self.but05 = intVisual.get_object("but05")
        self.but02 = intVisual.get_object("but02")
        self.but01 = intVisual.get_object("but01")
        self.but005 = intVisual.get_object("but005")
        self.but002 = intVisual.get_object("but002")
        self.but001 = intVisual.get_object("but001")

        self.venPrincipal.show()
        dic = {
            'on_venPrincipal_destroy': self.sair,
            'on_butbarSair_activate': self.sair,
            'on_butbarAbout_activate': self.showAbout,
            'on_venAbout_destroy': self.hideAbout,
            'on_venCarteira_destroy': self.hideCarteira,
            'on_butSaldo_clicked': self.showCarteira,
            'on_butRetirar_clicked': self.retirar,
            'on_but2_clicked': self.sum2,
            'on_but1_clicked': self.sum1,
            'on_but05_clicked': self.sum05,
            'on_but02_clicked': self.sum02,
            'on_but01_clicked': self.sum01,
            'on_but005_clicked': self.sum005,
            'on_but002_clicked': self.sum002,
            'on_but001_clicked': self.sum001,
            'on_butPagar_clicked':self.pagar
        }

        intVisual.connect_signals(dic)

    #Metodos dos Botons de moedas:
    def sum2(self,widget):
        self.saldo +=2

    def sum1(self,widget):
        self.saldo +=1

    def sum05(self,widget):
        self.saldo +=0.5

    def sum02(self,widget):
        self.saldo +=0.2

    def sum01(self,widget):
        self.saldo +=0.1

    def sum005(self,widget):
        self.saldo +=0.05

    def sum002(self,widget):
        self.saldo +=0.02

    def sum001(self,widget):
        self.saldo +=0.01

    # Métodos de destroys e shows das ventás:
    def sair(self,widget,data=None):
        Gtk.main_quit()

    def showAbout(self,widget):
        self.venAbout.show()

    def hideAbout(self,widget):
        self.venAbout.hide()

    def hideCarteira(self, widget):
        self.venCarteira.destroy()
        self.texAvisos.set_text("Saldo: "+(str)(self.saldo)+"€")

    def showCarteira(self, widget):
        self.venCarteira.show()

    #Métodos lóxicos
    def retirar(self,widget):
        self.texComprado.set_text("Vacio")
        self.texCambio.set_text("Vacio")
        self.texAvisos.set_text("Avisos")


    def pagar(self,widget):
        self.texCambio.set_text((str)(self.saldo))

if __name__ == "__main__":
    print("Iniciando Vending:")
    main=Vending()
    Gtk.main()
