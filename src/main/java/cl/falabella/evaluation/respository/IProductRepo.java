package cl.falabella.evaluation.respository;

import cl.falabella.evaluation.entity.ProductEntity;
import cl.falabella.evaluation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 */
@Repository
public interface IProductRepo extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "select u from ProductEntity u where u.sku=?1")
    Optional<Product> findProduct(Integer sku);

}
