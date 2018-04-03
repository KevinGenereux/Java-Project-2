package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ResultsGUI extends JFrame{
	
	private JLabel titleLabel, wordsCorrectLabel, wordsIncorrectLabel;
	private JTextArea wordsCorrectTextArea, wordsIncorrectTextArea;
	private JTextField wordsCorrectTextField, wordsIncorrectTextField;
	private JButton exitButton;
	
	public ResultsGUI(ArrayList <String> incorrect, ArrayList <String> correct, ArrayList <String> corrected) {
		
		////calls the superclass constructor to give the application a title
		super("Typing Test Results");
		//absolute positioning layout
		setLayout(null);
		//changes the background colour to light blue
		getContentPane().setBackground(new Color(204, 255, 229));
		
		titleLabel = new JLabel("Results");
		//changes the font of the label
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 54));
		//changes font colour
		titleLabel.setForeground(Color.BLACK);
		//setBounds(x-coordinate, y-coordinate, x length, y length)
		titleLabel.setBounds(225, 10, 600, 65);
		add(titleLabel);
		
		wordsCorrectLabel = new JLabel("Words Typed Correctly:");
		wordsCorrectLabel.setFont(new Font("Serif", Font.BOLD, 16));
		wordsCorrectLabel.setForeground(Color.BLACK);
		wordsCorrectLabel.setBounds(20, 100, 240, 20);
		add(wordsCorrectLabel);
		
		wordsCorrectTextField = new JTextField("60");
		wordsCorrectTextField.setFont(new Font("Serif", Font.PLAIN, 16));
		wordsCorrectTextField.setForeground(Color.BLACK);
		wordsCorrectTextField.setBackground(null);
		wordsCorrectTextField.setBounds(187, 100, 240, 20);
		wordsCorrectTextField.setBorder(null);
		wordsCorrectTextField.setEditable(false);
		add(wordsCorrectTextField);
		
		wordsCorrectTextArea = new JTextArea();
		wordsCorrectTextArea.setBounds(20, 123, 650, 170);
		wordsCorrectTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		wordsCorrectTextArea.setForeground(Color.BLACK);
		//makes it so that the last word on the line will get transferred to the next line instead of getting cut off
		wordsCorrectTextArea.setLineWrap(true);
		//gives the TextArea a border colour
		wordsCorrectTextArea.setBorder(new LineBorder(Color.GREEN));
		wordsCorrectTextArea.setEditable(false);
		for (int i = 0; i < correct.size(); i++) {
			wordsIncorrectTextArea.append(correct.get(i) + " ");
		}
		add(wordsCorrectTextArea);
		
		wordsIncorrectLabel = new JLabel("Words Typed Incorrectly:");
		wordsIncorrectLabel.setFont(new Font("Serif", Font.BOLD, 16));
		wordsIncorrectLabel.setForeground(Color.BLACK);
		wordsIncorrectLabel.setBounds(20, 310, 240, 20);
		add(wordsIncorrectLabel);
		
		wordsIncorrectTextField = new JTextField("60");
		wordsIncorrectTextField.setFont(new Font("Serif", Font.PLAIN, 16));
		wordsIncorrectTextField.setForeground(Color.BLACK);
		wordsIncorrectTextField.setBackground(null);
		wordsIncorrectTextField.setBounds(195, 310, 240, 20);
		wordsIncorrectTextField.setBorder(null);
		wordsIncorrectTextField.setEditable(false);
		add(wordsIncorrectTextField);
		
		wordsIncorrectTextArea = new JTextArea();
		wordsIncorrectTextArea.setBounds(20, 333, 650, 170);
		wordsIncorrectTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		wordsIncorrectTextArea.setForeground(Color.BLACK);
		//makes it so that the last word on the line will get transferred to the next line instead of getting cut off
		wordsIncorrectTextArea.setLineWrap(true);
		//gives the TextArea a border colour
		wordsIncorrectTextArea.setBorder(new LineBorder(Color.GREEN));
		wordsIncorrectTextArea.setEditable(false);
		for (int i = 0; i < incorrect.size(); i++) {
			wordsIncorrectTextArea.append(corrected.get(i) + " (" + incorrect.get(i) + ") ");
		}
		add(wordsIncorrectTextArea);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(570, 550, 100, 40);
		exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		exitButton.setForeground(Color.BLACK);
		exitButton.setBorder(new LineBorder(Color.BLACK));
		exitButton.setBackground(new Color(0,160,0));
		//creating a mouse listener class to handle mouse input
		ButtonHandler handler = new ButtonHandler();
		exitButton.addActionListener(handler);
		add(exitButton);
	}
	
	//creates a button handler 
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
		
	}

}
