import gi
gi.require_version('Gtk', '3.0')
from gi.repository import Gtk
import MetodosDB
import datos

class Main:
    def __init__(self):
        int_visual = Gtk.Builder()
        int_visual.add_from_file("frm.glade")
        self.ven_principal = int_visual.get_object("ven_principal")
        self.treepacientes = int_visual.get_object("treepacientes")
        self.treemedidas = int_visual.get_object("treemedidas")
        self.listpacientes = int_visual.get_object("listpacientes")
        self.listmedidas = int_visual.get_object("listmedidas")
        self.notebook = int_visual.get_object("notebook")
        self.but_alta = int_visual.get_object("but_alta")
        self.but_modificacion = int_visual.get_object("but_modificacion")
        self.but_baixa = int_visual.get_object("but_baixa")
        self.but_limpar = int_visual.get_object("but_limpar")
        self.but_calendario = int_visual.get_object("but_calendario")
        self.ventana_calendario = int_visual.get_object("ventana_calendario")
        self.ventana_calendario.connect('delete-event', lambda w, e: w.hide() or True)
        self.fech = int_visual.get_object("fech")
        self.entrada_dni = int_visual.get_object("entrada_dni")
        self.entrada_nome = int_visual.get_object("entrada_nome")
        self.entrada_peso = int_visual.get_object("entrada_peso")
        self.entrada_talla = int_visual.get_object("entrada_talla")
        self.rb_masculino = int_visual.get_object("rb_masculino")
        self.rb_femenino = int_visual.get_object("rb_femenino")
        self.entrada_fecha = int_visual.get_object("entrada_fecha")
        self.saida_dni = int_visual.get_object("saida_dni")
        self.saida_imc = int_visual.get_object("saida_imc")
        self.saida_clasificacion = int_visual.get_object("saida_clasificacion")
        self.but_calcular = int_visual.get_object("but_calcular")
        self.lbl_avisos = int_visual.get_object("lbl_avisos")
        self.selector_pacientes = int_visual.get_object("selector_pacientes")
        self.selector_medidas = int_visual.get_object("selector_medidas")
        self.but_about = int_visual.get_object("but_about")
        self.ven_about = int_visual.get_object("ven_about")
        self.ven_about.connect('delete-event', lambda w, e: w.hide() or True)
        self.but_sair = int_visual.get_object("but_sair")
        self.but_delete = int_visual.get_object("but_delete")



# Diccionario de captura de eventos
        dic = {
            'on_ven_principal_destroy': self.sair,
            'on_notebook_switch_page': self.discriminabotons,
            'on_but_calendario_clicked': self.show_calendario,
            'on_fech_day_selected_double_click': self.marcar_fecha,
            'on_but_calcular_clicked': self.calcula_e_clasifica,
            'on_but_alta_clicked': self.alta,
            'on_but_modificacion_clicked': self.modificacion,
            'on_but_baixa_clicked': self.baixa,
            'on_selector_pacientes_changed': self.actualizar_paciente,
            'on_selector_medidas_changed': self.actualizar_medida,
            'on_but_about_activate': self.show_about,
            'on_but_sair_activate': self.sair,
            'on_but_limpar_clicked': self.limpar,
            'on_but_delete_activate': self.limpar,
        }
# Implementacion do diccionario
        int_visual.connect_signals(dic)
        self.ven_principal.show()
        self.DNISELECCIONADO = ""
        self.actualizar_listas()
        self.lbl_avisos.hide()

    def sair(self,widget):
        Gtk.main_quit()
        MetodosDB.pechar_conexion()

    def show_about(self,widget):
        self.ven_about.show()

    def limpar(self,widget):
        print("limpando")
        self.entrada_talla.set_text("")
        self.entrada_peso.set_text("")
        self.entrada_fecha.set_text("")
        self.entrada_dni.set_text("")
        self.entrada_nome.set_text("")
        self.saida_imc.set_text("")
        self.saida_clasificacion.set_text("")
        self.saida_dni.set_text("222")

    def alta(self,widget):
        if self.ver_paxina() == 0:
            self.alta_paciente()

        else:
            self.alta_medida()

    def modificacion(self,widget):
        self.modifica_paciente()


    def baixa(self,widget):
        if self.ver_paxina() == 0:
            self.elimina_paciente()
        else:
            print("baixa de medida")

    def discriminabotons(self, widget, x,i ):
        if self.ver_paxina() == 1:
            self.but_modificacion.show()
        else:
            self.but_modificacion.hide()

    def show_calendario(self, widget):
        self.ventana_calendario.show()

    def marcar_fecha(self, widget):
        ano, mes, dia = self.fech.get_date()
        self.entrada_fecha.set_text(str(dia) + '/' + str(mes) + '/' + str(ano))

    def calcula_e_clasifica(self,widget):
        erro=0
        if self.entrada_peso.get_text() == '':
            self.lbl_avisos.show()
            self.lbl_avisos.set_text("Falta peso")
            erro=1
        if self.entrada_talla.get_text() == '':
            self.lbl_avisos.show()
            self.lbl_avisos.set_text("Falta talla")
            erro = 1
        if erro == 0:
            aux=float(self.entrada_peso.get_text())/(float(self.entrada_talla.get_text())*float(self.entrada_talla.get_text()))
            self.saida_imc.set_text("{0:.2f}".format(aux))
            if aux <= 16:
                self.saida_clasificacion.set_text("Criterio de ingreso")
            elif aux <= 17:
                self.saida_clasificacion.set_text("Infrapeso")
            elif aux <= 18:
                self.saida_clasificacion.set_text("Peso Bajo")
            elif aux <= 25:
                self.saida_clasificacion.set_text("Peso Normal")
            elif aux <= 30:
                self.saida_clasificacion.set_text("Sobrepeso")
            elif aux <= 35:
                self.saida_clasificacion.set_text("Sobrepeso crónico")
            elif aux <= 40:
                self.saida_clasificacion.set_text("Obesidad Premorbida")
            elif aux >40:
                self.saida_clasificacion.set_text("Obesidad Mórbida")


    def ver_paxina(self):
        self.paxina_actual = self.notebook.get_current_page()
        return self.paxina_actual

