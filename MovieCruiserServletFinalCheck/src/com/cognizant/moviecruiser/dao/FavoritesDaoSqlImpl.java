package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public static final String ADD_MOVIE_TO_FAVORITES = "insert into favorites(fav_us_id,fav_mo_id)values(?,?)";
	public static final String GET_MOVIES_FAVORITES = "select mo_id, mo_title, mo_boxoffice, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie inner join favorites as Favorite on fav_mo_id=mo_id where fav_us_id=?";
	public static final String GET_TOTAL = "select count(fav_id) as No_Of_Favorites from favorites";
	public static final String REMOVE_MOVIE = "delete from favorites where fav_us_id=? and fav_mo_id=? limit 1";

	@Override
	public void addFavoriteMovies(long userId, long moviesId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_MOVIE_TO_FAVORITES);
			statement.setLong(1, userId);
			statement.setLong(2, moviesId);
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
	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> movieFavoriteList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		PreparedStatement statement_total = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		Favorites favorites = new Favorites();
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIES_FAVORITES);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Movies movie = new Movies();
				movie.setId(resultSet.getLong("mo_id"));
				movie.setTitle(resultSet.getString("mo_title"));
				movie.setGross(resultSet.getLong("mo_boxoffice"));
				movie.setActive(resultSet.getString("mo_active").equals("1"));
				movie.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie.setGenre(resultSet.getString("mo_genre"));
				movie.setTeaser(resultSet.getString("mo_has_teaser").equals("1"));
				movieFavoriteList.add(movie);
			}
			favorites.setMovieList(movieFavoriteList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement_total = connection.prepareStatement(GET_TOTAL);
			resultSetTotal = statement_total.executeQuery();
			if (movieFavoriteList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			while (resultSetTotal.next()) {
				favorites.setTotalFavorites(resultSetTotal.getInt("No_Of_Favorites"));
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
		return favorites;
	}

	@Override
	public void removeFavoriteMovies(long userID, long moviesId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(REMOVE_MOVIE);
			statement.setLong(1, userID);
			statement.setLong(2, moviesId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Data Not Deleted");
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
