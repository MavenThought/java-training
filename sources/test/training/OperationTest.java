package test.training;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import main.training.Operation;

import org.junit.Test;


public class OperationTest {

	@Test
	public void itShouldAddElements() {
		// arrange
		double d1 = 5;
		double d2 = 9;
		
		// act
		double actual = Operation.PLUS.eval(d1, d2);
		
		// assert
		assertThat(actual, equalTo(d1 + d2));
	}
}
