package cl.falabella.evaluation.services;

import cl.falabella.evaluation.model.Product;

/**
 *
 */
public interface IProductService {
    Object add(Product product);

    Object get(Integer sku);


}
