package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entity.Cart;
import com.example.demo.Repo.CartRepo;
import com.example.demo.service.IcartService;

public class CartServiceImpl implements IcartService {
	@Autowired
	CartRepo crepo;

	@Override
	public List<Cart> getAllByUserCart(int id) {
		// TODO Auto-generated method stub
		return crepo.findAllByUserId(id) ;
	}

	@Override
	public void deleteCart(int id) {
		// TODO Auto-generated method stub
		crepo.deleteById(id);
	}

	@Override
	public Cart addToCart(Cart cart) {
		// TODO Auto-generated method stub
		return crepo.save(cart);
	}

}
