package test.training;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import main.training.ForEachLoop;

public class ForEachLoopTest {

	private List<String> environments;
	private Iterable<String> expected;
	
	public ForEachLoopTest() {
		this.environments = Arrays.asList(new String[]{"Staging", "UAT", "Production"});
		this.expected = Arrays.asList(new String[]{"Deployed to Staging", "Deployed to UAT", "Deployed to Production"});
	}
	
	@Test
	public void itShouldDeployUsingForEach() {
		// arrange
		ForEachLoop fel = new ForEachLoop();
		// act
		Iterable<String> actual = fel.deployUsingForEach(environments);
		// assert
		assertThat(actual, equalTo(this.expected));
	}

	@Test
	public void itShouldDeployUsingAnIterator() {
		// arrange
		ForEachLoop fel = new ForEachLoop();
		// act
		Iterable<String> actual = fel.deployUsingIterator(environments);
		// assert
		assertThat(actual, equalTo(this.expected));
	}
	
	@Test
	public void itShouldDeployUsingEnhancedForLoop() {
		// arrange
		ForEachLoop fel = new ForEachLoop();
		// act
		Iterable<String> actual = fel.deployUsingEnhanced(environments);
		// assert
		assertThat(actual, equalTo(this.expected));
	}
	
	@Test
	public void itShouldDeployUsingMapping() {
		// arrange
		ForEachLoop fel = new ForEachLoop();
		
		// act
		Iterable<String> actual = fel.deployUsingMapping(environments);
		
		// assert
		assertThat(actual, equalTo(this.expected));
	}

	@Test
	public void itShouldDeployUsingFluentMapping() {
		// arrange
		ForEachLoop fel = new ForEachLoop();
		
		// act
		Iterable<String> actual = fel.deployUsingFluentMapping(environments);
		
		Iterator<String> actualIterator = actual.iterator();
		
		Iterator<String> expectedIterator = this.expected.iterator();
		
		// assert
		assertThat(actualIterator.next(), equalTo(expectedIterator.next()));
		assertThat(actualIterator.next(), equalTo(expectedIterator.next()));
		assertThat(actualIterator.next(), equalTo(expectedIterator.next()));
	}
}

