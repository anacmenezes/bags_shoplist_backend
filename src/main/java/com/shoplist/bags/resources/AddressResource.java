package com.shoplist.bags.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoplist.bags.domain.Address;
import com.shoplist.bags.resources.exception.ResourceNotFound;
import com.shoplist.bags.services.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {

	@Autowired(required=false)
	private AddressService service;
	private String zCodeCorrected;

	@GetMapping("{zCode}")
	public ResponseEntity<Address> getzCode(@PathVariable String zCode) throws ResourceNotFound {

		if (zCode.length() == 8) {
			Address address = service.findAddress(zCode);

			if (address.getPlace() == null || address.getDistrict() == null) {
				zCodeCorrected = zCode.substring(0, 7) + "0";
				address = service.findAddress(zCodeCorrected);
			}
			if (address.getPlace() == null || address.getDistrict() == null) {
				zCodeCorrected = zCode.substring(0, 6) + "00";
				address = service.findAddress(zCodeCorrected);
			}
			if (address.getPlace() == null || address.getDistrict() == null) {
				zCodeCorrected = zCode.substring(0, 5) + "000";
				address = service.findAddress(zCodeCorrected);
			}
			if (address.getPlace() == null || address.getDistrict() == null) {
				throw new ResourceNotFound("Invalid Zip Code", HttpStatus.NOT_FOUND);
			}

			return ResponseEntity.ok(address);
		} else {
            throw new ResourceNotFound("Invalid Zip Code", HttpStatus.BAD_REQUEST);
        }
	}
}