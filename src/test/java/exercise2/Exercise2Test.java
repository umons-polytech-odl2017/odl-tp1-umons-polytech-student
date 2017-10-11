package exercise2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

class Exercise2Test {
	@AfterEach
	void tearDown() {
		Exercise2.resetPopulation();
	}

	@Test
	void computePopulationSize() {
		Random rnd = new Random();
		int expectedPopulationSize = rnd.nextInt(10000);
		rnd.ints(expectedPopulationSize, 1, 100)
			.forEach(Exercise2::createPerson);
		assertThat(Exercise2.computePopulationSize()).isEqualTo(expectedPopulationSize);
	}


	@Test
	void computeAveragePopulationAge() {
		Random rnd = new Random();
		int youngestAge = rnd.nextInt(80);
		int oldestAge = youngestAge + rnd.nextInt(100 - youngestAge);
		int[] ages = rnd.ints(1000, youngestAge, oldestAge).toArray();
		float meanAge = (float) IntStream.of(ages).average().orElse(0.0);

		IntStream.of(ages).forEach(Exercise2::createPerson);
		assertThat(Exercise2.computeAveragePopulationAge()).isCloseTo(meanAge, withinPercentage(1));
	}
}
