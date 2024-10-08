package demo_validate.demo_jpa_mysql.controller;

import demo_validate.demo_jpa_mysql.model.entity.Product;
import demo_validate.demo_jpa_mysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String home(Model model){
        List<Product> products = productService.getProducts();
        model.addAttribute("list",products);
        return "product/listProduct";
    }

    @GetMapping("/initInsertProduct")
    public String initInsertProduct(Model model){
        Product p = new Product();
        model.addAttribute("p",p);
        return "product/insertProduct";
    }

    @PostMapping("/insertProduct")
    public String insertProduct(@ModelAttribute Product p){
        productService.insertProduct(p);
        return "redirect:/products";
    }
}
