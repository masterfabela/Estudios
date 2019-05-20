/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author femio23
 */
public class Coche implements Serializable {

    private String matricula, marca, modelo, tipo;
    private float precioCompra, precioVenta;
    private Proveedor codigoProveedor;
    private Set<Reparacion> reparacions;
    private Exposicion codigoExposicion;
    private Cliente codigoCliente;
    private Cliente codigoReserva;
    private Comision codigoVendedor;

    public Coche() {
    }

    public Coche(String matricula, String marca, String modelo, String tipo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.reparacions = new HashSet<Reparacion>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Proveedor getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(Proveedor codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public Set<Reparacion> getReparacions() {
        return reparacions;
    }

    public void setReparacions(Set<Reparacion> reparacions) {
        this.reparacions = reparacions;
    }

    public Exposicion getCodigoExposicion() {
        return codigoExposicion;
    }

    public void setCodigoExposicion(Exposicion codigoExposicion) {
        this.codigoExposicion = codigoExposicion;
    }

    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Cliente getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(Cliente codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Comision getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Comision codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

}
