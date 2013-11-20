/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.lang.System;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;

/**
 *
 * @author Owner
 */
@SuppressWarnings("serial")
public class JFrameQuack extends JFrame implements Runnable, MouseListener, KeyListener {
	
	public static final int WIDTH = 800; //Constante del ancho del JFrame
	public static final int HEIGHT = 600; //Constante de la altura del JFrame
	/** TODO: Se usa esto? */
	public static final double TIEMPO = 0.016; //Constante de tiempo
	
	private Image dbImage; 
	private Graphics dbg; 
	
	private Jugador pato;
	private LinkedList<Basura> basuras;
	private Bote boteAluminio;
	
	private TileMapRenderer mapRenderer;
	
	private TileMap map;
	
	private ArrayList<Image> tiles;
	
	Image fondo = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/fondo.png"));
	Image lataIcon = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/basuraAluminio.png"));
	Image patoImagen = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaIzq1.png"));

	public JFrameQuack() {
		addMouseListener(this);
		addKeyListener(this);
		
		setSize(WIDTH,HEIGHT); 
		setBackground(Color.white);
		
		Image basuraAluminio = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/basuraAluminio.png"));
					
		Image boteAlum = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/boteAluminio.png"));
		
		
		pato = new Jugador(300, 500, patoImagen);
		
		pato.setVelocidadY(10);
		
		basuras = new LinkedList<Basura>();
		
		boteAluminio = new Bote(40, 500, boteAlum, 2);		
		
		mapRenderer = new TileMapRenderer();
		mapRenderer.setBackground(fondo);
		
		
		for(int i=0; i<8; i++){
			Basura aux;
			int auxPosX = 64*i + 200;
			int auxPosY = 460;
					
			aux = new Basura(auxPosX, auxPosY, basuraAluminio, 2);
			basuras.add(aux);
		}
		
		loadTileImages();
		
		try{
			map = loadMap("maps/nivel.txt");
		}catch(IOException eo){
			System.out.println("error al leer mapa");
		}
		
	
		
		// Declaras un hilo
		Thread th = new Thread(this);
		// Empieza el hilo
		th.start();
		
	}
	
	public void actualiza(){
		if(pato.getLadoPato()){
			if(pato.getCaminaPato()){
				pato.setVelocidadX(5);
				pato.brillaPatoCaminaDer();
			}
			else{
				pato.setVelocidadX(0);
				pato.brillaPatoParadoDer();
			}
		}
		else{
			if(pato.getCaminaPato()){
				pato.setVelocidadX(-5);
				pato.brillaPatoCaminaIzq();
			}
			else{
				pato.setVelocidadX(0);
				pato.brillaPatoParadoIzq();
			}
		}
		
		if(pato.getSaltoPato()){
			pato.setVelocidadY(-8);
			pato.setSaltoPato(false);
			System.out.println("salto");
		}
		
		
		pato.setVelocidadY(pato.getVelocidadY()+0.2);
			
			
		
		
		
		checaColision();
	}
	
	public void colisionPatoBasura(){
		for(int i=0; i<basuras.size(); i++){
			Basura aux = (Basura) basuras.get(i);
			
			if(pato.intersecta(aux)){
				pato.recogerBasura(aux);
				basuras.remove(i);
				return;
			}
		}
	}
	
	public void colisionPatoBote(){
		if(pato.intersecta(boteAluminio)){
			boteAluminio.recibirBasura(pato);
		}
	}
	
