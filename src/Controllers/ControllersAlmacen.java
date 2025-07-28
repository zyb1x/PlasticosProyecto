package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo.connection;

public class ControllersAlmacen {
  

    public ControllersAlmacen(){

    }

    public void guardarAlmacen(int idProducto, int idCompra, int idVenta, String fechaEntrada, String fechaSalida){
        String sql = "INSERT INTO ALMACEN (idProductos, idCompra, idVenta, fechaEntrada, fechaSalida)" +
        "VALUES(?,?,?,?,?,?)";
        try (Connection conn = connection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            conn.prepareStatement(sql);
            pstmt.setInt(1, idProducto);
            pstmt.setInt(2, idCompra);
            pstmt.setInt(3, idVenta);
            pstmt.setString(4, fechaEntrada);
            pstmt.setString(5, fechaSalida);

            pstmt.executeUpdate();

            System.out.println("Producto guardado correctamente ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarFecha(int idProducto, String fechaEntrada, String fechaSalida){
        String sql = "UPDATE ALMACEN SET fechaEntrada=? AND fechaSalida=? WHERE idProductos=?";

        try (Connection conn = connection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            pstmt.setInt(1, idProducto);
            pstmt.setString(2, fechaEntrada);
            pstmt.setString(2, fechaSalida);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
