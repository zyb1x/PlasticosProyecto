/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionMP {
private static final String URL = "jdbc:mysql://localhost:3306/plasticos";
private static final String USER = "root";
private static final String PASSWORD = "";

public static Connection getConnection() {
try {
Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
System.out.println("Conexion exitosa");
return conn;
} catch (SQLException e) {
System.out.println("No se pudo conectar");
e.printStackTrace();
return null;
}
}
}