	/* Checa las colisiones con los tiles y actualiza las posiciones del pato */
	public void checaColision(){
	
		//boolean auxAterrizado = false;
		
		/* Checamos colisiones con los tiles en horizontal */
		double oldX = pato.getPosX();
		double newX = oldX + pato.getVelocidadX();
		Point tile = getTileCollision(pato, newX, pato.getPosY());
		if (tile == null) {
			
			pato.setDoublePosX(newX);
		}
		// si hay colision, dependiendo de si el pato se esta moviendo o no, ajustamos su posicion
		else {
			// si se mueve a la derecha, lo alineamos al borde izquierdo del tile
			if (pato.getVelocidadX() > 0) {
				pato.setPosX(TileMapRenderer.tilesToPixels(tile.x) - pato.getAncho());
			}
			// si se mueve a la izquierda, lo alineamos al tile de la derecha (que es igual al borde derecho del tile)
			else if (pato.getVelocidadX() < 0) {
				pato.setPosX(TileMapRenderer.tilesToPixels(tile.x + 1));
			}
			// apagamos su velocidad horizontal
			pato.setVelocidadX(0);
		}

		/* Checamos colisiones con los tiles en vertical */
		double oldY = pato.getPosY();
		double newY = oldY + pato.getVelocidadY();
			 tile = getTileCollision(pato, pato.getPosX(), newY);
		if (tile == null) {
			pato.setDoublePosY(newY);
		}
		// si hay colision, dependiendo de si el pato se esta moviendo o no, ajustamos su posicion
		else {
			// si esta cayendo (se mueve hacia abajo), lo ajustamos al borde superior del tile y avisamos que acaba de aterrizar
			if (pato.getVelocidadY() > 0) {
				pato.setPosY(TileMapRenderer.tilesToPixels(tile.y) - pato.getAlto());
				pato.setAterrizadoPato(true);
				//auxAterrizado = true;
				pato.setVelocidadY(0);
				System.out.println("aterrizo");
			}
			// si esta saltando (se mueve hacia arriba), lo alineamos al tile de abajo (que equivale a alinearlo con el borde inferior)
			else if (pato.getVelocidadY() < 0) {
				pato.setPosY(TileMapRenderer.tilesToPixels(tile.y + 1));
				System.out.println("topo borde inferior");
				pato.setVelocidadY(0);
			}
			// apagamos su velocidad horizontal
			//pato.setVelocidadY(0);
			//System.out.println("cambie velocidad a 0");
		}

//		if (!auxAterrizado) {
//			pato.setAterrizadoPato(false);
//			System.out.println("apague Aterrizado");
//		}else{
//			System.out.println("prendi aterrizado");
//		}
		
		
		
		//colisionPatoBasura();
		//colisionPatoBote();
		
		// Checar colision con el borde inferior de la pantalla
		/*if(pato.getPosY()+pato.getAlto() > HEIGHT){
			pato.setPosY(pato.getPosY() - (pato.getPosY()+pato.getAlto()-HEIGHT));
			pato.setAterrizadoPato(true);
		}*/
	
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() ==  KeyEvent.VK_RIGHT){
			pato.setLadoPato(true);
			pato.setCaminaPato(true);
			
		}
		
		
		if (e.getKeyCode() ==  KeyEvent.VK_LEFT){
			pato.setLadoPato(false);
			pato.setCaminaPato(true);
			
		}
		
		if (e.getKeyCode() ==  KeyEvent.VK_UP && pato.getAterrizadoPato()){
			//System.out.println(pato.getVelocidadY());
			pato.setSaltoPato(true);
			pato.setAterrizadoPato(false);
			
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() ==  KeyEvent.VK_RIGHT){
			pato.setCaminaPato(false);
		}
		
