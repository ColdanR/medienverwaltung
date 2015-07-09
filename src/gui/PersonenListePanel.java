package gui;

import gui.dialog.FehlerDialog;
import gui.dialog.PersonEingabeDialog;
import gui.renderer.PersonListRenderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;

import data.Person;
import data.logic.PersonLogik;
import enums.ErrorMessage;
import enums.ErrorsGUI;

import javax.swing.border.CompoundBorder;

import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class PersonenListePanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6117444169258495955L;
	private JLabel			lblHeader;
	private JList<Person>	lstPersonList;
	private JButton			btnBearbeiten;
	private JButton			btnLoeschen;
	private JScrollPane 	scrollPane;
	private JPanel 			pnlCenter;
	

	public PersonenListePanel() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		creatPersonListPanel();
		
		btnBearbeiten.addActionListener(this);
		btnLoeschen.addActionListener(this);
	}
	
	public void creatPersonListPanel(){
		this.setMinimumSize(StaticComponents.MAIN_PANEL);
		this.setLayout(new BorderLayout());
		
		JPanel pnlNorth		= new JPanel();
			   pnlCenter	= new JPanel();
		JPanel pnlSouth		= new JPanel();
		
		pnlCenter.setLayout(new BorderLayout());
		
		pnlNorth.setBorder(StaticComponents.BORDER_PANEL);
		pnlCenter.setBorder(new CompoundBorder(StaticComponents.BORDER_PANEL, new EmptyBorder(10, 10, 10, 10)));
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
				
		this.add(pnlNorth, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		//Header
		lblHeader = new JLabel("Interpreten anzeigen");
		lblHeader.setFont(StaticComponents.FONT_TITLE);
		pnlNorth.add(lblHeader);
		
		//Center
		generateList();
		
		
		//Footer
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		fl.setHgap(10);
		fl.setVgap(10);
		pnlSouth.setLayout(fl);
		btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnBearbeiten);
		btnLoeschen = new JButton("L\u00F6schen");
		btnLoeschen.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnLoeschen);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == btnLoeschen)
		{
			if (lstPersonList.isSelectionEmpty()) {
				List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
				errors.add(ErrorsGUI.NoSelection);
				JDialog	errorDialog = new FehlerDialog(null, errors);
				errorDialog.setVisible(true);
				return;
			}
			Person selected = lstPersonList.getSelectedValue();
			PersonLogik logik = new PersonLogik();
			if (logik.loadObject(selected.getId()) && logik.delete()) {
				generateList();
			} else {
				FehlerDialog dialogFehler = new FehlerDialog(null, logik.getErrors());
				dialogFehler.setVisible(true);
			}
		}
		else if (source == btnBearbeiten)
		{
			if (lstPersonList.isSelectionEmpty()) {
				List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
				errors.add(ErrorsGUI.NoSelection);
				JDialog	errorDialog = new FehlerDialog(null, errors);
				errorDialog.setVisible(true);
				return;
			}
			Person selected = lstPersonList.getSelectedValue();
			PersonEingabeDialog dialog = new PersonEingabeDialog(null);
			dialog.setPerson(selected);
			dialog.display();
			generateList();
		}
	}
	private void generateList() {
		PersonLogik		logik		=	new PersonLogik();
		List<Person>	listData	=	logik.getAll();
		if (scrollPane != null) {
			pnlCenter.remove(scrollPane);
		}
		if (logik.getErrors().isEmpty()) 
		{
			lstPersonList = new JList<Person>(listData.toArray(new Person[]{}));
			lstPersonList.setCellRenderer(new PersonListRenderer());
			lstPersonList.setVisibleRowCount(5);
			lstPersonList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			scrollPane = new JScrollPane(lstPersonList,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
		            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
			pnlCenter.add(scrollPane, BorderLayout.CENTER);
		} 
		else 
		{
			pnlCenter.add(new JLabel("Leider sind Fehler aufgetreten"));
			for (ErrorMessage error : logik.getErrors()) 
			{
				pnlCenter.add(new JLabel(error.getErrorMessage()));
			}
		}
		pnlCenter.revalidate();
		pnlCenter.repaint();
	}
}
