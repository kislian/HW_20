package sky.pro.Employee.Exception;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
        super(" В коллекции сотрудник существует");
    }
}
