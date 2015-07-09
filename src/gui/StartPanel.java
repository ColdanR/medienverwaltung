
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel zur Darstellung des Hauptbildschirms mit Begr��ungstext
 * @author Bernd Schmidt
 * @author Jens Wiede (design)
 *
 */
public class StartPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public StartPanel() {
		
		// Creating Panels
		this.setMinimumSize(StaticComponents.MAIN_PANEL);
		this.setLayout(new BorderLayout());
		
		JPanel pnlNorth		= new JPanel();
		JPanel pnlCenter	= new JPanel();
		JPanel pnlSouth		= new JPanel();
		
		pnlNorth.setBorder(StaticComponents.BORDER_PANEL);
		pnlCenter.setBorder(StaticComponents.BORDER_PANEL);
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);
		
		// Creating Labels
		JLabel lblWillkommen = new JLabel("Willkommen in der Multimedia Verwaltung!");
		lblWillkommen.setFont(StaticComponents.FONT_TITLE);
		pnlNorth.add(lblWillkommen);
				
		
		JLabel lblText = new JLabel();
		// XXX Nächster der mich oben hin schreibt, wird gegrillt!
		lblText.setText("<html><center><br><br>von<br><br>"
				+ "Andreas John<br><br>"
				+ "Bernd Schmidt<br><br>"
				+ "Jasmin Burger<br><br>"
				+ "Jens Wiede<br><br>"
				+ "</center></html>");
		
		lblText.setFont(StaticComponents.FONT_STD);
		pnlCenter.add(lblText);
		
				
		FlowLayout flowLayout = (FlowLayout) pnlSouth.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JLabel lblSouth = new JLabel("(c) 2015");
		lblSouth.setFont(StaticComponents.FONT_STD);
		pnlSouth.add(lblSouth);
		
		
	}
}
