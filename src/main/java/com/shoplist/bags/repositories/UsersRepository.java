package com.shoplist.bags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoplist.bags.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
