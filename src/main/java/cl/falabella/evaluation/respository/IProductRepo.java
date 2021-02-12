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

    @Query(value = "select u, e from ProductEntity u inner join ImageEntity  e " +
            "ON u.id=e.id where u.sku=?1")
    Optional<ProductEntity> findProduct(Integer sku);

}
