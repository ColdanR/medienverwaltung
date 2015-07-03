/**
 * 
 */
package gui;

import java.awt.Dialog.ModalityType;
import java.awt.Window;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * @author User
 *
 */
public abstract class ReturningDialog<E> implements ActionListener {
	private		Window	parent;
	protected	JDialog	dialog;
	private		E		object;
	private		String	title;
	private		int		width;
	private		int		height;

	public ReturningDialog (Window parent, String title, int width, int height) {
		this.parent	=	parent;
		this.title	=	title;
		this.width	=	width;
		this.height	=	height;
	}
	
	/**
	 * Method to create the Content of the Dialog
	 * @return
	 */
	protected abstract JPanel createDialogContent();
	
    /**
     * Creates the dialog and displays it. Resize is set to false.
     * @param title Title of the Dialog
     * @param width width of the Dialog
     * @param height height of the Dialog
     */
    public final void display() {
        dialog = new JDialog(parent, title, ModalityType.APPLICATION_MODAL);
        dialog.setSize(width, height);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane(createDialogContent());
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    };
    
    /**
     * Sets the returning object
     * @param object object to return
     */
    protected final void setObject(E object) {
    	this.object = object;
    }
    
    /**
     * Returns the object
     * @return
     */
    public final E getObject() {
        return object;
    }
}
