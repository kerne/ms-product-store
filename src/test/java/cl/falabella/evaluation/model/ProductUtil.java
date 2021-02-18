package cl.falabella.evaluation.model;

import cl.falabella.evaluation.entity.ProductEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class ProductUtil {

    /**
     * @return
     */
    public static Product getProduct() {
        return Product.builder().sku(1000000).brand("NEW BALANCE").size("37").price(49999d).name("500 Zapatilla Urbana Mujer").principalUrl("https://falabella.scene7.com/is/image/Falabella/8406270_1").build();
    }

    /**
     * @return
     * @throws JsonProcessingException
     */
    public static String getProductJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(getProduct());
    }

    /**
     * @return
     */
    public static Optional<ProductEntity> getProductEntity() {
        return Optional.of(ProductEntity.
                builder()
                .sku(123123)
                .brand("NEW BALANCE")
                .size("37")
                .price(49999d)
                .name("500 Zapatilla Urbana Mujer")
                .principalUrl("thttps://falabella.scene7.com/is/image/Falabella/8406270_1")
                .build())
                ;
    }

}
