package test.functional;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import static ch.lambdaj.Lambda.*;

import main.functional.Movie;

import org.junit.Test;

import static java.util.Arrays.asList;


public class FindBestReviewTest {

	@Test
	public void bestReview() {
		
		// arrange
		Iterable<Movie> movies = asList(
			new Movie("Blazing Saddles", 5),
			new Movie("Terminator", 6),
			new Movie("Canadian Bacon", 8)
		);
		
		// act
		int best = max(movies, on(Movie.class).getReview());
			
		// assert
		assertThat(8, equalTo(best));
	}

}
