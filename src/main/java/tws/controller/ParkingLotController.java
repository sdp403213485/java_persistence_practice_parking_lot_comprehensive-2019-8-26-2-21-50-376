package tws.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.ParkingLot;
import tws.repository.ParkingBoyMapper;
import tws.repository.ParkingLotMapper;



@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping
    public ResponseEntity<List<ParkingLot>> getAll() {
        return ResponseEntity.ok(parkingLotMapper.selectAll());
    }

    @PostMapping
    public void createParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotMapper.insert(parkingLot);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ParkingLot> updateEmployee(@PathVariable int id, @RequestBody ParkingLot parkingLot){
//        parkingLotMapper.update(id,parkingLot);
//        return ResponseEntity.ok(parkingLot);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteEmployee(@PathVariable int id) {
//        parkingLotMapper.deleteOne(id);
//    }

}
