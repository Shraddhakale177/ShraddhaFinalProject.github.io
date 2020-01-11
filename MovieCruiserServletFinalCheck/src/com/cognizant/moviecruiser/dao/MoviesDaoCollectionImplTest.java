package com.cognizant.moviecruiser.dao;

import java.util.List;
import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMovieItemListAdmin() {
		System.out.println("Movie List for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieItemList = moviesDao.getMovieListAdmin();
		for (Movies movieItem : movieItemList) {
			System.out.println(movieItem);
		}
	}

	public static void testGetMovieItemListCustomer() {
		System.out.println("Movie List for Customer");
		MoviesDao movieItemDao = new MoviesDaoCollectionImpl();
		List<Movies> movieItemList = movieItemDao.getMovieListCustomer();
		for (Movies movieItem : movieItemList) {
			System.out.println(movieItem);
		}
	}

	public static void testModifyMovieItem() {
		Movies item = new Movies(5L, "Mission Impossible-Fallout", 5750760348L, true,
				new DateUtil().convertToDate("12/06/2018"), "Spy", true);
		MoviesDao movieItemDao = new MoviesDaoCollectionImpl();
		movieItemDao.modifyMovieList(item);
		System.out.println("*** Modified Movie Item List***");
		testGetMovieItemListAdmin();
		Movies modified_item = movieItemDao.getMovieList(item.getId());
		System.out.println("Modified Item Detail\n" + modified_item);
	}

	public static void main(String[] args) {
		testGetMovieItemListAdmin();
		testGetMovieItemListCustomer();
		testModifyMovieItem();
	}
}
