package br.com.ecommerce.brandless.modules.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.brandless.modules.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
