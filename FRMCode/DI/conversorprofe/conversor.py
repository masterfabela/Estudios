# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

import gi
gi.require_version('Gtk','3.0')
from gi.repository import Gtk

class Conversor:
    def __init__(self):
    # iniciamos la libreria GTK
        b = Gtk.Builder()
        b.add_from_file('conversor.glade')

    #cargamos los widgets asociados a un evento o son referenciados
        self.venprincipal = b.get_object("venprincipal")
        self.venSecundario = b.get_object("venSecundario")
        self.aviso = b.get_object("lblaviso")
        self.aviso2 = b.get_object("lblaviso2")
        self.resultado = b.get_object("lblresultado")
        self.resultado2 = b.get_object('lblresultado2')
        self.entdato = b.get_object("entdato")
        self.entdato2 = b.get_object("entdato2")
        self.cmbuno = b.get_object("cmbuno")
        self.cmbdos = b.get_object("cmbdos")
        self.rbtcel1 = b.get_object('rbtcel1')
        self.rbtfah2 = b.get_object('rbtfah2')
        
        dic = {'on_venprincipal_destroy': self.salir, 
        'on_btncalcula_clicked': self.calcula, 'on_venSecundario_destroy': self.ocultar,
        'on_btnvendos_clicked': self.abrirvendos,'on_btnsalir_clicked': self.ocultar,
        'on_btncalcular2_clicked': self.calcula2,
        }
        
        b.connect_signals(dic)
        self.venprincipal.show()
        
    #aquí comenzamos la codificación de las funciones
    def ocultar(self, widget):
        self.venSecundario.hide()
    
    def abrirvendos(self, widget):
        self.venSecundario.show()
    
    def salir(self, widget, data = None):
        Gtk.main_quit()
    
    #funciones que realizan los calculos
 
    def celtofah(self):
        fah = 1.4*float(self.temp) + 32.0
        fah = round(fah,2)
        var = str(fah)
        return (var)
    
    def fahtocel(self):
        cel = (float(self.temp) - 32.0) / 1.4
        cel = round(cel,2)
        var = str(cel)
        
        return (var)
    
    def celtokel(self):
        kel = 273.15 + float(self.temp)
        kel = round(kel,2)
        var = str(kel)
        return (var)
    
    def keltocel(self):
        cel = float(self.temp) - 273.15
        cel = round(cel,2)
        var = str(cel)
        
        return (var)

    #funcion que lo maneja todo en uno
    
    def calcula2(self, widget):
        try: 
            self.temp = self.entdato2.get_text()
            print (self.temp)
            if self.rbtcel1.get_active() and self.rbtfah2.get_active():
                print ('hola')
                self.var = self.celtofah()
                print (self.var)
                self.resultado2.set_text("")
                self.resultado2.set_text(self.var)
        except:
            self.aviso2.set_text("Error")
            
    
    def calcula(self, widget):
        self.aviso.set_text("")
        try:
            #cojo datos
            self.selec1 = self.cmbuno.get_active_text()
            self.selec2 = self.cmbdos.get_active_text()
            self.temp = self.entdato.get_text()
            
            if self.selec1 == "celsius" and self.selec2 == "farenheit":
                self.var = self.celtofah()
                self.resultado.set_text("")
                self.resultado.set_text(self.var)
            elif self.selec1 == "farenheit" and self.selec2 == "celsius":
                self.var = self.fahtocel()
                self.resultado.set_text("")
                self.resultado.set_text(self.var)
            elif self.selec1 == "celsius" and self.selec2 == "kelvin":
                self.var = self.celtokel()
                self.resultado.set_text("")
                self.resultado.set_text(self.var)
            elif self.selec1 == "kelvin" and self.selec2 == "celsius":
                self.var = self.keltocel()
                self.resultado.set_text("")
                self.resultado.set_text(self.var)
            elif self.selec1 == "kelvin" and self.selec2 == "farenheit":
                self.var1 = self.keltocel()
                self.temp = self.var1
                self.entdato.set_text("")
                self.var = self.celtofah()
                self.resultado.set_text("")
                self.resultado.set_text(self.var)
            elif self.selec1 == "farenheit" and self.selec2 == "kelvin":
                self.var1 = self.fahtocel()
                print (self.var1)
                self.temp = self.var1
                self.entdato.set_text("")
                self.var = self.celtokel()
                self.resultado.set_text("")
                self.resultado.set_text(self.var)
            else:
                self.aviso.set_text("Sin dato o Error en Escala")
        except:
            self.aviso.set_text("Error")
    
#aquí lanzamos el programa
if __name__ == '__main__':
    main = Conversor()
    Gtk.main()