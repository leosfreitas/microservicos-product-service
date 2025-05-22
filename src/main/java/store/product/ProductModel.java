// ProductModel.java
package store.product;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "product")
@Setter @Accessors(fluent = true)
@NoArgsConstructor
public class ProductModel {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "tx_name")
    private String name;

    @Column(name = "db_price")
    private Double price;

    @Column(name = "tx_unit")
    private String unit;

    @Column(name = "dt_creation")
    private Date creation;

    public ProductModel(Product p) {
        this.id = p.id();
        this.name = p.name();
        this.price = p.price();
        this.unit = p.unit();
        this.creation = p.creation();
    }

    public Product to() {
        return Product.builder()
            .id(this.id)
            .name(this.name)
            .price(this.price)
            .unit(this.unit)
            .creation(this.creation)
            .build();
    }

}