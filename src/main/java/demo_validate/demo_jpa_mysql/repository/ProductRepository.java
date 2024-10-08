package demo_validate.demo_jpa_mysql.repository;

import demo_validate.demo_jpa_mysql.model.entity.Product;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findProductsByProNameContainsIgnoreCase(String proName);
}
