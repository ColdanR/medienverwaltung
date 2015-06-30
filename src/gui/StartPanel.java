/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel zur Darstellung des Hauptbildschirms mit Begrüßungstext
 * @author Bernd Schmidt
 *
 */
public class StartPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public StartPanel() {
		LayoutManager mgr = new BorderLayout();
		this.setLayout(mgr);
		JLabel text = new JLabel("Willkommen in der Multimedia Verwaltung!");
		text.setAlignmentX(CENTER_ALIGNMENT);
		text.setAlignmentY(CENTER_ALIGNMENT);
		this.add(text, BorderLayout.CENTER);
	}
}
