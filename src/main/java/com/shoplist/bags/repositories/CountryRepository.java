package com.shoplist.bags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoplist.bags.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
