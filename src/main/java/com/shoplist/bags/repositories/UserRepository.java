package com.shoplist.bags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoplist.bags.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
