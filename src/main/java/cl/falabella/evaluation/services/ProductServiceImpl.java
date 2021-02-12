package cl.falabella.evaluation.services;


import cl.falabella.evaluation.dto.ProductHelper;
import cl.falabella.evaluation.entity.ProductEntity;
import cl.falabella.evaluation.model.Product;
import cl.falabella.evaluation.respository.IProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepo repo;

    @Override
    public Object add(Product product) {
        ProductEntity entity = ProductHelper.toEntity(product);
        return repo.save(entity);
    }

    @Override
    public Object get(Integer sku) {
        return repo.findProduct(sku);
    }
}
