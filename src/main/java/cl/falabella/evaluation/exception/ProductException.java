package cl.falabella.evaluation.exception;

import org.springframework.http.HttpStatus;

public class ProductException extends RuntimeException {
    /**
     *
     */
    private HttpStatus status;
    private String message;

    public ProductException() {
    }

    public ProductException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public ProductException(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
