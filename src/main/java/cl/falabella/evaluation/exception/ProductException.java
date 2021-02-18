package cl.falabella.evaluation.exception;

import org.springframework.http.HttpStatus;

public class ProductException extends RuntimeException {
    /**
     *
     */
    private HttpStatus status;
    private String message;
    private Integer code;

    public ProductException() {
    }

    public ProductException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
        this.code = status.value();
    }

    public ProductException(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
