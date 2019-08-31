package tws.repository;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingBoyControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
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
}
