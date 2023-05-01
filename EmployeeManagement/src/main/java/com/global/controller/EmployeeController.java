package com.global.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.dto.EmployeeDto;
import com.global.exception.IdNotFoundException;
import com.global.modal.Department;
import com.global.modal.Employee;
import com.global.modal.Project;
import com.global.repository.EmployeeRepo;
import com.global.repository.ProjectRepo;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepo;
	
	
	@Autowired
	ProjectRepo projectRepo;
	
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	@GetMapping("/findAllEmployee")
	public List<Employee> findAllEmp()
	{
		return employeeRepo.findAll();
	}
	
	@GetMapping("/findEmployeeName/{ename}")
	public Employee findByEname(String ename)
	{
		Employee find = employeeRepo.findByEname(ename);
		if(find!=null)
		{
		return find;
		}
		else
		{
			throw new IdNotFoundException("employee name not found ");
		}
	}
	
	@PutMapping("/updateEmployee/{eid}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int eid)
	{
		Optional<Employee> find = employeeRepo.findById(eid);
		if(find.isPresent())
		{
			Employee fromRepo = find.get();
			fromRepo.setEname(employee.getEname());
			fromRepo.setBirthdate(employee.getBirthdate());
			fromRepo.setCellphone(employee.getCellphone());
			fromRepo.setDepartment(employee.getDepartment());
			fromRepo.setProject(employee.getProject());
			return employeeRepo.save(fromRepo);
		}
		else
		{
			throw new IdNotFoundException("employee id not found for updation");
		}
	}
	
	
	@GetMapping("/findDepartment/Employee/{ename}")
	public Department findDepartmentByEmployee(@PathVariable String ename)
	{
		Employee find = employeeRepo.findByEname(ename);
		if(find!=null)
		{
			Department department = find.getDepartment();
			return department;
		}
		else
		{
			throw new IdNotFoundException("employee name not found");
		}
	}
	
	
	@DeleteMapping("/deleteEmployee/{eid}")
	public String deleteEmployee(int eid)
	{
		if(!employeeRepo.existsById(eid))
		{
			throw new IdNotFoundException("employee Id not found for deletion");
		}
		employeeRepo.deleteById(eid);
		return "employee deleted successfully";
	}
	
	
	@GetMapping("/getAll/OnlyEmployee")
	public List<EmployeeDto> findAllEmployee()
	{
		List<Employee> find = employeeRepo.findAll();
		List<EmployeeDto> list = find.stream().map(employee -> toDto(employee)).collect(Collectors.toList());
		return list;
	}
	
	@GetMapping("/employee/department/{dname}")
	List<Employee> findAllEmployeeInDep(@PathVariable String dname)
	{
		return employeeRepo.findEmployeesInITDepartment(dname);
	}
	
	
	public EmployeeDto toDto(Employee employee)
	{
		EmployeeDto dto = new EmployeeDto();
		dto.setEid(employee.getEid());
		dto.setEname(employee.getEname());
		dto.setBirthdate(employee.getBirthdate());
		dto.setCellphone(employee.getCellphone());
		return dto;
	}
	
}
