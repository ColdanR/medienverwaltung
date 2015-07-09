package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.dialog.*;

import javax.swing.JButton;

import data.logic.PersonLogik;
import data.medien.logic.MusikLogik;
import enums.ErrorMessage;
import enums.ErrorsGUI;

public class Startfenster extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton		btnMNeu;
	private JButton		btnMAnzeigen;
	private JButton		btnPNeu;
	private JButton		btnPAnzeigen;
	private JButton btnBeenden;
	private JPanel		anzeigeFenster;
	private	Container	cp;			
	
	public Startfenster() 
	{
		super("Medien Verwaltung");
		this.setFont(StaticComponents.FONT_STD);
		this.setForeground(StaticComponents.FONT_COLOR_STD);
		this.setBackground(StaticComponents.BACKGROUND_COLOR_STD);
		
		cp = getContentPane();		
		cp.setLayout(new BorderLayout());
		cp.add(createButtonPanel(), BorderLayout.WEST);
		// XXX CP mit fester Größe erledigt das Zusammenklappen
		cp.setSize(new Dimension(600, 400));
		cp.setMinimumSize(new Dimension(600, 400));
		cp.setPreferredSize(new Dimension(600, 400));
		setPanel(new StartPanel());

		btnMAnzeigen.addActionListener(this);
		btnMNeu.addActionListener(this);
		btnBeenden.addActionListener(this);
		btnPNeu.addActionListener(this);
		btnPAnzeigen.addActionListener(this);
		
	}
	
	private JPanel createButtonPanel() 
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(StaticComponents.BORDER_PANEL);
		GridLayout gl_buttonPanel = new GridLayout(0,1);
		buttonPanel.setLayout(gl_buttonPanel);
		
		JPanel pnlGl1 = new JPanel();
		JPanel pnlGl2 = new JPanel();
		JPanel pnlGl3 = new JPanel();
		buttonPanel.add(pnlGl1);
		buttonPanel.add(pnlGl2);
		buttonPanel.add(pnlGl3);
		
		GridBagLayout gbl_pnlGl1 = new GridBagLayout();
		gbl_pnlGl1.columnWidths = new int[] {100, 0};
		gbl_pnlGl1.rowHeights = new int[] {0, 0, 0, 0};
		gbl_pnlGl1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlGl1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGl1.setLayout(gbl_pnlGl1);
		
		GridBagLayout gbl_pnlGl2 = new GridBagLayout();
		gbl_pnlGl2.columnWidths = new int[] {100, 0};
		gbl_pnlGl2.rowHeights = new int[] {0, 0, 0, 0};
		gbl_pnlGl2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlGl2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGl2.setLayout(gbl_pnlGl2);
		
		GridBagLayout gbl_pnlGl3 = new GridBagLayout();
		gbl_pnlGl3.columnWidths = new int[] {100, 0};
		gbl_pnlGl3.rowHeights = new int[] {0, 0};
		gbl_pnlGl3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlGl3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlGl3.setLayout(gbl_pnlGl3);
		
		JLabel lblMusik = new JLabel("Musik");
		lblMusik.setFont(StaticComponents.FONT_TITLE);
		GridBagConstraints gbc_lblMusik = new GridBagConstraints();
		gbc_lblMusik.insets = new Insets(10, 10, 10, 10);
		gbc_lblMusik.gridx = 0;
		gbc_lblMusik.gridy = 0;
		pnlGl1.add(lblMusik, gbc_lblMusik);
		
		btnMNeu = new JButton("Neu");
		btnMNeu.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnMNeu = new GridBagConstraints();
		gbc_btnMNeu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMNeu.insets = new Insets(0, 10, 10, 10);
		gbc_btnMNeu.gridx = 0;
		gbc_btnMNeu.gridy = 1;
		pnlGl1.add(btnMNeu, gbc_btnMNeu);
		
		btnMAnzeigen = new JButton("Anzeigen");
		btnMAnzeigen.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnMAnzeigen = new GridBagConstraints();
		gbc_btnMAnzeigen.anchor = GridBagConstraints.NORTH;
		gbc_btnMAnzeigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMAnzeigen.insets = new Insets(0, 10, 0, 10);
		gbc_btnMAnzeigen.gridx = 0;
		gbc_btnMAnzeigen.gridy = 2;
		pnlGl1.add(btnMAnzeigen, gbc_btnMAnzeigen);
		
		JLabel lblPerson = new JLabel("Person");
		lblPerson.setFont(StaticComponents.FONT_TITLE);
		GridBagConstraints gbc_lblPerson = new GridBagConstraints();
		gbc_lblPerson.insets = new Insets(10, 10, 10, 10);
		gbc_lblPerson.gridx = 0;
		gbc_lblPerson.gridy = 0;
		pnlGl2.add(lblPerson, gbc_lblPerson);
		
		btnPNeu = new JButton("Neu");
		btnPNeu.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnPNeu = new GridBagConstraints();
		gbc_btnPNeu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPNeu.insets = new Insets(0, 10, 10, 10);
		gbc_btnPNeu.gridx = 0;
		gbc_btnPNeu.gridy = 1;
		pnlGl2.add(btnPNeu, gbc_btnPNeu);
		
		btnPAnzeigen = new JButton("Anzeigen");
		btnPAnzeigen.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnKAnzeigen = new GridBagConstraints();
		gbc_btnKAnzeigen.anchor = GridBagConstraints.NORTH;
		gbc_btnKAnzeigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKAnzeigen.insets = new Insets(0, 10, 0, 10);
		gbc_btnKAnzeigen.gridx = 0;
		gbc_btnKAnzeigen.gridy = 2;
		pnlGl2.add(btnPAnzeigen, gbc_btnKAnzeigen);
		
		btnBeenden = new JButton("Beenden");
		btnBeenden.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnBeenden = new GridBagConstraints();
		gbc_btnBeenden.anchor = GridBagConstraints.SOUTH;
		gbc_btnBeenden.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBeenden.insets = new Insets(10, 10, 10, 10);
		gbc_btnBeenden.gridx = 0;
		gbc_btnBeenden.gridy = 0;
		pnlGl3.add(btnBeenden, gbc_btnBeenden);
		
		
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
	public void actionPerformed(ActionEvent arg0) 
	{
		Object source = arg0.getSource();
		
		if (source == btnPNeu) 
		{
			PersonEingabeDialog dialog = new PersonEingabeDialog(this);
			dialog.display();
		}
		else if (source == btnPAnzeigen) 
		{
			PersonLogik logik = new PersonLogik();
			if (logik.getAll() == null || logik.getAll().size() == 0) {
				List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
				errors.add(ErrorsGUI.NoDataAvailable);
				FehlerDialog dialog = new FehlerDialog(getOwner(), errors);
				dialog.setVisible(true);
			} else {
				setPanel(new PersonenListePanel());
			}
		}
		else if (source == btnMNeu) 
		{
			setPanel(new MusikEingabePanel(this, null));
		}
		else if (source == btnMAnzeigen) 
		{   
			MusikLogik logik = new MusikLogik();
			if (logik.getAll() == null || logik.getAll().size() == 0) {
				List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
				errors.add(ErrorsGUI.NoDataAvailable);
				FehlerDialog dialog = new FehlerDialog(getOwner(), errors);
				dialog.setVisible(true);
			} else {
				setPanel(new MusikListPanel(this));
			}
		}
		else if (source == btnBeenden)
		{
			this.dispose();
		}
	}

	public void setPanel(JPanel mainPanel) {
		if (anzeigeFenster != null) {
			cp.remove(anzeigeFenster);
		}
		anzeigeFenster = mainPanel;
		cp.add(anzeigeFenster, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
}
