/**
* Package che contiene il metodo main, il quale è responsabile dell'avvio del gioco. 
*/
package Main;

import Matrice.Matrix;
import Elementi.Start;
import java.util.Scanner;

/**  
* La classe elencata di seguito, ovvero il <b>Main</b>, è il cuore pulsante dell'intero progetto.
* 
* <p>Il metodo <b>main</b>, infatti, è il primo che viene eseguito 
* dalla <b>Java Virtual Machine</b> quando viene lanciata. 
* 
* <p>In questo modo l'esecuzione di <b>Golad</b> avverrà con successo e i metodi relativi alle altre
* classi, all'interno del progetto, verranno richiamati per dare vita al gioco stesso.
* @author Francesco Coppola	
* @version 1.0
*/ 
public class Main {
	public static void main(String[] args) {
		//double startTime = System.nanoTime();
		
		String play_again = "";
		@SuppressWarnings("resource")
		Scanner scan_play_again = new Scanner(System.in);
		
		do {
			Matrix Scacchiera;
			
			Start.welcome();
			
			Scacchiera = Start.chooseMatrix();	
			Scacchiera.setUpObj();	
			Scacchiera.percentageObj(0);	
			
			Scacchiera.toString();		
	
			@SuppressWarnings("resource")
			Scanner var_input = new Scanner(System.in);
	
			int contatore_turni = 0;
	
			String inserisci_turno = "\nInserisci il numero del turno: ";
	
			do {
				System.out.print(inserisci_turno);
				
				int numero_turni = 0;
				
				do {
					if(var_input.hasNextInt()) {
						numero_turni = Math.abs(var_input.nextInt());
						
						if(numero_turni == 0) {
							System.out.print("\nIl valore da lei inserito non è valido, la preghiamo di inserirne uno valido: ");
							var_input.nextLine();
						}
						else {
							break;
						}
					}	
					else {
						System.out.print("\nIl valore da lei inserito non è valido, la preghiamo di inserirne uno valido: ");
						var_input.nextLine();
					}
				}
				while(numero_turni == 0); 
				
				for(int turno_x = 1; turno_x <= numero_turni; turno_x++) {
					Scacchiera.movementObj();
					Scacchiera.spawnMan();
					Scacchiera.spawnMonster();
					Scacchiera.percentageObj(contatore_turni + 1);
					Scacchiera.toString();
					System.out.println("\n");
					
					contatore_turni++;	
	
					if(Scacchiera.dangerOverpopulation() == true) {
						break;
					}
	
					inserisci_turno = "Di quanti turni vorresti proseguire?: ";
				}
			}
			while(Scacchiera.dangerOverpopulation() == false);
			
			//double estimatedTime = (System.nanoTime() - startTime) / 1000000000.0;
			
			System.out.println("Tutte le unità sono decadute, il gioco si è concluso al " + contatore_turni + " turno.\n");
			
			//System.out.println("Il tempo di esecuzione del gioco è stato: " + estimatedTime + "secondi.");
			
			System.out.print("\nSe vuoi fare una nuova partita premi il tasto 'Y' altrimenti premi un tasto qualsisi per uscire da Golad: ");
	        play_again = scan_play_again.nextLine();
	     
	        final String ESC = "\033[";
	        System.out.print(ESC + "2J");
		}
		while(play_again.equalsIgnoreCase("Y"));
		System.out.println("Grazie per aver giocato a Golad!");
	}
}
