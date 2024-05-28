package com.example.pastelaria.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.pastelaria.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer>{
	@Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END from users where cod_user = : cod_user", nativeQuery=true)
	public boolean exist(int cod_user);
	
	@Query(value="select * from users where username = :username and senha= :senha", nativeQuery = true)
	public Users login(String username, String senha);
}
