package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo.connection;
import java.util.Date;

public class ControllersAlmacen {

    public ControllersAlmacen() {

    }

    public void guardarAlmacen(int idProducto, java.util.Date fechaEntrada, java.util.Date fechaSalida) {
        String sql = "INSERT INTO ALMACEN (idProductos, fechaEntrada, fechaSalida) VALUES (?, ?, ?)";

        try (Connection conn = connection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Parámetro 1: idProducto
            pstmt.setInt(1, idProducto);

            // Conversión de java.util.Date a java.sql.Date
            pstmt.setDate(2, new java.sql.Date(fechaEntrada.getTime()));
            if (fechaEntrada != null) {
                pstmt.setDate(2, new java.sql.Date(fechaEntrada.getTime()));
            } else {
                pstmt.setNull(2, java.sql.Types.DATE);
            }

            if (fechaSalida != null) {
                pstmt.setDate(3, new java.sql.Date(fechaSalida.getTime()));
            } else {
                pstmt.setNull(3, java.sql.Types.DATE);
            }

            // Ejecutar la consulta
            pstmt.executeUpdate();

            System.out.println("Producto guardado correctamente en almacén");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarFecha(int idProducto, String fechaSalida) {
        String sql = "UPDATE ALMACEN SET fechaSalida=? WHERE idProductos=?";

        try (Connection conn = connection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idProducto);
            pstmt.setString(2, fechaSalida);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
