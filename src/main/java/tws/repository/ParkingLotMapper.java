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

    @Select("select * from parkinglot;")
    List<ParkingLot> selectAll();

    @Insert("insert into parkinglot values (#{parkinglot.id}, #{parkinglot.capacity}, #{parkinglot.availablePositionCount}, #{parkinglot.parkingBoysId});")
    void insert(@Param("parkinglot") ParkingLot parkinglot);

    @Update("update parkinglot set parkinglot.capacity=#{employee.capacity}, parkinglot.availablePositionCount=#{employee.availablePositionCount} where parkinglot.parkingBoyId = #{parkingBoyId};")
    void update(@Param("parkinglot") int parkingBoyId, @Param("employee") ParkingLot parkinglot);

    @Delete("delete from parkinglot where parkinglot.parkingboy_id #{parkingBoysId};")
    void deleteOne(@Param("parkingBoysId") int parkingBoysId);
}