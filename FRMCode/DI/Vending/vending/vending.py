# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk
class Vending:
#A modo de explicación, a pulsación dos botons de producto , ata que se lle da a pagar,
#  só ten a funcionalidade de mostrar os prezos, só se cobraŕa o utimo elemento seleccionado
    def __init__(self):

        intVisual = Gtk.Builder()
        intVisual.add_from_file('Vending.glade')

        self.saldo = 0.0
        self.cambio = 0.0
        self.carrito = 'Nada'
        self.factura = 0.0
        self.reserva = 'Nada'
        self.moeda002 = 0
        self.moeda001 = 0
        self.diccionario_prezos = {
            'p01': 0.70,
            'p02': 1.1,
            'p03': 2.3,
            'p04': 0.55,
            'p05': 1.3,
            'p06': 0.9,
            'p07': 4.0,
            'p08': 1.0,
            'p09': 0.80
        }
        self.venPrincipal = intVisual.get_object("venPrincipal")
        self.venCarteira = intVisual.get_object("venCarteira")
        self.venCarteira.connect('delete-event', lambda w, e: w.hide() or True)
        self.butbarSair = intVisual.get_object("butbarSair")
        self.butbarAbout = intVisual.get_object("butbarAbout")
        self.venAbout = intVisual.get_object("venAbout")
        self.venAbout.connect('delete-event', lambda w, e: w.hide() or True)
        self.butPagar = intVisual.get_object("butPagar")
        self.propiedades = intVisual.get_object("popiedades")
        self.venPrezos = intVisual.get_object("venPrezos")
        self.venPrezos.connect('delete-event', lambda w, e: w.hide() or True)
        self.butSaldo = intVisual.get_object("butSaldo")
        self.butRetirar = intVisual.get_object("butRetirar")
        self.texComprado = intVisual.get_object("texComprado")
        self.texCambio = intVisual.get_object("texCambio")
        self.texAvisos = intVisual.get_object("texAvisos")
        self.texcodigo = intVisual.get_object("texcodigo")
        self.texprezo = intVisual.get_object("texprezo")
        self.butaplicar = intVisual.get_object("butaplicar")
        self.but2 = intVisual.get_object("but2")
        self.but1 = intVisual.get_object("but1")
        self.but05 = intVisual.get_object("but05")
        self.but02 = intVisual.get_object("but02")
        self.but01 = intVisual.get_object("but01")
        self.but005 = intVisual.get_object("but005")
        self.but002 = intVisual.get_object("but002")
        self.but001 = intVisual.get_object("but001")
        self.butzumo = intVisual.get_object("but_zumo")
        self.butsandwich = intVisual.get_object("but_sandwich")
        self.butfritos = intVisual.get_object("but_fritos")
        self.butcola = intVisual.get_object("but_cola")
        self.butpatatas = intVisual.get_object("but_patatas")
        self.butcacahuetes = intVisual.get_object("but_cacahuetes")
        self.butoreo = intVisual.get_object("but_oreo")
        self.butkitkat = intVisual.get_object("but_kitkat")
        self.butchicle = intVisual.get_object("but_chicle")

        self.venPrincipal.show()
        dic = {
            'on_venPrincipal_destroy': self.sair,
            'on_butbarSair_activate': self.sair,
            'on_butbarAbout_activate': self.showAbout,
            'on_propiedades_activate': self.alterarPrezos,
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
            'on_butPagar_clicked': self.pagar,
            'on_butaplicar_clicked': self.cambiaprezos,
            'on_but_zumo_clicked': self.czumo,
            'on_but_sandwich_clicked': self.csandwich,
            'on_but_fritos_clicked': self.cfritos,
            'on_but_cola_clicked': self.ccola,
            'on_but_patatas_clicked': self.cpatatas,
            'on_but_cacahuetes_clicked': self.ccacahuetes,
            'on_but_oreo_clicked': self.coreo,
            'on_but_kitkat_clicked': self.ckitkat,
            'on_but_chicle_clicked': self.cchicle
        }
        intVisual.connect_signals(dic)
# Métodos dos botons dos productos.
    def czumo(self, widget):
        self.texAvisos.set_text("Zumo: " + str(self.diccionario_prezos['p01']) + "€")
        self.reserva = "Zumo"
        self.factura = self.diccionario_prezos['p01']

    def csandwich(self, widgeta):
        self.texAvisos.set_text("Sandwich: " + str(self.diccionario_prezos['p02']) + "€")
        self.reserva = "Sandwich"
        self.factura = self.diccionario_prezos['p02']

    def cfritos(self, widget):
        self.texAvisos.set_text("Bolsa Fritos: " + str(self.diccionario_prezos['p03']) + "€")
        self.reserva = "Fritos"
        self.factura = self.diccionario_prezos['p03']

    def ccola(self,widget):
        self.texAvisos.set_text("CocaCola: " + str(self.diccionario_prezos['p04']) + "€")
        self.reserva = "CocaCola"
        self.factura = self.diccionario_prezos['p04']

    def cpatatas(self, widget):
        self.texAvisos.set_text("Patatas Frit.: " + str(self.diccionario_prezos['p05']) + "€")
        self.reserva = "Patatas Frit."
        self.factura = self.diccionario_prezos['p05']

    def coreo(self, widget):
        self.texAvisos.set_text("Gall. Oreo: " + str(self.diccionario_prezos['p06']) + "€")
        self.reserva = "Gall. Oreo"
        self.factura = self.diccionario_prezos['p06']

    def ccacahuetes(self, widget):
        self.texAvisos.set_text("Cacahuetes: " + str(self.diccionario_prezos['p07']) + "€")
        self.reserva = "Cacahuetes"
        self.factura = self.diccionario_prezos['p07']

    def ckitkat(self, widget):
        self.texAvisos.set_text("Kitkat: " + str(self.diccionario_prezos['p08']) + "€")
        self.reserva = "Kitkat"
        self.factura = self.diccionario_prezos['p08']

    def cchicle(self, widget):
        self.texAvisos.set_text("Chicle Mint: " + str(self.diccionario_prezos['p09']) + "€")
        self.reserva = "Chicles Mint"
        self.factura = self.diccionario_prezos['p09']

