/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author Dj Trake Mix
 */
public class ControllersMateriaPrima {
    private String nombre;
    private String codigo;
    private String unidad;
    private String medida;
    private int cantidad;
    private String tipo;
    private String proveedor;

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getMedida() {
        return medida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }
    private String fechaingreso;

    public ControllersMateriaPrima(String nombre, String codigo, String unidad, String medida, int cantidad, String tipo, String proveedor, String fechaingreso) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.unidad = unidad;
        this.medida = medida;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.proveedor = proveedor;
        this.fechaingreso = fechaingreso;
    }
    
    public Object[] toRow() {
        return new Object[]{ nombre, codigo, unidad, medida, cantidad, tipo, proveedor, fechaingreso};
    }
    
}
