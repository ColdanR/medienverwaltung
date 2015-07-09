package gui.renderer;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import data.Person;
import gui.StaticComponents;

public class PersonListRenderer implements ListCellRenderer<Person> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Person> list, Person person, int index, 
			boolean isSelected, boolean cellHasFocus) {
		JLabel			cell	=	new JLabel();
		StringBuilder	text	=	new StringBuilder();
		text.append(person.getKuenstlername());
		if (hasNachname(person) || hasVorname(person)) {
			text.append(" (");
			if (hasNachname(person)) {
				text.append(person.getNachname());
			}
			if (hasNachname(person) && hasVorname(person)) {
				text.append(", ");
			}
			if (hasVorname(person)) {
				text.append(person.getVorname());
			}
			text.append(")");
		}
		cell.setText(text.toString());
		if (isSelected) {
			StaticComponents.setFontBorderCell_Selected(cell);			
		} else {
			StaticComponents.setFontBorderCell(cell);
		}
		return cell;
	}
	
	private boolean hasNachname(Person person) {
		return person.getNachname() != null && !person.getNachname().isEmpty();
	}
	
	private boolean hasVorname(Person person) {
		return person.getVorname() != null && !person.getVorname().isEmpty();
	}
}
