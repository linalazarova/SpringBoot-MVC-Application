package com.productmanagement.web.controllers;

import com.productmanagement.web.models.Product;
import com.productmanagement.web.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String listProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @GetMapping("products/search")
    public String searchProduct(@RequestParam(value = "query") String query, Model model){
        List<Product> products = productService.searchProducts(query);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product/create")
    public String createProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create-product";
    }

    @PostMapping("/product/create")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("products/{productId}/edit")
    public String editProductForm(@PathVariable(name = "productId") Long id, Model model){
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @PostMapping("products/{productId}/edit")
    public String updateProduct(@PathVariable(name = "productId") Long id, @ModelAttribute("product") Product product){
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/";
    }

    @GetMapping("products/{productId}/delete")
    public String deleteProduct(@PathVariable(name = "productId") Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
