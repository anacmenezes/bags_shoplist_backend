package com.shoplist.bags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoplist.bags.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}