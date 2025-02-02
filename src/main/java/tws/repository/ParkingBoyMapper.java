package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.ParkingBoy;





@Mapper
public interface ParkingBoyMapper {
	@Select("select * from parkingBoys")
	List<ParkingBoy> selectAll();
	
	@Insert("insert into parkingBoys values (#{parkingBoy.employeeID})")
	void insertEmployee(@Param("parkingBoy") ParkingBoy parkingBoy);
}
