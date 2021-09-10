package hello.SE;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
    public static Connection getConnection(){
        try{
            String dbURL = "jdbc:mysql://localhost:3307/member?serverTimezone=Asia/Seoul&useSSL=false";
            String dbID = "root";
            String dbPW = "@dla123456";
            //Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(dbURL, dbID, dbPW);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
