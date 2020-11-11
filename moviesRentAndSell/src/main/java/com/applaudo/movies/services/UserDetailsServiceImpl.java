package com.applaudo.movies.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.applaudo.movies.model.Users;
import com.applaudo.movies.repository.IUsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	IUsersRepository UsersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user =UsersRepository.findByUsername(username);
		
		//List<GrantedAuthority>roles =new ArrayList<>();
	//	roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet= new User(user.getUsername(),user.getPassword(),user.getAuthorities());
		return userDet;
	}

	
}
