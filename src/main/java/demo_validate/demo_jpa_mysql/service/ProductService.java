package demo_validate.demo_jpa_mysql.service;

import demo_validate.demo_jpa_mysql.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product insertProduct(Product pro);
    Product updateProduct(Integer proId, Product pro);
    boolean deleteProduct(Integer proId);
    Product getProductById(Integer proId);
    List<Product> getProductsByName(String proName);
}
