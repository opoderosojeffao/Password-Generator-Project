import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener{

	// Setting up all variables needed for the frame
	private static final long serialVersionUID = 1L;
	int WIDTH = 400;
	int HEIGHT = 220;
	
	int titleFont = 37;
	
	JPanel titlePanel = new JPanel();
	JLabel text = new JLabel("Text");
	
	JPanel check = new JPanel();
	JCheckBox numbers = new JCheckBox("Numbers");
	JCheckBox symbols = new JCheckBox("Symbols");
	
	JPanel passTextPanel = new JPanel();
	JTextField passText = new JTextField();
	
	JLabel lengthCap = new JLabel();
	JTextField lengthText = new JTextField();
	
	JPanel button = new JPanel();
	JButton submit = new JButton("Generate");
	
	// Setting up variables needed for calling the constructor from Password class
	
	boolean isNumber; 
	boolean isSymbol;
	
	int length;
	
	Password password;
	
	
	// Constructor Frame to generate the frame, it makes all necessary code for the GUI
	Frame() {
		this.setVisible(true);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setFocusable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Password Generator");
		
		text.setText("Password Generator");
		text.setFont(new Font("Times New Roman", Font.BOLD, titleFont));
		
		check.setBounds(0, 100, WIDTH, HEIGHT/6);
		
		
		passText.setPreferredSize(new Dimension(250,30));
		passText.setEditable(false);
		passText.setHorizontalAlignment(JTextField.CENTER);
		
		lengthCap.setText("Length:");
		lengthText.setPreferredSize(new Dimension(40,30));
		lengthText.setHorizontalAlignment(JTextField.CENTER);
		
		submit.addActionListener(this);
		
		check.add(numbers);
		check.add(symbols);
		titlePanel.add(text);
		passTextPanel.add(passText);
		check.add(lengthCap);
		check.add(lengthText);
		button.add(submit);
		this.add(titlePanel, BorderLayout.PAGE_START);
		this.add(check);
		this.add(passTextPanel);
		this.add(button, BorderLayout.PAGE_END);
	}

	
	
	// Method to run the code when the button is pressed
	public void actionPerformed(ActionEvent e) {
		isSymbol = symbols.isSelected();
		isNumber = numbers.isSelected();
		
		password = new Password(isNumber, isSymbol, length);
		
		// Try statement to check if the user entered a number or anything else
		// that cannot be transformed into a string
		
		if(e.getSource()==submit) {
			try {
				length = Integer.parseInt(lengthText.getText());
				if(length >= 8 && length <= 32) {
					passText.setText(password.GenPassword());
				} else {
					passText.setText("Enter a number from 8 to 32");
				}
			} catch (Exception error){
				passText.setText("Length needs to be a number");
			}
		}		
	}
}
