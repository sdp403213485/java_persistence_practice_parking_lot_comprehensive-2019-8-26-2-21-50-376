package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.ParkingBoy;





@Mapper
public interface ParkingBoyMapper {
	@Select("select * from parkingBoy")
	List<ParkingBoy> selectAll();
	
	@Insert("insert into parkingBoy values (#{parkingBoy.id})")
	void insertEmployee(@Param("parkingBoy") ParkingBoy parkingBoy);
}
