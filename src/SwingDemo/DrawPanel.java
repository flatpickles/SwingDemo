package SwingDemo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.util.Vector;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	Vector<Ellipse2D.Double> _circles;
	Vector<java.awt.Color> _colors;
	public DrawPanel() {
		_circles = new Vector<Ellipse2D.Double>();
		_colors = new Vector<java.awt.Color>();
		
		// set size
		java.awt.Dimension size = new java.awt.Dimension(300, 300);
		this.setPreferredSize(size);
		this.setSize(size);
		
		// set background color
		this.setBackground(new java.awt.Color(25, 150, 70));
		
		// visible?
		this.setVisible(true);
	}
	
	public void newCircle(java.awt.Color c) {
		// create a new randomly placed circle
		Random r = new Random();
		int x = r.nextInt(250); // we could make canvas/circle size a constant
		int y = r.nextInt(250);
		_circles.add(new Ellipse2D.Double(x, y, 50, 50));
		// add to colors
		_colors.add(c);
		this.repaint();
	}
	
	// called with panel.repaint()
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D ga = (Graphics2D) g;
		ga.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < _circles.size(); i++) {
			Ellipse2D.Double e = _circles.get(i);
			ga.setStroke(new java.awt.BasicStroke(5)); // stroke width 5
			ga.setPaint(_colors.get(i));
			ga.draw(e);
		}
	}
}
