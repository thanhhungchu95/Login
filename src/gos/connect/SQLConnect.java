package gos.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnect {
    private final String HOST = "localhost";
    private final String DATABASE = "member";
    private final String USER = "hungct";
    private final String PASSWORD = "23840561";
    
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    
    public SQLConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.err.println("Can't find and load driver!!!");
            System.exit(1);
        }
    }
    
    public void connectToDatabase() {
        String urlConnect = "jdbc:mysql://" + HOST + "/" + DATABASE + "?user=" + USER + "&password=" + PASSWORD;
        try {
            con = DriverManager.getConnection(urlConnect);
        } catch (SQLException ex) {
            displaySQLError(ex);
        }
    }
    
    public void executeQueryString(String query) {
        try {
            if (con.isClosed()) connectToDatabase();
            stm = con.createStatement();
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            displaySQLError(ex);
        }
    }
    
    public ResultSet getResultSet() {
        return rs;
    }
    
    public void displaySQLError(SQLException ex) {
        System.err.println("SQL Error: " + ex.getMessage());
        System.err.println("State    : " + ex.getSQLState());
        System.err.println("Vendor:    " + ex.getErrorCode());
    }
}
