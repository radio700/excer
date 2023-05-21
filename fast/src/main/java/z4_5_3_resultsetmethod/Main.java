package z4_5_3_resultsetmethod;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException{

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "JAWSBAR", "1234");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT A.*  FROM PRODUCT A WHERE A.ID BETWEEN 1 AND 5");

        if(rs.next()){
            //cursur 1
            printRs(rs);
        }
        
        if(rs.last()){
            //cursur 5
            printRs(rs);
        }

        if(!rs.next()){
            try{
                printRs(rs);
            } catch(SQLException e){
                System.out.println(e.getErrorCode()+", "+e.getMessage());
            }
        }

        rs.last();
        if(rs.previous()) printRs(rs);
        

        if(rs.absolute(2)) printRs(rs);
        

        if(rs.relative(2)) printRs(rs);

        if(rs.relative(-2)) printRs(rs);

        if(rs.first()) printRs(rs);

        if(!rs.previous()){
            try{
                printRs(rs);
            } catch(SQLException e){
                System.out.println(e.getErrorCode()+", "+e.getMessage());
            }
        }

        



        con.close();
    }

    public static void printRs(ResultSet rs) throws SQLException{
        System.out.println(rs.getInt(1) + " "
        + rs.getString(2) + " "
        + rs.getDate(3) + " "
        + rs.getString(4) + " " 
        + rs.getInt(5));
    }
}
