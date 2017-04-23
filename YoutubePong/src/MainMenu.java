import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MainMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	int screenWidth = 250;
	int screenHeight = 150;

	int buttonWidth = 100;
	int buttonHeight = 40;

	JButton Play, Quit;
	JCheckBox twoPlayer;

	public MainMenu() {

		addButtons();
		addActions();

		getContentPane().setLayout(null);

		Play.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth, buttonHeight); // Position the Play button
		Quit.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth, buttonHeight); // Position the Quit button
		twoPlayer.setBounds((screenWidth - buttonWidth) / 2, 95, buttonWidth * 2, buttonHeight); // Position the towPlayer checkbox

		// Adding buttons
		getContentPane().add(Play); // Add the button to the JFrame
		getContentPane().add(Quit); // Add the button to the JFrame
		getContentPane().add(twoPlayer); // Add the checkbox to the JFrame

		// JFrame stuff
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(screenWidth, screenHeight);
		setTitle("Pong Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	private void addButtons() {
		Play = new JButton("Play");
		Quit = new JButton("Quit");
		twoPlayer = new JCheckBox("Two Players?");
	}

	private void addActions() {

		Play.addActionListener(new ActionListener() { // Take Play button, add new actionlistener
					public void actionPerformed(ActionEvent e) { // Turn the action performed into a variable for usage
						dispose();

						Game game = new Game();

						if (twoPlayer.isSelected()) {
							Game.ai.isTwoPlayer = true;
						} else {
							Game.ai.isTwoPlayer = false;
						}

						game.start();
					}
				});// Play button

		Quit.addActionListener(new ActionListener() { // Take Quit button, add new actionlistener
					public void actionPerformed(ActionEvent e) { // Turn the action performed into a variable for usage
						System.exit(0); // Shut down the program
					}
				});// Quit button
	}
}