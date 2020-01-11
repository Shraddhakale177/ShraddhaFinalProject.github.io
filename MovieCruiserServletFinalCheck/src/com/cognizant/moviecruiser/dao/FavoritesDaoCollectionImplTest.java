package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDao favoriteDao = new FavoritesDaoCollectionImpl();
		favoriteDao.addFavoriteMovies(1, 2L);
		favoriteDao.addFavoriteMovies(1, 5L);
		favoriteDao.addFavoriteMovies(2, 1L);
		favoriteDao.addFavoriteMovies(2, 3L);

		Favorites favorites = favoriteDao.getAllFavoriteMovies(1);
		List<Movies> movieListItem = favorites.getMovieList();
		System.out.println("User Added Favorites for CheckOut");
		for (Movies movies : movieListItem) {
			System.out.println(movies);
		}
		System.out.println("Favorites are : "+movieListItem.size());
	}

	public static void testRemoveFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		try {
		    favoritesDao.removeFavoriteMovies(1, 5L);
		    Favorites favorites = favoritesDao.getAllFavoriteMovies(1);
			List<Movies> movieListItem = favorites.getMovieList();
			System.out.println("User Added Favorites for CheckOut");
			for (Movies movies : movieListItem) {
				System.out.println(movies);
			}
			System.out.println("Favorites are : "+movieListItem.size());
		} catch(FavoritesEmptyException e) {
			System.out.println(e);
		}
	}
	
    public static void testGetAddFavoriteMovies() {

	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoriteMovies();
		testRemoveFavoriteMovies();
	}
}
