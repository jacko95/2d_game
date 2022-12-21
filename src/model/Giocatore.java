package model;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Classe che definisce il giocatore
 * @author Domenico
 *
 */
public class Giocatore extends GiocoOggetto{
	
	Handler handler;
	Game gioco;
	private BufferedImage immagine_mago;
	public static int puntiVita = 100;//vita
	static int scatole; //ho modificato, occio, se va in errore...
	static int medicine;
	

	/**
	 * Costruttore della classe Mago
	 * @param x : coordinata
	 * @param y : coordinata
	 * @param id : id giocatore
	 * @param handler : handler
	 * @param gioco : oggetto di tipo Game
	 */
	public Giocatore(int x, int y, ID id, Handler handler, Game gioco) {
		
		super(x, y, id);
		this.handler = handler;
		this.gioco = gioco;
		CaricatoreImmagine caricatore = new CaricatoreImmagine();
		
		immagine_mago = caricatore.immagineDaCaricare("/mago.png");
	}

	
	/**
	 * Definisce il movimento del giocatore
	 */
	public void tick() {
		
		x += velX;
		y += velY;
		
		collision();

		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isDestra()) velX = 5;
		else if(!handler.isSinistra()) velX = 0;
		
		if(handler.isSinistra()) velX = -5;
		else if(!handler.isDestra()) velX = 0;
				
	}

	
	/**
	 * Definisce cosa accade quando degli oggetti di gioco interagiscono con il giocatore
	 */
	private void collision() {
		
		view.Finestra1 x1;
		view.Finestra2 x2;
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GiocoOggetto tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Blocco) {
				if(getBounds().intersects(tempObject.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
			
			if(tempObject.getId() == ID.Scatola) {
				if(getBounds().intersects(tempObject.getBounds())) {
					scatole--;
					handler.removeObject(tempObject);
					if(scatole == 0) {
						x2 = new view.Finestra2("Hai vinto");
						x2.setVisible(true);
						try {
							Thread.sleep(99999999);
							System.exit(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			if(tempObject.getId() == ID.Medicina) {
				if(getBounds().intersects(tempObject.getBounds())) {
					medicine--;
					puntiVita += 20;
					if(puntiVita >= 100)
						puntiVita = 100;
					handler.removeObject(tempObject);
				}
			}
			
			if(tempObject.getId() == ID.Nemico) {
				if(getBounds().intersects(tempObject.getBounds())) {
					puntiVita = puntiVita - 2;//sottrazione punti vita ogni volta che il mago tocca i nemici
					if(puntiVita <= 0) {
						puntiVita = 0;	
						x1 = new view.Finestra1("Hai perso");
						x1.setVisible(true);
						try {
							Thread.sleep(99999999);
							System.exit(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * Renderizza, cioè genera il giocatore a partire dall'oggetto grafico dato in input
	 */
	public void render(Graphics g) {
		
		g.drawImage(immagine_mago, x, y, null);
	}

	
	/**
	 * Restituisce un nuovo rettangolo
	 * @return Un rettangolo
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}

}
