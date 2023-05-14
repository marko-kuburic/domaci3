package vezbe.demo.dto;

import vezbe.demo.model.Company;
import vezbe.demo.model.Department;

public class DepartmentDto {

    private Long id;
    private String name;
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentDto(Department department){
        this.id = department.getId();
        this.name = department.getName();
        this.company = department.getCompany();
    }
}
