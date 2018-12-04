import xestion_clientes
import datos
import gi
from gi.repository import Gtk
gi.require_version('Gtk', '3.0')


class Taller:
    def __init__(self):
        int_visual = Gtk.Builder()
        int_visual.add_from_file("XestionClientes.glade")
        self.but_alta = int_visual.get_object("but_alta")
        self.venPrincipal = int_visual.get_object("venPrincipal")
        self.listclientes = int_visual.get_object("listclientes")
        self.treeclientes = int_visual.get_object("treeclientes")
        self.listreparacion = int_visual.get_object("listreparacion")
        self.treereparacion = int_visual.get_object("treereparacion")
        self.listfacturas = int_visual.get_object("listfacturas")
        self.treefacturas = int_visual.get_object("treefacturas")
        self.entdni = int_visual.get_object("entdni")
        self.entapel = int_visual.get_object("entapel")
        self.entmat = int_visual.get_object("entmat")
        self.entnom = int_visual.get_object("entnom")
        self.entmail = int_visual.get_object("entmail")
        self.entmovil = int_visual.get_object("entmovil")
        self.entdata = int_visual.get_object("entdata")
        self.enthoras = int_visual.get_object("enthoras")
        self.entlitros = int_visual.get_object("entlitros")
        self.entpastillas = int_visual.get_object("entpastillas")
        self.entneumaticos = int_visual.get_object("entneumaticos")
        self.entfiltros = int_visual.get_object("entfiltros")
        self.checkaceite = int_visual.get_object("checkaceite")
        self.checkpastillas = int_visual.get_object("checkpastillas")
        self.checkneumaticos = int_visual.get_object("checkneumaticos")
        self.checkbateria = int_visual.get_object("checkbateria")
        self.checkfiltros = int_visual.get_object("checkfiltros")
        self.saida_factura = int_visual.get_object("saida_factura")
        self.saida_matricula = int_visual.get_object("saida_matricula")
        self.ent_data_factura = int_visual.get_object("ent_data_factura")
        self.lblavisos = int_visual.get_object("lblavisos")
        self.venCalendar = int_visual.get_object("venCalendar")
        self.venCalendar.connect('delete-event', lambda w, e: w.hide() or True)
        self.but_calendar = int_visual.get_object("but_calendar")
        self.but_calendarfact = int_visual.get_object("but_calendarfact")
        self.selectorClientes = int_visual.get_object("selectorClientes")
        self.selectorReparacions = int_visual.get_object("selectorReparacions")
        self.selectorFacturas = int_visual.get_object("selectorFacturas")
        self.fecha = int_visual.get_object("fecha")
        self.but_vaciador = int_visual.get_object("but_vaciador")
        self.but_about = int_visual.get_object("but_about")
        self.ven_about = int_visual.get_object("ven_about")
        self.ven_about.connect('delete-event', lambda w, e: w.hide() or True)
        self.notebook = int_visual.get_object("notebook")
        
        dic = {
            'on_venPrincipal_destroy': self.sair,
            'on_but_about_activate':self.showAbout,
            'on_but_alta_clicked': self.altas,
            'on_but_calendar_clicked': self.showcalendar,
            'on_but_calendarfact_clicked': self.showcalendar,
            'on_fecha_day_selected_double_click': self.showfecha,
            'on_but_editar_clicked': self.editar,
            'on_but_eliminar_clicked': self.eliminar,
            'on_but_pechar_clicked': self.sair,
            'on_selectorClientes_changed': self.cargandodatos_clientes,
            'on_selectorReparacions_changed': self.cargandodatos_reparacions,
            'on_selectorFacturas_changed': self.cargandodatos_facturas,
            'on_but_vaciador_clicked': self.limpador
        }
        int_visual.connect_signals(dic)
        self.lblavisos.hide()
        self.actualizar_listas()
        self.venPrincipal.show()
        # self.venPrincipal.maximize()
        self.paxina_actual = 0


# Funcions de ventás:

    def showcalendar(self, widget):
        self.venCalendar.show()

    def showAbout(self, widget):
        self.ven_about.show()

