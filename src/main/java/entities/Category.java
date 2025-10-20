package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    // Getters et Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public List<Product> getProducts() { return products; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setProducts(List<Product> products) { this.products = products; }

}
