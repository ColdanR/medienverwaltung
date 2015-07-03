package gui.renderer;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import data.medien.Musik;
import gui.StaticComponents;

public class MusikListRenderer implements ListCellRenderer<Musik> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Musik> list, Musik titel, int index, 
			boolean isSelected, boolean cellHasFocus) {
		JLabel			cell	=	new JLabel();
		StringBuilder	text	=	new StringBuilder();
		text.append(titel.getInterpret().getKuenstlername());
		text.append(" - ");
		text.append(titel.getTitel());
		cell.setText(text.toString());
		if (isSelected) {
			cell.setForeground(StaticComponents.FONT_COLOR_SELECTED);
			cell.setBackground(StaticComponents.BACKGROUND_COLOR_SELECTED);
		} else {
			cell.setForeground(StaticComponents.FONT_COLOR_STD);
			cell.setBackground(StaticComponents.BACKGROUND_COLOR_STD);
		}
		
		return cell;
	}
}
