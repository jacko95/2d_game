package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.GiocoOggetto;
import model.Handler;
import model.ID;
import model.Game;
import model.Game.STATE;

/**
 * Classe che definisce i comandi di gioco
 * @author Domenico
 *
 */
public class KeyInput extends KeyAdapter{

	Game game;
	Handler handler;
	
	/**
	 * Costruttore della classe KeyInput
	 * @param handler: handler del gioco
	 */
	public KeyInput(Game game, Handler handler) {
		
		this.game = game;
		this.handler = handler;
	}
	
	
	/**
	 * Definisce cosa avviene quando viene premuto un comando
	 */
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GiocoOggetto tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Giocatore) {
				if(key == KeyEvent.VK_UP) handler.setUp(true);
				if(key == KeyEvent.VK_DOWN) handler.setDown(true);
				if(key == KeyEvent.VK_LEFT) handler.setSinistra(true);
				if(key == KeyEvent.VK_RIGHT) handler.setDestra(true);
			}
			if(key == KeyEvent.VK_ESCAPE) {
				Game.gameState = STATE.Menu;
			}
		}	
	}
	
	
	/**
	 * Definisce cosa avviene quando viene rilasciato un comando
	 */
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GiocoOggetto tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Giocatore) {
				if(key == KeyEvent.VK_UP) handler.setUp(false);
				if(key == KeyEvent.VK_DOWN) handler.setDown(false);
				if(key == KeyEvent.VK_LEFT) handler.setSinistra(false);
				if(key == KeyEvent.VK_RIGHT) handler.setDestra(false);
			}
		}
	}
}
