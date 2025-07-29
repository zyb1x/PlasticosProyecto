package Controllers;

import Modelo.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ControllersProveedor {
    private int id;
    private String nombre, rfc, telefono, direccion;

  //constructores
    public ControllersProveedor(){
    }

    public ControllersProveedor(int id, String nombre, String rfc, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.rfc = rfc;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
   //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
   // Metodo para crear proveedor   
    public void crearProveedor() {
    String sql = "INSERT INTO proveedor(nombre, rfc, telefono, direccion) VALUES (?, ?, ?, ?)";

    try (Connection conn = connection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, this.getNombre());
        pstmt.setString(2, this.getRfc());
        pstmt.setString(3, this.getTelefono());
        pstmt.setString(4, this.getDireccion());

        pstmt.executeUpdate();
        System.out.println("Proveedor registrado correctamente.");

    } catch (Exception e) {
        System.out.println("Error al insertar proveedor: " + e.getMessage());
    }
}
    
    public void buscarProveedor(){

    }
    public void actualizarProveedor(){

    }
    public void eliminarProveedor(){
        
    }
}
