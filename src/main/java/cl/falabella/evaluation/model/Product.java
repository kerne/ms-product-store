package cl.falabella.evaluation.model;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
public class Product {


    @Max(value = 99999999)
    @Min(value = 1000000)
    private Integer sku;

    @Size(min = 3, max = 50)
    private String name;

    private String brand;

    @NotBlank
    private String size;

    @Max(value = 1)
    @Min(value = 99999999)
    private Double price;

    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
    private String principalUrl;

    private List<Images> otherUrls;

}
