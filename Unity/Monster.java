package Unity;

import java.awt.Point;

import Elementi.Colors;

/**   
* <p>La <b>classe Monster</b> genera l'unità relativa alla seconda specie animale
* come proposto dalla reference.
* 
* <p>Quest'ultima è caratterizzata da delle coordinate che la individuano in modo 
* univoco nella griglia e da un livello di stamina.
* @author Francesco Coppola	
* @version 1.0
*/ 
public class Monster {
	private Point coord = new Point();
	private int stamina;
	
	/**  
	* Metodo costruttore che genera l'unità Monster.
	* @param coord Parametro relativo alle coordinate della cella.
	* @param stamina Parametro relativo alla stamina.
	*/ 
	public Monster(Point coord, int stamina) {
		this.coord = coord;
		this.stamina = stamina;
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
	* Metodo <b>get</b> che permette di ottenere le informazioni relative alla stamina 
	* della seguente unità.
	* @return Viene restituito il numero intero relativo alla stamina.
	*/
	public int getStamina() {
		return stamina;
	}
	
	/**  
	* Metodo <b>set</b> che permette all'utente di <i>settare</i> un nuovo livello di stamina
	* per la seguente unità.
	* @param stamina Valore che definisce il nuovo livello di stamina.
	*/
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	@Override
	public String toString() {
		return Colors.CYAN + "VIRU" + Colors.RESET;
	}
}
