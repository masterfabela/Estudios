# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk
import xestionclientes
import datos



class Taller:
    def __init__(self):
        int_visual = Gtk.Builder();
        int_visual.add_from_file("XestionClientes.glade");
        self.but_alta=int_visual.get_object("but_alta")
        self.venPrincipal = int_visual.get_object("venPrincipal")
        self.listclientes = int_visual.get_object("listclientes")
        self.treeclientes = int_visual.get_object("treeclientes")
        self.entdni = int_visual.get_object("entdni")
        self.entapel = int_visual.get_object("entapel")
        self.entmat = int_visual.get_object("entmat")
        self.entnom = int_visual.get_object("entnom")
        self.entmail = int_visual.get_object("entmail")
        self.entmovil = int_visual.get_object("entmovil")
        self.entdata = int_visual.get_object("entdata")
        self.lblavisos = int_visual.get_object("lblavisos")
        self.venCalendar = int_visual.get_object("venCalendar")
        self.but_calendar = int_visual.get_object("but_calendar")
        self.fecha = int_visual.get_object("fecha")
        dic = {
            'on_venPrincipal_destroy': self.sair,
            'on_but_alta_clicked': self.altacliente,
            'on_venCalendar_destroy': self.destroycalendar,
            'on_but_calendar_clicked': self.showcalendar,
            'on_fecha_day_selected_double_click': self.showfecha,
            'on_but_editar_clicked': datos.edicion,
            'on_but_eliminar_clicked': datos.eliminacion,
            'on_but_pechar_clicked': self.sair,
        }
        int_visual.connect_signals(dic)
        self.lblavisos.hide()
        self.listarclientes()
        self.venPrincipal.show()
        #self.venPrincipal.maximize()

    def showfecha(self,widget):
        print ("Hola")
        ano,mes,dia=self.fecha.get_date()
        self.entdata.set_text(str(dia)+'/'+str(mes)+'/'+str(ano))

    def showcalendar(self, widget):
        self.venCalendar.show()


    def destroycalendar(self,widget):
        self.venCalendar.hide()

    def sair(self,widget):
        Gtk.main_quit()
        datos.pecharconexion()

    def listarclientes(self):
        lista = datos.listar()
        for registro in lista:
            self.listclientes.append(registro)

    def altacliente(self,widget):
            self.lblavisos.show()
            self.dni = self.entdni.get_text()
            self.mat = self.entmat.get_text()
            self.apel = self.entapel.get_text()
            self.nom = self.entnom.get_text()
            self.mail = self.entmail.get_text()
            self.movil = self.entmovil.get_text()
            self.data = self.entdata.get_text()
            if self.dni != '' and self.mat != '' and self.apel != '':
                if datos.comprobarDNI(self.entdni):
                    self.filacli = (self.dni, self.mat, self.apel, self.nom, self.mail, self.movil,self.data)
                    if datos.comprobarMail(self.mail):
                        xestionclientes.altacli(self.treeclientes, self.listclientes, self.filacli)
                        datos.altacliente(self.filacli)
                    else:
                        self.lblavisos.set_text("Email Incorrecto.")
                    self.limpacli()
                else:
                    self.lblavisos.set_text("DNI Incorrecto.")

            else:
                self.lblavisos.set_text("Faltan datos.")
    def limpacli(self):

        self.lmpcli = (self.entdni, self.entmat, self.entapel, self.entnom, self.entmail, self.entmovil,self.entdata)
        xestionclientes.limpiacli(self.lmpcli)
<<<<<<< HEAD
#engadir comporbador de dn1,expresion regular de email, e modulo datos.py e control de maiusculas en
# dni e Matricula(todas), e en nome e apelidos, só as primeiras.
#engadir canlendario
#engadir as funcionalidades de medificacion "a tempo real"
#carga de datos da base a o programa ó abrir a aplicación.
=======
# funcionalidade de BD
# modificación e eliminacion automatico-interactiva
# funcionalidade de calendario.
# instalar o sqlite.
>>>>>>> 8a54fe81c6776c87b14b7c92832a135e0bd6503e

if __name__ == "__main__":
    print("Inicio")
    main=Taller()
    Gtk.main()
