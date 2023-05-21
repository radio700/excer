package z4_7_2_custom;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Main {
    public static void main(String[] args) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "JAWSBAR", "1234");
        CallableStatement stmtProcedureCall = con.prepareCall("CALL DISCOUNT_PRICE(?,?,?)");
        stmtProcedureCall.setInt(1, 1);
        stmtProcedureCall.setInt(2, 10);
        stmtProcedureCall.registerOutParameter(3, Types.INTEGER);

        boolean result = stmtProcedureCall.execute();
        System.out.println("result : "+result);
        if(!result){
            System.out.println("update count: " + stmtProcedureCall.getUpdateCount());
        }
        System.out.println("param "+stmtProcedureCall.getInt(3));

    }
}
