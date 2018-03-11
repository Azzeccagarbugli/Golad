/**
* Package che contiene le classi Colors, Stamina e infine la classe Start. 
*/
package Elementi;

import Matrice.Matrix;

import java.util.Scanner;

/**
* La seguente classe dà la possibilità all'utente di scegliere le dimensioni 
* della matrice sulla quale giocare.
* 
* <p>Essa possiede due metodi principali che permettono all'utente di scegliere 
* se giocare con una griglia di dimensioni predefinite o personalizzate.
* @author Francesco Coppola	
* @version 1.0
*/ 
public class Start {
	
	/**  
	* Metodo che visulizza il logo del progetto e le possibilità di scelta proposte all'utente.  
	*/ 
	public final static void welcome() {
		String logo_golad = (
		"\r\n" +
		"         _              _            _             _                _         \r\n" + 
		"        /\\ \\           /\\ \\         _\\ \\          / /\\             /\\ \\       \r\n" + 
		"       /  \\ \\         /  \\ \\       /\\__ \\        / /  \\           /  \\ \\____  \r\n" + 
		"      / /\\ \\_\\       / /\\ \\ \\     / /_ \\_\\      / / /\\ \\         / /\\ \\_____\\ \r\n" + 
		"     / / /\\/_/      / / /\\ \\ \\   / / /\\/_/     / / /\\ \\ \\       / / /\\/___  / \r\n" + 
		"    / / / ______   / / /  \\ \\_\\ / / /         / / /  \\ \\ \\     / / /   / / /  \r\n" + 
		"   / / / /\\_____\\ / / /   / / // / /         / / /___/ /\\ \\   / / /   / / /   \r\n" + 
		"  / / /  \\/____ // / /   / / // / / ____    / / /_____/ /\\ \\ / / /   / / /    \r\n" + 
		" / / /_____/ / // / /___/ / // /_/_/ ___/\\ / /_________/\\ \\ \\\\ \\ \\__/ / /     \r\n" + 
		"/ / /______\\/ // / /____\\/ //_______/\\__\\// / /_       __\\ \\_\\\\ \\___\\/ /      \r\n" + 
		"\\/___________/ \\/_________/ \\_______\\/    \\_\\___\\     /____/_/ \\/_____/       \r\n" + 
		"                                                                              \r\n" + 
		"");
		System.out.println(Colors.CYAN + logo_golad + Colors.RESET);
		System.out.println(Colors.BOLD + "Benvenuto in GoLaD! - Game of Life and Death" + Colors.RESET);
		System.out.println(Colors.ITALIC + "“Per risolvere il problema di questa infelicità furono suggerite varie proposte, "
									   + "\nma queste perlopiù concernevano lo scambio continuo di pezzetti di carta verde, un fatto "
									   + "\nindubbiamente strano, visto che a essere infelici non erano i pezzetti di carta verde, "
									   + "\nma gli abitanti del pianeta. Ma dopo anni di ricerca essi trovarono la felicità."
									   + "\nLa via per arrivare a quest'ultima infatti si chiamava Golad.” " + Colors.RESET);
		System.out.println("\nGriglie disponibili");
		System.out.println(Colors.GREEN + "1) 10 x 10" + Colors.RESET);
		System.out.println(Colors.YELLOW + "2) 25 x 25" + Colors.RESET);
		System.out.println(Colors.RED + "3) 40 x 40" + Colors.RESET);
		System.out.print("\nSeleziona il numero della griglia con cui desideri giocare, oppure premi il numero '0' per costruire una griglia personalizzata: ");
	}
	
	/**  
	* Metodo che permette all'utente di selezionare una delle griglie di default, e in base
	* alla scelta di quest'ultimo genera la griglia selezionata.  
	* @return Viene restituito un oggetto relativo alla classe Matrix.
	* @see Matrix  
	*/ 
	public static Matrix chooseMatrix() {
		Matrix Scacchiera = null;
		
		@SuppressWarnings("resource")
		Scanner var_input = new Scanner(System.in);
		
		Boolean loop = true;
		
		do {
			
			int var_switch;
			
			while(!(var_input.hasNextInt())) {
				System.out.print("\nIl valore da lei inserito non è valido, la preghiamo di inserirne uno valido: ");
				var_input.nextLine();
			}
			
			var_switch = var_input.nextInt();
			
			switch(var_switch) {
				case 1:
					Scacchiera = new Matrix(10, 10);
					loop = false;
					break;
				case 2:
					Scacchiera = new Matrix(25, 25);
					loop = false;
					break;
				case 3:
					Scacchiera = new Matrix(40, 40);
					loop = false;
					break;
				case 0:
					Scacchiera = customMatrix();
					loop = false;
					break;
				default:
					System.out.print("\nIl valore da lei inserito non è valido, la preghiamo di inserirne uno valido: ");
					break;
			}
		}
		while(loop);
		
		return Scacchiera;
	}
	
	/**  
	* Metodo che permette all'utente di generare una griglia con numero di righe
	* e colonne personalizzate.
	* @return Viene restituito un oggetto relativo alla classe Matrix.
	* @see Matrix  
	*/ 
	public static Matrix customMatrix() {
		Matrix Scacchiera = null;
		
		@SuppressWarnings("resource")
		Scanner var_input_righe = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner var_input_colonne = new Scanner(System.in);

		Boolean loop = true;
		
		int number_righe = 0;
		int number_colonne = 0;
		
		do {
			System.out.print("\nInserisci un valore per il numero delle righe: ");
			
			do{
				if(var_input_righe.hasNextInt()) {
					number_righe = Math.abs(var_input_righe.nextInt());
					
					if(number_righe == 0) {
						System.out.print("\nIl valore da lei inserito non è valido, la preghiamo di inserirne uno valido: ");
						var_input_righe.nextLine();
					}
					else {
						break;
					}
				}
				else {
					System.out.print("\nIl valore da lei inserito non è valido, la preghiamo di inserirne uno valido: ");
				    var_input_righe.nextLine();
				}
			}
			while(number_righe == 0);
			
			System.out.print("\nInserisci un valore per il numero delle colonne: ");
			
			do {
				if(var_input_colonne.hasNextInt()) {
					number_colonne = Math.abs(var_input_colonne.nextInt());
					
					if(number_colonne == 0) {
						System.out.print("\nIl valore da lei inserito non è valido, la preghiamo di inserirne uno valido: ");
						var_input_colonne.nextLine();
					}
					else {
						break;
					}
				}
				else {
					System.out.print("\nIl valore da lei inserito non è valido, la preghiamo di inserirne uno valido: ");
				    var_input_colonne.nextLine();
				}
			}
			while(number_colonne == 0);
			
			Scacchiera = new Matrix(number_righe, number_colonne);
			
			loop = false;
		}
		while(loop);
			
		return Scacchiera;
	}
}