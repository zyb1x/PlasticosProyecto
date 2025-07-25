package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}


