package Controllers;

import Modelo.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    public void Mostrar(JTable table){
        String sql = "SELECT * FROM PRODUCTO";
        DefaultTableModel model = new DefaultTableModel();
        try(Connection conn = connection.getConnection();
                Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                String[] datos = new String[6];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
            }
            
        }catch(SQLException e){
                    e.printStackTrace();
                    }
    }
    public void desactivarProducto(){

    } 
    public void actualizarProducto(){
        
    }
}
