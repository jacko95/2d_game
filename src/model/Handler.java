package model;
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	public LinkedList<GiocoOggetto> object = new LinkedList<GiocoOggetto>();
	private boolean up = false, down = false, destra = false, sinistra = false;


	/**
	 * Definisce il movimento degli oggetti di gioco
	 */
	public void tick() {
		
		for(int i = 0; i < object.size(); i++) {
			GiocoOggetto tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	
	/**
	 * Renderizza, cioè genera un immagine a partire dall'oggetto grafico dato in input
	 * @param g: Oggetto grafico
	 */
	public void render(Graphics g) {
		
		for(int i = 0; i < object.size(); i++) {
			GiocoOggetto tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	
	/**
	 * Aggiunge l'oggetto di gioco passato in input
	 * @param tempObject: Oggetto di gioco
	 */
	public void addObject(GiocoOggetto tempObject) {
		
		object.add(tempObject);
	}
	
	
	/**
	 * Rimuove l'oggetto di gioco passato in input
	 * @param tempObject: Oggetto di gioco
	 */
	public void removeObject(GiocoOggetto tempObject) {
		
		object.remove(tempObject);
	}
	
	
	/**
	 * Restituisce il valore della variabile up
	 * @return up
	 */
	public boolean isUp() {
		return up;
	}


	/**
	 * Setta la variabile up data in input
	 * @param up: variabile up
	 */
	public void setUp(boolean up) {
		this.up = up;
	}

	/**
	 * Restituisce il valore della variabile down
	 * @return down: variabile down
	 */
	public boolean isDown() {
		return down;
	}


	/**
	 * Setta la variabile down data in input
	 * @param down: variabile down
	 */
	public void setDown(boolean down) {
		this.down = down;
	}


	/**
	 * Restituisce il valore della variabile destra
	 * @return destra: variabile destra
	 */
	public boolean isDestra() {
		return destra;
	}

	/**
	 * Setta la variabile destra data in input
	 * @param destra: variabile destra
	 */
	public void setDestra(boolean destra) {
		this.destra = destra;
	}

	
	/**
	 * Restituisce il valore della variabile sinistra
	 * @return sinistra: variabile sinistra
	 */
	public boolean isSinistra() {
		return sinistra;
	}


	/**
	 * Setta la variabile sinistra data in input
	 * @param sinistra: variabile sinistra
	 */
	public void setSinistra(boolean sinistra) {
		this.sinistra = sinistra;
	}
	
}
