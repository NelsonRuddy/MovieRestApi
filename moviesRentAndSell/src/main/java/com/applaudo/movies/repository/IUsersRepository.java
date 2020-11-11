package com.applaudo.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.applaudo.movies.model.Users;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Long> {

	    public Users findByUsername(String username);
	    	
}
