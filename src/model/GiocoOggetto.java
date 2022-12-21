package model;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Classe astratta che definisce la struttura degli oggetti di gioco
 * @author Domenico
 */
public abstract class GiocoOggetto {

	protected int x, y;
	protected float velX = 0, velY = 0;
	protected ID id;
	
	
	/**
	 * Costruttore della classe GameObject
	 * @param x: coordinata 
	 * @param y: coordinata 
	 * @param id: Tipo di oggetto di gioco
	 */
	public GiocoOggetto(int x, int y, ID id) {
		
		this.x = x;
		this.y = y;
		this.id = id;
	}


	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	
	/**
	 * Restituisce il tipo di oggetto di gioco
	 * @return id: identificatore oggetto di gioco
	 */
	public ID getId() {
		return id;
	}

	
	/**
	 * Setta il tipo di oggetto di gioco
	 * @param id: identificatore oggetto di gioco
	 */
	public void setId(ID id) {
		this.id = id;
	}
	
	
	/**
	 * Restituisce la coordinata x dell'oggetto di gioco
	 * @return x: coordinata
	 */
	public int getX() {
		return x;
	}


	/**
	 * Setta la coordinata x dell'oggetto di gioco
	 * @param x: coordinata
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * Restituisce la coordinata y dell'oggetto di gioco
	 * @return y: coordinata
	 */
	public int getY() {
		return y;
	}


	/**
	 * Setta la coordinata y dell'oggetto di gioco
	 * @param y: coordinata
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * Restituisce la velocità sull'asse delle x dell'oggetto di gioco
	 * @return velX: velocità sulla coordinata x
	 */
	public float getVelX() {
		return velX;
	}


	/**
	 * Setta la velocità sull'asse delle x dell'oggetto di gioco
	 * @param velX: velocità sulla coordinata x
	 */
	public void setVelX(float velX) {
		this.velX = velX;
	}


	/**
	 * Restituisce la velocità sull'asse delle y dell'oggetto di gioco
	 * @return velY: velocità sulla coordinata ys
	 */
	public float getVelY() {
		return velY;
	}


	/**
	 * Setta la velocità sull'asse delle y dell'oggetto di gioco
	 * @param velY: velocità sulla coordinata Y
	 */
	public void setVelY(float velY) {
		this.velY = velY;
	} 
	
}
