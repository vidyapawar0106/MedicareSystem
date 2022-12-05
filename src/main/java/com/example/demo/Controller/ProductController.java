package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;
import com.example.demo.helper.Helper;

import java.util.Map;
import java.util.Optional;

import javax.persistence.Access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.Entity.Product;
import com.example.demo.Repo.ProductRepo;

@RestController
@RequestMapping("/product")

@CrossOrigin("http://localhost:4200/")

public class ProductController {
	@Autowired
	ProductRepo prepo;
	
    
	@PostMapping("/insert")
	public Product insertProduct(@RequestBody Product p)
	{
		return prepo.save(p);
	}
	@PostMapping("/insertall")
	public List<Product> insertallProduct(@RequestBody List<Product> list)
	{
		return prepo.saveAll(list);
	}
	@GetMapping("/getall")
	public List<Product> getallProduct()
	{
		return prepo.findAll();
	}
	@GetMapping("/getbyid/{id}")
	public Product getproductbyid(@PathVariable int id)
	{
		return prepo.findById(id).get();
	}
	@DeleteMapping("/delete/{id}")
	public void  deletebyid(@PathVariable int id)
	{
		 prepo.deleteById(id);
	}
	@PutMapping("/update")
	public Product updateproduct(@RequestBody Product p)
	{
		
	     return prepo.save(p);
	}
	@PostMapping("/add-bulk-products")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if(Helper.checkExelFormat(file))
		{
			List<Product> product;
			try {
				product = Helper.convertExcelToListOfProducts(file.getInputStream());
				this.prepo.saveAll(product);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			return ResponseEntity.ok(Map.of("message","file is uploaded"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file only");
		
	}
	
		
	
		
	

}

