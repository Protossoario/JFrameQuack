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
    public Jugador(int posX, int posY, Image image){
        super(posX,posY,null);//se llama a constructor de la super clase
		recogidaOrganica = 0;
		recogidaPlastico = 0;
		recogidaAluminio = 0;
		
		Image patoCaminaIzq1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaIzq1.png"));
			Image patoCaminaIzq2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaIzq2.png"));
			Image patoCaminaIzq3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaIzq3.png"));
			Image patoCaminaIzq4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaIzq4.png"));
			Image patoCaminaIzq5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaIzq5.png"));
			Image patoCaminaIzq6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaIzq6.png"));
			Image patoCaminaIzq7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaIzq7.png"));
			Image patoCaminaIzq8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaIzq8.png"));
			
		Image patoCaminaDer1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaDer1.png"));
			Image patoCaminaDer2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaDer2.png"));
			Image patoCaminaDer3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaDer3.png"));
			Image patoCaminaDer4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaDer4.png"));
			Image patoCaminaDer5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaDer5.png"));
			Image patoCaminaDer6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaDer6.png"));
			Image patoCaminaDer7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaDer7.png"));
			Image patoCaminaDer8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoCamina/patoCaminaDer8.png"));
			
		Image patoParadoIzq1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoIzq1.png"));
			Image patoParadoIzq2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoIzq2.png"));
			Image patoParadoIzq3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoIzq3.png"));
			Image patoParadoIzq4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoIzq4.png"));
			Image patoParadoIzq5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoIzq5.png"));
			Image patoParadoIzq6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoIzq6.png"));
			Image patoParadoIzq7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoIzq7.png"));
			Image patoParadoIzq8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoIzq8.png"));
			
		Image patoParadoDer1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoDer1.png"));
			Image patoParadoDer2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoDer2.png"));
			Image patoParadoDer3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoDer3.png"));
			Image patoParadoDer4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoDer4.png"));
			Image patoParadoDer5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoDer5.png"));
			Image patoParadoDer6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoDer6.png"));
			Image patoParadoDer7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoDer7.png"));
			Image patoParadoDer8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/patoParado/patoParadoDer8.png"));
	
		
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
