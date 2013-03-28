package main.functional;

public class Movie {

	private String title;
	private int review;
	
	public Movie(String title, int review) {
		this.title = title;
		this.review = review;
	}
	
	public Movie(String title) {
		this.title = title;
		this.review = -1;
	}

	public String getTitle() {
		return title;
	}

	public int getReview() {
		return review;
	}
	
}
