package Matrice;

import java.awt.Point;

/**   
* <p>La <b>classe cella</b> inizializza un Array bidimensionale
* formato da celle.
* 
* <p>Quest'ultime sono caratterizzate da delle coordinate e dalla presenza o meno
* di un oggetto.
* @author Francesco Coppola	
* @version 1.0
*/ 
public class Cella {
	private Point coord = new Point();
	private Object var_oggetto;
	
	/**  
	* Metodo costruttore che genera una cella.
	* @param coord Parametro relativo alle coordinate della cella.
	* @param var_oggetto Oggetto presente nelle coordinate indicate precedentemente.  
	*/ 
	public Cella(Point coord, Object var_oggetto) {
		this.coord = coord;
		this.var_oggetto = var_oggetto;
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
	
	/**  
	* Metodo <b>get</b> che permette di ottenere le informazioni relative all'oggetto.
	* @return Viene restituito l'oggetto presente nelle coordinate X e Y.
	*/ 
	public Object getObj() {
		if (this.var_oggetto != null) {
			return var_oggetto;
		}
		else {
			return null;
		}
	}
	
	/**  
	* Metodo <b>set</b> che permette all'utente di <i>settare</i> un nuovo oggetto nelle coordinate X e Y.
	* @param var_oggetto Parametro relativo all'oggetto che si vuole inserire nella cella.
	*/ 
	public void setObj(Object var_oggetto) {
		this.var_oggetto = var_oggetto;
	}
}
