package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.util.Timer;
import java.util.TimerTask;

public class TypingTestGUI extends JFrame {

	private JLabel titleLabel, pangramLabel, typeWordsLabel, timeLeftLabel, WPMLabel, accuracyLabel;
	private JTextArea pangramTextArea, typeWordsTextArea;
	private JTextField timeLeftTextField, WPMTextField, accuracyTextField;

	private JButton acuteButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton,
			eightButton, nineButton, zeroButton, minusButton, plusButton, backspaceButton;
	private JButton tabButton, qButton, wButton, eButton, rButton, tButton, yButton, uButton, iButton, oButton, pButton,
			leftClosedBraceButton, rightClosedBraceButton, backslashButton;
	private JButton capsButton, aButton, sButton, dButton, fButton, gButton, hButton, jButton, kButton, lButton,
			semicolonButton, quoteButton, enterButton;
	private JButton shiftOneButton, zButton, xButton, cButton, vButton, bButton, nButton, mButton, commaButton,
			periodButton, forwardSlashButton, shiftTwoButton;
	private JButton spaceButton;
	private JButton startButton;
	private JButton[] keyJButtons = new JButton[KeyEvent.KEY_LAST + 1];
	private JButton lastJButton;
	private int countdownTimer;
	private boolean toggle = true;
	private static Timer timer = new Timer();

