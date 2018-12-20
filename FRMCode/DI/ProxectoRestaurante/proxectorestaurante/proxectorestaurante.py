import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
import XestionDatos
from reportlab.pdfgen import canvas
from reportlab.lib.pagesizes import A4


class Restaurante:
    def __init__(self):
        int_visual = Gtk.Builder()
        int_visual.add_from_file("Restaurante.glade")
        self.vent_principal = int_visual.get_object("vent_principal")
        self.vent_principal.show()
        self.boton = int_visual.get_object("boton")
        self.listServicio = int_visual.get_object("listServicio")
        dic = {
            'on_vent_principal_destroy': self.sair,
            'on_boton_clicked': self.click
        }
        int_visual.connect_signals(dic)
        self.vent_principal.show()
        self.actualizar_listas()
        # self.venPrincipal.maximize()
    def click(self,widget):
        print("clickaches")

    def sair(self,widget):
        Gtk.main_quit()

    def actualizar_listas(self):
        self.listServicio.clear()
        lista1 = XestionDatos.consultar_servicio()
        for registro1 in lista1:
            self.listServicio.append(registro1)


# O camareiro asigna todolos campos da base,
# as facturas so poden ser accedidas polo camareiro que atendeu a mesa, momento no cal, levanta dita factura.
# as liñas de factura son os capos de productos que se engaden
#


if __name__ == "__main__":
    print("Lanzase a aplicación.")
    main = Restaurante()
    Gtk.main()

