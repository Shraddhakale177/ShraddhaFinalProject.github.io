package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoSqlImplTest {

	public static void testaddFavoriteMovies() {

		Long userId = 2l;
		Long moviesId = 1l;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.addFavoriteMovies(userId, moviesId);
		System.out.println("Data added to cart successfully");
		System.out.println("\n");
	}

	public static void testgetAllFavoriteMovies() throws FavoritesEmptyException {

		long userId = 2l;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites obj = favoritesDaoSqlImpl.getAllFavoriteMovies(userId);
		System.out.println(obj.getMovieList());
		System.out.println("Total Favorites :" + obj.getTotalFavorites());
		System.out.println("\n");
	}

	public static void testremoveFavoriteMovies() {

		Long userID = 1l;
		Long moviesId = 4l;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.removeFavoriteMovies(userID, moviesId);
		System.out.println("Item Removed Successfully");
	}

	public static void main(String[] args) throws FavoritesEmptyException {

		testaddFavoriteMovies();
		testgetAllFavoriteMovies();
		testremoveFavoriteMovies();
	}
}
