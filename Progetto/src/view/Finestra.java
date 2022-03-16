package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import model.Game;

/**
 * Classe che definisce la struttura della finestra di gioco
 * @author Domenico
 *
 */
public class Finestra {

	/**
	 * Crea una finestra JFrame
	 * @param width: larghezza finestra
	 * @param height: altezza finestra
	 * @param title: titolo finestra
	 * @param gioco: gioco
	 */
	public Finestra(int width, int height, String title, Game gioco) {
		
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		
		frame.add(gioco);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
