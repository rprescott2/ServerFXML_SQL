package sample;
import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DataBaseSQL extends Config {
    Connection dbCon;
    public Connection conn()throws ClassNotFoundException, SQLException{
        String conne = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbCon = DriverManager.getConnection(conne, dbUser, dbPass);
        return dbCon;
    }
    public void AddPass(String pass){
        String insert = "INSERT INTO" + Const.USER_TABLE + "(" + Const.USER_ID+")"+"VALUES(?)";
        try {
            PreparedStatement prst = conn().prepareStatement(insert);
        prst.setString(1, pass);
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