# Método de refresco das listas
    def actualizar_listas(self):
        self.listpacientes.clear()
        self.listmedidas.clear()
        lista1 = MetodosDB.consultar_pacientes()
        for registro1 in lista1:
            self.listpacientes.append(registro1)
        lista2 = MetodosDB.consultar_medidas()
        for registro2 in lista2:
            self.listmedidas.append(registro2)
            print(self.DNISELECCIONADO)

    def limpafilacliente(self):
        self.dni = ''
        self.nome = ''
        self.sexo = ''
        self.fila_paciente = (self.dni, self.nome, self.sexo)

    def limpafilamedida(self):
        self.id = ''
        self.dni1 = ''
        self.peso = ''
        self.talla = ''
        self.imc = ''
        self.fecha = ''
        self.clasificacion = ''
        self.filamedida = (self.id, self.dni1, self.peso, self.talla, self.imc, self.fecha, self.clasificacion)

    def creafilas_paciente(self):
        self.dni = ''
        self.nome = ''
        self.sexo = ''
        self.dni = self.entrada_dni.get_text()
        self.nome = self.entrada_nome.get_text()
        if self.rb_femenino.get_active() == True:
            self.sexo = "F"
        else:
            self.sexo = "M"
        self.fila_paciente = (self.dni, self.nome, self.sexo)
        return self.fila_paciente

    def creafilas_medidas(self):
        self.dni1 = self.saida_dni.get_text()
        self.peso = float(self.entrada_peso.get_text())
        self.talla = float(self.entrada_talla.get_text())
        self.imc = float(self.saida_imc.get_text())
        self.fecha = self.entrada_fecha.get_text()
        self.clasificacion = self.saida_clasificacion.get_text()
        self.filamedida = (self.dni1, self.peso, self.talla, self.imc, self.fecha, self.clasificacion)

    def alta_paciente(self):
        if datos.comprobar_paciente(self.lbl_avisos,self.entrada_dni,self.entrada_nome):
            MetodosDB.insert_paciente(self.creafilas_paciente(),self.lbl_avisos)
        self.actualizar_listas()

    def alta_medida(self):
        MetodosDB.insert_medida(self.creafilas_medidas(),self.lbl_avisos)
        self.actualizar_listas()

    def modifica_paciente(self):
        if datos.comprobar_paciente(self.lbl_avisos, self.entrada_dni, self.entrada_nome):
            self.dni = ''
            self.nome = ''
            self.sexo = ''
            self.dni = self.entrada_dni.get_text()
            self.nome = self.entrada_nome.get_text()
            if self.rb_femenino.get_active() == True:
                self.sexo = "F"
            else:
                self.sexo = "M"
            self.fila_paciente = (self.nome, self.sexo, self.dni)
            MetodosDB.update_paciente(self.fila_paciente, self.lbl_avisos)
        self.actualizar_listas()

    def elimina_paciente(self):
        if datos.comprobar_paciente(self.lbl_avisos,self.entrada_dni,self.entrada_nome):
            MetodosDB.delete_paciente(self.creafilas_paciente(),self.lbl_avisos)
        self.actualizar_listas()

    def actualizar_paciente(self,widget):
        model,iter = self.treepacientes.get_selection().get_selected()
        self.sdni = model.get_value(iter, 0)
        self.DNISELECCIONADO = self.sdni
        self.snome = model.get_value(iter, 1)
        self.ssexo =model.get_value(iter, 2)
        self.entrada_dni.set_text(self.sdni)
        self.entrada_nome.set_text(self.snome)
        if self.ssexo == 'F':
            self.rb_femenino.set_active(True)
        else:
            self.rb_masculino.set_active(True)
        self.saida_dni.set_text(self.DNISELECCIONADO)

    def actualizar_medida(self,widget):
        model,iter = self.treemedidas.get_selection().get_selected()
        self.sdni1 = model.get_value(iter, 1)
        self.speso = model.get_value(iter, 2)
        self.stalla = model.get_value(iter, 3)
        self.saida_dni.set_text(self.sdni1)
        self.entrada_peso.set_text(str(self.speso))
        self.entrada_talla.set_text("{0:.2f}".format(self.stalla))





# Codificar o limpiador.
# Engadir boton de saida.
# Engadir funcion de cargar datos do paciente.



if __name__ == "__main__":
    print("Iniciando")
    main=Main()
    Gtk.main()