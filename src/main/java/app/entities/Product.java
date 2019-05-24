package app.entities;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private String description;
    private String price;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
