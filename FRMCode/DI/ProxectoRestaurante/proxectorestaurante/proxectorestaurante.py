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
        self.ven_about = int_visual.get_object("ven_about")
        self.vent_principal.show()
        self.sair_barra = int_visual.get_object("sair_barra")
        self.boton = int_visual.get_object("boton")
        self.listServicio = int_visual.get_object("listServicio")
        self.listCliente = int_visual.get_object("listCliente")
        self.listCamarero = int_visual.get_object("listCamarero")
        dic = {
            'on_vent_principal_destroy': self.sair,
            'on_sair_activate': self.sair,
            'on_sair_barra_clicked': self.sair,
            'on_boton_clicked': self.click,
            'on_but_about_activate': self.show_about

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

        self.listCliente.clear()
        lista2 = XestionDatos.consultar_cliente()
        for registro2 in lista2:
            self.listCliente.append(registro2)
        self.listCamarero.clear()
        lista3 = XestionDatos.consultar_camarero()
        for registro3 in lista3:
            self.listCamarero.append(registro3)

    def show_about(self,widget):
        self.ven_about.show()


# O camareiro asigna todolos campos da base,
# as facturas so poden ser accedidas polo camareiro que atendeu a mesa, momento no cal, levanta dita factura.
# as liñas de factura son os capos de productos que se engaden
#


if __name__ == "__main__":
    print("Lanzase a aplicación.")
    main = Restaurante()
    Gtk.main()