		if (e.getKeyCode() ==  KeyEvent.VK_LEFT){
			pato.setCaminaPato(false);
		}
	}
	
	public void keyTyped(KeyEvent e) {
	
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
	
	}
	
	public void mouseMoved(MouseEvent e){
	
	}
	
	public void mouseEntered(MouseEvent e){
	
	}
	
	public void mouseClicked(MouseEvent e){
	
	}
	
	public void mouseExited(MouseEvent e){
	
	}
	
	public void paint (Graphics g) {
		// Inicializan el DoubleBuffer                
		dbImage = createImage (this.getSize().width, this.getSize().height);
		dbg = dbImage.getGraphics ();
		
		// Actualiza la imagen de fondo.
		dbg.setColor(getBackground ());
		dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		// Actualiza el Foreground.
		dbg.setColor(getForeground());
		paint1(dbg);

		paintHUD(g);
		
		// Dibuja la imagen actualizada
		g.drawImage (dbImage, 0, 0, this);
	}
	
	public void paint1 (Graphics g) {                                     
		if(g != null) { //Si ya se creo el objeto grafico g
			
			Graphics2D g2d = (Graphics2D)g;
			mapRenderer.draw(g2d, map, WIDTH, HEIGHT);
				
			for(int i=0; i<basuras.size(); i++) {
				Basura aux = (Basura) basuras.get(i);
				
				g.drawImage(aux.getImagenI() ,aux.getPosX(), aux.getPosY(), this);
			}
			
			g.drawImage(boteAluminio.getImagenI() ,boteAluminio.getPosX(), boteAluminio.getPosY(), this);
		}
		else {
			System.out.println("cargando");
		}
		
	}

	public void paintHUD(Graphics g) {
		g.drawImage(lataIcon, 0, 0, null);
		g.drawString("Aluminio recogido: " + pato.getRecogidaAluminio(),
			       15, 15);
	}	
	
	public void run() {
		while(true) {
			
			actualiza(); //Se actualiza y checa colision
			repaint();
			try{
				Thread.sleep(16); //Se duerme el juego 1 frame (1/60 de segundo es 1 frame)
			}
			catch(InterruptedException ex){
				System.out.println("Error en " + ex.toString());
			}
		}
				
	}
	
	public TileMap loadMap(String filename)
        throws IOException
    {
        ArrayList<String> lines = new ArrayList<String>();
        int width = 0;
        int height = 0;

        // read every line in the text file into the list
        BufferedReader reader = new BufferedReader(
            new FileReader(filename));
        while (true) {
            String line = reader.readLine();
            // no more lines to read
            if (line == null) {
                reader.close();
                break;
            }

            // add every line except for comments
            if (!line.startsWith("#")) {
                lines.add(line);
                width = Math.max(width, line.length());
            }
        }

        // parse the lines to create a TileEngine
        height = lines.size();
        TileMap newMap = new TileMap(width, height);
        for (int y=0; y<height; y++) {
            String line = lines.get(y);
            for (int x=0; x<line.length(); x++) {
                char ch = line.charAt(x);

                // check if the char represents tile A, B, C etc.
                int tile = ch - 'A';
                if (tile >= 0 && tile < tiles.size()) {
                    newMap.setTile(x, y, tiles.get(tile));
                }

                // check if the char represents a sprite
                /*else if (ch == 'o') {
                    addSprite(newMap, coinSprite, x, y);
                }
                else if (ch == '!') {
                    addSprite(newMap, musicSprite, x, y);
                }
                else if (ch == '*') {
                    addSprite(newMap, goalSprite, x, y);
                }
                else if (ch == '1') {
                    addSprite(newMap, grubSprite, x, y);
                }
                else if (ch == '2') {
                    addSprite(newMap, flySprite, x, y);
                }*/
            }
        }

        // add the player to the map
        pato.setPosX(TileMapRenderer.tilesToPixels(3));
        pato.setPosY(0);
        newMap.setJugador(pato);

        return newMap;
    }
	
	 public Image loadImage(String name) {
        String filename = "imagenes/" + name;
        return new ImageIcon(filename).getImage();
    }
	
	public void loadTileImages() {
        // keep looking for tile A,B,C, etc. this makes it
        // easy to drop new tiles in the images/ directory
        tiles = new ArrayList<Image>();
        char ch = 'A';
        while (true) {
            String name = "tile_" + ch + ".png";
            File file = new File("imagenes/" + name);
            if (!file.exists()) {
                break;
            }
            tiles.add(loadImage(name));
            ch++;
        }
    }
	
	public Point getTileCollision(Secundarios s,
        double newX, double newY)
    {
        double fromX = Math.min(s.getPosX(), newX);
        double fromY = Math.min(s.getPosY(), newY);
        double toX = Math.max(s.getPosX(), newX);
        double toY = Math.max(s.getPosY(), newY);

        // get the tile locations
        int fromTileX = TileMapRenderer.pixelsToTiles(fromX);
        int fromTileY = TileMapRenderer.pixelsToTiles(fromY);
        int toTileX = TileMapRenderer.pixelsToTiles(
            toX + s.getAncho() - 1);
        int toTileY = TileMapRenderer.pixelsToTiles(
            toY + s.getAlto() - 1);

        // check each tile for a collision
        for (int x=fromTileX; x<=toTileX; x++) {
            for (int y=fromTileY; y<=toTileY; y++) {
                if (x < 0 || x >= map.getWidth() ||
                    map.getTile(x, y) != null)
                {
                    // collision found, return the tile
                    //pointCache.setLocation(x, y);
                    //return pointCache;
					return new Point(x,y);
                }
            }
        }

        // no collision found
        return null;
    }
	

	
	/*
	 * Metodo main
	 * metodo principal del juego
	 * @param String[] args
	 */
	public static void main(String[] args) {
	
		JFrameQuack quack = new JFrameQuack(); //Se crea un objeto JFrameCesta
		quack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Despliega la ventana en pantalla al hacerla visible
		quack.setVisible(true); //Se hace visible
	
	}
}
