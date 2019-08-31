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
import tws.entity.ParkingLot;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingLotMapperTest {
	
    @Autowired
    private ParkingLotMapper parkingLotMapper;

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
    public void shouldFetchAllParkingLots() {
        // given
        jdbcTemplate.execute("INSERT INTO parkingLots values ('lot_1','100','50','parkingboy_1');");
        // when
        List<ParkingLot> parkingLotsList = parkingLotMapper.selectAll();
        // then
        assertEquals(1, parkingLotsList.size());
    }
    
    
    @Test
    public void shouldGetParkingLotWhenCallInsertParkingLot() {
        // given
    	parkingLotMapper.insert(new ParkingLot("lot_1",100,50,"parkingboy_1"));
        // when
        List<ParkingLot> parkingLotsList = parkingLotMapper.selectAll();
        // then
        assertEquals("lot_1", parkingLotsList.get(0).getParkingLotID());
        assertEquals(100, parkingLotsList.get(0).getCapacity());
        assertEquals(50, parkingLotsList.get(0).getAvailablePositionCount());
        assertEquals("parkingboy_1", parkingLotsList.get(0).getEmployeeID());
        
    }
    

  
}

