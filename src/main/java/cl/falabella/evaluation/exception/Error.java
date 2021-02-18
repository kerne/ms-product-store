package cl.falabella.evaluation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
public class Error {

    private HttpStatus errorCode;
    private String message;

    public Error(HttpStatus errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }


}
