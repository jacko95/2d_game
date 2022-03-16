package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Game.STATE;


/**
 * Classe che implementa un menu
 * @author Domenico
 * @version 1.0
 */
public class Menu extends MouseAdapter{
	
	protected Handler handler;
	
	/**
	 * Costruttore della classe Menu
	 */
	public Menu(Handler handler) {
		this.handler = handler;
	}
	
	/**
	 * Metodo che decide cosa accade ogni volta che viene premuto il mouse
	 */
	public void mousePressed(MouseEvent e) {
		int mx = e.getX(); //posizione sull asse x del mouse
		int my = e.getY(); //posizione sull asse y del mouse
		
		if(Game.gameState == STATE.Menu) {
			
			//bottone riprendi
			if(mouseOver(mx, my, 640, 350, 200, 64)) { //se il mouse è all'interno del tasto riprendi
				Game.gameState = STATE.Game;
			}
			
			//bottone aiuto
			if(mouseOver(mx, my, 640, 450, 200, 64)) { //se il mouse è all'interno del tasto aiuto
				Game.gameState = STATE.Help;	
			}
			
			//bottone esci
			if(mouseOver(mx, my, 640, 550, 200, 64)) { 
				System.exit(1);
			}
		}
		
		//bottone back in aiuto
		if(Game.gameState == STATE.Help) {
			if(mouseOver(mx, my, 640, 550, 200, 64)) { //se il mouse è all'interno del primo tasto
				Game.gameState = STATE.Menu;	
				return;
			}
		}
	}
	
	/**
	 * Metodo che decide cosa accade ogni volta che viene rilasciato un tasto del mouse
	 */
	public void mouseReleased(MouseEvent e) {
		
	}
	
	/**
	 * Metodo che tiene traccia degli spostamenti del mouse
	 */
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}
			else return false;
		}
		return false;
	}
	
	
	public void tick() {
		
	}
	
	/**
	 * Imposta la grafica del gioco
	 */
	public void render(Graphics g) {
		if(Game.gameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);

			g.setColor(Color.blue);
			g.drawRect(390, 190, 740, 500); //dimensione e posizione del rettangolo del menu
			g.fillRect(390, 190, 740, 500); //dimensione e posizione del rettangolo del menu

			g.setColor(new Color(66, 244, 179)); //si setta prima il colore
			g.drawRect(400, 200, 720, 480); //dimensione e posizione del rettangolo del menu
			g.fillRect(400, 200, 720, 480);
			
			g.setFont(fnt);
			g.setColor(Color.white); //si setta prima il colore
			g.drawString("Menu", 670, 270);
			
			//creiamo 3 bottoni/tasti
			g.setFont(fnt2);
			
			g.setColor(Color.green);
			g.fillRect(640, 350, 200, 64);
			g.setColor(Color.white);
			g.drawRect(640, 350, 200, 64); //dimensione e posizione del rettangolo del menu
			g.drawString("Riprendi", 680, 390);
			
			g.setColor(Color.gray);
			g.fillRect(640, 450, 200, 64);
			g.setColor(Color.white);
			g.drawRect(640, 450, 200, 64); //dimensione e posizione del rettangolo del menu
			g.drawString("Aiuto", 700, 490);
			
			g.setColor(Color.red);
			g.fillRect(640, 550, 200, 64);
			g.setColor(Color.white);
			g.drawRect(640, 550, 200, 64); //dimensione e posizione del rettangolo del menu
			g.setColor(Color.white);
			g.drawString("Esci", 710, 590);
		}
		
		if(Game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setColor(Color.blue);
			g.drawRect(390, 190, 740, 500); //dimensione e posizione del rettangolo del menu
			g.fillRect(390, 190, 740, 500); //dimensione e posizione del rettangolo del menu

			g.setColor(new Color(66, 244, 179)); //si setta prima il colore
			g.drawRect(400, 200, 720, 480); //dimensione e posizione del rettangolo del menu
			g.fillRect(400, 200, 720, 480);
			
			
			g.setFont(fnt);
			g.setColor(Color.white); //si setta prima il colore
			g.drawString("Istruzioni", 630, 270);

			g.setFont(fnt3);
			g.drawString("Usa le frecce per muovere il giocatore e raccogliere tutte le scatole,", 430, 400);	
			g.drawString("evitando i nemici", 660, 450);			
			
			g.setFont(fnt2);
			g.setColor(Color.orange);
			g.fillRect(640, 550, 200, 64);
			g.setColor(Color.white);
			g.drawRect(640, 550, 200, 64); //dimensione e posizione del rettangolo del menu
			g.drawString("Indietro", 685, 590);
		}		
	}
	
}
