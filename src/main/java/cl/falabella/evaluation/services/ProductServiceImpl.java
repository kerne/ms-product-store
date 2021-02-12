package cl.falabella.evaluation.services;


import cl.falabella.evaluation.dto.ProductHelper;
import cl.falabella.evaluation.entity.ProductEntity;
import cl.falabella.evaluation.exception.ProductException;
import cl.falabella.evaluation.model.Product;
import cl.falabella.evaluation.respository.IProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepo repo;

    @Override
    public Object add(Product product) {
        Optional<Product> prd = Optional.of(product);

        if (!prd.isPresent()) {
            throw new ProductException(HttpStatus.NO_CONTENT, "Producto Vacio");
        }
        Optional<ProductEntity> productEntity = Optional.ofNullable(repo.findProduct(product.getSku()));
        if (productEntity.isPresent()) {
            throw new ProductException(HttpStatus.CONFLICT,"Producto Existente");
        }

        log.info("Product {}", product);

        ProductEntity entity = ProductHelper.toEntity(product);
        return repo.save(entity);
    }

    @Override
    public Object get(Integer sku) {
        Optional<ProductEntity> optEntity = Optional.ofNullable(repo.findProduct(sku));
        if (!optEntity.isPresent()) {
            throw new ProductException(HttpStatus.NO_CONTENT, "Producto No existe");
        }
        return optEntity.get();
    }
}
