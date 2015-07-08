package gui;

import gui.renderer.PersonListRenderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;

import data.Person;

public class PersonenListePanel extends JPanel implements ActionListener {
	private JLabel			lblHeader;
	private JList<Person>	lstPersonList;
	private JButton			btnBearbeiten;
	private JButton			btnLoeschen;
	private JScrollPane scrollPane;
	

	public PersonenListePanel() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		creatPersonListPanel();
		
		btnBearbeiten.addActionListener(this);
		btnLoeschen.addActionListener(this);
	}
	
	public void creatPersonListPanel(){
		this.setMinimumSize(new Dimension (300, 300));
		this.setLayout(new BorderLayout());
		
		JPanel pnlNorth		= new JPanel();
		JPanel pnlCenter	= new JPanel();
		JPanel pnlSouth		= new JPanel();

		pnlNorth.setBorder(StaticComponents.BORDER_PANEL);
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
		pnlCenter.setBorder(StaticComponents.BORDER_PANEL);
		
		this.add(pnlNorth, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		//Header
		lblHeader = new JLabel("Interpreten anzeige");
		lblHeader.setFont(StaticComponents.FONT_TITLE);
		pnlNorth.add(lblHeader);
		
		//Center
		lstPersonList = new JList<Person>();
		lstPersonList.setCellRenderer(new PersonListRenderer());
		lstPersonList.setVisibleRowCount(5);
		lstPersonList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane = new JScrollPane(lstPersonList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnlCenter.add(scrollPane);
		
		//Footer
		btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnBearbeiten);
		btnLoeschen = new JButton("Löschen");
		btnLoeschen.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnLoeschen);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if (source == btnLoeschen)
		{
			
		}
		else if (source == btnBearbeiten)
		{
			
		}
	}

}
