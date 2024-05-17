package sky.pro.Employee.Exception;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException() {
        super("Превышен лимит сотрудников в фирме");
    }
}
