package statement_excute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "JAWSBAR", "1234");
        Statement stmt = con.createStatement();

        boolean selectquery = stmt.execute("SELECT A.ID, A.NAME ,A.UPDATED_AT ,A.CONTENTS ,A.PRICE  FROM PRODUCT A WHERE A.ID BETWEEN 1 AND 5");

        if(selectquery){
            ResultSet resultSet = stmt.getResultSet();
            while(resultSet.next()){
                printRs(resultSet);
            }
        }

        boolean updateResult = stmt.execute("UPDATE PRODUCT SET PRICE = PRICE +110000 WHERE ID = '1'");
        if(!updateResult){
            System.out.println("result of update : "+stmt.getUpdateCount());
        }

    }

    private static void printRs(ResultSet rs) throws SQLException{
        System.out.println(rs.getInt(1) + " "
        + rs.getString(2) + " "
        + rs.getDate(3) + " "
        + rs.getString(4) + " #### " 
        + rs.getInt(5));
    }
}