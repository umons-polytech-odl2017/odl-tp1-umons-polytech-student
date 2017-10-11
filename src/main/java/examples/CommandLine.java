package examples;

import java.util.Scanner;

public class CommandLine {
// tag::main[]
	public static void main(String[] args) {
		System.out.println("Hello!");
		System.out.print("What's your name? ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.format("Hello %s!\nHave a nice day!\n", name);

	}
// end::main[]
}
