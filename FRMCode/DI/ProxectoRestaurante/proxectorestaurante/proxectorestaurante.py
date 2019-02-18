import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
import XestionDatos
import informes
from reportlab.pdfgen import canvas
from reportlab.lib.pagesizes import A4

#engadir busquedas
#cambiar a distribucion dos paneis
#Implementar copia de seguridade da bd.
#fallo de login dos camareiros
#engadir todas as mesas
#subir o codigo a github
#Mostraranse avisos.
#Ver a distribucion da aplicacion
class Restaurante:
    def __init__(self):
        int_visual = Gtk.Builder()
        int_visual.add_from_file("Restaurante.glade")
        self.vent_principal = int_visual.get_object("vent_principal")
        self.ven_about = int_visual.get_object("ven_about")
        self.vent_principal.show()
        self.sair_barra = int_visual.get_object("sair_barra")
        self.mesa1 = int_visual.get_object("mesa1")
        self.mesa2 = int_visual.get_object("mesa2")
        self.listServicio = int_visual.get_object("listServicio")
        self.listCliente = int_visual.get_object("listCliente")
        self.listCamarero = int_visual.get_object("listCamarero")
        self.i_mesa1 = int_visual.get_object("Mesa1")
        self.i_mesa2 = int_visual.get_object("Mesa2")
        self.ven_login = int_visual.get_object("ven_login")
        self.ent_usuario = int_visual.get_object("ent_usuario")
        self.ent_contrasinal = int_visual.get_object("ent_contrasinal")
        self.but_login = int_visual.get_object("but_login")
        dic = {
            'on_vent_principal_destroy': self.sair,
            'on_sair_activate': self.sair,
            'on_sair_barra_clicked': self.sair,
            'on_boton1_clicked': self.click_mesa_1,
            'on_but_login_clicked': self.login,
            'on_but_about_activate': self.show_about,
            'on_but_imprimir_clicked': self.probaImpresion
        }
        int_visual.connect_signals(dic)
        self.vent_principal.hide()
        self.actualizar_listas()
        self.ven_login.show()
        # self.venPrincipal.maximize()
    def click_mesa_1(self,widget):
        if self.mesa2.is_active():
            print("activo")
            self.mesa2.set_from_file("MesaPequenaOcuoada.png")
            self.mesa2.set_active
        else:
            print("inactivo")
        self.mesa2.set_from_file("MesaPequena.png")
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

    def probaImpresion(self,widget):
        informes.reportservicios()

    def login(self,widget):
        print("asd")
        if XestionDatos.login(self.ent_usuario.get_text(),self.ent_contrasinal.get_text(),self.ven_login) :
            self.vent_principal.show()

# O camareiro asigna todolos campos da base,
# as facturas so poden ser accedidas polo camareiro que atendeu a mesa, momento no cal, levanta dita factura.
# as liñas de factura son os capos de productos que se engaden
#
if __name__ == "__main__":
    print("Lanzase a aplicación.")
    main = Restaurante()
    Gtk.main()

