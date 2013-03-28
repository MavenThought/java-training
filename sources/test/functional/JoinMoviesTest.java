package test.functional;

import static ch.lambdaj.Lambda.joinFrom;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import main.functional.Movie;

import org.junit.Test;
import static java.util.Arrays.asList;

public class JoinMoviesTest {

	@Test
	public void joinAllTheMovieTitles() {

		// arrange
		Iterable<Movie> movies = asList(
			new Movie("Blazing Saddles"),
			new Movie("Terminator"),
			new Movie("Curator")
		);
		
		// act
		String brands = joinFrom(movies).getTitle();
			
		// assert
		assertThat(brands, equalTo("Blazing Saddles, Terminator, Curator"));
	}

}
