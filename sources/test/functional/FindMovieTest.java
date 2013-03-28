package test.functional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.assertThat;

import static ch.lambdaj.Lambda.*;

import main.functional.Movie;

import org.hamcrest.Matcher;
import org.junit.Test;

import ch.lambdaj.function.matcher.Predicate;
import static java.util.Arrays.asList;


public class FindMovieTest {

	@Test
	public void findOnlyWithReview() {
		
		// arrange
		Iterable<Movie> movies = asList(
			new Movie("Blazing Saddles", 5),
			new Movie("Terminator"),
			new Movie("Canadian Bacon", 8)
		);
		
		// act
		Iterable<Movie> reviewed = filter(having(on(Movie.class).getReview(), greaterThan(-1)), movies);
			
		// assert
		assertThat(joinFrom(reviewed).getTitle(), equalTo("Blazing Saddles, Canadian Bacon"));
	}
	
	@Test
	public void findStartingWith() {

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