# Metodos dos Botons de moedas:
    # As moedas de 2 e 1 centimos teñen como única funcionalidade engadir ditas moedas directamente a o cambio.
    def sumador(self,cantidade):
        self.saldo +=cantidade
        self.texAvisos.set_text("Saldo: " + str(self.saldo) + "€")
        # Metodo multiparámetro para reducir o a repeticion do código, pero nn funcional.

    def sum2(self, widget):
        self.saldo +=2
        self.texAvisos.set_text("Saldo: " + str(self.saldo) + "€")

    def sum1(self, widget):
        self.saldo += 1
        self.texAvisos.set_text("Saldo: " + str(self.saldo) + "€")

    def sum05(self, widget):
        self.saldo += 0.5
        self.texAvisos.set_text("Saldo: " + str(self.saldo) + "€")

    def sum02(self, widget):
        self.saldo += 0.2
        self.texAvisos.set_text("Saldo: " + str(self.saldo) + "€")

    def sum01(self, widget):
        self.saldo += 0.1
        self.texAvisos.set_text("Saldo: " + str(self.saldo) + "€")

    def sum005(self, widget):
        self.saldo += 0.05
        self.texAvisos.set_text("Saldo: " + str(self.saldo) + "€")

    def sum002(self, widget):
        self.moeda002+= 1

    def sum001(self, widget):
        self.moeda001 += 1

# Métodos de destroys e shows das ventás:
    def sair(self, widget):
        Gtk.main_quit()

    def showAbout(self, widget):
        self.venAbout.show()

    def showCarteira(self, widget):
        self.venCarteira.show()

    def alterarPrezos(self, widget):
        # A selección que o dispara é properties
        self.venPrezos.show()

# Métodos lóxicos

    def retirar(self,widget):
        self.carrito = 'Nada'
        self.texComprado.set_text(self.carrito)
        self.texCambio.set_text("Vacio")
        self.texAvisos.set_text("Avisos")
        self.saldo = 0.0
        self.cambio = 0.0
        self.reserva = 'Nada'
        self.factura = 0.0

    def pagar(self, widget):
        if self.factura > self.saldo :
            self.texAvisos.set_text("Saldo Insuficiente")
            self.texComprado.set_text(self.carrito)
            self.texCambio.set_text("Vacio")
            self.saldo = 0.0
            self.cambio = 0.0
            self.carrito = 'Nada'
            self.reserva = 'Nada'
            self.factura = 0.0

        else:
            self.cambio = self.saldo - self.factura
            self.cambiofraccionado()
            if self.carrito == 'Nada' or self.carrito == 'Vacio':
                self.carrito = self.reserva
            else:
                self.carrito += ', ' + self.reserva
            self.texComprado.set_text(self.carrito)
            self.texAvisos.set_text('Avisos')

    def cambiaprezos(self, widget):
        self.diccionario_prezos[self.texcodigo.get_text()] = self.texprezo.get_text()


    def cambiofraccionado(self):
        self.moeda2 = self.cambio // 2
        self.aux = self.cambio % 2
        self.moeda1 = self.aux // 1
        self.aux = self.aux % 1
        self.moeda05 = self.aux // 0.5
        self.aux = self.aux % 0.5
        self.moeda02 = self.aux // 0.2
        self.aux = self.aux % 0.2
        self.moeda01 = self.aux // 0.1
        self.aux = self.aux % 0.1
        self.moeda005 = self.aux // 0.05
        self.aux = self.aux % 0.05
        self.texCambio.set_text("Moedas:\n"
                                "2€ x "+ str(self.moeda2)+"\n"
                                "1€ x " + str(self.moeda1) + "\n"
                                "0.5€ x " + str(self.moeda05) + "\n"
                                "0.2€ x " + str(self.moeda02) + "\n"
                                "0.1€ x " + str(self.moeda01) + "\n"
                                "0.05€ x " + str(self.moeda005) + "\n"
                                "0.002€ x " + str(self.moeda002) + "\n"
                                "0.01€ x " + str(self.moeda001))


if __name__ == "__main__":
    print("Iniciando Vending:")
    main=Vending()
    Gtk.main()
