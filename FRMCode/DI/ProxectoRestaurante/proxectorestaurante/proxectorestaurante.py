import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
import XestionDatos
import BDProvinciasLocalidades
import informes
import servicios
import time

#engadir busquedas.
#Implementar copia de seguridade da bd.
#Mostraranse avisos.
#Ver a distribucion da aplicacion.
#As liñas de factura son os campos de productos que se engaden.
#Crear metodo e interface para a implementacion de novos platos.
class Restaurante:
    def __init__(self):
        int_visual = Gtk.Builder()
        int_visual.add_from_file("Restaurante.glade")
        self.vent_principal = int_visual.get_object("vent_principal")
        self.ven_about = int_visual.get_object("ven_about")
        self.tree_mesa = int_visual.get_object("tree_mesa")
        self.sair_barra = int_visual.get_object("sair_barra")
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
        self.but_alta_cliente = int_visual.get_object("but_alta_cliente")
        self.but_baixa_cliente = int_visual.get_object("but_baixa_cliente")
        self.but_mod_cliente = int_visual.get_object("but_mod_cliente")
        self.tex_dni = int_visual.get_object("tex_dni")
        self.tex_nome = int_visual.get_object("tex_nome")
        self.tex_apelidos = int_visual.get_object("tex_apelidos")
        self.tex_direccion = int_visual.get_object("tex_direccion")
        self.tree_clientes = int_visual.get_object("tree_clientes")
        self.limpacaixas_cliente()
        self.combo_Cliente = int_visual.get_object("combo_Cliente")
        self.combo_Mesa = int_visual.get_object("combo_Mesa")
        self.combo_Camareiro = int_visual.get_object("combo_Camareiro")
        self.tree_Facturas = int_visual.get_object("tree_Facturas")
        self.list_Facturas = int_visual.get_object("list_Facturas")
        self.but_creaFactura = int_visual.get_object("but_creaFactura")
        self.but_pagar =int_visual.get_object("but_pagar")
        self.listServicio = int_visual.get_object("listServicio")
        self.tree_Servicios = int_visual.get_object("tree_Servicios")
        self.combo_facturas = int_visual.get_object("combo_facturas")
        self.combo_servicios = int_visual.get_object("combo_servicios")
        self.cantidade = int_visual.get_object("cantidade")
        self.cantidade.set_text("0")
        self.but_lineaFactura = int_visual.get_object("but_lineaFactura")
        dic = {
            'on_vent_principal_destroy': self.sair,
            'on_sair_activate': self.sair,
            'on_sair_barra_clicked': self.sair,
            'on_selector_mesa_changed': self.seleccionar_mesa,
            'on_selector_clientes_changed': self.cargandodatos_clientes,
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
            'on_but_imprimir_clicked': self.probaImpresion,
            'on_but_alta_cliente_clicked': self.alta_cliente,
            'on_but_baixa_cliente_clicked': self.baixa_cliente,
            'on_but_mod_cliente_clicked': self.mod_cliente,
            'on_but_creaFactura_clicked': self.crear_factura,
            'on_but_pagar_clicked': self.pagarfactura,
            'on_but_lineaFactura_clicked': self.crear_fFactura,
            'on_combo_facturas_changed': self.buscar_fFactura,
            'on_selector_facturas_changed': self.seleccionar_Factura
        }
        int_visual.connect_signals(dic)
        self.Factura_Seleccionada=1
        self.vent_principal.hide()
        self.actualizar_listas()
        self.ven_login.show()

    """
    # Metodo de control do login
    """

    def login(self, widget):
        if XestionDatos.login(self.ent_usuario.get_text(), self.ent_contrasinal.get_text(), self.ven_login):
            self.actualizar_mesas()
            self.vent_principal.show()
            # self.vent_principal.maximize()
            BDProvinciasLocalidades.cargar_provincias(self.combo_provincia)
            self.actualizar_listas()


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

    def click_mesa_1(self, widget):
        self.listaMesas.set_active(1)
        self.combo_Mesa.set_active(0)

    def click_mesa_2(self, widget):
        self.listaMesas.set_active(2)
        self.combo_Mesa.set_active(1)

    def click_mesa_3(self, widget):
        self.listaMesas.set_active(3)
        self.combo_Mesa.set_active(2)

    def click_mesa_4(self, widget):
        self.listaMesas.set_active(4)
        self.combo_Mesa.set_active(3)

    def click_mesa_5(self, widget):
        self.listaMesas.set_active(5)
        self.combo_Mesa.set_active(4)

    def click_mesa_6(self, widget):
        self.listaMesas.set_active(6)
        self.combo_Mesa.set_active(5)

    def click_mesa_7(self, widget):
        self.listaMesas.set_active(7)
        self.combo_Mesa.set_active(6)

    def click_mesa_8(self, widget):
        self.listaMesas.set_active(8)
        self.combo_Mesa.set_active(7)

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
        self.list_Facturas.clear()
        lista4 = XestionDatos.consultar_facturas()
        for registro4 in lista4:
            self.list_Facturas.append(registro4)
        self.combo_facturas.remove_all()
        self.combo_servicios.remove_all()
        self.combo_Mesa.remove_all()
        self.combo_Camareiro.remove_all()
        self.combo_Cliente.remove_all()
        XestionDatos.cargar_clientes(self.combo_Cliente)
        XestionDatos.cargar_mesa(self.combo_Mesa)
        XestionDatos.cargar_camareiro(self.combo_Camareiro)
        XestionDatos.cargar_facturas_activas(self.combo_facturas)
        XestionDatos.cargar_servicios(self.combo_servicios)

    def show_about(self, widget):
        self.ven_about.show()

    def probaImpresion(self, widget):
        informes.reportservicios(self.Factura_Seleccionada)

    """
        # Metodo para a actualización automática dos iconos dos botóns das mesas
    """

    def actualizar_mesas(self):
        listaMesas = XestionDatos.consultar_mesas()
        for columna in listaMesas:
            if columna[0] == "1" and columna[2] == "True":
                self.ocupar_mesa_P(self.i_mesa1)
            elif columna[0] == "2" and columna[2] == "True":
                self.ocupar_mesa_P(self.i_mesa2)
            elif columna[0] == "3" and columna[2] == "True":
                self.ocupar_mesa_M(self.i_mesa3)
            elif columna[0] == "4" and columna[2] == "True":
                self.ocupar_mesa_P(self.i_mesa4)
            elif columna[0] == "5" and columna[2] == "True":
                self.ocupar_mesa_P(self.i_mesa5)
            elif columna[0] == "6" and columna[2] == "True":
                self.ocupar_mesa_M(self.i_mesa6)
            elif columna[0] == "7" and columna[2] == "True":
                self.ocupar_mesa_G(self.i_mesa7)
            elif columna[0] == "8" and columna[2] == "True":
                self.ocupar_mesa_G(self.i_mesa8)
            if columna[0] == "1" and columna[2] == "False":
                self.liberar_mesa_P(self.i_mesa1)
            elif columna[0] == "2" and columna[2] == "False":
                self.liberar_mesa_P(self.i_mesa2)
            elif columna[0] == "3" and columna[2] == "False":
                self.liberar_mesa_M(self.i_mesa3)
            elif columna[0] == "4" and columna[2] == "False":
                self.liberar_mesa_P(self.i_mesa4)
            elif columna[0] == "5" and columna[2] == "False":
                self.liberar_mesa_P(self.i_mesa5)
            elif columna[0] == "6" and columna[2] == "False":
                self.liberar_mesa_M(self.i_mesa6)
            elif columna[0] == "7" and columna[2] == "False":
                self.liberar_mesa_G(self.i_mesa7)
            elif columna[0] == "8" and columna[2] == "False":
                self.liberar_mesa_G(self.i_mesa8)

    def seleccionar_mesa(self, widget):
        model, iter = self.tree_mesa.get_selection().get_selected()
        if iter != None:
            self.listaMesas.set_active(int(model.get_value(iter, 0)))

    def ocupar(self, widget):
        XestionDatos.modificar_mesas("True", str(self.listaMesas.get_active()))
        self.actualizar_listas()
        self.actualizar_mesas()

    def ocupar_factura(self, mesa):
        XestionDatos.modificar_mesas("True", mesa)
        self.actualizar_listas()
        self.actualizar_mesas()

    def baleirar(self, widget):
        XestionDatos.modificar_mesas("False", str(self.listaMesas.get_active()))
        self.actualizar_listas()
        self.actualizar_mesas()

    def seleccion_provincia(self, widget):
        self.combo_localidade.remove_all()
        BDProvinciasLocalidades.cargar_localidades(self.combo_localidade, self.combo_provincia.get_active_text())

    def creafilas_clientes(self):
        dni = self.tex_dni.get_text()
        direccion = self.tex_direccion.get_text()
        apel = self.tex_apelidos.get_text()
        nom = self.tex_nome.get_text()
        provincia = self.combo_provincia.get_active_text()
        localidade = self.combo_localidade.get_active_text()
        filacli = (dni, apel, nom, direccion, provincia, localidade)
        return filacli

    def creafilas_clientes_mod(self):
        dni = self.tex_dni.get_text()
        direccion = self.tex_direccion.get_text()
        apel = self.tex_apelidos.get_text()
        nom = self.tex_nome.get_text()
        provincia = self.combo_provincia.get_active_text()
        localidade = self.combo_localidade.get_active_text()
        filacli = (dni, apel, nom, direccion, provincia, localidade,self.dniProvisional)
        return filacli

    def alta_cliente(self, widget):

        XestionDatos.insertar_cliente(self.comprobar_entradas_cliente())
        self.actualizar_listas()
        self.limpacaixas_cliente()

    def baixa_cliente(self, widget):
        if self.tex_dni.get_text() != "":
            XestionDatos.baixa_cliente(str(self.tex_dni.get_text()))
            self.actualizar_listas()
            self.limpacaixas_cliente()
        else:
            print("Faltan datos para a eliminación");

    def mod_cliente(self, widget):
        XestionDatos.modificar_cliente(self.comprobar_entradas_cliente_mod())
        self.actualizar_listas()
        self.limpacaixas_cliente()

    def cargandodatos_clientes(self, widget):
        model, iter = self.tree_clientes.get_selection().get_selected()
        if iter != None:
            self.tex_dni.set_text(str(model.get_value(iter, 0)))
            self.dniProvisional =str(model.get_value(iter, 0))
            self.tex_apelidos.set_text(model.get_value(iter, 1))
            self.tex_nome.set_text(model.get_value(iter, 2))
            self.tex_direccion.set_text(model.get_value(iter, 3))

    def comprobar_entradas_cliente(self):
        if self.tex_dni != '' and self.tex_direccion != '' and self.tex_apelidos != '' and self.tex_nome != '':
            if servicios.comprobarDNI(self.tex_dni):
                return self.creafilas_clientes()
            else:
                print("DNI Incorrecto.")
        else:
            print("Faltan datos.")

    def comprobar_entradas_cliente_mod(self):
        if self.tex_dni != '' and self.tex_direccion != '' and self.tex_apelidos != '' and self.tex_nome != '':
            if servicios.comprobarDNI(self.tex_dni):
                return self.creafilas_clientes_mod()
            else:
                print("DNI Incorrecto.")
        else:
            print("Faltan datos.")

    def limpacaixas_cliente(self):
        self.tex_dni.set_text("")
        self.tex_nome.set_text("")
        self.tex_apelidos.set_text("")
        self.tex_direccion.set_text("")
        self.combo_localidade.remove_all()
        self.combo_provincia.remove_all()

    def comprobar_entradas_factura(self):
        if self.combo_Camareiro.get_active_text() != None and self.combo_Mesa.get_active_text() != None and self.combo_Cliente.get_active_text() != None:
            print("Podese.")
        else:
            print("Faltan datos")

    def creafilas_Factura(self):

        cliente = self.combo_Cliente.get_active_text()
        camareiro = self.combo_Camareiro.get_active_text()
        mesa = self.combo_Mesa.get_active_text()
        data = time.strftime("%d/%m/%y")
        self.ocupar_factura(mesa)

        filafact = (cliente, camareiro, mesa, data, "No")
        return filafact

    def crear_factura(self, widget):
        self.comprobar_entradas_factura()
        XestionDatos.insertar_factura(self.creafilas_Factura())
        self.actualizar_listas()

    def pagarfactura(self, widget):
        model, iter = self.tree_Facturas.get_selection().get_selected()
        if iter != None:
            XestionDatos.pagar_factura(str(model.get_value(iter, 0)))
        else:
            print("Non se seleccionou ningunha factura")
        self.actualizar_listas()

    def comprobar_entradas_fFactura(self):
        if self.combo_servicios.get_active() != -1 and self.combo_facturas.get_active() != -1 and (int(self.cantidade.get_text()) > 0):
            print("Podese.")
        else:
            print("Faltan datos")

    def creafilas_fFactura(self):
        filafFact = (self.combo_facturas.get_active_text(), (int(self.combo_servicios.get_active())+1), self.cantidade.get_text())
        return filafFact

    def buscar_fFactura(self, widget):
        if self.combo_facturas.get_active() != -1:
            self.listServicio.clear()
            lista4 = XestionDatos.consultar_lineaFactura_mod(self.combo_facturas.get_active_text())
            for registro4 in lista4:
                self.listServicio.append(registro4)

    def crear_fFactura(self, widget):
        self.comprobar_entradas_fFactura()
        XestionDatos.insertar_lineaFactura(self.creafilas_fFactura())
        self.cantidade.set_text("0")
        self.combo_servicios.set_active(-1)
        self.combo_facturas.set_active(-1)
        self.actualizar_listas()

    def seleccionar_Factura(self, widget):
        model, iter = self.tree_mesa.get_selection().get_selected()
        if iter != None:
            self.Factura_Seleccionada = model.get_value(iter, 0)


if __name__ == "__main__":
    print("Lanzase a aplicación.")
    main = Restaurante()
    Gtk.main()
