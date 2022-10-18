package com.shoplist.bags.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shoplist.bags.domain.Address;

@FeignClient(url= "https://byzipcode.com/" , name = "byzipcode")
public interface AddressService {

    @GetMapping("{zipcode}")
    Address findAddress(@PathVariable("zipcode") String zCode);
	
}