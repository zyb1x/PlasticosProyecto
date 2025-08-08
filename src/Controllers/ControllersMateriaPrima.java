/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

/**
 *
 * @author Are
 */
public class ControllersMateriaPrima {
    private String nombre;
    private String unidad;
    private String medida;
    private int cantidad;
    private String tipo;
    private String proveedor;

    public String getNombre() {
        return nombre;
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

    private String fechaingreso;

    public ControllersMateriaPrima(String nombre, String unidad, String medida, int cantidad, String tipo, String proveedor) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.medida = medida;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.proveedor = proveedor;
    }
    
    public Object[] toRow() {
        return new Object[]{ nombre, unidad, medida, cantidad, tipo, proveedor};
    }
    
}
