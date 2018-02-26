package dao;

import com.sun.istack.internal.Nullable;

import java.sql.*;
import java.util.Properties;

public abstract class DAO {
    protected String driver = null;
    protected String url = null;
    protected Properties properties = null;

    public DAO(String driver) {
        this.driver = driver;
    }

    protected void registerDriverManager() {
        try {
            Class.forName(driver).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public abstract void setURL(String host, String database, int port);

    public abstract Connection getConnection();

    public abstract void closeConnection();

    public void connect(String login, String password) {
        registerDriverManager();
        properties = new Properties();
        properties.setProperty("password", password);
        properties.setProperty("user", login);
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "utf8");
    }

    public void execute(final String sql) {
        try {
            Statement statement = getConnection().createStatement();
            statement.execute(sql);
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executePreparedStatement(final String sql, @Nullable String... params) {
        ResultSet result = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setString(i + 1, params[i]);
                }
            }
            result = statement.executeQuery();
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
