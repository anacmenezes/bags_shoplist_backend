package com.shoplist.bags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoplist.bags.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
