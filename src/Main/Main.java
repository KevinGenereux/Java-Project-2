package Main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		TypingTestGUI keyboardDipslay = new TypingTestGUI();
		keyboardDipslay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keyboardDipslay.setSize(940, 760);
		keyboardDipslay.setLocationRelativeTo(null);
		keyboardDipslay.setVisible(true);
	}
}
