package gui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import data.Person;
import data.logic.PersonLogik;
import enums.ErrorMessage;
import enums.ErrorsGUI;
import gui.ReturningDialog;
import gui.StaticComponents;
import gui.renderer.PersonListRenderer;

public class PersonAuswahlDialog extends ReturningDialog<Person> {
	JButton			btnSelectButton;
	JButton			btnCancelButton;
	JButton			btnAddButton;
	JList<Person>	listPersonen;


	public PersonAuswahlDialog(Window parent) 
	{
		super(parent, "Person ausw\u00E4hlen", 600, 400);
		createDialogContent();
		
	}

	@Override
	public void actionPerformed(ActionEvent a) 
	{
		if (a.getSource() == btnSelectButton) 
		{
			if (listPersonen.isSelectionEmpty()) 
			{
				List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
				errors.add(ErrorsGUI.NoSelection);
				JDialog	errorDialog = new FehlerDialog(dialog, errors);
				errorDialog.setVisible(true);
			} 
			else 
			{
				setObject(listPersonen.getSelectedValue());
				dialog.dispose();
			}
		} 
		else if (a.getSource() == btnCancelButton) 
		{
			dialog.dispose();
		} 
		else if (a.getSource() == btnAddButton) 
		{
			PersonEingabeDialog newDialog = new PersonEingabeDialog(dialog);
			newDialog.display();
			if (newDialog.getObject() != null) 
			{
				setObject(newDialog.getObject());
				dialog.dispose();
			}
		}
	}

	@Override
	protected JPanel createDialogContent() {
		
		// Creating MainPanel and Subpanels
		JPanel	pnlDisplay	=	new JPanel(new BorderLayout());
		JPanel 	pnlNorth	=	new JPanel();
		JPanel	pnlSouth	=	new JPanel();
		JPanel	pnlCenter	=	new JPanel(new BorderLayout());
		
		
		pnlNorth.setBorder(StaticComponents.BORDER_PANEL);
		pnlCenter.setBorder(new CompoundBorder(new MatteBorder(0, 1, 0, 1, StaticComponents.BORDER_COLOR), 
											   new EmptyBorder(10, 10, 10, 10)));
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
		pnlSouth.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		pnlDisplay.add(pnlNorth, BorderLayout.NORTH);
		pnlDisplay.add(pnlCenter, BorderLayout.CENTER);
		pnlDisplay.add(pnlSouth, BorderLayout.SOUTH);
		
		// Header
		JLabel 	titel =	new JLabel("Interpret");
		titel.setFont(StaticComponents.FONT_TITLE);
		pnlNorth.add(titel);
		
		// Main
		PersonLogik		logik		=	new PersonLogik();
		List<Person>	listData	=	logik.getAll();
		
				
		if (logik.getErrors().isEmpty()) 
		{
			listPersonen = new JList<Person>(listData.toArray(new Person[]{}));
			listPersonen.setCellRenderer(new PersonListRenderer());
			listPersonen.setVisibleRowCount(5);
			listPersonen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			JScrollPane scrollPane = new JScrollPane(listPersonen, 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
		            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			pnlCenter.add(scrollPane);
		} 
		else 
		{
			pnlCenter.add(new JLabel("Es sind Fehler aufgetreten"));
			for (ErrorMessage error : logik.getErrors()) 
			{
				pnlCenter.add(new JLabel(error.getErrorMessage()));
			}
		}
		
		// Buttons
		
		btnAddButton = new JButton("Neuanlage");
		btnAddButton.setFont(StaticComponents.FONT_BUTTON);

		pnlSouth.add(btnAddButton);
		if (listPersonen != null) 
		{
			btnSelectButton = new JButton("Ausw\u00E4hlen");
			btnSelectButton.setFont(StaticComponents.FONT_BUTTON);

			pnlSouth.add(btnSelectButton);
		}
		btnCancelButton = new JButton("Abbrechen");
		btnCancelButton.setFont(StaticComponents.FONT_BUTTON);

		pnlSouth.add(btnCancelButton);
		
		// Eventhandler
		btnAddButton.addActionListener(this);
		if (btnSelectButton != null) 
		{
			btnSelectButton.addActionListener(this);
		}
		btnCancelButton.addActionListener(this);
		
		return pnlDisplay;
	}
}
