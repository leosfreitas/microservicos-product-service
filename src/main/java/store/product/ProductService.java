// ProductService.java
package store.product;

import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(String id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Product not found"))
            .to();
    }

    public Product create(Product product) {
        if (product.price() == null || product.price() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid price!");
        }
        if (product.name() == null || product.name().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product name is required!");
        }
        if (product.unit() == null || product.unit().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unit is required!");
        }
        
        product.creation(new Date());
        return productRepository.save(new ProductModel(product)).to();
    }

    public void deleteById(String id) {
        if (!productRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
        productRepository.deleteById(id);
    }

    public List<Product> findAll() {
        return StreamSupport
            .stream(productRepository.findAll().spliterator(), false)
            .map(ProductModel::to)
            .toList();
    }
    
}