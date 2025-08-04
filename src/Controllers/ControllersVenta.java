//ControllersVenta

package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.connection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ControllersVenta {


    public ControllersVenta(){

    }

    public void crearVenta(int idEmpleado,int idCliente){
        String sql = "INSERT INTO VENTA (idEmpleado, fecha, idCliente)"
       + "VALUES(?, NOW(), ?)";

       try(Connection conn = connection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
           
        try{
        pstmt.setInt(1, idEmpleado);
        pstmt.setInt(2, idCliente);

        pstmt.executeUpdate();
        System.out.print("Venta registrada");
        }
        catch(Exception e){
            System.out.println("Error al registrar venta" + e.getMessage());
        }
        
       } catch (SQLException e) {
        System.out.println("Error al conectar con la base de datos");
        e.printStackTrace();
       }
    }   
    public void eliminarVenta(int idVenta){
        String sql = "DELETE FROM VENTA WHERE idVenta=?";

        try(Connection conn = connection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, idVenta);
            pstmt.executeUpdate();

            System.out.println("Venta eliminada");
        }
        catch(SQLException e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
    }
    public void buscarVentaId(int idVenta, JTable table, DefaultTableModel modelo){
        String sql = "SELECT * FROM VENTA WHERE idVenta=?";

        modelo.addColumn("ID Venta");
        modelo.addColumn("ID Empleado");
        modelo.addColumn("Fecha");
        modelo.addColumn("ID Cliente");

        Object[] datos = new Object[4];
        
        try (Connection conn = connection.getConnection();
            Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql)){
            while (rs.next()) {
                datos[0]=rs.getInt("idVenta");
                datos[1]=rs.getInt("idEmpleado");
                datos[2]=rs.getDate("fecha");
                datos[3]=rs.getInt("idCliente");
                modelo.addRow(datos);
            }
            table.setModel(modelo);
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
    }
    public void buscarPorIdEmpleado(int idEmpleado, DefaultTableModel model, JTable table){
        String sql = "SELECT * FROM VENTA WHERE idEmpleado=?";
        
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idEmpleado);
        try(ResultSet rs = pstmt.executeQuery()){
            Object[] ventas = new Object[4];
            model =  (DefaultTableModel) table.getModel();
            while(rs.next()){
                ventas[0] = rs.getInt("idVenta");
                ventas[1] = rs.getInt("idEmpleado");
                ventas[2] = rs.getDate("fecha");
                ventas[3] = rs.getInt("idCliente");
                model.addRow(ventas);
            }
            table.setModel(model);
        }
         }
        catch(SQLException e){
            System.out.println("No se pudo conectar con la base al cargar datos");
        }
        
    }
    public void buscarPorFecha(Date fecha, DefaultTableModel model, JTable table){
        String sql = "SELECT * FROM VENTA WHERE Date(fecha)=?";
        model =  (DefaultTableModel) table.getModel();
        model.addColumn("ID Venta");
        model.addColumn("ID Empleado");
        model.addColumn("Fecha");
        model.addColumn("ID Cliente");
        try(Connection conn = connection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setDate(1, (java.sql.Date) fecha);
            Object[] datos = new Object[4];
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){ 
                    datos[0]=rs.getInt("idVenta");
                    datos[1]=rs.getInt("idEmpleado");
                    datos[2]=rs.getDate("fecha");
                    datos[3]=rs.getInt("idCliente");
                    
                    model.addRow(datos);
                }
                table.setModel(model);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void buscarPorIdCliente(int idCliente, DefaultTableModel model, JTable table){
        String sql = "SELECT * FROM VENTA WHERE idCliente=?";
        model =  (DefaultTableModel) table.getModel();
        model.addColumn("ID Venta");
        model.addColumn("ID Empleado");
        model.addColumn("Fecha");
        model.addColumn("ID Cliente");
        try(Connection conn = connection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idCliente);
            Object[] datos = new Object[4];
            try(ResultSet rs = pstmt.executeQuery()){
                while(rs.next()){ 
                    datos[0]=rs.getInt("idVenta");
                    datos[1]=rs.getInt("idEmpleado");
                    datos[2]=rs.getDate("fecha");
                    datos[3]=rs.getInt("idCliente");
                    
                    model.addRow(datos);
                }
                table.setModel(model);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
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
    public void setIdVenta(int idCliente, int idVenta){
        String sql = "UPDATE VENTA SET idVenta=? WHERE idCliente=?";
        
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idCliente);
            pstmt.setInt(2, idVenta);
            
            pstmt.executeUpdate();
            System.out.println("Id De venta cambiado");
        }
        catch(SQLException e){
            System.out.println("Error al cambiar el id de venta" + e.getMessage());
        }
    }
    public int getIdVenta(int idCliente) {
    String sql = "SELECT idVenta FROM VENTA WHERE idCliente=?";
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
    public int getIdEmpleado(int idCliente){
        String sql = "SELECT idEmpleado FROM VENTA WHERE idCliente=?";
    int idEmpleado = -1; // Valor por defecto que indica no encontrado

    try (Connection conn = connection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, idCliente);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                idEmpleado = rs.getInt("idEmpleado");
                System.out.println("ID de Empleado en venta obtenido: " + idEmpleado);
                
            } else {
                System.out.println("No se encontró venta para el cliente: " + idCliente);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener ID de venta: ");
        e.printStackTrace();
    }
    return idEmpleado;
    }
    public int getIdCliente(int idVenta){
        String sql = "SELECT idCLiente WHERE idVenta=?";
        int idCliente = -1;
        try(Connection conn = connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idVenta);
            
        try (ResultSet rs = pstmt.executeQuery()){
            if(rs.next()){
                idCliente = rs.getInt("idCliente");
            }
            else{
                System.out.println("No se encontro el idCliente");
            }
        }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return idCliente ;
    }
    public Date getFecha(int idVenta){
        String sql = "SELECT fecha FROM VENTA WHERE idVenta=?";
        Date fecha = null;
        try(Connection conn= connection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,idVenta);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    fecha = rs.getDate("fecha");
                }
                else{
                    System.out.println("No se logro obtener la fecha");
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return fecha;
    }
    public void CargarDatos(JTable tabla, DefaultTableModel modelo){
        String sql = "SELECT * FROM VENTA";
        
        try(Connection conn = connection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)){
            Object[] ventas = new Object[4];
            modelo =  (DefaultTableModel) tabla.getModel();
            while(rs.next()){
                ventas[0] = rs.getInt("idVenta");
                ventas[1] = rs.getInt("idEmpleado");
                ventas[2] = rs.getDate("fecha");
                ventas[3] = rs.getInt("idCliente");
                modelo.addRow(ventas);
            }
            tabla.setModel(modelo);
        }
        catch(SQLException e){
            System.out.println("No se pudo conectar con la base al cargar datos");
        }
    }
    public ArrayList<Ventas> todasLasVentas(){
        ArrayList<Ventas> ventas = new ArrayList<>();
        String sql = "SELECT idVenta, idEmpleado, fecha, idCliente FROM VENTA";
        
        try(Connection conn = connection.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)){
            
            while (rs.next()) {
                Ventas venta = new Ventas();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setIdEmpleado(rs.getInt("idEmpleado"));
                venta.setFecha(rs.getTimestamp("fecha"));
                venta.setIdCliente(rs.getInt("idCliente"));
                
                ventas.add(venta);
            }
        }
        catch(SQLException e){
            
        }
        return ventas;
    }

}
