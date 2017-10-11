package exercise1;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class Exercise1Test {

	private Person mannekenPis;

	@Before
	public void setUp() {
		mannekenPis = Exercise1.createPerson("Manneken Pis", 97);
	}

	@Test
	public void personIsNotNull() {
		assertThat(mannekenPis).isNotNull();
	}

	@Test
	public void personClassNameIsPerson() {
		assertThat(mannekenPis.getClass().getName()).endsWith(".Person");
	}

	@Test
	public void personHasAName() {
		assertGetterValue(mannekenPis, "getName", "Manneken Pis");
	}

	@Test
	public void personHasAnAge() {
		assertGetterValue(mannekenPis, "getAge", 97);
	}

	@Test
	public void canCreateManyPeople() {
		Random rnd = new Random();
		rnd.ints(100, 1, 100)
			.forEach(number -> {
				int age = number;
				String name = String.format("Custom name %d", number);
				Person person = Exercise1.createPerson(name, age);
				assertGetterValue(person, "getName", name);
				assertGetterValue(person, "getAge", age);
			});
	}

	@Test
	public void runningExercice1PrintsNameAndAge() {
		Random rnd = new Random();
		PrintStream originalOut = System.out;
		try {
			rnd.ints(100, 1, 100)
				.forEach(number -> {
					String name = String.format("Custom name %d", number);
					String age = Integer.toString(number);
					ByteArrayOutputStream stringBuffer = new ByteArrayOutputStream();
					PrintStream fakeOut = new PrintStream(stringBuffer);
					System.setOut(fakeOut);
					Exercise1.main(new String[]{name, age});
					String output = stringBuffer.toString();
					assertThat(output).contains(name);
					assertThat(output).contains(age);
				});
		} finally {
			System.setOut(originalOut);
		}
	}

	private <T> void assertGetterValue(Person object, String getterName, T expectedValue) {
		try {
			Method getter = object.getClass().getMethod(getterName);
			Object value = getter.invoke(object);
			assertThat(value).isEqualTo(expectedValue);
		} catch (NoSuchMethodException e) {
			fail("Person has no name getter");
		} catch (IllegalAccessException e) {
			fail("Person#" + getterName + " is not accessible");
		} catch (InvocationTargetException e) {
			fail("Person#" + getterName + " didn't execute properly");
		}
	}

}
