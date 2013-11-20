package com.example;
import java.awt.Image;
import java.util.ArrayList;

/**
	La clase Animacion maneja una serie de imagenes (cuadros)
	y la cantidad de tiempo que se muestra cada cuadro.
*/

public class Animacion{
	
	private ArrayList<CuadroDeAnimacion> cuadros;
	private int indiceCuadroActual;
	private long tiempoDeAnimacion;
	private long duracionTotal;
	
	/**
		Crea una nueva Animacion vacia
	*/
	public Animacion(){
		cuadros = new ArrayList<CuadroDeAnimacion>();
		duracionTotal = 0;
		iniciar();
	}
	
	/**
		Anade una cuadro a la animacion con la duracion
		indicada (tiempo que se muestra la imagen).
	*/	
	public synchronized void sumaCuadro(Image imagen, long duracion){
		duracionTotal += duracion;
		cuadros.add(new CuadroDeAnimacion(imagen, duracionTotal));
	}
	
	// Inicializa la animacion desde el principio. 
	public synchronized void iniciar(){
		tiempoDeAnimacion = 0;
		indiceCuadroActual = 0;
	}
	
	/**
		Actualiza la imagen (cuadro) actual de la animacion,
		si es necesario.
	*/
	public synchronized void actualiza(long tiempoTranscurrido){
		if (cuadros.size() > 1){
			tiempoDeAnimacion += tiempoTranscurrido;
			
			if (tiempoDeAnimacion >= duracionTotal){
				tiempoDeAnimacion = tiempoDeAnimacion % duracionTotal;
				indiceCuadroActual = 0; 
			}
			
			while (tiempoDeAnimacion > getCuadro(indiceCuadroActual).tiempoFinal){
				indiceCuadroActual++;
			}
		}
	}
	
	/**
		Captura la imagen actual de la animacion. Regeresa null
		si la animacion no tiene imagenes.
	*/
	public synchronized Image getImagen(){
		if (cuadros.size() == 0){
			return null;
		}
		else {
			return getCuadro(indiceCuadroActual).imagen;
		}
	}
	
	private CuadroDeAnimacion getCuadro(int i){
		return cuadros.get(i);
	}
	
	public class CuadroDeAnimacion{
		
		Image imagen;
		long tiempoFinal;
		
		public CuadroDeAnimacion(){
			this.imagen = null;
			this.tiempoFinal = 0;
		}
		
		public CuadroDeAnimacion(Image imagen, long tiempoFinal){
			this.imagen = imagen;
			this.tiempoFinal = tiempoFinal;
		}
		
		public Image getImagen(){
			return imagen;
		}
		
		public long getTiempoFinal(){
			return tiempoFinal;
		}
		
		public void setImagen (Image imagen){
			this.imagen = imagen;
		}
		
		public void setTiempoFinal(long tiempoFinal){
			this.tiempoFinal = tiempoFinal;
		}
	}
		
}