	public TypingTestGUI() {
		super("Typing Application");
		setLayout(null);
		getContentPane().setBackground(new Color(204, 229, 255));

		titleLabel = new JLabel("Typing Speed Test");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 54));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(225, 10, 600, 65);
		add(titleLabel);

		pangramLabel = new JLabel("Pangram");
		pangramLabel.setFont(new Font("Serif", Font.BOLD, 16));
		pangramLabel.setForeground(Color.BLACK);
		pangramLabel.setBounds(20, 100, 80, 20);
		add(pangramLabel);

		pangramTextArea = new JTextArea();
		pangramTextArea.setBounds(20, 123, 650, 100);
		pangramTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		pangramTextArea.setLineWrap(true);
		pangramTextArea.setBorder(new LineBorder(Color.BLUE));
		add(pangramTextArea);

		typeWordsLabel = new JLabel("Type the Words Here");
		typeWordsLabel.setFont(new Font("Serif", Font.BOLD, 16));
		typeWordsLabel.setForeground(Color.BLACK);
		typeWordsLabel.setBounds(20, 235, 160, 20);
		add(typeWordsLabel);

		typeWordsTextArea = new JTextArea();
		typeWordsTextArea.setBounds(20, 258, 650, 100);
		typeWordsTextArea.setLineWrap(true);
		typeWordsTextArea.setBorder(new LineBorder(Color.BLUE));
		add(typeWordsTextArea);
		typeWordsTextArea.addKeyListener(
		         new KeyListener()
		         {
		            public void keyPressed(KeyEvent event)
		            {
		               int buttonIndex = event.getKeyCode();
		               changeColor(keyJButtons[buttonIndex]);
		            }

		            public void keyReleased(KeyEvent event)
		            {
		               resetColor();
		            } 

		            public void keyTyped(KeyEvent event)
		            {
		            } 
		         }
		     );
		

		timeLeftLabel = new JLabel("Time Left");
		timeLeftLabel.setFont(new Font("Serif", Font.BOLD, 16));
		timeLeftLabel.setForeground(Color.BLACK);
		timeLeftLabel.setBounds(700, 100, 160, 20);
		add(timeLeftLabel);

		timeLeftTextField = new JTextField("60");
		timeLeftTextField.setFont(new Font("Serif", Font.PLAIN, 24));
		timeLeftTextField.setForeground(Color.BLACK);
		timeLeftTextField.setBounds(700, 122, 80, 40);
		timeLeftTextField.setBorder(new LineBorder(Color.BLACK));
		add(timeLeftTextField);

		WPMLabel = new JLabel("Words Per Minute");
		WPMLabel.setFont(new Font("Serif", Font.BOLD, 16));
		WPMLabel.setForeground(Color.BLACK);
		WPMLabel.setBounds(700, 170, 160, 20);
		add(WPMLabel);

		WPMTextField = new JTextField("");
		WPMTextField.setFont(new Font("Serif", Font.PLAIN, 24));
		WPMTextField.setForeground(Color.BLACK);
		WPMTextField.setBounds(700, 192, 80, 40);
		WPMTextField.setBorder(new LineBorder(Color.BLACK));
		add(WPMTextField);

		accuracyLabel = new JLabel("Accuracy");
		accuracyLabel.setFont(new Font("Serif", Font.BOLD, 16));
		accuracyLabel.setForeground(Color.BLACK);
		accuracyLabel.setBounds(700, 240, 160, 20);
		add(accuracyLabel);

		accuracyTextField = new JTextField("");
		accuracyTextField.setFont(new Font("Serif", Font.PLAIN, 24));
		accuracyTextField.setForeground(Color.BLACK);
		accuracyTextField.setBounds(700, 262, 80, 40);
		accuracyTextField.setBorder(new LineBorder(Color.BLACK));
		add(accuracyTextField);

		startButton = new JButton("Start");
		startButton.setBounds(700, 315, 90, 45);
		startButton.setBackground(new Color(176, 224, 230));
		startButton.setBorder(new LineBorder(new Color(0, 0, 205)));
		startButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent event) {
				startButtonMouseClicked(event, timer);
			}
		});
		add(startButton);

		CreateKeyboardButtons();

	}

	public void CreateKeyboardButtons() {
		// 1st Row
		acuteButton = new JButton("`");
		acuteButton.setBounds(20, 380, 58, 58);
		keyJButtons[KeyEvent.VK_BACK_QUOTE] = acuteButton;
		add(acuteButton);

		oneButton = new JButton("1");
		oneButton.setBounds(80, 380, 58, 58);
		keyJButtons[KeyEvent.VK_1] = oneButton;
		add(oneButton);

		twoButton = new JButton("2");
		twoButton.setBounds(140, 380, 58, 58);
		keyJButtons[KeyEvent.VK_2] = twoButton;
		add(twoButton);

		threeButton = new JButton("3");
		threeButton.setBounds(200, 380, 58, 58);
		keyJButtons[KeyEvent.VK_3] = threeButton;
		add(threeButton);

		fourButton = new JButton("4");
		fourButton.setBounds(260, 380, 58, 58);
		keyJButtons[KeyEvent.VK_4] = fourButton;
		add(fourButton);

		fiveButton = new JButton("5");
		fiveButton.setBounds(320, 380, 58, 58);
		keyJButtons[KeyEvent.VK_5] = fiveButton;
		add(fiveButton);

		sixButton = new JButton("6");
		sixButton.setBounds(380, 380, 58, 58);
		keyJButtons[KeyEvent.VK_6] = sixButton;
		add(sixButton);

		sevenButton = new JButton("7");
		sevenButton.setBounds(440, 380, 58, 58);
		keyJButtons[KeyEvent.VK_7] = sevenButton;
		add(sevenButton);

		eightButton = new JButton("8");
		eightButton.setBounds(500, 380, 58, 58);
		keyJButtons[KeyEvent.VK_8] = eightButton;
		add(eightButton);

		nineButton = new JButton("9");
		nineButton.setBounds(560, 380, 58, 58);
		keyJButtons[KeyEvent.VK_9] = nineButton;
		add(nineButton);

		zeroButton = new JButton("0");
		zeroButton.setBounds(620, 380, 58, 58);
		keyJButtons[KeyEvent.VK_0] = zeroButton;
		add(zeroButton);

		minusButton = new JButton("-");
		minusButton.setBounds(680, 380, 58, 58);
		keyJButtons[KeyEvent.VK_MINUS] = minusButton;
		add(minusButton);

		plusButton = new JButton("+");
		plusButton.setBounds(740, 380, 58, 58);
		keyJButtons[KeyEvent.VK_EQUALS] = plusButton;
		add(plusButton);

		backspaceButton = new JButton("Backspace");
		backspaceButton.setBounds(800, 380, 118, 58);
		keyJButtons[KeyEvent.VK_BACK_SPACE] = backspaceButton;
		add(backspaceButton);

		// 2nd Row
		tabButton = new JButton("Tab");
		tabButton.setBounds(20, 442, 88, 58);
		keyJButtons[KeyEvent.VK_TAB] = tabButton;
		add(tabButton);

		qButton = new JButton("Q");
		qButton.setBounds(110, 442, 58, 58);
		keyJButtons[KeyEvent.VK_Q] = qButton;
		add(qButton);

		wButton = new JButton("W");
		wButton.setBounds(170, 442, 58, 58);
		keyJButtons[KeyEvent.VK_W] = wButton;
		add(wButton);

		eButton = new JButton("E");
		eButton.setBounds(230, 442, 58, 58);
		keyJButtons[KeyEvent.VK_E] = eButton;
		add(eButton);

		rButton = new JButton("R");
		rButton.setBounds(290, 442, 58, 58);
		keyJButtons[KeyEvent.VK_R] = rButton;
		add(rButton);

		tButton = new JButton("T");
		tButton.setBounds(350, 442, 58, 58);
		keyJButtons[KeyEvent.VK_T] = tButton;
		add(tButton);

		yButton = new JButton("Y");
		yButton.setBounds(410, 442, 58, 58);
		keyJButtons[KeyEvent.VK_Y] = yButton;
		add(yButton);

		uButton = new JButton("U");
		uButton.setBounds(470, 442, 58, 58);
		keyJButtons[KeyEvent.VK_U] = uButton;
		add(uButton);

		iButton = new JButton("I");
		iButton.setBounds(530, 442, 58, 58);
		keyJButtons[KeyEvent.VK_I] = iButton;
		add(iButton);

		oButton = new JButton("O");
		oButton.setBounds(590, 442, 58, 58);
		keyJButtons[KeyEvent.VK_O] = oButton;
		add(oButton);

		pButton = new JButton("P");
		pButton.setBounds(650, 442, 58, 58);
		keyJButtons[KeyEvent.VK_P] = pButton;
		add(pButton);

		leftClosedBraceButton = new JButton("[");
		leftClosedBraceButton.setBounds(710, 442, 58, 58);
		keyJButtons[KeyEvent.VK_OPEN_BRACKET] = leftClosedBraceButton;
		add(leftClosedBraceButton);

		rightClosedBraceButton = new JButton("]");
		rightClosedBraceButton.setBounds(770, 442, 58, 58);
		keyJButtons[KeyEvent.VK_CLOSE_BRACKET] = rightClosedBraceButton;
		add(rightClosedBraceButton);

		backslashButton = new JButton("\\");
		backslashButton.setBounds(830, 442, 88, 58);
		keyJButtons[KeyEvent.VK_BACK_SLASH] = backslashButton;
		add(backslashButton);

		// 3rd Row
		capsButton = new JButton("Caps Lock");
		capsButton.setBounds(20, 504, 118, 58);
		keyJButtons[KeyEvent.VK_CAPS_LOCK] = capsButton;
		add(capsButton);

		aButton = new JButton("A");
		aButton.setBounds(140, 504, 58, 58);
		keyJButtons[KeyEvent.VK_A] = aButton;
		add(aButton);

		sButton = new JButton("S");
		sButton.setBounds(200, 504, 58, 58);
		keyJButtons[KeyEvent.VK_S] = sButton;
		add(sButton);

		dButton = new JButton("D");
		dButton.setBounds(260, 504, 58, 58);
		keyJButtons[KeyEvent.VK_D] = dButton;
		add(dButton);

		fButton = new JButton("F");
		fButton.setBounds(320, 504, 58, 58);
		keyJButtons[KeyEvent.VK_F] = fButton;
		add(fButton);

		gButton = new JButton("G");
		gButton.setBounds(380, 504, 58, 58);
		keyJButtons[KeyEvent.VK_G] = gButton;
		add(gButton);

		hButton = new JButton("H");
		hButton.setBounds(440, 504, 58, 58);
		keyJButtons[KeyEvent.VK_H] = hButton;
		add(hButton);

		jButton = new JButton("J");
		jButton.setBounds(500, 504, 58, 58);
		keyJButtons[KeyEvent.VK_J] = jButton;
		add(jButton);

		kButton = new JButton("K");
		kButton.setBounds(560, 504, 58, 58);
		keyJButtons[KeyEvent.VK_K] = kButton;
		add(kButton);

		lButton = new JButton("L");
		lButton.setBounds(620, 504, 58, 58);
		keyJButtons[KeyEvent.VK_L] = lButton;
		add(lButton);

		semicolonButton = new JButton(";");
		semicolonButton.setBounds(680, 504, 58, 58);
		keyJButtons[KeyEvent.VK_SEMICOLON] = semicolonButton;
		add(semicolonButton);

		quoteButton = new JButton("'");
		quoteButton.setBounds(740, 504, 58, 58);
		keyJButtons[KeyEvent.VK_QUOTE] = quoteButton;
		add(quoteButton);

		enterButton = new JButton("Enter");
		enterButton.setBounds(800, 504, 118, 58);
		keyJButtons[KeyEvent.VK_ENTER] = enterButton;
		add(enterButton);

		// 4th Row
		shiftOneButton = new JButton("Shift");
		shiftOneButton.setBounds(20, 566, 148, 58);
		keyJButtons[KeyEvent.VK_SHIFT] = shiftOneButton;
		add(shiftOneButton);

		zButton = new JButton("Z");
		zButton.setBounds(170, 566, 58, 58);
		keyJButtons[KeyEvent.VK_Z] = zButton;
		add(zButton);

		xButton = new JButton("X");
		xButton.setBounds(230, 566, 58, 58);
		keyJButtons[KeyEvent.VK_X] = xButton;
		add(xButton);

		cButton = new JButton("C");
		cButton.setBounds(290, 566, 58, 58);
		keyJButtons[KeyEvent.VK_C] = cButton;
		add(cButton);

		vButton = new JButton("V");
		vButton.setBounds(350, 566, 58, 58);
		keyJButtons[KeyEvent.VK_V] = vButton;
		add(vButton);

		bButton = new JButton("B");
		bButton.setBounds(410, 566, 58, 58);
		keyJButtons[KeyEvent.VK_B] = bButton;
		add(bButton);

		nButton = new JButton("N");
		nButton.setBounds(470, 566, 58, 58);
		keyJButtons[KeyEvent.VK_N] = nButton;
		add(nButton);

		mButton = new JButton("M");
		mButton.setBounds(530, 566, 58, 58);
		keyJButtons[KeyEvent.VK_M] = mButton;
		add(mButton);

		commaButton = new JButton(",");
		commaButton.setBounds(590, 566, 58, 58);
		keyJButtons[KeyEvent.VK_COMMA] = commaButton;
		add(commaButton);

		periodButton = new JButton(".");
		periodButton.setBounds(650, 566, 58, 58);
		keyJButtons[KeyEvent.VK_PERIOD] = periodButton;
		add(periodButton);

		forwardSlashButton = new JButton("/");
		forwardSlashButton.setBounds(710, 566, 58, 58);
		keyJButtons[KeyEvent.VK_SLASH] = forwardSlashButton;
		add(forwardSlashButton);

		shiftTwoButton = new JButton("Shift");
		shiftTwoButton.setBounds(770, 566, 148, 58);
		keyJButtons[KeyEvent.VK_SHIFT] = shiftTwoButton;
		add(shiftTwoButton);

		// fifthRow
		spaceButton = new JButton();
		spaceButton.setBounds(268, 628, 372, 58);
		keyJButtons[KeyEvent.VK_SPACE] = spaceButton;
		add(spaceButton);
	}
	
	// highlight JButton passed as argument
	   private void changeColor(JButton changeJButton)
	   {
	      if (changeJButton != null)
	      {
	         resetColor();
	         changeJButton.setBackground(Color.YELLOW);
	         lastJButton = changeJButton;
	      }
	   } 

	   // changes lastJButton's color back to default
	   private void resetColor()
	   {
	      if (lastJButton != null)
	         lastJButton.setBackground(this.getBackground());
	   } 

	private void startButtonMouseClicked(java.awt.event.MouseEvent evt, Timer timer) {//GEN-FIRST:event_btnStartMouseClicked
			if (toggle) {
            countdownTimer = 60; //setting the counter to 10 sec
            TimerTask task = new TimerTask() {         
                public void run() {
                    timeLeftTextField.setText(Integer.toString(countdownTimer)); //the timer label to counter.
                    countdownTimer--;
                    if (countdownTimer == 0)
                        timer.cancel();     
                }
            };
            timer.scheduleAtFixedRate(task, 0, 1000); // =  timer.scheduleAtFixedRate(task, delay, period);
			}
			toggle = false;
      }

}