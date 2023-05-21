package z4_5_41mapper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import z4_5_4_mapper.Product;
import z4_5_4_mapper.ResultSetMapper;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "JAWSBAR", "1234");
            DatabaseMetaData databaseMetaData = con.getMetaData();
            System.out.println(databaseMetaData.getDriverName()+", "+databaseMetaData.getDriverVersion());

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT");

            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product =ResultSetMapper.create(rs);
                products.add(product);
            }

            products.stream().forEach(it -> it.setPrice(it.getPrice() -1000));

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}