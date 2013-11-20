package com.example;


import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Alberto Harden Cooper & Ana Paula
 */
public class Jugador extends Secundarios {

	private int recogidaOrganica; //basura organica recogida
	private int recogidaPlastico; //basura plastico recogida
	private int recogidaAluminio; //bsaura aluminio recogida
	
	private boolean ladoPato;
	private boolean caminaPato;
	private boolean saltoPato;
	private boolean aterrizadoPato;
	
	private Animacion animPatoCaminaIzq;
	private Animacion animPatoCaminaDer;
	
	private Animacion animPatoParadoIzq;
	private Animacion animPatoParadoDer;
	
	private Animacion animCurrent;
	
	private long tiempoActualPatoCaminaIzq = System.currentTimeMillis();
	private long tiempoActualPatoCaminaDer = System.currentTimeMillis();
	
	private long tiempoActualPatoParadoIzq = System.currentTimeMillis();
	private long tiempoActualPatoParadoDer = System.currentTimeMillis();
	
	private long tiempoActualPatoSaltoIzq = System.currentTimeMillis();
	private long tiempoActualPatoSaltoDer = System.currentTimeMillis();
	
	/**
	* Constructor de Jugador
	* @param posX es la posicion en x
	* @param posY es la posicion en y
	* @param image es la imagen del objeto
	*/
    public Jugador(int posX, int posY){
        super(posX,posY,null);//se llama a constructor de la super clase
		recogidaOrganica = 0;
		recogidaPlastico = 0;
		recogidaAluminio = 0;
		
		Image patoCaminaIzq1 = null;
		Image patoCaminaIzq2 = null;
		Image patoCaminaIzq3 = null;
		Image patoCaminaIzq4 = null;
		Image patoCaminaIzq5 = null;
		Image patoCaminaIzq6 = null;
		Image patoCaminaIzq7 = null;
		Image patoCaminaIzq8 = null;
		
		Image patoCaminaDer1 = null;
		Image patoCaminaDer2 = null;
		Image patoCaminaDer3 = null;
		Image patoCaminaDer4 = null;
		Image patoCaminaDer5 = null;
		Image patoCaminaDer6 = null;
		Image patoCaminaDer7 = null;
		Image patoCaminaDer8 = null;
		
		Image patoParadoIzq1 = null;
		Image patoParadoIzq2 = null;
		Image patoParadoIzq3 = null;
		Image patoParadoIzq4 = null;
		Image patoParadoIzq5 = null;
		Image patoParadoIzq6 = null;
		Image patoParadoIzq7 = null;
		Image patoParadoIzq8 = null;
		
		Image patoParadoDer1 = null;
		Image patoParadoDer2 = null;
		Image patoParadoDer3 = null;
		Image patoParadoDer4 = null;
		Image patoParadoDer5 = null;
		Image patoParadoDer6 = null;
		Image patoParadoDer7 = null;
		Image patoParadoDer8 = null;
		
		try {
			patoCaminaIzq1 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaIzq1.png");
				patoCaminaIzq2 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaIzq2.png");
				patoCaminaIzq3 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaIzq3.png");
				patoCaminaIzq4 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaIzq4.png");
				patoCaminaIzq5 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaIzq5.png");
				patoCaminaIzq6 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaIzq6.png");
				patoCaminaIzq7 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaIzq7.png");
				patoCaminaIzq8 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaIzq8.png");
				
			patoCaminaDer1 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaDer1.png");
				patoCaminaDer2 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaDer2.png");
				patoCaminaDer3 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaDer3.png");
				patoCaminaDer4 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaDer4.png");
				patoCaminaDer5 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaDer5.png");
				patoCaminaDer6 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaDer6.png");
				patoCaminaDer7 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaDer7.png");
				patoCaminaDer8 = JFrameQuack.loadImage("imagenes/patoCamina/patoCaminaDer8.png");
				
			patoParadoIzq1 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoIzq1.png");
				patoParadoIzq2 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoIzq2.png");
				patoParadoIzq3 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoIzq3.png");
				patoParadoIzq4 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoIzq4.png");
				patoParadoIzq5 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoIzq5.png");
				patoParadoIzq6 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoIzq6.png");
				patoParadoIzq7 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoIzq7.png");
				patoParadoIzq8 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoIzq8.png");
				
			patoParadoDer1 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoDer1.png");
				patoParadoDer2 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoDer2.png");
				patoParadoDer3 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoDer3.png");
				patoParadoDer4 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoDer4.png");
				patoParadoDer5 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoDer5.png");
				patoParadoDer6 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoDer6.png");
				patoParadoDer7 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoDer7.png");
				patoParadoDer8 = JFrameQuack.loadImage("imagenes/patoParado/patoParadoDer8.png");
		}
		catch (Exception ex) {
			System.out.println("Error cargando las imagenes del jugador");
			System.out.println(ex);
		}
		
		animPatoCaminaIzq = new Animacion();
			animPatoCaminaIzq.sumaCuadro(patoCaminaIzq1, 130);
			animPatoCaminaIzq.sumaCuadro(patoCaminaIzq2, 130);
			animPatoCaminaIzq.sumaCuadro(patoCaminaIzq3, 130);
			animPatoCaminaIzq.sumaCuadro(patoCaminaIzq4, 130);
			animPatoCaminaIzq.sumaCuadro(patoCaminaIzq5, 130);
			animPatoCaminaIzq.sumaCuadro(patoCaminaIzq6, 130);
			animPatoCaminaIzq.sumaCuadro(patoCaminaIzq7, 130);
			animPatoCaminaIzq.sumaCuadro(patoCaminaIzq8, 130);
			
		animPatoCaminaDer = new Animacion();
			animPatoCaminaDer.sumaCuadro(patoCaminaDer1, 130);
			animPatoCaminaDer.sumaCuadro(patoCaminaDer2, 130);
			animPatoCaminaDer.sumaCuadro(patoCaminaDer3, 130);
			animPatoCaminaDer.sumaCuadro(patoCaminaDer4, 130);
			animPatoCaminaDer.sumaCuadro(patoCaminaDer5, 130);
			animPatoCaminaDer.sumaCuadro(patoCaminaDer6, 130);
			animPatoCaminaDer.sumaCuadro(patoCaminaDer7, 130);
			animPatoCaminaDer.sumaCuadro(patoCaminaDer8, 130);
			
		animPatoParadoIzq = new Animacion();
			animPatoParadoIzq.sumaCuadro(patoParadoIzq1, 130);
			animPatoParadoIzq.sumaCuadro(patoParadoIzq2, 130);
			animPatoParadoIzq.sumaCuadro(patoParadoIzq3, 130);
			animPatoParadoIzq.sumaCuadro(patoParadoIzq4, 130);
			animPatoParadoIzq.sumaCuadro(patoParadoIzq5, 130);
			animPatoParadoIzq.sumaCuadro(patoParadoIzq6, 130);
			animPatoParadoIzq.sumaCuadro(patoParadoIzq7, 130);
			animPatoParadoIzq.sumaCuadro(patoParadoIzq8, 130);
			
		animPatoParadoDer = new Animacion();
			animPatoParadoDer.sumaCuadro(patoParadoDer1, 130);
			animPatoParadoDer.sumaCuadro(patoParadoDer2, 130);
			animPatoParadoDer.sumaCuadro(patoParadoDer3, 130);
			animPatoParadoDer.sumaCuadro(patoParadoDer4, 130);
			animPatoParadoDer.sumaCuadro(patoParadoDer5, 130);
			animPatoParadoDer.sumaCuadro(patoParadoDer6, 130);
			animPatoParadoDer.sumaCuadro(patoParadoDer7, 130);
			animPatoParadoDer.sumaCuadro(patoParadoDer8, 130);
			
			ladoPato = false;
			caminaPato = false;
			saltoPato = false;
			aterrizadoPato = true;
    }
	
