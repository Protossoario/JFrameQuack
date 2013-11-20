/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Alberto Harden Cooper & Ana Paula
 */
public class Plataforma extends Personajes {
	

	
	/**
	 * Metodo constructor usado para crear plataforma
	 * @param posX es la <code>posicion en x</code> del objeto.
	 * @param posY es la <code>posicion en y</code> del objeto.
	 * @param image es la <code>imagen</code> del objeto.
	 */
	public Plataforma(int posX, int posY ,Image image) {
		super(posX, posY, image);
	}
	
}

