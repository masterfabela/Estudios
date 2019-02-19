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
        self.listServicio = int_visual.get_object("listServicio")
        self.listCliente = int_visual.get_object("listCliente")
        self.listCamarero = int_visual.get_object("listCamarero")
        self.i_mesa1 = int_visual.get_object("Mesa1")
        self.i_mesa2 = int_visual.get_object("Mesa2")
        self.i_mesa3 = int_visual.get_object("Mesa3")
        self.i_mesa4 = int_visual.get_object("Mesa4")
        self.i_mesa5 = int_visual.get_object("Mesa5")
        self.i_mesa6 = int_visual.get_object("Mesa6")
        self.i_mesa7 = int_visual.get_object("Mesa7")
        self.i_mesa8 = int_visual.get_object("Mesa8")
        self.ven_login = int_visual.get_object("ven_login")
        self.ent_usuario = int_visual.get_object("ent_usuario")
        self.ent_contrasinal = int_visual.get_object("ent_contrasinal")
        self.but_login = int_visual.get_object("but_login")
        dic = {
            'on_vent_principal_destroy': self.sair,
            'on_sair_activate': self.sair,
            'on_sair_barra_clicked': self.sair,
            'on_boton1_clicked': self.click_mesa_1,
            'on_boton2_clicked': self.click_mesa_2,
            'on_boton3_clicked': self.click_mesa_3,
            'on_boton4_clicked': self.click_mesa_4,
            'on_boton5_clicked': self.click_mesa_5,
            'on_boton6_clicked': self.click_mesa_6,
            'on_boton7_clicked': self.click_mesa_7,
            'on_boton8_clicked': self.click_mesa_8,
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
        self.i_mesa1.set_from_file("MesaPequenaOcuoada.png")

    def click_mesa_2(self, widget):
        self.i_mesa2.set_from_file("MesaPequenaOcuoada.png")
    def click_mesa_3(self, widget):
        self.i_mesa3.set_from_file("MesaMediaOcupada.png")

    def click_mesa_4(self, widget):
        self.i_mesa4.set_from_file("MesaPequenaOcuoada.png")

    def click_mesa_5(self, widget):
        self.i_mesa5.set_from_file("MesaPequenaOcuoada.png")

    def click_mesa_6(self, widget):
        self.i_mesa6.set_from_file("MesaMediaOcupada.png")

    def click_mesa_7(self, widget):
        self.i_mesa7.set_from_file("MesaGrandeOcupada.png")

    def click_mesa_8(self, widget):
        self.i_mesa8.set_from_file("MesaGrandeOcupada.png")


    def sair(self,widget):
        XestionDatos.pechar_conexion()
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

