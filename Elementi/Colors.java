package Elementi;

/**  
* La seguente classe permette al developer di utilizzare determinati
* <b>stili</b> e <b>colori</b> da applicare a delle stringhe di testo, in modo tale 
* da ottenre un output decisamente più interessante e comprensibile.
* 
* <p>L'utilizzo della classe è molto semplice, basterà infatti andare a <i>concatenare</i> il
* colore desiderato alla stringa di testo sulla quale si vuole applicare quest'ultimo.
* 
* <p>La classe in questione contiene <b>esclusivamente</b> stringhe con modificatore di comportamento
* settato a <i>static</i>.
* @author Francesco Coppola	
* @version 1.0
*/ 

public class Colors {
	//Colori disponibili
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	// Stili disponibili
	public static final String BOLD = "\033[0;1m";
	public static final String ITALIC = "\u001B[3m";
	public static final String UNDERLINE = "\u001B[4m";
	public static final String BLINK = "\u001B[5m";
	public static final String RAPID_BLINK	= "\u001B[6m";
	public static final String REVERSE_VIDEO = "\u001B[7m";
	public static final String INVISIBLE_TEXT = "\u001B[8m";
}
