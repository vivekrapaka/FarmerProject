package com.farmersell.FarmerSell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmersell.FarmerSell.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserName(String userName);
}
