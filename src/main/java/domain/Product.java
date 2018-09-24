package domain;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("product")
public class Product {
    @PrimaryKey

    private int id;

    private String title;

    private String description;

    private String image;

    private String price;

    private int stock;

    public Product(){}
    public Product(int id, String title, String description, String image , String price, int stock) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getId() {
        return id;
    }
}
