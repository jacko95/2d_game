package model;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Classe che definisce l'oggetto di gioco medicina
 * @author Domenico
 *
 */
public class Medicina extends GiocoOggetto{

	private BufferedImage immagine_medicina = null;
	
	/**
	 * Costruttore della classe Medicina
	 * @param x: Coordinata x
	 * @param y: Coordinata y
	 * @param id: identificatore dell'oggetto di gioco
	 */
	public Medicina(int x, int y, ID id) {
		
		super(x, y, id);
		CaricatoreImmagine caricatore = new CaricatoreImmagine();
		immagine_medicina = caricatore.immagineDaCaricare("/medicina.png");
	}

	
	/**
	 * Definisce il movimento dell'oggetto medicina
	 */
	public void tick() {
		
	}

	
	/**
	 * Disegna una medicina a partire da un oggetto grafico in input
	 * @param g: oggetto grafico
	 */
	public void render(Graphics g) {
		g.drawImage(immagine_medicina, x, y, null);
	}

	
	/**
	 * Restituisce un nuovo rettangolo
	 * @return Un rettangolo
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
