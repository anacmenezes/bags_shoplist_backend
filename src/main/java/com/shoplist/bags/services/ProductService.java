package com.shoplist.bags.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.shoplist.bags.Dto.ProductDTO;
import com.shoplist.bags.domain.Product;
import com.shoplist.bags.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public Product find(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Product insert(Product obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Product update(Product obj) {
		Product newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw (null);
		}
	}
	
	public List<Product> findAll() {
		return repo.findAll();
	}	
	
	public Product fromDTO(ProductDTO objDto) {
		return new Product(objDto.getId(), objDto.getName(), null);
	}

	private void updateData(Product newObj, Product obj) {
		newObj.setName(obj.getName());
	}
}