package com.example.demo.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	@Query("select user from User user where user.email=?1")
	public User findByUseremail(String email);

}
