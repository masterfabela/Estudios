import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk
import bbdd
import servicios
import informes


class Restaurante():

    def __init__(self):
        b = Gtk.Builder()
        b.add_from_file('ventana.glade')
        self.vprincipal = b.get_object('principal')
        """ widgets entry """
        self.entservicio = b.get_object('entservicio')
        self.entprecio = b.get_object('entprecio')

        """ widgets liststores and treeviews """
        self.listservicios = b.get_object('listservicios')
        self.treeservicios = b.get_object('treeservicios')

        dic = {'on_principal_destroy': self.salir, 'on_btnaltaser_clicked': self.altaser,
               'on_btnsalir_clicked': self.salir, 'on_btnrepser_clicked': self.reporserv,
               'on_treeservicios_cursor_changed': self.cargaservicio, 'on_btnbajaser_clicked': self.bajarserv,
               'on_btnmodifser_clicked': self.modifserv}

        """ label usados """
        self.lblcodigo = b.get_object('lblcodigo')


        """ lista de listas """
        self.listaservicios = [ self.lblcodigo, self.entservicio, self.entprecio ]

        """ mostramos la ventana """
        b.connect_signals(dic)
        self.vprincipal.show()
        self.vprincipal.maximize()
        self.listarservicios()


        """ funciones servicios """
    def altaser(self, widget):
        self.servicio = self.entservicio.get_text()
        self.precio = self.entprecio.get_text()
        servicios.altaser(self.servicio, self.precio)
        self.listarservicios()

    def bajarserv(self, widget):
        self.codigo = self.lblcodigo.get_text()
        servicios.bajaservicio(self.codigo)
        self.listarservicios()

    def modifserv(self, widget):
        self.filaser = []
        for i in range(3):
            self.filaser.append(self.listaservicios[i].get_text())

        servicios.modifservicios(self.filaser)
        self.listarservicios()

    def listarservicios(self):
        listado = servicios.mostrarservicios()
        self.listservicios.clear()
        for registro in listado:
            self.listservicios.append(registro)

    def reporserv(self, widget):
        informes.reportservicios()

    def cargaservicio(self, widget):
        servicios.cargarservicio(self.listaservicios, self.treeservicios)

    """ funciones principales """

    def salir(self, widget):
        bbdd.cerrarconexion()
        Gtk.main_quit()




""" lanzamos el programa """

if __name__ == '__main__':
    main = Restaurante()
    Gtk.main()