package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {


        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "JAWSBAR", "1234");
            con.getMetaData();
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " "
                                + rs.getString(2) + " "
                                + rs.getDate(3) + " "
                                + rs.getString(4) + " #### " 
                                + rs.getInt(5));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}