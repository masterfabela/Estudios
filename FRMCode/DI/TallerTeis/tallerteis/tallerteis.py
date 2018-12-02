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
        self.lblavisos = int_visual.get_object("lblavisos")
        self.venCalendar = int_visual.get_object("venCalendar")
        self.venCalendar.connect('delete-event', lambda w, e: w.hide() or True)
        self.but_calendar = int_visual.get_object("but_calendar")
        self.selectorClientes = int_visual.get_object("selectorClientes")
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
            'on_fecha_day_selected_double_click': self.showfecha,
            'on_but_editar_clicked': self.editardatos,
            'on_but_eliminar_clicked': self.baixacliente,
            'on_but_pechar_clicked': self.sair,
            'on_selectorClientes_changed': self.cargandodatos,
            'on_but_vaciador_clicked': self.limpador
        }
        int_visual.connect_signals(dic)
        self.lblavisos.hide()
        self.actualizar_listas()
        self.venPrincipal.show()
        #self.venPrincipal.maximize()

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

    def ver_paxina(self):
        print(self.notebook.get_current_page())

    def showfecha(self , widget):
        ano, mes, dia = self.fecha.get_date()
        self.entdata.set_text(str(dia)+'/'+str(mes)+'/'+str(ano))

    def cargandodatos(self, widget):
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

    def sair(self, widget):
        Gtk.main_quit()
        xestion_clientes.pechar_conexion()

    def actualizar_listas(self):
        lista1 = xestion_clientes.consultar_clientes()
        for registro1 in lista1:
            self.listclientes.append(registro1)
        lista2 = xestion_clientes.consultar_reparacion()
        for registro2 in lista2:
            self.listreparacion.append(registro2)
        lista3 = xestion_clientes.consultar_factura()
        for registro3 in lista3:
            self.listfacturas.append(registro3)

    def creafilas(self):
        self.dni = self.entdni.get_text()
        self.mat = self.entmat.get_text()
        self.apel = self.entapel.get_text()
        self.nom = self.entnom.get_text()
        self.mail = self.entmail.get_text()
        self.movil = self.entmovil.get_text()
        self.data = self.entdata.get_text()
        self.filacli = (self.dni, self.mat, self.apel, self.nom, self.mail, self.movil, self.data)
        return self.filacli

    def altas(self,widget):
        if self.ver_paxina()== '0':
            self.altacliente()
        else:
            print(self.ver_paxina())

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
                self.filacli = (self.dni, self.mat, self.apel, self.nom, self.mail, self.movil,self.data)
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
            xestion_clientes.eliminacion(self.fila, self.lblavisos)
            self.listclientes.clear()
            self.actualizar_listas()
            self.limpacli()

    def editardatos(self, widget):
        self.dni = self.entdni.get_text()
        self.mat = self.entmat.get_text()
        self.apel = self.entapel.get_text()
        self.nom = self.entnom.get_text()
        self.mail = self.entmail.get_text()
        self.movil = self.entmovil.get_text()
        self.data = self.entdata.get_text()
        self.filacliedit = (self.dni, self.mat, self.apel, self.nom, self.mail, self.movil, self.data, self.dniprovisional)

        xestion_clientes.edicion(self.filacliedit, self.lblavisos)
        self.listclientes.clear()
        self.actualizar_listas()
        self.limpacli()

    def limpacli(self):

        self.lmpcli = (self.entdni, self.entmat, self.entapel, self.entnom, self.entmail, self.entmovil,self.entdata)
        xestion_clientes.limpiacli(self.lmpcli)

# engadir as funcionalidades de modificacion "a tempo real"
# facturas con Man de obra, cambio de aceite, cambio de rodas:
# (discriminando dianteiras e traseiras),bateria, pastillas de freo e filtros.
# clientes e reparacións terán cadansua taboa.
# Deseñar botons personalizados
# Distintas funcións dos botons dependendo do notebook.
# Ver a función de saida da facturación.
# Como pillar solo dous decimales
# "{0:.2f}".format(variable)


if __name__ == "__main__":
    print("Inicio")
    main = Taller()
    Gtk.main()
