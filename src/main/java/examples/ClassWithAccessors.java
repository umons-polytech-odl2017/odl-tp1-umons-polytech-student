package examples;

public class ClassWithAccessors {
	private int field1;
	private String field2;

	public ClassWithAccessors(int field1) { this.field1 = field1; }

	public int getField1() { return field1; } // <1>

	public String getField2() { return field2; }

	protected void setField2(String field2) { this.field2 = field2; }
}
