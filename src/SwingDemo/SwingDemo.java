package SwingDemo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SwingDemo extends JFrame {
	DrawPanel _panel;
	
	public SwingDemo() {
		// set basic window stuff
		super("Swing Demo");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// instantiate stuff
		JButton redButton = new JButton("Red");
		JButton blueButton = new JButton("Blue");
		JButton greenButton = new JButton("Green");
		_panel = new DrawPanel(); 
		
		// add listeners
		redButton.addActionListener(new ClickListener(new java.awt.Color(255, 0, 0)));
		blueButton.addActionListener(new ClickListener(new java.awt.Color(0, 0, 255)));
		greenButton.addActionListener(new ClickListener(new java.awt.Color(0, 255, 0)));
		
		// set up layout
		this.setLayout(new BorderLayout());
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(redButton);
		bottomPanel.add(blueButton);
		bottomPanel.add(greenButton);
		this.add(_panel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		// finish the window creation
		this.pack();
		this.setLocationRelativeTo(null); // centers frame on main screen
		this.setVisible(true);
	}
	
	/**
	 * Inner class to handle mousepress actions on the buttons.
	 */
	private class ClickListener implements ActionListener {
		java.awt.Color buttonColor;
		public ClickListener(java.awt.Color c) {
			buttonColor = c;
		}
		public void actionPerformed(ActionEvent arg0) {
			_panel.newCircle(buttonColor);
		}
		
	}
}
