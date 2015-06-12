package gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;

public class Mainscreen extends JFrame {
	public Mainscreen() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	}
	private static final long serialVersionUID = 1L;
}
