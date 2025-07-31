package Controllers;

import Modelo.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllersProductos {
    private int codigo, existencia;
    private String nombre, tipo, categoria;
    private double venta, costo_articulo, porcentaje_ganancia;

    public ControllersProductos(){
      
    }
    public ControllersProductos(int codigo, int existencia, String nombre, String tipo, String categoria, double venta, double costo_articulo, double porcentaje_ganancia) {
        this.codigo = codigo;
        this.existencia = existencia;
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
        this.venta = venta;
        this.costo_articulo = costo_articulo;
        this.porcentaje_ganancia = porcentaje_ganancia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }

    public double getCosto_articulo() {
        return costo_articulo;
    }

    public void setCosto_articulo(double costo_articulo) {
        this.costo_articulo = costo_articulo;
    }

    public double getPorcentaje_ganancia() {
        return porcentaje_ganancia;
    }

    public void setPorcentaje_ganancia(double porcentaje_ganancia) {
        this.porcentaje_ganancia = porcentaje_ganancia;
    }
    
 
    /*public void registrarProducto(int idProductos, int idCategoria, String nombre, double precio, int stock, String tamannio){
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
    }*/
   
    // Método para insertar un producto
    public boolean insertarProducto() {
        String sql = "INSERT INTO productos VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, this.codigo);
            ps.setString(2, this.nombre);
            ps.setString(3, this.tipo);
            ps.setString(4, this.categoria);
            ps.setInt(5, this.existencia);
            ps.setDouble(6, this.venta);
            ps.setDouble(7, this.costo_articulo);
            ps.setDouble(8, this.porcentaje_ganancia);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }


    public void buscarProducto(){
      
    }
    public void desactivarProducto(){

    } 
    public void actualizarProducto(){
        
    }
}
