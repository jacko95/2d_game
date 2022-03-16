package model;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Classe che definisce l'oggetto di gioco Nemico
 * @author Domenico
 */
public class Nemico extends GiocoOggetto{
	
	private Handler handler;
	Random caso = new Random();
	int scelto = 0;
	private BufferedImage immagine_nemico;

	
	/**
	 * Costruttore della classe Nemico
	 * @param x: Coordinata x
	 * @param y: Coordinata y
	 * @param id: id dell'oggetto di gioco
	 * @param handler: handler del gioco
	 */
	public Nemico(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		CaricatoreImmagine caricatore = new CaricatoreImmagine();
		immagine_nemico = caricatore.immagineDaCaricare("/nemico.png");
	}

	
	/**
	 * Definisce il movimento del nemico
	 */
	public void tick() {
		x += velX;
		y += velY;
		
		scelto = caso.nextInt(10);
	
		for(int i = 0; i < handler.object.size(); i++) {
			GiocoOggetto tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Blocco) {
				if(getBoundsBig().intersects(tempObject.getBounds())) {
					x += velX*-5;
					y += velY*-5;
					velX *= -1;
					velY *= -1;
				}else if(scelto == 0) {
					   	velX = (caso.nextInt(8) - 4);
						velY = (caso.nextInt(8) - 4);
				}
			}
		}	
	}
	
	
	/**
	 * Crea il nemioìco a partire da un oggetto grafico
	 * @param g: oggetto grafico
	 */
	public void render(Graphics g) {
		
		g.drawImage(immagine_nemico, x, y, null);
	}

	
	/**
	 * Restituisce un nuovo rettangolo
	 * @return Un rettangolo
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	
	/**
	 * Restituisce un nuovo rettangolo
	 * @return Un rettangolo
	 */
	public Rectangle getBoundsBig() {
		return new Rectangle(x-16, y-16, 64, 64);
	}
}
