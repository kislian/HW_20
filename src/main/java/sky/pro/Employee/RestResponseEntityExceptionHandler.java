package sky.pro.Employee;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sky.pro.Employee.Exception.EmployeeAlreadyAddedException;
import sky.pro.Employee.Exception.EmployeeNotFoundException;
import sky.pro.Employee.Exception.EmployeeStorageIsFullException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value  = { EmployeeStorageIsFullException.class })
    protected ResponseEntity<Object> handleConflict(
            EmployeeStorageIsFullException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.INSUFFICIENT_STORAGE, request);
    }

    @ExceptionHandler(value  = { EmployeeNotFoundException.class })
    protected ResponseEntity<Object> handleConflict(
            EmployeeNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value  = { EmployeeAlreadyAddedException.class })
    protected ResponseEntity<Object> handleConflict(
            EmployeeAlreadyAddedException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.ALREADY_REPORTED, request);
    }
}
