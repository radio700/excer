package excute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {


        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "JAWSBAR", "1234");
            Statement stmt = con.createStatement();
            int rst = stmt.executeUpdate("UPDATE PRODUCT SET PRICE = PRICE +110000 WHERE ID = '1'");
            System.out.println(">>>>>>>>>> ["+rst+"]");

            int rst1 = stmt.executeUpdate("UPDATE PRODUCT SET PRICE = PRICE +110000 WHERE NAME LIKE '%shoes%'");
            System.out.println(">>>>>>>>>> ["+rst1+"]");

            int rst2 = stmt.executeUpdate("UPDATE PRODUCT SET PRICE = PRICE +110000 WHERE id = '9999999'");
            System.out.println(">>>>>>>>>> ["+rst2+"]");

            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}