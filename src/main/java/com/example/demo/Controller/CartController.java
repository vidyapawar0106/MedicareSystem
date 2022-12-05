package com.example.demo.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Repo.CartRepo;
import com.example.demo.Repo.ProductRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.service.IcartService;
import com.example.demo.serviceImpl.CartServiceImpl;

@RestController
@RequestMapping("/cart")
@CrossOrigin("http://localhost:4200/")

public class CartController {
	@Autowired
	CartRepo crepo;
	@Autowired
	UserRepo urepo;
	@Autowired
	ProductRepo prepo;
	
	
	@GetMapping("/add/{product_id}/{user_id}")
	public ResponseEntity<Cart> addtocart(@PathVariable int product_id,@PathVariable int user_id)
	{ 
		User user=urepo.findById(user_id).get();
		
		Product product=prepo.findById(product_id).get();
		Cart cart=new Cart(user,product);
		cart.setUnit(1);
		cart.setTotalPrice(cart.getUnit()*product.getPrize());
		Cart addtocart=crepo.save(cart);
		return new ResponseEntity<Cart>(addtocart,HttpStatus.CREATED);
		
		
		
	}
	@GetMapping("/getcart/{userid}")
	public List<Cart> getcartbyuser(@PathVariable int userid)
	{ 
		return crepo.findAllByUserId(userid);
		
	}
	@DeleteMapping("/delete/{cartId}")
public ResponseEntity<?> deletCart(@PathVariable int cartId) {

	crepo.deleteById(cartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("/updatecart/{cid}")
	public void  updateCart(@RequestBody Cart cart,@PathVariable int cid) {
		
		Cart updated=crepo.findById(cid).get();
		updated=cart;
		crepo.save(updated);
		
	}
	
	
}
