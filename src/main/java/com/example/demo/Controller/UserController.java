package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {
	@Autowired
	UserRepo urepo;
	@PostMapping("/adduser")
	public User adduser(@RequestBody User u)
	{
		return urepo.save(u);
		
	}
	@GetMapping("/getuser/{id}")
	public User usergetbyid(@PathVariable int id)
	{
		return urepo.findById(id).get();
	}
	@GetMapping("/getalluser")
	public List<User> getalluser()
	{
		return urepo.findAll();
	}
	@GetMapping("/getbyemail/{email}")
	public User getuserbyemail(@PathVariable String email)
	{
		return urepo.findByUseremail(email);
	}
	@DeleteMapping("/delete/{id}")
	public void deletebyid(@PathVariable int id)
	{
		urepo.deleteById(id);
	}
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User u)
	{
		return urepo.save(u);
	}

}
