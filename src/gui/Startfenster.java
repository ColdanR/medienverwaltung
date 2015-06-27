package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.dialog.InterpretDialog;

import javax.swing.JButton;

public class Startfenster extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnMNeu;
	private JButton btnMAnzeigen;
	private JButton btnKNeu;
	private JButton btnKAnzeigen;

	public Startfenster() {
		super("Medien Verwaltung");
		this.setFont(StaticComponents.FONT_STD);
		this.setForeground(StaticComponents.FONT_COLOR_STD);
		this.setBackground(StaticComponents.BACKGROUND_COLOR_STD);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createButtonPanel(), BorderLayout.WEST);
		cp.add(new InputPanel(), BorderLayout.CENTER);
		
		btnKAnzeigen.addActionListener(this);
		btnKNeu.addActionListener(this);
		btnMAnzeigen.addActionListener(this);
		btnMNeu.addActionListener(this);
	}
	
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		buttonPanel.setLayout(new GridLayout(0,1));
		
		JPanel pnlGl1 = new JPanel();
		JPanel pnlGl2 = new JPanel();
		buttonPanel.add(pnlGl1);
		buttonPanel.add(pnlGl2);
		
		GridBagLayout gbl_pnlGl1 = new GridBagLayout();
		gbl_pnlGl1.columnWidths = new int[] {100, 0};
		gbl_pnlGl1.rowHeights = new int[] {30, 0, 0, 0, 0};
		gbl_pnlGl1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlGl1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0};
		pnlGl1.setLayout(gbl_pnlGl1);
		
		GridBagLayout gbl_pnlGl2 = new GridBagLayout();
		gbl_pnlGl2.columnWidths = new int[] {100, 0};
		gbl_pnlGl2.rowHeights = new int[] {30, 0, 0, 0, 0};
		gbl_pnlGl2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlGl2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0};
		pnlGl2.setLayout(gbl_pnlGl2);
				
		JLabel lblMusik = new JLabel("Musik");
		GridBagConstraints gbc_lblMusik = new GridBagConstraints();
		gbc_lblMusik.insets = new Insets(0, 10, 10, 10);
		gbc_lblMusik.gridx = 0;
		gbc_lblMusik.gridy = 1;
		pnlGl1.add(lblMusik, gbc_lblMusik);
		
		btnMNeu = new JButton("neu");
		btnMNeu.setPreferredSize(new Dimension(83, 25));
		GridBagConstraints gbc_btnMNeu = new GridBagConstraints();
		gbc_btnMNeu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMNeu.insets = new Insets(0, 10, 10, 10);
		gbc_btnMNeu.gridx = 0;
		gbc_btnMNeu.gridy = 2;
		pnlGl1.add(btnMNeu, gbc_btnMNeu);
		
		btnMAnzeigen = new JButton("anzeigen");
		GridBagConstraints gbc_btnMAnzeigen = new GridBagConstraints();
		gbc_btnMAnzeigen.anchor = GridBagConstraints.NORTH;
		gbc_btnMAnzeigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMAnzeigen.insets = new Insets(0, 10, 10, 10);
		gbc_btnMAnzeigen.gridx = 0;
		gbc_btnMAnzeigen.gridy = 3;
		pnlGl1.add(btnMAnzeigen, gbc_btnMAnzeigen);
		
		JLabel lblKuenstler = new JLabel("Kuenstler");
		GridBagConstraints gbc_lblKuenstler = new GridBagConstraints();
		gbc_lblKuenstler.insets = new Insets(0, 10, 10, 10);
		gbc_lblKuenstler.gridx = 0;
		gbc_lblKuenstler.gridy = 1;
		pnlGl2.add(lblKuenstler, gbc_lblKuenstler);
		
		btnKNeu = new JButton("neu");
		btnKNeu.setPreferredSize(new Dimension(83, 25));
		GridBagConstraints gbc_btnKNeu = new GridBagConstraints();
		gbc_btnKNeu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKNeu.insets = new Insets(0, 10, 10, 10);
		gbc_btnKNeu.gridx = 0;
		gbc_btnKNeu.gridy = 2;
		pnlGl2.add(btnKNeu, gbc_btnKNeu);
		
		btnKAnzeigen = new JButton("anzeigen");
		GridBagConstraints gbc_btnKAnzeigen = new GridBagConstraints();
		gbc_btnKAnzeigen.anchor = GridBagConstraints.NORTH;
		gbc_btnKAnzeigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKAnzeigen.insets = new Insets(0, 10, 10, 10);
		gbc_btnKAnzeigen.gridx = 0;
		gbc_btnKAnzeigen.gridy = 3;
		pnlGl2.add(btnKAnzeigen, gbc_btnKAnzeigen);
		
		return buttonPanel;
	}
	
	
	public static void main(String[] args) {
		Startfenster mv = new Startfenster();
		mv.pack();
		mv.setVisible(true);
		mv.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mv.setLocationRelativeTo(null);
		mv.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnKAnzeigen) {
			InterpretDialog dialog = new InterpretDialog(this);
			dialog.display();
		}
	}

}
