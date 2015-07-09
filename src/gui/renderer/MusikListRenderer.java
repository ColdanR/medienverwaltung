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
			StaticComponents.setFontBorderCell_Selected(cell);			
		} else {
			StaticComponents.setFontBorderCell(cell);
		}
		return cell;
	}
}
