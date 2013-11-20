package com.example;


import java.awt.Image;

/**
 *
 * @author Alberto Harden Cooper & Ana Paula
 */
public class Bote extends Secundarios {

	private int tipoBote; //0 organico
						 //1 plastico
						 //2 aluminio
						 
	private int basuraRecibida;

	/**
	* Constructor de Bote
	* @param posX es la posicion en x
	* @param posY es la posicion en y
	* @param image es la imagen del objeto
	*/
    public Bote(int posX, int posY, Image image){
        super(posX,posY,image);//se llama a constructor de la super clase
		tipoBote = 0;
		basuraRecibida = 0;
    }
	
	/**
	* Constructor de Bote
	* @param posX es la posicion en x
	* @param posY es la posicion en y
	* @param image es la imagen del objeto
	* @param tipoBote es el tipo de bote
	*/
    public Bote(int posX, int posY, Image image, int tipoBote){
        super(posX,posY,image);//se llama a constructor de la super clase
		this.tipoBote = tipoBote;
		basuraRecibida = 0;
    }
	
	public void setTipoBote(int tipoBote){
		this.tipoBote = tipoBote;
		
	}
	
	public int getTipoBote(){
		return tipoBote;
	}
	
	public void setBasuraRecibida(int basuraRecibida){
		this.basuraRecibida = basuraRecibida;
	}
	
	public int getBasuraRecibida(){
		return this.basuraRecibida;
	}
	
	public void recibirBasura(Jugador p){
		if(tipoBote == 0){
			setBasuraRecibida(getBasuraRecibida()+p.getRecogidaOrganica());
			p.setRecogidaOrganica(0);
		}
		
		if(tipoBote == 1){
			setBasuraRecibida(getBasuraRecibida()+p.getRecogidaPlastico());
			p.setRecogidaPlastico(0);
		}
		
		if(tipoBote == 2){
			setBasuraRecibida(getBasuraRecibida()+p.getRecogidaAluminio());
			p.setRecogidaAluminio(0);
		}
	}
}
