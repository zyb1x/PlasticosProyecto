package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.connection;
public class ControllersCliente {

    public ControllersCliente(){

    }
    public void crearCliente( String RFC, String nombre, String direccion, String telefono){
        String sql = "INSERT INTO CLIENTE (rfc, nombre, direccion, telefono)"+
        "VALUES (?,?,?,?)";

        try (Connection conn = connection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setString(1,RFC );
            pstmt.setString(2, nombre);
            pstmt.setString(3, direccion);
            pstmt.setString(4, telefono);

            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getIdCliente(String nombre, String telefono){
        String sql = "SELECT idCliente FROM CLIENTE WHERE nombre=? AND telefono=?";

         int idCliente = -1; // Valor por defecto que indica no encontrado

    try (Connection conn = connection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, nombre);
        pstmt.setString(2, telefono);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                idCliente = rs.getInt("idCliente");
                System.out.println("ID de venta obtenido: " + idCliente);
            } else {
                System.out.println("No se encontró el cliente con el nombre: " + nombre);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener ID de venta: ");
        e.printStackTrace();
    }
    return idCliente;
    }
}
