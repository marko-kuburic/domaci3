package vezbe.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vezbe.demo.dto.DepartmentDto;
import vezbe.demo.model.Department;
import vezbe.demo.model.Employee;
import vezbe.demo.service.DepartmentService;

@RestController
public class DepartmentRestController {

    @Autowired
    DepartmentService departmentService;
    
    @GetMapping("/api/department")
    public ResponseEntity<DepartmentDto> getDepartment(HttpSession session){
        Department department;
        DepartmentDto dto;

        Employee loggedEmployee = (Employee) session.getAttribute("employee");
        if(loggedEmployee == null) {
            System.out.println("Nema sesije");
            department = null;
        } else {
            System.out.println(loggedEmployee);
            department = departmentService.getDepartment(loggedEmployee.getId());
        }
        
        dto = new DepartmentDto(department);
        return ResponseEntity.ok(dto);
    }

}
