package lt.bit.products.ui.service;

import lt.bit.products.ui.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private UUID id;

    public ProductService(List<Product> products) {
       products.add(new Product("Product1", BigDecimal.valueOf(10.5), 5));
       products.add(new Product("Product2", BigDecimal.valueOf(12.35), 11));
       products.add(new Product("Product3", BigDecimal.valueOf(9.5), 20));
       products.add(new Product("Product4", BigDecimal.valueOf(59.78), 55));
       products.add(new Product("Product5", BigDecimal.valueOf(10.50), 5));
    }

    public List<Product> getProducts() {
        return products;
    }
    public void addProduct(Product newProduct){
        products.add(newProduct);
    }
    public void deleteProduct(){
        products.remove(findProduct(id));
    }
    public void updateProduct(Product product){
        Product existingProduct = findProduct(product.getId());

           if (existingProduct != null){
               existingProduct.setName(product.getName());
               existingProduct.setPrice(product.getPrice());
               existingProduct.setQuantity(product.getQuantity());

       }

    }

    public Product getProducts(UUID id) {
        return findProduct(id);
    }

    private Product findProduct (UUID id) {
        for (Product p: products){
            if (p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
}
