package DatabaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {

    private final String serverName = "DESKTOP-QU2TFD4";
    private final String dbName = "PersonnelDB";
    private final String userID = "sa";
    private final String password = "123456789";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + dbName;
        return DriverManager.getConnection(url, userID, password);
    }
}
