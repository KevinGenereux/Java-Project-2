package Main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		//instantiating the GUI frame to open
		TypingTestGUI keyboardDipslay = new TypingTestGUI();
		//Closes the application when the user clicks on exit symbol
		keyboardDipslay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//sets the size of the frame
		keyboardDipslay.setSize(940, 760);
		//centers the frame relative to the screen
		keyboardDipslay.setLocationRelativeTo(null);
		//Display the frame
		keyboardDipslay.setVisible(true);
		
	}
}
