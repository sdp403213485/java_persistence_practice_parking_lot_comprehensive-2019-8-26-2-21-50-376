package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;
import tws.repository.ParkingLotMapper;

@RestController
@RequestMapping("/parkingboys")
public class ParkingBoyController {

	@Autowired
    private ParkingBoyMapper parkingBoyMapper;
	@Autowired
	private ParkingLotMapper ParkingLotMapper;
	
	 @GetMapping
	    public ResponseEntity<List<ParkingBoy>> getAll() {
	        return ResponseEntity.ok(parkingBoyMapper.selectAll());
	    }
	 
	@PostMapping
		public void addParkingBoy(@RequestBody ParkingBoy parkingBoy) {
			parkingBoyMapper.insertEmployee(parkingBoy);
		}
	
	 @GetMapping("/{employeeID}/parkinglots")
	    public ResponseEntity<List<String>> getParkingBoyParkingLots(@PathVariable("employeeID") String employeeID ) {
	        return ResponseEntity.ok(ParkingLotMapper.selectParkinglotIdbyOneParkingboy(employeeID));
	    }
	
}
