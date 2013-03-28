package test.functional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import static ch.lambdaj.Lambda.*;

import main.functional.Movie;

import org.hamcrest.Matcher;
import org.junit.Test;

import ch.lambdaj.function.matcher.Predicate;
import static java.util.Arrays.asList;


public class FindMovieTest {

	@Test
	public void findAllMoviesThatStartWith() {

		// arrange
		Iterable<Movie> movies = asList(
			new Movie("Blazing Saddles"),
			new Movie("Terminator"),
			new Movie("Curator")
		);
		
		// act
		Matcher<Movie> endsWithAtor = new Predicate<Movie>() {
	        public boolean apply(Movie item) {
	                return item.getTitle().endsWith("ator");
	        }
		};

		Iterable<Movie> atorMovies = filter(endsWithAtor, movies);
			
		// assert
		assertThat(joinFrom(atorMovies).getTitle(), equalTo("Terminator, Curator"));
	}
}
