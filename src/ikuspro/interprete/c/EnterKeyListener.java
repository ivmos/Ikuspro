package ikuspro.interprete.c;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JDialog;

/**
 * 
 * @author Iván Mosquera Paulo
 * 
 * Esta clase la utiliza el interprete para que manejar el enter en la entrada estándar
 */
public class EnterKeyListener implements KeyListener {
	
	private JDialog dialogo;

	public EnterKeyListener(JDialog pDialogo) {
		dialogo = pDialogo;
	}

	@Override
	public void keyPressed(KeyEvent pE) {
		if (pE.getKeyCode() == KeyEvent.VK_ENTER) {
			dialogo.dispose();
		}

	}

	@Override
	public void keyReleased(KeyEvent pE) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent pE) {
		// TODO Auto-generated method stub

	}

}
