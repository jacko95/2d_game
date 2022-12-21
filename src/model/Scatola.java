package model;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Classe che definisce l'oggetto di gioco scatola
 * @author Domenico
 *
 */
public class Scatola extends GiocoOggetto{

	private BufferedImage immagine_scatola = null;
	
	/**
	 * Costruttore della classe Scatola
	 * @param x: Coordinata x
	 * @param y: Coordinata y
	 * @param id: identificatore dell'oggetto di gioco
	 */
	public Scatola(int x, int y, ID id) {
		
		super(x, y, id);
		CaricatoreImmagine caricatore = new CaricatoreImmagine();
		immagine_scatola = caricatore.immagineDaCaricare("/scatola.png");
	}

	
	/**
	 * Definisce il movimento dell'oggetto scatola
	 */
	public void tick() {
		
	}

	
	/**
	 * Disegna una scatola a partire da un oggetto grafico in input
	 * @param g: oggetto grafico
	 */
	public void render(Graphics g) {
		g.drawImage(immagine_scatola, x, y, null);
	}

	
	/**
	 * Restituisce un nuovo rettangolo
	 * @return Un rettangolo
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
