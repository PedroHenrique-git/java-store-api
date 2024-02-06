package br.com.ecommerce.brandless.modules.product.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDTORequest(
        @NotBlank(message = "The product name must not be blank") @NotNull(message = "The product name must not be null") @Size(min = 1, max = 1000, message = "The product name must between 1 and 100 characters") String name,
        @NotNull(message = "The product price must not be null") int price) {

}
