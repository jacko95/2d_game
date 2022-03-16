package model;
/**
 * Classe che definisce la camera che segue l'oggetto giocatore
 * @author Domenico
 *
 */
public class Camera {

	private float x, y;
	
	/**
	 * Costruttore della classe Camera
	 * @param x: coordinata
	 * @param y: coordinata
	 */
	public Camera(float x, float y) {
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Regola la camera
	 * @param object: oggetto di gioco
	 */
	public void tick(GiocoOggetto object) {
		
		x += ((object.getX() - x) - 1920/2) * 0.05;
		y += ((object.getY() - y) - 1080/2) * 0.05;
		
		if(x <= 0) x = 0;
		if(x >= 1920) x = 1920;
		if(y <= 0) y = 0;
		if(y >= 1080) y = 1080;

	}


	/**
	 * Restituisce la coordinata x dell'oggetto di gioco
	 * @return x: coordinata
	 */
	public float getX() {
		return x;
	}


	/**
	 * Setta la coordinata x dell'oggetto di gioco
	 * @param x: coordinata
	 */
	public void setX(float x) {
		this.x = x;
	}


	/**
	 * Restituisce la coordinata y dell'oggetto di gioco
	 * @return y: coordinata
	 */
	public float getY() {
		return y;
	}


	/**
	 * Setta la coordinata y dell'oggetto di gioco
	 * @param y: coordinata
	 */
	public void setY(float y) {
		this.y = y;
	}
}
