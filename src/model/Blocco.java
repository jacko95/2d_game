package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Classe che definisce i blocchi che costituiranno il muro del gioco
 * @author Domenico
 * @version 1.0
 */
public class Blocco extends GiocoOggetto{

	private BufferedImage block_image;
	
	/**
	 * Questo è il costruttore della classe Blocco
	 * @param x: coordinata ascissa
	 * @param y: coordinata ordinate
	 * @param id: id dell'ogetto di gioco
	 */
	public Blocco(int x, int y, ID id) {
		
		super(x, y, id);
		CaricatoreImmagine caricatore = new CaricatoreImmagine();
		block_image = caricatore.immagineDaCaricare("/muro.png");
	}

	
	public void tick() {
		
	}

	/**
	 * Metodo che disegna un blocco 
	 * @param g  oggetto grafico
	 */
	public void render(Graphics g) {
		
		g.drawImage(block_image, x, y, null);
	}

	
	/**
	 * Costruisce un nuovo rettangolo
	 * @return nuovo rettangolo
	 */
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 32, 32);
	}

}
