package test.functional;


import static org.hamcrest.CoreMatchers.hasItems;

import static org.junit.Assert.assertThat;

import static ch.lambdaj.Lambda.*;

import main.functional.Movie;

import org.junit.Test;

import ch.lambdaj.function.closure.Closure;
import ch.lambdaj.function.closure.Closure1;
import ch.lambdaj.function.convert.Converter;

public class ClosureTest {

	@Test
	public void closurePrintLine() {
		
		Closure println = closure(); {
			of(System.out).println(var(String.class));
		}
		
		println.apply("Hello JVM user group");
		
		println.each("Hello JVM user group", "Isn't this cool?", "You bet it is!");
	}
	
	public String movieTitle(Movie m) {
		String msg = "The movie %s has %d stars";
		return String.format(msg, m.getTitle(), m.getReview());
	}
	
	@Test 
	public void closureMoviePrinter() {
		
		Closure1<Movie> moviePrinter = closure(Movie.class); {
			of(this).movieTitle(var(Movie.class));
		};
		
		Converter<Movie, String> titleConverter = moviePrinter.cast(Converter.class);
		
		// arrange
		Movie[] movies = new Movie[]{
			new Movie("Blazing Saddles", 7),
			new Movie("Terminator", 6),
			new Movie("Canadian Bacon", 8)
		};
		
		// act
		Iterable<String> titles = convert(movies, titleConverter);
		
		// assert
		assertThat(titles, hasItems(movieTitle(movies[0]), movieTitle(movies[1]),movieTitle(movies[2])));
	}
}
