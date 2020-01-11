package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImpl implements MoviesDao {

	public static final String GET_MOVIELIST_ADMIN = "select mo_id,mo_title, mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,"
			+ "mo_has_teaser from  moviecruiser.movie";
	public static final String GET_MOVIELIST_CUSTOMER = "select mo_id,mo_title, mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,"
			+ "mo_has_teaser from moviecruiser.movie where mo_active='1' and mo_date_of_launch > (select CURDATE())";
	public static final String EDIT_MOVIE = "update moviecruiser.movie set mo_title=?, mo_boxoffice=?, mo_active=?, mo_date_of_launch=?, "
			+ "mo_genre=?, mo_has_teaser=? where mo_id=?";
	public static final String GET_MOVIE = "select mo_id,mo_title, mo_boxoffice,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser "
			+ "from moviecruiser.movie where mo_id=?";

	@Override
	public List<Movies> getMovieListAdmin() {
		
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> movieList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIELIST_ADMIN);
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
				movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		
		Connection connection = ConnectionHandler.getConnection();
		ArrayList<Movies> movieList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIELIST_CUSTOMER);
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
				movieList.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	@Override
	public void modifyMovieList(Movies movies) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(EDIT_MOVIE);
			preparedStatement.setString(1, movies.getTitle());
			preparedStatement.setLong(2, movies.getGross());
			preparedStatement.setBoolean(3, movies.getActive());
			preparedStatement.setDate(4, DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			preparedStatement.setString(5, movies.getGenre());
			preparedStatement.setBoolean(6, movies.getTeaser());
			preparedStatement.setLong(7, movies.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Movies getMovieList(Long moviesId) {

		Connection connection = ConnectionHandler.getConnection();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Movies movie = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIE);
			preparedStatement.setLong(1, moviesId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movie = new Movies();
				movie.setId(resultSet.getLong("mo_id"));
				movie.setTitle(resultSet.getString("mo_title"));
				movie.setGross(resultSet.getLong("mo_boxoffice"));
				movie.setActive(resultSet.getString("mo_active").equals("1"));
				movie.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movie.setGenre(resultSet.getString("mo_genre"));
				movie.setTeaser(resultSet.getString("mo_has_teaser").equals("1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movie;
	}
}
