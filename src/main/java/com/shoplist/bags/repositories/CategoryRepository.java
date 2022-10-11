package com.shoplist.bags.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoplist.bags.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
