package gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;

public class Startfenster extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	Container cp;
	private JTextField textField;
		
	
	public Startfenster()							
	{
		
		
		
		super("Medien Verwaltung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JSplitPane splitPane = new JSplitPane();
		cp.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		EingabePanel eingabe = new EingabePanel();
		splitPane.setRightComponent(eingabe);
		//panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		
	}
	

	public static void main(String[] args) 
	{
		Startfenster mv = new Startfenster();
		mv.setSize(500,500);
		mv.setVisible(true);
		
	

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
