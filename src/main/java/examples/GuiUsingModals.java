package examples;

import javax.swing.*;

public class GuiUsingModals {
// tag::main[]
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What's your name?");
		JOptionPane.showMessageDialog(null, "Hello " + name + "!");
	}
// end::main[]
}
