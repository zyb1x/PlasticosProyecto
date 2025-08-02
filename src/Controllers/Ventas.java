/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Ventas {
    
    private int idVenta;
    private int idEmpleado;
    private Date fecha;
    private int idCliente;
    
    public Ventas(){
        
    }
    
    public void setIdVenta( int idVenta){
        this.idVenta = idVenta;
    }
    public void setIdEmpleado(int idEmpleado){
        this.idEmpleado = idEmpleado;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }
    public int idVenta(){
        return idVenta;
    }
    public int getIdEmpleado(){
        return idEmpleado;
    }
    public Date getFecha(){
        return fecha;
    }
    public int getIdCliente(){
        return idEmpleado;
    }
    
}
