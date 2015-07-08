package gui.renderer;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import data.SpeicherFormatInterface;
import data.speicherformate.DigitalMusik;
import gui.StaticComponents;

public class SpeicherortListRenderer implements ListCellRenderer<SpeicherFormatInterface> {

	@Override
	public Component getListCellRendererComponent(JList<? extends SpeicherFormatInterface> list, SpeicherFormatInterface value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JLabel cell = new JLabel();
		switch (value.getType()) {
		case DigitalMusik:
			if (value instanceof DigitalMusik) {
				DigitalMusik element = (DigitalMusik) value;
				StringBuilder builder = new StringBuilder();
				builder.append(element.getDatentraeger());
				builder.append(" - ");
				builder.append(element.getPfad());
				cell.setText(builder.toString());
			}
			break;
		default:
			throw new UnsupportedOperationException();
		}
		
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
