/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Roberto
 */
public abstract class ConnectionDataBase {

    private static final String SERVIDOR = "jdbc:mysql://localhost/ballard";
    private static final String USUARIO = "ballard";
    private static final String CLAVE = "ballardweb2016.,";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection connection;

    public ConnectionDataBase() {

    }

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(SERVIDOR, USUARIO, CLAVE);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion Fallida : " + e.getMessage());
        }
        return connection;
    }

}
