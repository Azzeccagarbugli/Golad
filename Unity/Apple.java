package Unity;

import java.awt.Point;

import Elementi.Colors;

/**   
* <p>La <b>classe Apple</b> genera l'unità relativa all'alimentazione 
* come proposto dalla reference.
* 
* <p>Quest'ultima è caratterizzata da delle coordinate che la individuano in modo 
* univoco nella griglia.
* @author Francesco Coppola	
* @version 1.0
*/ 
public class Apple {
	private Point coord = new Point();
	
	/**  
	* Metodo costruttore che genera l'unità Apple.
	* @param coord Parametro relativo alle coordinate della cella.
	*/ 
	public Apple(Point coord) {
		this.coord = coord;
	}
	
	/**  
	* Metodo <b>get</b> che permette di ottenere le informazioni relative alle coordinate.
	* @return Viene restituito l'oggetto Point contenente le coordinate X e Y.
	*/ 
	public Point getCoord() {
		return coord;
	}
	
	/**  
	* Metodo <b>set</b> che permette all'utente di <i>settare</i> delle nuove coordinate.
	* @param coord Parametro relativo alle coordinate della cella.
	*/ 
	public void setCoord(Point coord) {
		this.coord = coord;
	}

	@Override
	public String toString() {
		return Colors.GREEN + "FOOD" + Colors.RESET;
	}
}
