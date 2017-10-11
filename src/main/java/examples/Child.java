package examples;

public class Child extends ClassWithAccessors {
	private String field3;

	public Child(int field1, String field3) {
		super(field1); // <1>
		this.field3 = field3;
	}

	@Override
	public int getField1() { return super.getField1() * 3; }; // <2>

	@Override
	public void setField2(String field2) { super.setField2(field2); } // <3>

	public String getField3() { return field3; } // <4>
}