	public void setLadoPato(boolean b){
		ladoPato = b;
	}
	
	public boolean getLadoPato(){
		return ladoPato;
	}
	
	public void setCaminaPato(boolean b){
		caminaPato = b;
	}
	
	public boolean getCaminaPato(){
		return caminaPato;
	}
	
	public void setSaltoPato(boolean b){
		saltoPato = b;
	}
	
	public boolean getSaltoPato(){
		return saltoPato;
	}
	
	public void setAterrizadoPato(boolean b){
		aterrizadoPato = b;
	}
	
	public boolean getAterrizadoPato(){
		return aterrizadoPato;
	}
	
	
	public void setRecogidaOrganica(int n){
		recogidaOrganica = n;
	}
	
	public int getRecogidaOrganica(){
		return recogidaOrganica;
	}
	
	public void setRecogidaPlastico(int n){
		recogidaPlastico = n;
	}
	
	public int getRecogidaPlastico(){
		return recogidaPlastico;
	}
	
	public void setRecogidaAluminio(int n){
		recogidaAluminio = n;
	}
	
	public int getRecogidaAluminio(){
		return recogidaAluminio;
	}
	
	public void recogerBasura(Basura b){
		int auxTipoBasura;
		
		auxTipoBasura = b.getTipoBasura();
		if(auxTipoBasura == 0){
			recogidaOrganica++;
		} else if(auxTipoBasura == 1){
			recogidaPlastico++;
		}
		else if(auxTipoBasura == 2){
			recogidaAluminio++;
		}
	}
	
	public void brillaPatoCaminaIzq() {
		long tiempoTranscurrido = System.currentTimeMillis() - tiempoActualPatoCaminaIzq;
		tiempoActualPatoCaminaIzq += tiempoTranscurrido;
		animPatoCaminaIzq.actualiza(tiempoTranscurrido);
	}
	
	public void brillaPatoCaminaDer() {
		long tiempoTranscurrido = System.currentTimeMillis() - tiempoActualPatoCaminaDer;
		tiempoActualPatoCaminaDer += tiempoTranscurrido;
		animPatoCaminaDer.actualiza(tiempoTranscurrido);
	}
	
	public void brillaPatoParadoIzq() {
		long tiempoTranscurrido = System.currentTimeMillis() - tiempoActualPatoParadoIzq;
		tiempoActualPatoParadoIzq += tiempoTranscurrido;
		animPatoParadoIzq.actualiza(tiempoTranscurrido);
	}
	
	public void brillaPatoParadoDer() {
		long tiempoTranscurrido = System.currentTimeMillis() - tiempoActualPatoParadoDer;
		tiempoActualPatoParadoDer += tiempoTranscurrido;
		animPatoParadoDer.actualiza(tiempoTranscurrido);
	}
	
	public void setAnimCurrent(Animacion current){
		animCurrent = current;
	}
	
	public Animacion getAnimCurrent(){
		return animCurrent;
	}
	
	public Image getImagenActual(){
		if(ladoPato){
				if(caminaPato){
					return animPatoCaminaDer.getImagen();
				}
				else{
					return animPatoParadoDer.getImagen();
				}
			}
			else{
				if(caminaPato){
					return animPatoCaminaIzq.getImagen();
				}
				else{
					return animPatoParadoDer.getImagen();
				}
			}
	}
}
