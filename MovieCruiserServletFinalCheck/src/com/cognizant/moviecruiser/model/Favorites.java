package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {

    private List<Movies> movieList;
	private int totalGross;
	private int totalFavorites;
	
	public Favorites() {
		super();
	}  

	public Favorites(List<Movies> movieList, int totalGross, int totalFavorites) {
		super();
		this.movieList = movieList;
		this.totalGross = totalGross;
		this.totalFavorites = totalFavorites;
	}

	public List<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movies> movieList) {
		this.movieList = movieList;
	}

	public int getTotalGross() {
		return totalGross;
	}

	public void setTotalGross(int totalGross) {
		this.totalGross = totalGross;
	}

	public int getTotalFavorites() {
		return totalFavorites;
	}

	public void setTotalFavorites(int totalFavorites) {
		this.totalFavorites = totalFavorites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + totalFavorites;
		result = prime * result + totalGross;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (totalFavorites != other.totalFavorites)
			return false;
		if (totalGross != other.totalGross)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", totalGross=" + totalGross + ", totalFavorites=" + totalFavorites
				+ "]";
	}
}	