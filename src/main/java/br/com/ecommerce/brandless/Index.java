package br.com.ecommerce.brandless;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Index {
    @GetMapping("/")
    public ResponseEntity<Map<String, String>> index() {
        return ResponseEntity.ok().body(Map.of("message", "it works 👌"));
    }

    @GetMapping("/*")
    public ResponseEntity<Map<String, String>> notFound() {
        return ResponseEntity.ok().body(Map.of("message", "route not found 🥲"));
    }
}
