package cl.falabella.evaluation.controller;

import cl.falabella.evaluation.model.Product;
import cl.falabella.evaluation.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    IProductService service;

    @PostMapping("/")
    public Object addProducto(@RequestBody Product product) {
        return service.add(product);
    }

    @GetMapping("/{id}")
    public Object getProducto(@PathVariable Integer id) {
        return service.get(id);
    }

}
