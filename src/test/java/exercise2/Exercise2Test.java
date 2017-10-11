package exercise2;

import org.junit.After;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

public class Exercise2Test {
	@After
	public void tearDown() {
		Exercise2.resetPopulation();
	}

	@Test
	public void computePopulationSize() {
		Random rnd = new Random();
		int expectedPopulationSize = rnd.nextInt(10000);
		rnd.ints(expectedPopulationSize, 1, 100)
			.forEach(Exercise2::createPerson);
		assertThat(Exercise2.computePopulationSize()).isEqualTo(expectedPopulationSize);
	}


	@Test
	public void computeAveragePopulationAge() {
		Random rnd = new Random();
		int youngestAge = rnd.nextInt(80);
		int oldestAge = youngestAge + rnd.nextInt(100 - youngestAge);
		int[] ages = rnd.ints(1000, youngestAge, oldestAge).toArray();
		float meanAge = (float) IntStream.of(ages).average().orElse(0.0);

		IntStream.of(ages).forEach(Exercise2::createPerson);
		assertThat(Exercise2.computeAveragePopulationAge()).isCloseTo(meanAge, withinPercentage(1));
	}
}
