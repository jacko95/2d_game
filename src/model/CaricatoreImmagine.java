package model;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Classe che definisce il caricamento delle immagini nel gioco
 * @author Domenico
 *
 */
public class CaricatoreImmagine {

	private BufferedImage immagine;
	
	
	/**
	 * Costruttore della classe BufferedImageLoader
	 * @param path: Directory dell' immagine da caricare
	 * @return immagine: l'immagine caricata
	 */
	public BufferedImage immagineDaCaricare(String path) {
		
		try {
			immagine = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return immagine;
	}
}