# Funcions de limpeza:

    def limpador(self, widget):
        self.limpacli()
        self.lblavisos.set_text('')
        self.lblavisos.hide()
        self.ver_paxina()
        self.NUMEROFACTURA=0
        self.ent_data_factura.set_text('')
        self.enthoras.set_text('')
        self.checkbateria.set_active(False)
        self.checkfiltros.set_active(False)
        self.checkaceite.set_active(False)
        self.entlitros.set_text('')
        self.checkneumaticos.set_active(False)
        self.entneumaticos.set_active(-1)
        self.checkpastillas.set_active(False)
        self.entpastillas.set_active(-1)
        self.checkfiltros.set_active(False)
        self.entfiltros.set_active(-1)
        self.saida_matricula.set_text('')
        self.saida_factura.set_text('')

    def ver_paxina(self):
        self.paxina_actual=self.notebook.get_current_page()
        return self.paxina_actual

    def showfecha(self, widget):
        if self.ver_paxina() == 0:
            ano, mes, dia = self.fecha.get_date()
            self.entdata.set_text(str(dia) + '/' + str(mes) + '/' + str(ano))
        elif self.ver_paxina() == 2:
            ano, mes, dia = self.fecha.get_date()
            self.ent_data_factura.set_text(str(dia)+'/'+str(mes)+'/'+str(ano))

    def cargandodatos_clientes(self, widget):
        model, iter = self.treeclientes.get_selection().get_selected()
        if iter != None:
            sdni = model.get_value(iter, 0)
            self.dniprovisional = sdni
            self.entdni.set_text(sdni)
            smat = model.get_value(iter, 1)
            self.entmat.set_text(smat)
            sapel = model.get_value(iter, 2)
            self.entapel.set_text(sapel)
            snome = model.get_value(iter, 3)
            self.entnom.set_text(snome)
            smail = model.get_value(iter, 4)
            self.entmail.set_text(smail)
            smovil = model.get_value(iter, 5)
            self.entmovil.set_text(smovil)
            sdata = model.get_value(iter, 6)
            self.entdata.set_text(sdata)
            self.saida_matricula.set_text(str(smat))

    def cargandodatos_reparacions(self, widget):
        model, iter = self.treereparacion.get_selection().get_selected()
        if iter != None:
            self.NUMEROFACTURA= model.get_value(iter, 0)
            shoras = model.get_value(iter, 1)
            self.horasprovisional = shoras
            self.enthoras.set_text("{0:.2f}".format(shoras))
            sbateria = model.get_value(iter, 2)
            self.bateriaprovisional=sbateria
            if sbateria == "Si":
                self.checkbateria.set_active(True)
            else:
                self.checkbateria.set_active(False)
            saceite = model.get_value(iter, 3)
            self.aceiteprovisional = saceite
            if saceite > 0:
                self.checkaceite.set_active(True)
                self.entlitros.set_text("{0:.2f}".format(saceite))
            else:
                self.checkaceite.set_active(False)
            sneumaticos = model.get_value(iter, 4)
            self.neumaticosprovisional=sneumaticos
            if sneumaticos != "Non":
                self.checkneumaticos.set_active(True)
                if sneumaticos == "Dianteiros":
                    self.entneumaticos.set_active(0)
                elif sneumaticos == "Traseiros":
                    self.entneumaticos.set_active(1)
                elif sneumaticos == "Todos":
                    self.entneumaticos.set_active(2)
            spastillas = model.get_value(iter, 5)
            self.pastillasprovisional=spastillas
            if spastillas != "Non":
                self.checkpastillas.set_active(True)
                if spastillas == "Dianteiras":
                    self.entpastillas.set_active(0)
                elif spastillas == "Traseiras":
                    self.entpastillas.set_active(1)
                elif spastillas == "Todas":
                    self.entpastillas.set_active(2)
            sfiltros = model.get_value(iter,6)
            self.filtrosprovisionais = sfiltros
            if sfiltros != "Non":
                self.checkfiltros.set_active(True)
                if sfiltros == "Aire":
                    self.entfiltros.set_active(0)
                elif sfiltros == "Aceite":
                    self.entfiltros.set_active(1)
                elif sfiltros == "Todos":
                    self.entfiltros.set_active(2)
            self.saida_factura.set_text(str(self.NUMEROFACTURA))

    def cargandodatos_facturas(self, widget):
        model, iter = self.treefacturas.get_selection().get_selected()
        ssaida_factura = model.get_value(iter,0)
        self.saida_facturaprovisional = ssaida_factura
        self.saida_factura.set_text(str(ssaida_factura))
        ssaida_matricula = model.get_value(iter, 1)
        self.saida_matriculaprovisional = ssaida_matricula
        self.saida_matricula.set_text(ssaida_matricula)
        sdata_factura = model.get_value(iter, 2)
        self.data_facturaprovisional = sdata_factura
        self.ent_data_factura.set_text(sdata_factura)

    def sair(self, widget):
        Gtk.main_quit()
        xestion_clientes.pechar_conexion()

    def actualizar_listas(self):
        self.listreparacion.clear()
        self.listclientes.clear()
        self.listfacturas.clear()
        lista1 = xestion_clientes.consultar_clientes()
        for registro1 in lista1:
            self.listclientes.append(registro1)
        lista2 = xestion_clientes.consultar_reparacion()
        for registro2 in lista2:
            self.listreparacion.append(registro2)
        lista3 = xestion_clientes.consultar_factura()
        for registro3 in lista3:
            self.listfacturas.append(registro3)


    def creafilas_clientes(self):
        self.dni = self.entdni.get_text()
        self.mat = self.entmat.get_text()
        self.apel = self.entapel.get_text()
        self.nom = self.entnom.get_text()
        self.mail = self.entmail.get_text()
        self.movil = self.entmovil.get_text()
        self.data = self.entdata.get_text()
        self.filacli = (self.dni, self.mat, self.apel, self.nom, self.mail, self.movil, self.data)
        return self.filacli

    def creafilas_reparacion(self):
        self.horas = float(self.enthoras.get_text())
        if self.checkbateria.get_active() == True:
            self.bateria = "Si"
        else:
            self.bateria = "Non"
        if self.checkaceite.get_active() == True:
            self.aceite = float(self.entlitros.get_text())
        else:
            self.aceite = 0
        if self.checkneumaticos.get_active() == True:
            if self.entneumaticos.get_active() == 0:
                self.neumaticos = "Dianteiros"
            elif self.entneumaticos.get_active() == 1:
                self.neumaticos = "Traseiros"
            elif self.entneumaticos.get_active() == 2:
                self.neumaticos = "Todos"
        else:
            self.neumaticos = "Non"
        if self.checkpastillas.get_active == True:
            if self.entpastillas.get_active() == 0:
                self.pastillas = "Dianteiras"
            elif self.entpastillas.get_active() == 1:
                self.pastillas = "Traseiras"
            elif self.entpastillas.get_active() == 2:
                self.pastillas = "Todas"
        else:
            self.pastillas = "Non"
        if self.checkfiltros.get_active == True:
            if self.entfiltros.get_active() == 0:
                self.filtros = "Aceite"
            elif self.entfiltros.get_active() == 1:
                self.filtros = "Aire"
            elif self.entpastillas.get_active() == 2:
                self.filtros = "Todos"
        else:
            self.filtros = "Non"
        self.filarep = (self.horas, self.bateria, self.aceite, self.neumaticos, self.pastillas, self.filtros)
        return self.filarep

    def altas(self, widget):
        if self.ver_paxina() == 0:
            self.altacliente()
        elif self.ver_paxina() == 1:
            self.altareparacions()
        elif self.ver_paxina() == 2:
            self.altafactura()

    def editar(self, widget):
        if self.ver_paxina() == 0:
            self.editarcliente()
        elif self.ver_paxina() == 1:
            self.editarreparacion()
        elif self.ver_paxina() == 2:
            self.editarfactura()

    def eliminar(self, widget):
        if self.ver_paxina() == 0:
            self.baixacliente()
        elif self.ver_paxina() == 1:
            self.baixareparacion()
        elif self.ver_paxina() == 2:
            self.baixafactura()

    def creafilas_factura(self):
        aux = self.saida_factura.get_text()
        self.fnfactura = int(aux)
        self.fmatricula = self.saida_matricula.get_text()
        self.fdata = self.ent_data_factura.get_text()
        self.filafact = (self.fnfactura, self.fmatricula, self.fdata)
        return self.filafact

    def altafactura(self):
        xestion_clientes.altafactura(self.creafilas_factura(), self.lblavisos)
        self.actualizar_listas()
        self.fnfactura = ''
        self.fmatricula = ''
        self.fdata = ''



    def altareparacions(self):
        xestion_clientes.altareparacion(self.creafilas_reparacion(), self.lblavisos)
        self.actualizar_listas()
        self.horas = 0
        self.bateria = ""
        self.aceite = 0
        self.neumaticos = ""
        self.pastillas = ""
        self.filtros = ""

    def altacliente(self):
        self.lblavisos.show()
        self.dni = self.entdni.get_text()
        self.mat = self.entmat.get_text()
        self.apel = self.entapel.get_text()
        self.nom = self.entnom.get_text()
        self.mail = self.entmail.get_text()
        self.movil = self.entmovil.get_text()
        self.data = self.entdata.get_text()
        self.filacli = (self.dni, self.mat, self.apel, self.nom, self.mail, self.movil, self.data)
        if self.dni != '' and self.mat != '' and self.apel != '':
            if datos.comprobarDNI(self.entdni):
                self.filacli = (self.dni, self.mat, self.apel, self.nom, self.mail, self.movil, self.data)
                if datos.comprobarMail(self.mail):
                    xestion_clientes.altacli(self.treeclientes, self.listclientes, self.filacli)
                    xestion_clientes.altacliente(self.filacli,self.lblavisos)
                else:
                    self.lblavisos.set_text("Email Incorrecto.")
                self.limpacli()
            else:
                self.lblavisos.set_text("DNI Incorrecto.")
        else:
            self.lblavisos.set_text("Faltan datos.")
        self.dni = ''
        self.mat = ''
        self.apel = ''
        self.nom = ''
        self.mail = ''
        self.movil = ''
        self.data = ''

    def baixacliente(self, widget):
        if self.entdni.get_text() == ''and self.mat == '' and self.apel == '':
            self.lblavisos.set_text('Faltan datos')
        else:
            self.fila = self.creafilas()
            xestion_clientes.eliminacioncliente(self.fila, self.lblavisos)
            self.listclientes.clear()
            self.actualizar_listas()
            self.limpacli()

    def baixareparacion(self):
        xestion_clientes.eliminacionreparacion(self.NUMEROFACTURA,self.lblavisos)
        self.actualizar_listas()

    def editarreparacion(self):
        self.horas = float(self.enthoras.get_text())
        if self.checkbateria.get_active() == True:
            self.bateria = "Si"
        else:
            self.bateria = "Non"
        if self.checkaceite.get_active() == True:
            self.aceite = float(self.entlitros.get_text())
        else:
            self.aceite = 0
        if self.checkneumaticos.get_active() == True:
            if self.entneumaticos.get_active() == 0:
                self.neumaticos = "Dianteiros"
            elif self.entneumaticos.get_active() == 1:
                self.neumaticos = "Traseiros"
            elif self.entneumaticos.get_active() == 2:
                self.neumaticos = "Todos"
        else:
            self.neumaticos = "Non"
        if self.checkpastillas.get_active == True:
            if self.entpastillas.get_active() == 0:
                self.pastillas = "Dianteiras"
            elif self.entpastillas.get_active() == 1:
                self.pastillas = "Traseiras"
            elif self.entpastillas.get_active() == 2:
                self.pastillas = "Todas"
        else:
            self.pastillas = "Non"
        if self.checkfiltros.get_active == True:
            if self.entfiltros.get_active() == 0:
                self.filtros = "Aceite"
            elif self.entfiltros.get_active() == 1:
                self.filtros = "Aire"
            elif self.entpastillas.get_active() == 2:
                self.filtros = "Todos"
        else:
            self.filtros = "Non"
        self.filarep = (self.horas, self.bateria, self.aceite, self.neumaticos, self.pastillas, self.filtros, self.NUMEROFACTURA)
        xestion_clientes.edicionreparacion(self.filarep, self.lblavisos)
        self.actualizar_listas()

    def editarcliente(self):
        self.dni = self.entdni.get_text()
        self.mat = self.entmat.get_text()
        self.apel = self.entapel.get_text()
        self.nom = self.entnom.get_text()
        self.mail = self.entmail.get_text()
        self.movil = self.entmovil.get_text()
        self.data = self.entdata.get_text()
        self.filacliedit = (self.dni, self.mat, self.apel, self.nom, self.mail, self.movil, self.data, self.dniprovisional)
        xestion_clientes.edicioncliente(self.filacliedit, self.lblavisos)
        self.listclientes.clear()
        self.actualizar_listas()
        self.limpacli()

    def limpacli(self):

        self.lmpcli = (self.entdni, self.entmat, self.entapel, self.entnom, self.entmail, self.entmovil,self.entdata)
        xestion_clientes.limpiacli(self.lmpcli)

# Como pillar solo dous decimales:
# "{0:.2f}".format(variable)


if __name__ == "__main__":
    print("Inicio")
    main = Taller()
    Gtk.main()
