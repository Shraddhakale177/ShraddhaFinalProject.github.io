package com.cognizant.moviecruiser.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {

	public static void testgetMovieListAdmin() {

		List<Movies> movieList = new MoviesDaoCollectionImpl().getMovieListAdmin();
		System.out.println("\n");
		System.out.println("Admin Details\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		System.out.format("%15s%25s%15s%15s%15s%15s%15s\n", "ID", "TITLE", "BOXOFFICE", "ACTIVE", "DATEOFLAUNCH",
				"GENRE", "HASTEASER");
		for (Movies movies : movieList) {
			String date = sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			String boxoffice = df.format(movies.getGross());
			System.out.format("%15d%25s%15s%15s%15s%15s%15s\n", movies.getId(), movies.getTitle(), boxoffice,
					movies.getActive(), date, movies.getGenre(), movies.getTeaser());
		}
	}

	public static void testgetMovieListCustomer() {

		List<Movies> movieList = new MoviesDaoCollectionImpl().getMovieListCustomer();
		System.out.println("\n");
		System.out.println("customer Details\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		System.out.format("%15s%25s%15s%15s%15s%15s%15s\n", "ID", "TITLE", "BOXOFFICE", "ACTIVE", "DATEOFLAUNCH",
				"GENRE", "HASTEASER");
		for (Movies movies : movieList) {
			String date = sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			String boxoffice = df.format(movies.getGross());
			System.out.format("%15d%25s%15s%15s%15s%15s%15s\n", movies.getId(), movies.getTitle(), boxoffice,
					movies.getActive(), date, movies.getGenre(), movies.getTeaser());
		}
	}

	public static void testmodifyMovieList() {

		Movies movies = new Movies(3l, "Lucy", 5678432567l, true, new DateUtil().convertToDate("26/11/2014"),
				"Science Fiction", false);
		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();
		moviesDaoSqlImpl.modifyMovieList(movies);
		System.out.println("\n");
		System.out.println("modified Details\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		System.out.format("%15s%25s%15s%15s%15s%15s%15s\n", "ID", "TITLE", "BOXOFFICE", "ACTIVE", "DATEOFLAUNCH",
				"GENRE", "HASTEASER");

		System.out.format("%15d%25s%15s%15s%15s%15s%15s\n", movies.getId(), movies.getTitle(),
				df.format(movies.getGross()), movies.getActive(),
				sdf.format(DateUtil.convertToSqlDate(movies.getDateOfLaunch())), movies.getGenre(), movies.getTeaser());
	}

	public static void testgetMovieList() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();
		long moviesId = 4;
		Movies movie = moviesDaoSqlImpl.getMovieList(moviesId);
		System.out.println("\n");
		System.out.println("Get Details\n");
		System.out.format("%15s%25s%15s%15s%15s%15s%15s\n", "ID", "TITLE", "BOXOFFICE", "ACTIVE", "DATEOFLAUNCH",
				"GENRE", "HASTEASER");
		System.out.format("%15d%25s%15s%15s%15s%15s%15s\n", movie.getId(), movie.getTitle(),
				df.format(movie.getGross()), movie.getActive(),
				sdf.format(DateUtil.convertToSqlDate(movie.getDateOfLaunch())), movie.getGenre(), movie.getTeaser());
	}

	public static void main(String[] args) {

		testgetMovieListAdmin();
		testgetMovieListCustomer();
		testmodifyMovieList();
		testgetMovieList();
	}
}
