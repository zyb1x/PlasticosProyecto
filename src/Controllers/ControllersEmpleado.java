package Controllers;

import Modelo.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ControllersEmpleado {
    private Connection conn;
    public ControllersEmpleado(){

    }
    public void crearEmpleado(int idEmpleado,String nombre, String turno, String password, String correo, String puesto){
        String sql = "INSERT INTO EMPLEADO (idEmpleado,nombre, turno, password, correo,puesto)"+
        "VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idEmpleado);
            pstmt.setString(2, nombre);
            pstmt.setString(3, turno);
            pstmt.setString(4, password);
            pstmt.setString(5, correo);
            pstmt.setString(6, puesto);
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos " + e.getMessage());
        }
    }
    public void buscarEmpleado(int idEmpleado){
        String sql = "SELECT * FROM EMPLEADO WHERE idEmpleado=?";
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Turno");
        model.addColumn("Contraseña");
        model.addColumn("Correo");
        model.addColumn("Puesto");
         try (Connection conn = connection.getConnection();
                Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)){
             while (rs.next()) {
                String[] datos = new String[6];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
             }
         }
         catch(SQLException e){
             e.printStackTrace();
         }
    }

    public void borrarEmpleado(int idEmpleado){
        String sql = "DELETE EMPLEADO WHERE idEmpleado=?";
        
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idEmpleado);
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
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
    public void setContrasennia(int idEmpleado, String newPwd){
        String sql = "UPDATE EMPLEADO SET password=? WHERE idEmpleado=?";
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idEmpleado);
            pstmt.setString(2, newPwd);
            pstmt.executeUpdate();
            System.out.print("New Password is: " + newPwd);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public int getPuesto(int idEmpleado){
        return idEmpleado;
    }
}


