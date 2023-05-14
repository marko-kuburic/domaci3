package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vezbe.demo.model.Department;
import vezbe.demo.model.Employee;
import vezbe.demo.repository.DepartmentRepository;
import vezbe.demo.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getDepartment (Long id){
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        if (foundEmployee.isPresent())
            return departmentRepository.getById(id);
        return null;
    }
    
}
