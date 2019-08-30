package tws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.bytebuddy.implementation.attribute.AnnotationAppender.Target.OnType;
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
