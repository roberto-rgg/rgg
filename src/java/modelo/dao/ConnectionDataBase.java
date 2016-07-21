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
    private static final String USUARIO = "root";
    private static final String CLAVE = "rockmetal";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection connection;

    public ConnectionDataBase() {

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(SERVIDOR, USUARIO, CLAVE);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion Fallida : " + e.getMessage());
        }

    }

    public static Connection getConnection() {
        return connection;
    }

}
