package z4_5_4_mapper;

import java.time.LocalDateTime;

public class Product {
    int id;
    String name;
    LocalDateTime updated_at;
    String contents;
    int price;
    
    public Product(int id, String name, LocalDateTime updated_at, String contents, int price) {
        this.id = id;
        this.name = name;
        this.updated_at = updated_at;
        this.contents = contents;
        this.price = price;
    }

    

    public void setPrice(int price) {
        this.price = price;
    }



    public int getPrice() {
        return price;
    }



    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", updated_at=" + updated_at + ", contents=" + contents
                + ", price=" + price + "]";
    }



    
}
