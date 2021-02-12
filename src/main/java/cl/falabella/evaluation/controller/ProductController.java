package cl.falabella.evaluation.controller;

import cl.falabella.evaluation.model.Product;
import cl.falabella.evaluation.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    IProductService service;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object addProducto(@RequestBody Product product) {
        return service.add(product);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public Object getProducto(@PathVariable Integer id) {
        return service.get(id);
    }

}
