package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {

		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListAdmin();
		System.out.println("\n");
		System.out.println("Admin Details\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("####.00");
		System.out.format("%15s%25s%15s%15s%15s%15s%15s\n", "ID", "NAME", "PRICE", "ACTIVE", "DATEOFLAUNCH", "CATEGORY",
				"FREEDELIVERY");
		for (MenuItem menuItem : menuItemList) {
			String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			String price = df.format(menuItem.getPrice());
			System.out.format("%15d%25s%15s%15s%15s%15s%15s\n", menuItem.getId(), menuItem.getName(), price,
					menuItem.getActive(), date, menuItem.getCategory(), menuItem.getFreeDelivery());
		}
	}

	public static void testGetMenuItemListCustomer() {

		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListCustomer();
		System.out.println("\n");
		System.out.println("customer Details\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("####.00");
		System.out.format("%15s%25s%15s%15s%15s%15s%15s\n", "ID", "NAME", "PRICE", "ACTIVE", "DATEOFLAUNCH", "CATEGORY",
				"FREEDELIVERY");
		for (MenuItem menuItem : menuItemList) {
			String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			String price = df.format(menuItem.getPrice());
			System.out.format("%15d%25s%15s%15s%15s%15s%15s\n", menuItem.getId(), menuItem.getName(), price,
					menuItem.getActive(), date, menuItem.getCategory(), menuItem.getFreeDelivery());
		}
	}

	public static void testmodifyMenuItem() {

		MenuItem menuItem = new MenuItem(1l, "Kajukatli", 150f, true, new DateUtil().convertToDate("25/12/2019"),
				"Main Course", false);
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		menuItemDaoSqlImpl.modifyMenuItem(menuItem);
		System.out.println("\n");
		System.out.println("modified Details\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("####.00");
		System.out.format("%15s%25s%15s%15s%15s%15s%15s\n", "ID", "NAME", "PRICE", "ACTIVE", "DATEOFLAUNCH", "CATEGORY",
				"FREEDELIVERY");
		System.out.format("%15d%25s%15s%15s%15s%15s%15s\n", menuItem.getId(), menuItem.getName(), df.format(menuItem.getPrice()),
				menuItem.getActive(), sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch())), menuItem.getCategory(), menuItem.getFreeDelivery());

	}

	public static void testgetMenuItem() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("####.00");
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		long menuItemId = 4;
		MenuItem menuItem = menuItemDaoSqlImpl.getMenuItem(menuItemId);
		System.out.println("\n");
		System.out.println("Get Details\n");
		System.out.format("%15s%25s%15s%15s%15s%15s%15s\n", "ID", "NAME", "PRICE", "ACTIVE", "DATEOFLAUNCH", "CATEGORY",
				"FREEDELIVERY");
		System.out.format("%15d%25s%15s%15s%15s%15s%15s\n", menuItem.getId(), menuItem.getName(), df.format(menuItem.getPrice()),
				menuItem.getActive(), sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch())), menuItem.getCategory(), menuItem.getFreeDelivery());

	}

	public static void main(String[] args) {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testmodifyMenuItem();
		testgetMenuItem();
	}
}
