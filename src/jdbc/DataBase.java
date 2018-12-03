package jdbc;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/url?useUnicode=true&characterEncoding=utf8&useSSL=false", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from url");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id")+" "+rs.getString("url"));
            }
        } finally {
            if(con!=null){
                con.close();
            }
        }
    }
}
