package dao.impl;

import dao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOPostgres extends DAO {
    private Connection connection = null;
    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_DATABASE = "coursework";
    public static final String DEFAULT_LOGIN = "postgres";
    public static final String DEFAULT_PASSWORD = "123";
    public static final int DEFAULT_PORT = 5432;

    public DAOPostgres() {
        super("org.postgresql.Driver");
    }

    @Override
    public void setURL(String host, String database, int port) {
        if (database.length() > 0)
            this.url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        else
            this.url = "jdbc:postgresql://" + host + ":" + port;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void connect(String login, String password) {
        super.connect(login, password);
        try {
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            connection = null;
        }
    }
}