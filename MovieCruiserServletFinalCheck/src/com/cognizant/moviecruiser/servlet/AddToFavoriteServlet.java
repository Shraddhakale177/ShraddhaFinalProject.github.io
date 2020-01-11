package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecruiser.dao.MoviesDao;
import com.cognizant.moviecruiser.dao.MoviesDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movies;

/**
 * Servlet implementation class AddToFavoriteServlet
 */
@WebServlet("/AddToFavorite")
public class AddToFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long userId = 1l;
		Long moviesId=Long.parseLong(request.getParameter("id"));
		FavoritesDao favoriteDao = new FavoritesDaoSqlImpl();
		favoriteDao.addFavoriteMovies( userId, moviesId);
		MoviesDao movieDao = new MoviesDaoSqlImpl();
		List<Movies> movieListCustomer = movieDao.getMovieListCustomer();
		request.setAttribute("movieList",  movieListCustomer);
		request.setAttribute("addFavoriteStatus", true);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
