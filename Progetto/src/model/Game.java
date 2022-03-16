package model;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import model.Menu;


/**
 * Classe che implementa un nuovo gioco
 * @author Domenico
 * @version 1.0
 */
public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private boolean isRunning = false;
	public static boolean paused = false;
	private Thread thread;
	private Handler handler;
	int frames = 0;

	private BufferedImage livello = null;
	private BufferedImage pavimento_immagine = null;	
	
	private Camera camera;

	private Menu menu;

	public enum STATE {
		Menu,
		Help,
		Game
	};
	
	static public STATE gameState; //se si cambia in STATE.menu compare il menu; se si setta a STATE.game compare il gioco

	/**
	 * Costruttore della classe gioco
	 */
	public Game() {
		
		new view.Finestra(1920, 1080, "Il Labirinto", this);
		start();
		
		handler = new Handler();
		menu = new Menu(/*this,*/ handler);
		camera = new Camera(0, 0);
		this.addKeyListener(new controller.KeyInput(this, handler));
		this.addMouseListener(menu);
		

		CaricatoreImmagine loader = new CaricatoreImmagine();
		livello = loader.immagineDaCaricare("/livello.png");
		pavimento_immagine = loader.immagineDaCaricare("/blocco.png");//stabiliamo la sottoimmagine da associare al pavimento
			
		gameState = STATE.Game;
		
		if(gameState == STATE.Game) {
			loadLevel(livello);
		}
	}
	
	
	/**
	 * Crea e avvia il thread del gioco
	 */
	void start() {
		
		isRunning = true;
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	
	/**
	 * Attende che il thread del gioco termini
	 */
	void stop() {
		
		isRunning = false;
		try {
			thread.join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Definisce e regola il ciclo di gioco
	 */
	public void run() {
		
		this.requestFocus();
		this.transferFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;				   
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}
	
	
	/**
	 * Regola lo spostamento della camera in modo da seguire il giocatore
	 */
	public void tick() {
		if(gameState  == STATE.Menu) {
			menu.tick();
		}
		if(gameState == STATE.Game) {
			if(!paused) {
				handler.tick();
				for(int i = 0; i < handler.object.size(); i++) {
					if(handler.object.get(i).getId() == ID.Giocatore) {
						camera.tick(handler.object.get(i));
					}
				}
			}
		}
	}
	
	
	/**
	 * Imposta la grafica del gioco
	 */
	public void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.translate(-camera.getX(), -camera.getY());
		
		for(int xx = 0; xx < 30*72; xx+=32) {
			for(int yy = 0; yy < 30*72; yy+=32) {
				g.drawImage(pavimento_immagine, xx, yy, null);
			}
		}
		
		handler.render(g);
		
		g2d.translate(camera.getX(), camera.getY());

		if(gameState == STATE.Game) {
			Font fnt = new Font("arial black", Font.BOLD, 20);
			g.setFont(fnt);

			//barra della vita
			g.setColor(Color.GRAY);
			g.fillRect(5, 5, 200, 32);
			g.setColor(Color.green);
			g.fillRect(5, 5, Giocatore.puntiVita*2, 32);
			//cornice della barra della vita
			g.setColor(Color.white);
			g.drawRect(5, 5, 200, 32);
			
			//barra delle scatole
			g.setColor(Color.GRAY);
			g.fillRect(5, 50, 200, 32);
			g.setColor(new Color(138, 102, 66));
			g.fillRect(5, 50, Giocatore.scatole*10, 32);
			//cornice della barra delle scatole
			g.setColor(Color.white);
			g.drawRect(5, 50, 200, 32);
			
			//barra delle medicine
			g.setColor(Color.GRAY);
			g.fillRect(5, 95, 200, 32);
			g.setColor(Color.blue);
			g.fillRect(5, 95, Giocatore.medicine*50, 32);
			//cornice della barra delle scatole
			g.setColor(Color.white);
			g.drawRect(5, 95, 200, 32);
			
			//scritte delle barre
			g.setColor(Color.white);
			g.drawString("Salute " + Giocatore.puntiVita, 40, 30);
			g.drawString("Scatole " + Giocatore.scatole, 40, 75);
			g.drawString("Medicine " + Giocatore.medicine, 40, 120);
		}
		
		if(gameState == STATE.Menu || gameState == STATE.Help) {
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	
	/**
	 * Carica il livello di gioco partendo da un immagine in input
	 * @param immagine: carica l'immagine del livello di gioco
	 */
	private void loadLevel(BufferedImage immagine) {
		
		int w = immagine.getWidth();
		int h = immagine.getHeight();
		
		for(int xx = 0; xx < w; xx++) {
			for(int yy = 0; yy < h; yy++) {
				int pixel = immagine.getRGB(xx, yy);
				int rosso = (pixel >> 16) & 0xff;
				int verde = (pixel >> 8) & 0xff;
				int blu = (pixel) & 0xff;

				if(rosso == 255 && verde == 0 && blu == 0)
					handler.addObject(new Blocco(xx*32, yy*32, ID.Blocco));
				if(blu == 255 && verde == 0)
					handler.addObject(new Giocatore(xx*32, yy*32, ID.Giocatore, handler, this));
				if(verde == 255 && blu == 0)
					handler.addObject(new Nemico(xx*32, yy*32, ID.Nemico, handler));
				if(verde == 255 && blu == 255 && rosso == 0) {
					handler.addObject(new Scatola(xx*32, yy*32, ID.Scatola));
					Giocatore.scatole++;
				}
				if(verde == 255 && blu == 255 && rosso == 255) {
					handler.addObject(new Medicina(xx*32, yy*32, ID.Medicina));
					Giocatore.medicine++;
				}
			}
		}
	}
	

	/**
	 * Main della classe Game
	 * @param args: argomenti da linea di comando
	 */
	public static void main(String[] args) {
		
		new Game(); 
	}

}
