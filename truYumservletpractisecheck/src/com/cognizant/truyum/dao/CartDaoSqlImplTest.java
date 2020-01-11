package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {

	public static void testaddCartItem() {

		Long userId = 2l;
		Long menuItemId = 1l;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.addCartItem(userId, menuItemId);
		System.out.println("Data added to cart successfully");
		System.out.println("\n");
	}

	public static void testgetAllCartItems() throws CartEmptyException {
		long userId = 2l;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		Cart obj = cartDaoSqlImpl.getAllCartItems(userId);
		System.out.println(obj.getMenuItemList());
		System.out.println("Total price :" + obj.getTotal());
		System.out.println("\n");

	}

	public static void testremoveCartItem() {
		Long userId = 2l;
		Long menuItemId = 5l;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.removeCartItem(userId, menuItemId);
		System.out.println("Item Removed Successfully");
	}

	public static void main(String[] args) throws CartEmptyException {
		testaddCartItem();
		testgetAllCartItems();
		testremoveCartItem();
	}
}
