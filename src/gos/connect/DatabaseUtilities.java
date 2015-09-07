package gos.connect;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DatabaseUtilities {
    public static boolean loginInforCheck(String username, String password) {
        String query = "SELECT username, password FROM memberInfor WHERE username = '" + username + "' AND password = '" + password + "'";
        boolean successFlag = false;
        SQLConnect sqlCon = new SQLConnect();
        sqlCon.connectToDatabase();
        sqlCon.executeQueryString(query);
        ResultSet rs = sqlCon.getResultSet();
        try {
            boolean notEmptyFlag = rs.next();
            if (notEmptyFlag) successFlag = true;
        } catch (SQLException ex) {
            sqlCon.displaySQLError(ex);
        }
        return successFlag;
    }
}
