package batch;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException{

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "JAWSBAR", "1234");
        Statement stmt = con.createStatement();
        stmt.addBatch("SELECT * FROM PRODUCT WHERE ID BETWEEN 1 AND 5");
        stmt.addBatch("UPDATE PRODUCT SET PRICE = PRICE +110000 WHERE ID = '1'");
        try{
            stmt.executeBatch();
        } catch(BatchUpdateException batchUpdateException){
            System.out.println(batchUpdateException.getMessage());
        }
        


        stmt.addBatch("UPDATE PRODUCT SET PRICE = PRICE +1 WHERE ID = '1'");
        stmt.addBatch("UPDATE PRODUCT SET PRICE = PRICE +2 WHERE ID = '2'");
        stmt.addBatch("UPDATE PRODUCT SET PRICE = PRICE +35 WHERE ID BETWEEN 3 AND 5");
        int[] results = stmt.executeBatch();

        for(int result: results){
            if(result >= 0){
                System.out.println("result of updated : "+result);
            }
        }

        con.close();;

    }
}