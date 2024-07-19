package org.conexion;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/db_factura?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() {
        if (pool == null) {
            pool=new BasicDataSource();
            pool.setUrl(URL);
            pool.setUsername(USERNAME);
            pool.setPassword(PASSWORD);
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMinIdle(8);
            pool.setMaxTotal(8);
        }
        return pool;
    }
    public static Connection getConnection() throws SQLException{
        return   getInstance().getConnection();
    }
}
