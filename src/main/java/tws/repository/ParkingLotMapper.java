package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.entity.ParkingLot;

@Mapper
public interface ParkingLotMapper {

    @Select("select * from parkinglots")
    List<ParkingLot> selectAll();

    @Insert("insert into parkinglots values (#{parkinglot.parkingLotID}, #{parkinglot.capacity}, #{parkinglot.availablePositionCount}, #{parkinglot.employeeID});")
    void insert(@Param("parkinglot") ParkingLot parkinglot);
    
    
    @Select("select parkingLotID from parkinglots where employeeID = #{employeeID}")
    List<String> selectParkinglotIdbyOneParkingboy(@Param("employeeID") String employeeID);


}