package Controllers;

import Modelo.ClaseEmpleado;
import Modelo.connection;
import Vista.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControllersEmpleado {
    connection cn = new connection();
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    
    public boolean guardarEmpleado(ClaseEmpleado clem) {
    Connection conn = null;
    PreparedStatement ps = null;
    connection cn = new connection(); 

    String sql = "INSERT INTO empleado (turno, password, correo, puesto, nombre) VALUES (?, ?, ?, ?, ?)";

    try {
        conn = cn.getConnection(); 
        ps = conn.prepareStatement(sql);

        ps.setString(1, clem.getTurno());
        ps.setString(2, clem.getContrasena());
        ps.setString(3, clem.getCorreo());
        ps.setString(4, clem.getPuesto());
        ps.setString(5, clem.getNombre());

        ps.execute();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al guardar: " + e.toString());
        return false;
    } finally {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar conexión: " + e.toString());
        }
    }
}
    
    
    /*    public void crearEmpleado(String turno, String password, String correo, String puesto, String nombre){
    String sql = "INSERT INTO EMPLEADO ( turno, password, correo, puesto, nombre)"+
    "VALUES (?,?,?,?,?,?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)){
    
    pstmt.setString(2, turno);
    pstmt.setString(3, password);
    pstmt.setString(4, correo);
    pstmt.setString(5, puesto);
    pstmt.setString(6, nombre);
    } catch (Exception e) {
    System.out.println("Error al conectar con la base de datos " + e.getMessage());
    }
    }*/
    
    public String getPuesto(int id){
        String sql = "SELECT puesto FROM EMPLEADO WHERE idEmpleado=?";
        String puesto = null;
        try(Connection conn = connection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,id);
            
            try(ResultSet re = pstmt.executeQuery()){
                if (rs.next()) {
                puesto = rs.getString("puesto");
                System.out.println("Puesto obtenido " + puesto);
                
            } else {
                System.out.println("No se encontró el empleado: " + id);
            }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return puesto;
    }
    public boolean actualizarEmpleado(ClaseEmpleado clem){
        String sql = "UPDATE empleado SET turno=?, password=?, correo=?, puesto=?, nombre=? WHERE idEmpleado=?";//consulta sql para actualizar segun el id
        try {
            ps = conn.prepareStatement(sql);//se prepara la consulta con la conexion a la base
            //se establecen los valores que iran en los signos de pregunta
            ps.setString(1, clem.getTurno());
            ps.setString(2, clem.getContrasena());
            ps.setString(3, clem.getCorreo());
            ps.setString(4, clem.getPuesto());
            ps.setString(5, clem.getNombre());
            ps.setInt(6, clem.getIdEmpleado());
            
            ps.execute();//se ejecuta la consulta
            return true;//si todo salio bien devuelve true
        } catch (SQLException e) {
            System.out.println(e.toString());//si sale un erro se muestr en consola y devuelve false
            return false;
        }finally{//en cualquier caso se intenta cerrar la conexion
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean borrarEmpleado(int idEmpleado){
        String sql = "DELETE FROM empleado WHERE idEmpleado = ?";//consulta sql
        try {
            ps = conn.prepareStatement(sql);//se prepara consulta
            ps.setInt(1, idEmpleado);//se pasa id como parametro
            ps.execute();//se ejecuta
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public int getIdEmpleado(String correo){
        String sql = "SELECT idEmpleado FROM EMPLEADO WHERE correo=?";

         int idEmpleado = -1; // Valor por defecto que indica no encontrado

    try (Connection conn = connection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, correo);
        
        try (ResultSet res = pstmt.executeQuery()) {
            if (res.next()) {
                idEmpleado = res.getInt("idEmpleado");
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
    
    /*public void CargarDatos(JTable tabla, DefaultTableModel modelo){
    String sql = "SELECT * FROM EMPLEADO";
    
    try(Connection conn = connection.getConnection();
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql)){
    Object[] ventas = new Object[5];
    modelo =  (DefaultTableModel) tabla.getModel();
    while(rs.next()){
    ventas[0] = rs.getInt("idEmpleado");
    ventas[1] = rs.getString("turno");
    ventas[2] = rs.getDate("password");
    ventas[3] = rs.getString("correo");
    ventas[4]= rs.getString("puesto");
    modelo.addRow(ventas);
    }
    tabla.setModel(modelo);
    }
    catch(SQLException e){
    System.out.println("No se pudo conectar con la base al cargar datos");
    }
    }*/
    
    public List listarEmpleado(){
        List<ClaseEmpleado> ListaAdm = new ArrayList();//se crea una lista para guardar los empleados
        String sql = "SELECT * FROM empleado";//consulta
        try {
            conn = cn.getConnection();//se establece la conexxion y se prepara consulta
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();//se ejecuta la consulta y se guarda el resultado
            //si hay registros se recorre uno por uno
            while(rs.next()){
                ClaseEmpleado clem = new ClaseEmpleado();//se crea un objeto empleado y se asignan los valores
                clem.setIdEmpleado(rs.getInt("idEmpleado"));
                clem.setTurno(rs.getString("turno"));
                clem.setContrasena(rs.getString("password"));
                clem.setCorreo(rs.getString("correo"));
                clem.setPuesto(rs.getString("puesto"));
                clem.setNombre(rs.getString("nombre"));
                
                ListaAdm.add(clem);
                
                
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaAdm;
    }
}


