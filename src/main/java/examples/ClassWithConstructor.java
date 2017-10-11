package examples;

public class ClassWithConstructor {
	int field1;
	String field2;

// tag::constructor[]
	public ClassWithConstructor() { // <1>
		field1 = 123;
		field2 = "default value";
	}

	protected ClassWithConstructor(int field1, String field2) { // <2>
		this.field1 = field1;
		this.field2 = field2;
	}
// end::constructor[]
}
