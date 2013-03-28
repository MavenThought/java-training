package test.functional;


import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

import static ch.lambdaj.Lambda.*;
import static ch.lambdaj.collection.LambdaCollections.*;

import main.functional.Movie;

import org.junit.Test;

import static java.util.Arrays.asList;


public class SortByReviewTest {

	@Test
	public void bestReview() {
		
		// arrange
		Iterable<Movie> movies = asList(
			new Movie("Blazing Saddles", 7),
			new Movie("Terminator", 6),
			new Movie("Canadian Bacon", 8)
		);
		
		// act
		Iterable<Movie> sortedByReview = with(movies)
			.sort(on(Movie.class).getReview(), DESCENDING);
			
		// assert
		assertThat(joinFrom(sortedByReview).getTitle(), equalTo("Canadian Bacon, Blazing Saddles, Terminator"));
	}

}

