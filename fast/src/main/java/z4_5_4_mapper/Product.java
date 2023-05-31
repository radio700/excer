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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", updated_at=" + updated_at + ", contents=" + contents
                + ", price=" + price + "]";
    }



    
}
