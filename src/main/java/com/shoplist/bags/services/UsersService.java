package com.shoplist.bags.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.shoplist.bags.Dto.UsersDTO;
import com.shoplist.bags.domain.Users;
import com.shoplist.bags.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repo;

	public Users find(Integer id) {
		Optional<Users> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Users insert(Users obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Users update(Users obj) {
		Users newObj = find(obj.getId());
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
	
	public List<Users> findAll() {
		return repo.findAll();
	}	
	
	public Users fromDTO(UsersDTO objDto) {
		return new Users(objDto.getId(), objDto.getName(), null, null, null);
	}

	private void updateData(Users newObj, Users obj) {
		newObj.setName(obj.getName());
	}
}