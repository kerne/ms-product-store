package cl.falabella.evaluation.controller;

import cl.falabella.evaluation.entity.ProductEntity;
import cl.falabella.evaluation.model.Product;
import cl.falabella.evaluation.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    IProductService service;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> addProducto(@Validated @RequestBody  Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(product));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> getProducto(@PathVariable Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

}
