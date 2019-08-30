package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.activation.DataSource;

import org.apache.ibatis.io.JBoss6VFS;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Employee;

@RunWith(SpringRunner.class)
@MybatisTest

public class EmployeeMapperTest {
	
	
	 @Autowired
		private EmployeeMapper employeeMapper;

	    JdbcTemplate jdbcTemplate;

	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	    	this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }
	    
	    @Before
	    public void clearDB() {
	     JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
	    }

	    @After
	    public void tearDown() throws Exception {
	        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboy");
	    }
	

	@Test
    public void shouldGetParkingBoyListWhenCallGetAllParkingBoyByPageAndPageSize() {
     // given
     for(int i = 0; i < 10; i++) {
      jdbcTemplate.execute("INSERT INTO parkingboy VALUES(" + (i+1) +",'parkingboy_" + i + "');");
     }
     
     // when
     List<Employee> employeeList = employeeMapper.getAllParkingBoyByPageAndPageSize(2, 6);
     
     // then
     for(int i = 0; i < 6; i++) {
      assertEquals(i+3, employeeList.get(i).getId());
      assertEquals("parkingboy_" + (i+2), employeeList.get(i).getName());
     }
    }

}
