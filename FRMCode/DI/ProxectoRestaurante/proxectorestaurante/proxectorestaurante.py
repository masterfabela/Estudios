import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
import XestionDatos
import BDProvinciasLocalidades
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
# as liñas de factura son os campos de productos que se engaden
class Restaurante:
    def __init__(self):
        int_visual = Gtk.Builder()
        int_visual.add_from_file("Restaurante.glade")
        self.vent_principal = int_visual.get_object("vent_principal")
        self.ven_about = int_visual.get_object("ven_about")
        self.tree_mesa = int_visual.get_object("tree_mesa")
        self.sair_barra = int_visual.get_object("sair_barra")
        self.listServicio = int_visual.get_object("listServicio")
        self.listCliente = int_visual.get_object("listCliente")
        self.listMesa = int_visual.get_object("listMesa")
        self.i_mesa1 = int_visual.get_object("Mesa1")
        self.i_mesa2 = int_visual.get_object("Mesa2")
        self.i_mesa3 = int_visual.get_object("Mesa3")
        self.i_mesa4 = int_visual.get_object("Mesa4")
        self.i_mesa5 = int_visual.get_object("Mesa5")
        self.i_mesa6 = int_visual.get_object("Mesa6")
        self.i_mesa7 = int_visual.get_object("Mesa7")
        self.i_mesa8 = int_visual.get_object("Mesa8")
        self.listaMesas = int_visual.get_object("listaMesas")
        self.combo_provincia = int_visual.get_object("combo_provincia")
        self.combo_localidade = int_visual.get_object("combo_localidade")
        self.ven_login = int_visual.get_object("ven_login")
        self.ent_usuario = int_visual.get_object("ent_usuario")
        self.ent_contrasinal = int_visual.get_object("ent_contrasinal")
        self.but_login = int_visual.get_object("but_login")
        dic = {
            'on_vent_principal_destroy': self.sair,
            'on_sair_activate': self.sair,
            'on_sair_barra_clicked': self.sair,
            'on_selector_mesa_changed': self.seleccionar_mesa,
            'on_boton1_clicked': self.click_mesa_1,
            'on_boton2_clicked': self.click_mesa_2,
            'on_boton3_clicked': self.click_mesa_3,
            'on_boton4_clicked': self.click_mesa_4,
            'on_boton5_clicked': self.click_mesa_5,
            'on_boton6_clicked': self.click_mesa_6,
            'on_boton7_clicked': self.click_mesa_7,
            'on_boton8_clicked': self.click_mesa_8,
            'on_combo_provincia_changed': self.seleccion_provincia,
            'on_but_login_clicked': self.login,
            'on_but_ocupar_clicked': self.ocupar,
            'on_but_baleirar_clicked': self.baleirar,
            'on_but_about_activate': self.show_about,
            'on_but_imprimir_clicked': self.probaImpresion
        }
        int_visual.connect_signals(dic)
        self.vent_principal.hide()
        self.actualizar_listas()
        self.ven_login.show()
    """
    # Metodos de asignación das imaxes de Ocupado e libre das mesas dos botóns
    """
    def ocupar_mesa_P(self, imaxemesa):
        imaxemesa.set_from_file("MesaPequenaOcuoada.png")

    def ocupar_mesa_M(self, imaxemesa):
        imaxemesa.set_from_file("MesaMediaOcupada.png")

    def ocupar_mesa_G(self, imaxemesa):
        imaxemesa.set_from_file("MesaGrandeOcupada.png")

    def liberar_mesa_P(self, imaxemesa):
        imaxemesa.set_from_file("MesaPequena.png")

    def liberar_mesa_M(self, imaxemesa):
        imaxemesa.set_from_file("Mesa8.png")

    def liberar_mesa_G(self, imaxemesa):
        imaxemesa.set_from_file("Mesa10.png")

    """
        # Metodos para o lanzado de eventos dos botons das mesas
    """

    def click_mesa_1(self,widget):
        self.listaMesas.set_active(1)

    def click_mesa_2(self, widget):
        self.listaMesas.set_active(2)

    def click_mesa_3(self, widget):
        self.listaMesas.set_active(3)

    def click_mesa_4(self, widget):
        self.listaMesas.set_active(4)

    def click_mesa_5(self, widget):
        self.listaMesas.set_active(5)

    def click_mesa_6(self, widget):
        self.listaMesas.set_active(6)

    def click_mesa_7(self, widget):
        self.listaMesas.set_active(7)

    def click_mesa_8(self, widget):
        self.listaMesas.set_active(8)

    """
        # Metodo para a finalización do programa
    """
    def sair(self,widget):
        XestionDatos.pechar_conexion()
        BDProvinciasLocalidades.pechar_conexion()
        Gtk.main_quit()

    """
        # Metodo para a actualización de todalas listas de datos do programa
    """

    def actualizar_listas(self):
        self.listServicio.clear()
        lista1 = XestionDatos.consultar_servicio()
        for registro1 in lista1:
            self.listServicio.append(registro1)
        self.listCliente.clear()
        lista2 = XestionDatos.consultar_cliente()
        for registro2 in lista2:
            self.listCliente.append(registro2)
        self.listMesa.clear()
        lista3 = XestionDatos.consultar_mesas()
        for registro3 in lista3:
            self.listMesa.append(registro3)

    def show_about(self,widget):
        self.ven_about.show()

    def probaImpresion(self,widget):
        informes.reportservicios()

    """
        # Metodo de control do login
    """

    def login(self,widget):
        if XestionDatos.login(self.ent_usuario.get_text(),self.ent_contrasinal.get_text(),self.ven_login) :
            self.actualizar_mesas()
            self.vent_principal.show()
            #self.vent_principal.maximize()
            BDProvinciasLocalidades.cargar_provincias(self.combo_provincia)

    """
        # Metodo para a actualización automática dos iconos dos botóns das mesas
    """

    def actualizar_mesas(self):
        listaMesas = XestionDatos.consultar_mesas()
        for columna in listaMesas:
            if columna[0] == 1 and columna[2] == "True":
                self.ocupar_mesa_P(self.i_mesa1)
            elif columna[0] == 2 and columna[2] == "True":
                self.ocupar_mesa_P(self.i_mesa2)
            elif columna[0] == 3 and columna[2] == "True":
                self.ocupar_mesa_M(self.i_mesa3)
            elif columna[0] == 4 and columna[2] == "True":
                self.ocupar_mesa_P(self.i_mesa4)
            elif columna[0] == 5 and columna[2] == "True":
                self.ocupar_mesa_P(self.i_mesa5)
            elif columna[0] == 6 and columna[2] == "True":
                self.ocupar_mesa_M(self.i_mesa6)
            elif columna[0] == 7 and columna[2] == "True":
                self.ocupar_mesa_G(self.i_mesa7)
            elif columna[0] == 8 and columna[2] == "True":
                self.ocupar_mesa_G(self.i_mesa8)
            if columna[0] == 1 and columna[2] == "False":
                self.liberar_mesa_P(self.i_mesa1)
            elif columna[0] == 2 and columna[2] == "False":
                self.liberar_mesa_P(self.i_mesa2)
            elif columna[0] == 3 and columna[2] == "False":
                self.liberar_mesa_M(self.i_mesa3)
            elif columna[0] == 4 and columna[2] == "False":
                self.liberar_mesa_P(self.i_mesa4)
            elif columna[0] == 5 and columna[2] == "False":
                self.liberar_mesa_P(self.i_mesa5)
            elif columna[0] == 6 and columna[2] == "False":
                self.liberar_mesa_M(self.i_mesa6)
            elif columna[0] == 7 and columna[2] == "False":
                self.liberar_mesa_G(self.i_mesa7)
            elif columna[0] == 8 and columna[2] == "False":
                self.liberar_mesa_G(self.i_mesa8)

    def seleccionar_mesa(self,widget):
        model, iter = self.tree_mesa.get_selection().get_selected()
        if iter != None:
            self.listaMesas.set_active(model.get_value(iter, 0))

    def ocupar(self,widget):
        XestionDatos.modificar_mesas("True", str(self.listaMesas.get_active()))
        self.actualizar_listas()
        self.actualizar_mesas()

    def baleirar(self,widget):
        XestionDatos.modificar_mesas("False", str(self.listaMesas.get_active()))
        self.actualizar_listas()
        self.actualizar_mesas()

    def seleccion_provincia(self, widget):
        self.combo_localidade.remove_all()
        BDProvinciasLocalidades.cargar_localidades(self.combo_localidade, self.combo_provincia.get_active_text())


if __name__ == "__main__":
    print("Lanzase a aplicación.")
    main = Restaurante()
    Gtk.main()
