package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class EmployeeService {
	 @Autowired 
	 private EmployeeMapper employeeMapper;
	 
	 public List<Employee> findAllEmployees(){
		 List<Employee> employees =employeeMapper.selectAll();
		 for(Employee employee:employees) {
			 employee.setName("中原银行"+employee.getName());
//			 employeeMapper.update(employee.getId(), employee);
		 }
		 return employees;
	 }
	 
	 
	 
	 public List<Employee> getAllEmployeePage(Integer page, Integer pageSize){
		  int start = 0;
		  if(page != null && pageSize !=null) {
		   start = (page - 1) * pageSize;
		  }
	
		  List<Employee> resultBoys = employeeMapper.getAllParkingBoyByPageAndPageSize(start, pageSize);
		  return resultBoys;
		 }
	 
	 
	 
	 
	 
	 
	 
}
