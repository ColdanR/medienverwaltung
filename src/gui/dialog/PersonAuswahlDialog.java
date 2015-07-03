package gui.dialog;

import java.awt.BorderLayout;
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

import data.Person;
import data.logic.PersonLogik;
import enums.ErrorMessage;
import enums.ErrorsGUI;
import gui.ReturningDialog;
import gui.renderer.PersonListRenderer;

public class PersonAuswahlDialog extends ReturningDialog<Person> {
	JButton			btnSelectButton;
	JButton			btnCancelButton;
	JButton			btnAddButton;
	JList<Person>	listPersonen;


	public PersonAuswahlDialog(Window parent) 
	{
		super(parent, "Person auswählen", 600, 400);
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
		JPanel	display	=	new JPanel(new BorderLayout());
		JPanel	buttons	=	new JPanel();
		JPanel	main	=	new JPanel(new GridLayout(0, 1));
		display.add(main, BorderLayout.CENTER);
		display.add(buttons, BorderLayout.SOUTH);
		
		// Main
		PersonLogik		logik		=	new PersonLogik();
		List<Person>	listData	=	logik.getAll();
		
		listPersonen = new JList<Person>(listData.toArray(new Person[]{}));
		listPersonen.setCellRenderer(new PersonListRenderer());
		main.add(listPersonen);
		
		if (logik.getErrors().isEmpty()) 
		{
			listPersonen = new JList<Person>(listData.toArray(new Person[]{}));
			listPersonen.setCellRenderer(new PersonListRenderer());
			main.add(listPersonen);
		} 
		else 
		{
			main.add(new JLabel("Leider sind Fehler aufgetreten"));
			for (ErrorMessage error : logik.getErrors()) 
			{
				main.add(new JLabel(error.getErrorMessage()));
			}
		}
		
		// Buttons
		btnAddButton = new JButton("Neuanlage");
		buttons.add(btnAddButton);
		if (listPersonen != null) 
		{
			btnSelectButton = new JButton("Auswählen");
			buttons.add(btnSelectButton);
		}
		btnCancelButton = new JButton("Abbrechen");
		buttons.add(btnCancelButton);
		
		// Eventhandler
		btnAddButton.addActionListener(this);
		if (btnSelectButton != null) 
		{
			btnSelectButton.addActionListener(this);
		}
		btnCancelButton.addActionListener(this);
		
		return display;
	}
}
