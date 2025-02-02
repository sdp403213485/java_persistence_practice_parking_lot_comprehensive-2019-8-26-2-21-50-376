package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.EmployeeMapper;
import tws.service.EmployeeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
    @Autowired
    private EmployeeService employeeService;
//    private EmployeeMapper employeeMapper;
    
    
    
//    @GetMapping("/")
//    public ResponseEntity<List<Employee>> getAll() {
//        return ResponseEntity.ok(employeeService.findAllEmployees());
//    }
    
    
//     http://localhost:8080/parkingboys?page=2&pageSize=25
    @GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getAllPage(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "pageSize", required = false) Integer pageSize){
		if(page==null || pageSize==null) {
			return employeeService.findAllEmployees();
		}else {
			return employeeService.getAllEmployeePage(page, pageSize);
		}
    	
	}
    

//    @GetMapping("/{id}/parkinglots")
//    public ResponseEntity<List<ParkingLot>> getOneParkingBoyAllParkingLots(@PathVariable int id) {
//        return ResponseEntity.ok(employeeMapper.selectOneParkingBoyAllParkingLots(id));
//    }
//
//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//        employeeMapper.insert(employee);
//        return ResponseEntity.created(URI.create("/employees/" + employee.getId())).body(employee);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
//        employeeMapper.update(id,employee);
//        return ResponseEntity.ok(employee);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteEmployee(@PathVariable int id) {
//        employeeMapper.deleteOne(id);
//    }
}
