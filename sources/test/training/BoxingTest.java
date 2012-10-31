package test.training;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;


public class BoxingTest {
	
	@Test
	public void itShouldBoxTheValues() {
		
		List<Double> collection =  new ArrayList<Double>();
		
		collection.add(4.0);
		
		Double value = collection.get(0);
		
		double otherValue = collection.get(0);
		
		assertThat(value, equalTo(otherValue));
	}

}
