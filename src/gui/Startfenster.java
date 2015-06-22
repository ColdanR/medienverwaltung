package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Component;

public class Startfenster extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	Container cp;

	public Startfenster()							
	{
		super("Medien Verwaltung");
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
				
		ButtonPanel buttonPanel = new ButtonPanel();
		cp.add(buttonPanel, BorderLayout.WEST);
		
		
		InputPanel input = new InputPanel();
		input.setAlignmentY(Component.TOP_ALIGNMENT);
		cp.add(input, BorderLayout.CENTER);
				
	}
	

	public static void main(String[] args) 
	{
		Startfenster mv = new Startfenster();
		mv.pack();
		mv.setVisible(true);
		mv.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mv.setLocationRelativeTo(null);
		mv.setResizable(false);
		
	

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// XXX Hallo!
		
	}

}
