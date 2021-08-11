package dio.experts.dioproductcatalog.controller;


import dio.experts.dioproductcatalog.model.Product;
import dio.experts.dioproductcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }




}
