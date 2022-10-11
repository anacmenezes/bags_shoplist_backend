package com.shoplist.bags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoplist.bags.domain.Historic;

@Repository
public interface HistoricRepository extends JpaRepository<Historic, Integer> {

}
