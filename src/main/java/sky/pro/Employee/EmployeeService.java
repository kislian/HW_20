package sky.pro.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addPerson(String firstName, String lastName);
    Employee deletePerson(String firstName, String lastName);
    Employee findPerson (String firstName, String lastName);
    Collection<Employee> findAll();
}
