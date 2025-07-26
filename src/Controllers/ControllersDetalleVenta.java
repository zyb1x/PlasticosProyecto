package Controllers;

import Modelo.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControllersDetalleVenta {

    public ControllersDetalleVenta(){
    }

    public void crearDetalle(int idVenta, int idProductos, int cantidad, double precio, double total){
        String sql = "INSERT INTO DETALLE_VENTA (idVenta, idProductos, cantidad, precio, subtotal)"
        + "VALUES(?,?,?,?,?)";

        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idVenta);
            pstmt.setInt(2, idProductos);
            pstmt.setInt(3, cantidad);
            pstmt.setDouble(4, precio);
            pstmt.setDouble(5, total);

            pstmt.executeUpdate();
            System.out.println("Detalle de venta registrado");
        }
        catch(SQLException e){
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
        
    }

    public void buscarDetalle(int idDetalle, JTable table){
        String sqlString = "SELECT * FROM DETALLE_VENTA WHERE idDetalle=?";
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Detalle");
        model.addColumn("ID Venta");
        model.addColumn("ID Producto");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Subtotal");
        table.setModel(model);
        try (Connection conn = connection.getConnection();
                Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sqlString)){
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
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
    }
}
