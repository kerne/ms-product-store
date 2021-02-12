package cl.falabella.evaluation.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductUtil {

    /**
     * @return
     */
    public static Product getProduct() {
        return Product.builder().sku(123123).brand("NEW BALANCE").size("37").price(49999d).name("500 Zapatilla Urbana Mujer").principalUrl("•\thttps://falabella.scene7.com/is/image/Falabella/8406270_1").build();
    }

    /**
     * @return
     * @throws JsonProcessingException
     */
    public static String getProductJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(getProduct());
    }

}
