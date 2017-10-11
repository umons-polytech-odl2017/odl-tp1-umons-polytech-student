// tag::header[]
package examples.aPackage; // <1>

import examples.anotherPackage.AClassInAnotherPackage; // <2>
import examples.yetAnotherPackage.*; // <3>

import static examples.aPackage.Utils.sayHello; // <4>
// end::header[]

public class Header {
	private AClassInAnotherPackage field1;
	private YetAnotherClass1 field2;
	private YetAnotherClass2 field3;
	private YetAnotherClass3 field4;
	private YetAnotherClass4 field5;
	private YetAnotherClass5 field6;

	public static void main(String[] args) {
		String salutation = sayHello();
	}
}
