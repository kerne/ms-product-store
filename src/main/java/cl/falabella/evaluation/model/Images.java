package cl.falabella.evaluation.model;


import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class Images {

    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
    private String name;

}
