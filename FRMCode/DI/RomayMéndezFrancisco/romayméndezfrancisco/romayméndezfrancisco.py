# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gdk,Gtk
import XestionDatos
import Informes


class Empresa:
    def __init__(self):
        int_visual = Gtk.Builder()
        int_visual.add_from_file("Interface.glade")
        self.ven_principal = int_visual.get_object("ven_principal")
        self.ent_matricula = int_visual.get_object("ent_matricula")
        self.combo_plazas = int_visual.get_object("combo_plazas")
        self.but_engadir_bus = int_visual.get_object("but_engadir_bus")
        self.but_eliminar_bus = int_visual.get_object("but_eliminar_bus")
        self.but_engadir_servicio = int_visual.get_object("but_engadir_servicio")
        self.but_eliminar_servicio = int_visual.get_object("but_engadir_servicio")
        self.but_actualizar_servicio = int_visual.get_object("but_actualizar_servicio")
        self.but_imprimir = int_visual.get_object("but_imprimir")
        self.tree_buses = int_visual.get_object("tree_buses")
        self.tree_ser = int_visual.get_object("tree_ser")
        self.listBuses = int_visual.get_object("listBuses")
        self.listServicios = int_visual.get_object("listServicio")
        self.combo_matricula = int_visual.get_object("combo_matricula")
        self.id_bus_borrar=0
        self.id_ser_borrar=0
        self.ent_iniciais= int_visual.get_object("ent_iniciais")
        self.ent_finais = int_visual.get_object("ent_finais")
        self.sair_barra = int_visual.get_object("sair_barra")
        self.aviso = int_visual.get_object("aviso")
        self.ven_about = int_visual.get_object("ven_about")
        self.but_about = int_visual.get_object("but_about")
        self.but_ver = int_visual.get_object("but_ver")
        dic = {
            'on_ven_principal_destroy': self.sair,
            'on_ven_about_destroy':self.hide_about,
            'on_sair_barra_activate': self.sair,
            'on_but_engadir_bus_clicked': self.engadir_bus,
            'on_but_eliminar_bus_clicked': self.eliminar_bus,
            'on_selector_buses_changed': self.cargandodatos_bus,
            'on_but_engadir_servicio_clicked': self.engadir_ser,
            'on_but_eliminar_servicio_clicked': self.eliminar_ser,
            'on_selector_servicios_changed': self.cargandodatos_ser,
            'on_but_actualizar_servicio_clicked': self.actualizar_ser,
            'on_but_imprimir_clicked': self.imprimir,
            'on_but_about_activate': self.show_about,
            'on_but_ver_activate': self.test_aviso
        }
        int_visual.connect_signals(dic)
        self.limpar_entradas()
        self.actualizar_listas()
        self.ven_principal.show()

    def test_aviso(self,widget):
        self.aviso.set_text("Proba de aviso.")

    def hide_about(self, widget):
        self.ven_about.hide()

    def show_about(self, widget):
        self.ven_about.show()

    def limpar_entradas(self):
        self.ent_matricula.set_text("")
        self.ent_iniciais.set_text("0")
        self.ent_finais.set_text("0")
        self.aviso.set_text("")


    def sair(self, widget):
        """

            Metodo para a finalización do programa.

        """
        XestionDatos.pechar_conexion()
        Gtk.main_quit()

    def actualizar_listas(self):
        """

            Metodo para a actualización de todalas listas de datos(ListViews) do programa.

        """
        self.listBuses.clear()
        lista1 = XestionDatos.consultar_buses()
        for registro1 in lista1:
            self.listBuses.append(registro1)
        self.listServicios.clear()
        lista2 = XestionDatos.consultar_servicios()
        for registro2 in lista2:
            self.listServicios.append(registro2)
        self.combo_matricula.remove_all()
        XestionDatos.cargar_matriculas(self.combo_matricula)

    def comprobador_bus(self):
        if self.ent_matricula.get_text() == "" or self.combo_plazas.get_active_text() == "Plazas":
            return False
        else:
            return True

    def creafilas_bus(self):
        filabus = (self.ent_matricula.get_text(), int(self.combo_plazas.get_active_text()))
        return filabus

    def comprobador_ser(self):
        if self.combo_matricula.get_active_text() is None or self.ent_finais.get_text() == "0" or self.ent_iniciais.get_text() == "0":
            return False
        else:
            return True

    def comprobador_ser_m(self):
        if self.id_ser_borrar == 0 or self.combo_matricula.get_active_text() is None or self.ent_finais.get_text() == "0" or self.ent_iniciais.get_text() == "0":
            return False
        else:
            return True

    def creafilas_ser(self):
        lista4 = XestionDatos.buscar_plazas(self.combo_matricula.get_active_text())
        filaser = (self.combo_matricula.get_active_text(), lista4,int(self.ent_iniciais.get_text()),int(self.ent_finais.get_text()),int(self.ent_finais.get_text())-int(self.ent_iniciais.get_text()))
        return filaser

    def creafilas_ser_m(self):

        filaser = (int(self.ent_iniciais.get_text()), int(self.ent_finais.get_text()), int(self.ent_finais.get_text()) -int(self.ent_iniciais.get_text()))
        return filaser

    def engadir_bus(self, widget):
        if self.comprobador_bus():
            XestionDatos.engadir_bus(self.creafilas_bus())
            self.actualizar_listas()
            self.limpar_entradas()
        else:
            self.aviso.set_text("Faltan datos")

    def cargandodatos_bus(self, widget):
        """

            Método que se ocupa de cargar os datos do TreeView do Servicio nos Entry correspondentes.

        """
        model, iter = self.tree_buses.get_selection().get_selected()
        if iter != None:
            self.id_bus_borrar = 0
            self.ent_matricula.set_text(str(model.get_value(iter, 0)))
            self.id_bus_borrar=model.get_value(iter, 0)


    def eliminar_bus(self, widget):
        XestionDatos.eliminar_bus(self.id_bus_borrar)
        self.actualizar_listas()
        self.limpar_entradas()

    def engadir_ser(self, widget):
        if self.comprobador_ser():
            XestionDatos.engadir_servicio(self.creafilas_ser())
            self.actualizar_listas()
            self.limpar_entradas()
        else:
            self.aviso.set_text("Faltan datos")

    def eliminar_ser(self, widget):
        XestionDatos.eliminar_servicio(self.id_ser_borrar)
        self.actualizar_listas()
        self.limpar_entradas()

    def cargandodatos_ser(self, widget):
        """

            Método que se ocupa de cargar os datos do TreeView do Servicio nos Entry correspondentes.

        """
        model, iter = self.tree_ser.get_selection().get_selected()
        if iter != None:
            self.id_ser_borrar = 0
            self.id_ser_borrar = str(model.get_value(iter, 0))
            self.ent_iniciais.set_text(str(model.get_value(iter, 3)))
            self.ent_finais.set_text(str(model.get_value(iter, 4)))


    def actualizar_ser(self, widget):
        if self.comprobador_ser_m():
            XestionDatos.modificar_servicio(self.id_ser_borrar, self.creafilas_ser_m())
            self.actualizar_listas()
            self.limpar_entradas()
        else:
            self.aviso.set_text("Faltan datos ou non seleccionou item para modificar.")

    def imprimir(self, widget):
        Informes.informe()

if __name__ == "__main__":
    print("Lanzase a aplicación.")
    main = Empresa()
    Gtk.main()

