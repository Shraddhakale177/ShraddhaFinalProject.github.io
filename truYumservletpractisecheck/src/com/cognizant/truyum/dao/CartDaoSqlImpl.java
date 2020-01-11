package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_MENUITEM_TO_CART = "insert into cart(ct_us_id,ct_me_id) values(?,?)";
	public static final String GET_MENUITEM_CART = "select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery  from menu_item inner join cart as Cart on ct_me_id=me_id where ct_us_id=?";
	public static final String GET_TOTAL = "select sum(me_price) as Total_price from menu_item inner join cart as Total on ct_me_id = me_id where ct_us_id=?";
	public static final String REMOVE_MENUITEM = "delete from cart where ct_us_id=? and ct_me_id=? limit 1";

	@Override
	public void addCartItem(long userId, long menuItemId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Data Not Inserted");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {

		Connection connection = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemCartList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		PreparedStatement statement_total = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		Cart cart = new Cart();

		try {

			preparedStatement = connection.prepareStatement(GET_MENUITEM_CART);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				menuItemCartList.add(menuItem);
			}
			cart.setMenuItemList(menuItemCartList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement_total = connection.prepareStatement(GET_TOTAL);
			statement_total.setLong(1, userId);
			resultSetTotal = statement_total.executeQuery();
			if (menuItemCartList.size() == 0) {
				throw new CartEmptyException();
			}
			while (resultSetTotal.next()) {
				cart.setTotal(resultSetTotal.getDouble("Total_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (statement_total != null) {
					statement_total.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
				if (resultSetTotal != null) {
					resultSetTotal.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(REMOVE_MENUITEM);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("row affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("DATA NOT DELETED");
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
			}
		}
	}
}
