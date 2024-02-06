package br.com.ecommerce.brandless.modules.product.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.brandless.modules.product.model.Product;
import br.com.ecommerce.brandless.modules.product.model.ProductDTORequest;
import br.com.ecommerce.brandless.modules.product.repository.ProductRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductRepository repository;
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Product> getAll() {
        return repository.findAll().stream().map(p -> new Product(p.getId(), p.getName(), p.getPrice())).toList();
    }

    @PostMapping()
    public Product create(@RequestBody @Valid ProductDTORequest payload) {
        Product product = new Product();

        product.setName(payload.name());
        product.setPrice(payload.price());

        return repository.save(product);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handler(MethodArgumentNotValidException exception) {
        Map<String, String> body = new HashMap<>();

        exception.getFieldErrors().forEach(e -> body.put(e.getField(), e.getDefaultMessage()));

        return ResponseEntity.badRequest().body(body);
    }
}
