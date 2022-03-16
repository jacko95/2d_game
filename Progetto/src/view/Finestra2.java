package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Domenico
 *
 */
public class Finestra2 extends JFrame {

	private static final long serialVersionUID = 1L;
	String scritta;
	int width = 480;
	int height = 480;
	int widthLabel = 480;
	int heightLabel = 480;
	Font font = new Font("SanSerif", Font.BOLD, 60);
	
	/**
	 * Fa comparire una finestra quando si vince una partita
	 * @param scritta: stringa hai vinto
	 */
	public Finestra2(String scritta) {
		this.scritta = scritta;
		JFrame frame = new JFrame(scritta);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		frame.setLayout(new GridBagLayout());
		
		JLabel label = new JLabel(scritta, SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(widthLabel, heightLabel));
		label.setMaximumSize(new Dimension(widthLabel, heightLabel));
		label.setMinimumSize(new Dimension(widthLabel, heightLabel));
		label.setFont(font);
		frame.add(label);
		frame.getContentPane().setBackground(Color.black);
		label.setForeground(Color.GREEN);
		
	}
	
}

