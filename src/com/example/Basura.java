package com.example;


import java.awt.Image;

/**
 *
 * @author Alberto Harden Cooper & Ana Paula
 */
public class Basura extends Personajes {

	private int tipoBasura; //0 es organica, 1 es plastico, 2 es aluminio

	/**
	* Constructor de basura
	* @param posX es la posicion en x
	* @param posY es la posicion en y
	* @param image es la imagen del objeto
	*/
    public Basura(int posX, int posY, Image image){
        super(posX,posY,image);//se llama a constructor de la super clase
		tipoBasura = 0;
    }
	
	public Basura(int posX, int posY, Image image, int t){
        super(posX,posY,image);//se llama a constructor de la super clase
		tipoBasura = t;
    }
	
	public void setTipoBasura(int t){
		tipoBasura = t;
	}
	
	public int getTipoBasura(){
		return tipoBasura;
	}
}
