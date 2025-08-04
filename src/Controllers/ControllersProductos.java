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
    public void registrarProducto(int idProducto, int idCategoria,String tipo, String nombre, int stock, double precio, double costo, String tamannio){
        String sql = "INSERT INTO PRODUCTOS (idProductos,idCategoria,tipo,nombre,precio,stock,costo,tamannio)"
                +"VALUES(?,?,?,?,?,?,?,?)";
        try(Connection conn = connection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idProducto);
        pstmt.setInt(2, idCategoria);
        pstmt.setString(3, tipo);
        pstmt.setString(4, nombre);
        pstmt.setDouble(5, precio);
        pstmt.setInt(6, stock);
        pstmt.setDouble(7, costo);
        pstmt.setString(8, tamannio);

        pstmt.executeUpdate();
        System.out.println("Producto agregado");
       } catch (Exception e) {
        System.out.println("Error al conectar con la base de datos" + e.getMessage());
       }
    }
    public void Mostrar(DefaultTableModel model, JTable table){
        String sql = "SELECT * FROM PRODUCTO";
        model = (DefaultTableModel) table.getModel();
        
        Object[] datos = new Object[8];
        try(Connection conn = connection.getConnection();
                Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)){
            while(rs.next()){
                datos[0] = rs.getInt("idProductos");
                datos[1] = rs.getInt("idCategoria");
                datos[2] = rs.getString("tipo");
                datos[3] = rs.getString("nombre");
                datos[4] = rs.getDouble("precio");
                datos[5] = rs.getInt("stock");
                datos[6] = rs.getDouble("costo");
                datos[7] = rs.getString("tamannio");
                model.addRow(datos);
            }
            table.setModel(model);
        }catch(SQLException e){
                    e.printStackTrace();
        }
    }
    public void desactivarProducto(int idProducto){
        String sql = "update productos set stock=0 where idProductos=?";
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idProducto);
            
            pstmt.executeUpdate();
            System.out.println("Producto desactivado");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }  
    public void actualizarProducto(double newPrecio, int newStock, double newCosto, String tamannio, int idProducto){
        String sql = "UPDATE PRODUCTOs SET precio=?, stock=?, costo=?, tamannio=? WHERE idProductos=?";
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setDouble(1, newPrecio);
            pstmt.setInt(2, newStock);
            pstmt.setDouble(3, newCosto);
            pstmt.setString(4, tamannio);
            pstmt.setInt(5, idProducto);
            pstmt.executeUpdate();
            System.out.println("Producto actualizado");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
     public int getStock(int idProducto){
        String sql = "SELECT stock FROM PRODUCTOS WHERE idProductos=?";
        int stock=-1;
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idProducto);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {
                stock = rs.getInt("stock");
                System.out.println("Nuevo stock " + stock);
            } else {
                System.out.println("No se encontro el stock del id del producto: " + idProducto);
            }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return stock;
    }
     public void setStock(int idProducto, int newStock){
         String sql = "UPDATE PRODUCTOS SET stock=? WHERE idProductos=?";
         try(Connection conn = connection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)){
             pstmt.setInt(1, idProducto);
             pstmt.setInt(2, newStock);
             
             pstmt.executeUpdate();
             System.out.println("Stock cambiado: " +  newStock);
         }
         catch(SQLException e){
             e.printStackTrace();
         }
     }
}
