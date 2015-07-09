package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class StaticComponents {
	public	static	Font 		FONT_STD					=	new Font("Arial", Font.PLAIN, 12);
	public	static	Font		FONT_BOLD					=	new Font("Arial", Font.BOLD, 12);
	
	public	static 	Font		FONT_TITLE					=	new Font("Arial", Font.BOLD, 16);
	public	static 	Font		FONT_LABEL					=	new Font("Arial", Font.BOLD, 12);
	public	static 	Font		FONT_TEXTFIELD				=	new Font("Arial", Font.PLAIN, 14);
	public	static 	Font		FONT_BUTTON					=	new Font("Arial", Font.BOLD, 12);
	
	
	
	public	static	Color		FONT_COLOR_STD				=	Color.BLACK;
	public	static	Color		FONT_COLOR_LABEL			=	Color.DARK_GRAY;
	public	static	Color		FONT_COLOR_SELECTED			=	Color.LIGHT_GRAY;
	
	public	static	Color		BACKGROUND_COLOR_STD		=	Color.WHITE;
	public	static	Color		BACKGROUND_COLOR_SELECTED	=	Color.BLUE;
	
	public	static	Color		BORDER_COLOR				=	Color.LIGHT_GRAY;
	
	public	static	LineBorder	BORDER_PANEL				=	new LineBorder(BORDER_COLOR);
	public	static	LineBorder	BORDER_TEXTFIELDS_STD		=	new LineBorder(BORDER_COLOR);
	public	static	EmptyBorder	BORDER_EMPTY_BORDER 		= 	new EmptyBorder(2, 4, 2, 4);
	
	public	static	Dimension	MAIN_PANEL					=	new Dimension(600, 400);
		
	
	public	static	void 	setFontLabel(JLabel x)	{
		x.setFont(StaticComponents.FONT_LABEL);
		x.setForeground(StaticComponents.FONT_COLOR_LABEL);
	}
	
	public	static	void 	setFontLabelRed(JLabel x) {
		x.setFont(StaticComponents.FONT_LABEL);
		x.setForeground(Color.RED);
	}

	public	static	void 	setFontLabel(JCheckBox x) {
		x.setFont(FONT_LABEL);
		x.setForeground(FONT_COLOR_LABEL);
				
	}
	
	public	static	void	setFontBorderTextField (JTextField x)	{
		x.setFont(FONT_TEXTFIELD);
		x.setBorder(new CompoundBorder(BORDER_PANEL, BORDER_EMPTY_BORDER));
	}
	
	public	static	void	setFontBorderLabel (JLabel x)	{
		x.setFont(FONT_TEXTFIELD);
		x.setForeground(FONT_COLOR_LABEL);
		x.setBorder(new CompoundBorder(BORDER_TEXTFIELDS_STD, BORDER_EMPTY_BORDER));
	}
	public	static	void	setFontBorderCell (JLabel x)	{
		x.setFont(FONT_TEXTFIELD);
		x.setForeground(FONT_COLOR_STD);
		x.setOpaque(true);
		x.setBackground(BACKGROUND_COLOR_STD);
		x.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY),BORDER_EMPTY_BORDER));
	}
	public	static	void	setFontBorderCell_Selected (JLabel x)	{
		x.setFont(FONT_TEXTFIELD);
		x.setForeground(FONT_COLOR_SELECTED);
		x.setOpaque(true);
		x.setBackground(BACKGROUND_COLOR_SELECTED);
		x.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY),BORDER_EMPTY_BORDER));
	}
	

}
