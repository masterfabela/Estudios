/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;

/**
 *
 * @author femio23
 */
public class Reparacion implements Serializable{
    private String codigo,tipo,descricion;
    private Coche codigoCoche;

    public Reparacion() {
    }

    public Reparacion(String codigo, String tipo, String descricion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descricion = descricion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public Coche getCodigoCoche() {
        return codigoCoche;
    }

    public void setCodigoCoche(Coche codigoCoche) {
        this.codigoCoche = codigoCoche;
    }

    
    
}
