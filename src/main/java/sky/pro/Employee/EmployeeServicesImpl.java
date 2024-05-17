package sky.pro.Employee;

import org.springframework.stereotype.Service;
import sky.pro.Employee.Exception.EmployeeAlreadyAddedException;
import sky.pro.Employee.Exception.EmployeeNotFoundException;
import sky.pro.Employee.Exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeService {
    private static final int MAX_COUNT_PERSON = 30;

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addPerson(String firstName, String lastName) {
        var employee = new Employee(firstName, lastName);
        if (employees.size() > MAX_COUNT_PERSON) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee deletePerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Удаляемый сотрудник не найден");
    }

    @Override
    public Employee findPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Cотрудник не найден");
    }

    @Override
    public Collection<Employee> findAll() {
        // для того, чтобы не отдавать ссылку на внутреннюю коллекцию наружу, делаем новую
        return new ArrayList<>(employees);
    }
}
