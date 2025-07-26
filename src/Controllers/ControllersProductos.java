package Controllers;

import Modelo.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ControllersProductos {

    public ControllersProductos(){

    }
    public void registrarProducto(int idProductos, int idCategoria, String nombre, double precio, int stock, String tamannio){
        String sql = "INSERT INTO PRODUCTOS (idProductos, idCategoria, nombre, precio, stock, tamannio)"
                +"VALUES(?,?,?,?,?,?)";
        try(Connection conn = connection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idProductos);
        pstmt.setInt(2, idCategoria);
        pstmt.setString(3, nombre);
        pstmt.setDouble(4, precio);
        pstmt.setInt(5, stock);
        pstmt.setString(6, tamannio);


        pstmt.executeUpdate();
       } catch (Exception e) {
        System.out.println("Error al conectar con la base de datos" + e.getMessage());
       }
    }
    public void buscarProducto(){

    }
    public void desactivarProducto(){

    } 
    public void actualizarProducto(){
        
    }
}
