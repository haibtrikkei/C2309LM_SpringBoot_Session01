package demo_validate.demo_jpa_mysql.service.impl;

import demo_validate.demo_jpa_mysql.model.entity.Product;
import demo_validate.demo_jpa_mysql.repository.ProductRepository;
import demo_validate.demo_jpa_mysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product pro) {
        return productRepository.save(pro);
    }

    @Override
    public Product updateProduct(Integer proId, Product pro) {
        productRepository.findById(proId).orElseThrow(() -> new NoSuchElementException("Khong ton tai product co id: " + proId));
       // pro.setProId(proId);
        return productRepository.save(pro);
    }

    @Override
    public boolean deleteProduct(Integer proId) {
        try {
            productRepository.deleteById(proId);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public Product getProductById(Integer proId) {
        return productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Khong ton tai product co ma: "+proId));
    }

    @Override
    public List<Product> getProductsByName(String proName) {
        return productRepository.findProductsByProNameContainsIgnoreCase(proName);
    }
}
