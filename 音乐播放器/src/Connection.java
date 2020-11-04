import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=UTC","root","426457");
        return conn;
    }
}
