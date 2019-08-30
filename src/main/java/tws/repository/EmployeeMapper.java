package tws.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import tws.entity.Employee;
import tws.entity.ParkingLot;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee;")
    List<Employee> selectAll();

    @Select("select * from employee where parkingBoyId = #{id};")
    List<ParkingLot> selectOneParkingBoyAllParkingLots(@Param("id") int id);

//    @Select("seltect * from employee OFFSET 5 ROWS FETCH NEXT 10 ROWS ONLY")
//    List<Employee> getAllPage(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "pageSize", required = false) Integer pageSize);
    
    @Select("select * from employee where 1=1 order by id offset #{start} rows fetch next #{pageSize} rows only ")
    List<Employee> getAllParkingBoyByPageAndPageSize(@Param("start") int start, @Param("pageSize") int pageSize);
    
    @Insert("insert into employee values (#{employee.id}, #{employee.name}, #{employee.age});")
   void insert(@Param("employee") Employee employee);

    @Update("update employee set employee.name=#{employee.name}, employee.age=#{employee.age} where employee.id = #{id};")
   void update(@Param("employee") int id, @Param("employee") Employee employee);

    @Delete("delete from employee where employee.id = #{id};")
    void deleteOne(@Param("id") int id);

}
