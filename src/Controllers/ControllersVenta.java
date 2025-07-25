package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.connection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;

public class ControllersVenta {


    public ControllersVenta(){

    }

    public void crearVenta(int idEmpleado,int idClienteSF){
        String sql = "INSERT INTO VENTA (idEmpleado, fecha, idClienteSF)"
       + "VALUES(?, NOW(), ?)";

       try(Connection conn = connection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idEmpleado);
        pstmt.setInt(2, idClienteSF);

        pstmt.executeUpdate();
       } catch (Exception e) {
        System.out.println("Error al conectar con la base de datos" + e.getMessage());
       }
    }
    
    public void eliminarVenta(int idVenta){
        String sql = "DELETE FROM VENTA WHERE idVenta=?";

        try(Connection conn = connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, idVenta);
            pstmt.executeUpdate();

        }
        catch(SQLException e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
    }

    public void buscarVenta(int idVenta, JTable table){
        String sql = "SELECT * FROM VENTA WHERE idVenta=";
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Id Venta");
        modelo.addColumn("Fecha");
        modelo.addColumn("ID Cliente");

        table.setModel(modelo);

        try (Connection conn = connection.getConnection();
            Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)){

            while (rs.next()) {
                String[] datos = new String[3];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelo.addRow(datos);
            }

        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
    }

    public void listarVentas(){
        String sql = "SELECT * FROM venta";
        try (Connection conn = connection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID Venta: " + rs.getInt("idVenta") + ", Fecha: " + rs.getDate("fecha"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getIdVenta(int idCliente) {
    String sql = "SELECT idVenta FROM VENTA WHERE idClienteSF=?";
    int idVenta = -1; // Valor por defecto que indica no encontrado

    try (Connection conn = connection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, idCliente);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                idVenta = rs.getInt("idVenta");
                System.out.println("ID de venta obtenido: " + idVenta);
            } else {
                System.out.println("No se encontró venta para el cliente: " + idCliente);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener ID de venta: ");
        e.printStackTrace();
    }
    return idVenta;
}

public void buscarVentaPorFecha(String fecha, JTable table){
    String sql = "SELECT * FROM VENTA WHERE fecha=?";
    try (Connection conn = connection.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql)){
        
        pstmt.setString(1, fecha);
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID venta");
        model.addColumn("ID Cliente");
        model.addColumn("Fecha");

        table.setModel(model);
        try(ResultSet rs = pstmt.executeQuery()){
            while (rs.next()) {
              String[] datos = new String[3];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                model.addRow(datos);
            }
        }
        catch(SQLException e){
            System.out.println("Error al obtener la(s) ventas");
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al conectar con la base de datos");
    }
}

}
