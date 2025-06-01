package store.product;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Builder
@Data 
@Accessors(fluent = true)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private Double price;
    private String unit;
    private Date creation;
    
}