package z4_5_46_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import z4_5_4_mapper.ResultSetMapper;

public class Main {//파라미터 전달 후 쿼리 실행
    public static void main(String[] args) throws SQLException{
        
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "JAWSBAR", "1234");
        PreparedStatement psUpdate = con.prepareStatement("UPDATE PRODUCT SET PRICE = PRICE + ? WHERE ID = ?");
        psUpdate.setInt(1, 10000);
        psUpdate.setInt(2, 1);

        int updateResult = psUpdate.executeUpdate();
        System.out.println("updateResult : "+updateResult);

        PreparedStatement select = con.prepareStatement("SELECT A.ID, A.NAME ,A.UPDATED_AT ,A.CONTENTS ,A.PRICE FROM PRODUCT A WHERE A.ID BETWEEN ? AND ?");
        select.setInt(1, 1);
        select.setInt(2, 5);

        ResultSet rs = select.executeQuery();
        while(rs.next()){
            ResultSetMapper.printRs(rs);
        }

        System.out.println("=============================================");
        select.setInt(1, 6);
        select.setInt(2, 10);
        ResultSet rs2 = select.executeQuery();


        while(rs2.next()){
            ResultSetMapper.printRs(rs2);
        }



        con.close();
    }
}

