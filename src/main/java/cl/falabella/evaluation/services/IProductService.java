package cl.falabella.evaluation.services;

import cl.falabella.evaluation.entity.ProductEntity;
import cl.falabella.evaluation.model.Product;

/**
 *
 */
public interface IProductService {
    Product add(Product product);

    Product get(Integer sku);


}
