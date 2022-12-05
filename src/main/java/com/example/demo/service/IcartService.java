package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cart;


public interface IcartService {
	
	
	public List<Cart> getAllByUserCart(int id);
	
	public void deleteCart(int id);
	


	public Cart addToCart(Cart cart);

}
