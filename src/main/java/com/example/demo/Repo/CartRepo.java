package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Cart;
@EnableJpaRepositories
@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
	public List<Cart> findAllByUserId(int id);
//	@Query("delete cart from Cart cart where cart.cart_id=?1")
//	public void deleteBycartId(long id);

}
