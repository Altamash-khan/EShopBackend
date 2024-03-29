package com.niit.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.dao.CategoryDAO;
import com.niit.model.CartItem;

public class CartDAOTest 
{
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}
	
	//@Ignore
	@Test
	public void addCartItemTest()
	{
		CartItem cartItem=new CartItem();
		cartItem.setProducId(2);
		cartItem.setPrice(33000);
		cartItem.setProductName("oneplus");
		cartItem.setQuantity(3);
		cartItem.setUsername("queen");
		cartItem.setPstatus("NP");
		
		assertTrue("Problem in Adding the Cart Item:",cartDAO.addCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void retreiveCartItemTest()
	{
		List<CartItem> listCartItems=cartDAO.retrieveCartItems("Altamash");
		
		assertTrue("Problem in retreiving Cart Items:",listCartItems.size()>0);
		
		for(CartItem cartItem:listCartItems)
		{
			System.out.println(cartItem.getProductName()+":::"+":::"+cartItem.getQuantity()+":::"+cartItem.getPstatus());
		}
	}
}