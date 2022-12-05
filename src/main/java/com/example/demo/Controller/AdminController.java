package com.example.demo.Controller;

import java.util.List;

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

import com.example.demo.Entity.Admin;
import com.example.demo.Repo.AdminRepo;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200/")
public class AdminController {
	@Autowired
	AdminRepo arepo;
	@PostMapping("/insertadmin")
	public Admin saveadmin(@RequestBody Admin a)
	{
		return arepo.save(a);
	}
	@GetMapping("/getadmin")
	public List<Admin> getalladmin()
	{
		return arepo.findAll();
	}
	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody Admin a)
	{
		return arepo.save(a);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteAdmin(@PathVariable int id)
	{
		arepo.deleteById(id);
	}
	@GetMapping("getadminbyid/{id}")
	public Admin getAdminById(@PathVariable int id)
	{
		return arepo.findById(id).get();
	}

}
