package com.example.task4.controller;

import com.example.task4.model.Product;
import com.example.task4.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAll(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products-list";
    }

    @GetMapping("/products/add")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/products/add")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
