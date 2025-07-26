package Controllers;

import Modelo.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllersEmpleado {
    private Connection conn;
    public ControllersEmpleado(){

    }
    public void crearEmpleado(int idEmpleado, String turno, String password, String correo, String puesto){
        String sql = "INSERT INTO EMPLEADO (idEmpleado, turno, password, correo,puesto)"+
        "VALUES (?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idEmpleado);
            pstmt.setString(2, turno);
            pstmt.setString(3, password);
            pstmt.setString(4, correo);
            pstmt.setString(5, puesto);
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos " + e.getMessage());
        }
    }
    public void buscarEmpleado(){

    }
    public void actualizarEmpleado(){

    }

    public void borrarEmpleado(){

    }
    public int getIdEmpleado(String correo){
        String sql = "SELECT idEmpleado FROM EMPLEADO WHERE correo=?";

         int idEmpleado = -1; // Valor por defecto que indica no encontrado

    try (Connection conn = connection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, correo);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                idEmpleado = rs.getInt("idEmpleado");
                System.out.println("ID de Empleado: " + idEmpleado);
            } else {
                System.out.println("No se encontró el cliente con el correo: " + correo);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener ID de venta: ");
        e.printStackTrace();
    }
    return idEmpleado;
    }
}


