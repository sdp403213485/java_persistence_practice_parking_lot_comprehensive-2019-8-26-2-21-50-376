package tws.repository;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.ParkingBoy;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingBoyMapperTest {
	
    @Autowired
    private ParkingBoyMapper parkingBoyMapper;

    JdbcTemplate jdbcTemplate;
   
    @Autowired
    public void setDataSource(DataSource dataSource) {
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
    	
    }
    
    @Before
    public void clearDB() {
    	
    	JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboys");
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingboys");
    }

    @Test
    public void shouldFetchAllParkingBoys() {
        // given
        jdbcTemplate.execute("INSERT INTO parkingboys VALUES('parkingboy_4');");
        // when
        List<ParkingBoy> employees = parkingBoyMapper.selectAll();
        // then
        assertEquals(1, employees.size());
    }
    
    
    @Test
    public void shouldGetParkingBoyWhenCallInsertParkingBoy() {
        // given
    	parkingBoyMapper.insertEmployee(new ParkingBoy("parkingboy_4"));
        // when
        List<ParkingBoy> employees = parkingBoyMapper.selectAll();
        // then
        assertEquals(1, employees.get(0).getEmployeeID());
    }
    

  
}
