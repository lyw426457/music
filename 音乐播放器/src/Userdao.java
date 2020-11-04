import java.sql.*;
import java.sql.Connection;

public class Userdao {
    public User Findpwd(String username) throws SQLException, ClassNotFoundException {
        User user = null;
        Connection connection = Dbutil.getConnection();
        String sql = "select * from userinfo where username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            user = new User();
            user.setUsername(resultSet.getString(2));
            user.setUserpwd(resultSet.getString(3));
            user.setNickname(resultSet.getString(4));
            user.setBirth(resultSet.getDate(5));
            user.setSignature(resultSet.getString(6));
        }
        Dbutil.Closeall(resultSet,statement,connection);
        return user;
    }
    public void zhuce(String id,String username ,String userpwd, String nickname, String birth, String signature) throws SQLException, ClassNotFoundException {
        Connection connection = Dbutil.getConnection();
        String sql = "insert into userinfo (id,username,userpwd,nickname,birth,signature) values(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,id);
        statement.setString(2,username);
        statement.setString(3,userpwd);
        statement.setString(4,nickname);
        statement.setString(5,birth);
        statement.setString(6,signature);
        Dbutil.Closeall(null,statement,connection);
    }
    public void update(String username,String userpwd,String nickname,String birth,String signature) throws SQLException, ClassNotFoundException {
        Connection connection = Dbutil.getConnection();
        String sql = "update userinfo set username = ?,userpwd = ?,nickname = ?,birth = ?,signature = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,userpwd);
        statement.setString(3,nickname);
        statement.setString(4,birth);
        statement.setString(5,signature);
        Dbutil.Closeall(null,statement,connection);
    }
}
