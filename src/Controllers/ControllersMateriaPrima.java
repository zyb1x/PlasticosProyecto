/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Modelo.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
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
    private int codigo;
    
    public int getCodigo(){
        return this.codigo;
    }

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

    public ControllersMateriaPrima( String nombre, String unidad, String medida, int cantidad, String tipo, String proveedor) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.medida = medida;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.proveedor = proveedor;
        this.codigo = -1;
    }
        public ControllersMateriaPrima( int codigo, String nombre, String unidad, String medida, int cantidad, String tipo, String proveedor) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.medida = medida;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.proveedor = proveedor;
    }
    
    public Object[] toRow() {
        return new Object[]{ codigo, nombre, unidad, medida, cantidad, tipo, proveedor};
    }
    
    
    public int getCodigo(String nombre){
        String sql = "SELECT codigo FROM ALMACEN_MATERIAL WHERE nombre=?";
        int codigo = -1;
        try(Connection conn = connection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, nombre);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {
                codigo = rs.getInt("codigo");
                System.out.println("Codigo obtenido" + codigo);
                
            } else {
                System.out.println("No se encontró codigo para " + nombre);
            }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return codigo;
    }
    public void setExistencia(int newStock, int codigo){
        String sql = "UPDATE ALMACEN_MATERIAL SET cantidad=? WHERE codigo=?";
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(2, codigo);
            pstmt.setInt(1, newStock);
        }
        catch(SQLException e){
            
        }
    }
    public int getExistencia(int codigo){
        String sql = "SELECT cantidad FROM ALMACEN_MATERIAL WHERE codigo=?";
        int cantidad = -1;
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, codigo);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    cantidad = rs.getInt("cantidad");
                    System.out.println("Cantidad" + cantidad);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return cantidad;
    }
}
