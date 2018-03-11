/**
* Package che contiene le classi Matrix e cella, responsbili del comportamento della griglia. 
*/
package Matrice;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.StreamSupport;

import Elementi.Stamina;
import Unity.Apple;
import Unity.Man;
import Unity.Monster;

/**  
* La classe di seguito è il fulcro del progetto.
* 
* <p>Essa gestisce il controllo di tutte le unità presenti nella griglia.
* Quest'utlime sono: Man, Monster, Apple e null come specificato da reference. 
* 
* <p>• <b>Man</b> è l'unità che descrive la prima razza animale, colei che è in grado
* di riprodursi se la sua stamina è compresa tra 5 e 20 unità e soprattutto se è presente 
* un animale della stesse specie in una delle 8 celle limitrofe.
* 
* <p>• <b>Monster</b> è l'unità che descrive la seconda razza animale, colei che è in grado
* di clonarsi se, e solo se, la sua stamina è superiore a 20 unità.
* 
* <p>• <b>Apple</b> è l'unità che permette alle specie precedentemente descritte l'incremento
* della stamina quando una di queste si trova nella medesima posizione del cibo. A questo punto l'unità
* cibo decadrà e l'unità sopra presente aumenterà il suo livello di stamina di 2 unità.
* 
* <p>• <b>null</b> è l'unità che descrive l'assenza di un altro qualsiasi oggetto nella posizione X, Y.
* 
* <p>Quando un delle due specie riesce a completare la sua riproduzione o la sua clonazione, genera un'entità
* della stessa specie nella prima posizione <i>null</i> disponibile.
* 
* <p>La griglia creata evolverà a seconda del turno selezionato.
* @author Francesco Coppola	
* @version 1.0
*/
public class Matrix {
	//Dichiarazione attributi
	private int righe;
	private int colonne;

	private int percentuale_null = 0;
	private int percentuale_man = 0;
	private int percentuale_monster = 0;
	private int percentuale_food = 0;

	//Dichiarazione matrice di oggetti
	private Cella Matrice[][];

	Random percentuale_random = new Random();

	Man essere_umano;
	Monster virus;
	Apple food;

	/**  
	* Metodo costruttore che genera la griglia.
	* @param r Parametro relativo al numero delle righe.
	* @param c Parametro relativo al numero delle colonne.  
	*/ 
	public Matrix(int r, int c) {
		this.righe = r;
		this.colonne = c;

		if (righe > 0 && righe != 0 && colonne > 0 && colonne != 0) {
			Matrice = new Cella[r][c];
		}

		for(int x = 0; x < righe; x++) {
			for(int y = 0; y < colonne; y++) {
				Point coord = new Point(x, y);
				Matrice[x][y] = new Cella(coord, null);
			}
		}
	}
	
	/**  
	* Metodo che dispone le unità Man, Monster, Apple e null lungo la griglia
	* in maniera del tutto casuale.
	* @see Random 
	*/ 
	public void setUpObj() {
		int tot_cells = (righe)*(colonne);

		int perc_free = (int)((0.2)*(tot_cells));

		int perc_food = (int)((percentuale_random.nextInt(50)) * tot_cells) / 100;
		int perc_mons = (int)(tot_cells - perc_food - perc_free)/2;
		int perc_huma = (int)(tot_cells - perc_food - perc_free)/2;

		perc_free = tot_cells - perc_food - perc_huma - perc_mons;

		for(int x = 0; x < righe; x++) {
			for(int y = 0; y < colonne; y++) {
				Point coord = new Point(x, y);

				List<Integer> randomListObj = new ArrayList<>();

				if (perc_food != 0)
					randomListObj.add(0);
				if(perc_mons != 0)
					randomListObj.add(1);
				if(perc_huma != 0)
					randomListObj.add(2);
				if(perc_free != 0)
					randomListObj.add(3);

				int my_random = randomListObj.get(percentuale_random.nextInt(randomListObj.size()));

				if (my_random == 0) {
					perc_food = perc_food - 1;
					food = new Apple(coord);
					Matrice[x][y] = new Cella(coord, food);
					percentuale_food++;
				}
				else if (my_random == 1) {
					perc_mons = perc_mons - 1;
					virus = new Monster(coord, Stamina.getSTAMINA());
					Matrice[x][y] = new Cella(coord, virus);
					percentuale_monster++;
				}
				else if (my_random == 2) {
					perc_huma = perc_huma - 1;
					essere_umano = new Man(coord, Stamina.getSTAMINA());
					Matrice[x][y] = new Cella(coord, essere_umano);
					percentuale_man++;
				}
				else if (my_random == 3) {
					perc_free = perc_free - 1;
					Matrice[x][y] = new Cella(coord, null);
					percentuale_null++;
				}
			}
		}
	}
	
	/**  
	* Metodo che dati in input due valori interi X e Y, che stanno a rappresentare
	* le coordinate nella griglia, restituisce <b>True</b> o <b>False</b>.
	* @param x Coordinata X selezionata.
	* @param y Coordinata Y selezionata.
	* @return True o False a seconda della presenza o meno dell'unità Man.  
	*/ 
	public Boolean checkMan(int x, int y) {
		if(Matrice[x][y].getObj() instanceof Man) {
			return true;
		}
		else {
			return false;
		}
	}

	/**  
	* Metodo che dati in input due valori interi X e Y, che stanno a rappresentare
	* le coordinate nella griglia, restituisce <b>True</b> o <b>False</b>.
	* @param x Coordinata X selezionata.
	* @param y Coordinata Y selezionata.
	* @return True o False a seconda della presenza o meno dell'unità Monster.  
	*/ 
	public Boolean checkMonster(int x, int y) {
		if(Matrice[x][y].getObj() instanceof Monster) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**  
	* Metodo che dati in input due valori interi X e Y, che stanno a rappresentare
	* le coordinate nella griglia, restituisce <b>True</b> o <b>False</b>.
	* @param x Coordinata X selezionata.
	* @param y Coordinata Y selezionata.
	* @return True o False a seconda della presenza o meno dell'unità null.  
	*/ 
	public Boolean checkNull(int x, int y) {
		if(Matrice[x][y].getObj() == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**  
	* Metodo che dati in input due valori interi X e Y, che stanno a rappresentare
	* le coordinate nella griglia, restituisce <b>True</b> o <b>False</b>.
	* @param x Coordinata X selezionata.
	* @param y Coordinata Y selezionata.
	* @return True o False a seconda della presenza o meno dell'unità Apple.  
	*/ 
	public Boolean checkFood(int x, int y) {
		if(Matrice[x][y].getObj() instanceof Apple) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**  
	* Metodo che dati in input due valori interi X e Y, che stanno a rappresentare
	* le coordinate nella griglia, restituisce le coordinate X e Y del primo Man adiacente.
	* @param x Coordinata X selezionata.
	* @param y Coordinata Y selezionata.
	* @return Coordinate, sotto forma di oggetto Point, del primo Man adiacente.  
	*/ 
	public Point checkNearMan(int x, int y) {
		Point coord_near = new Point(-1, -1);

		int[] range = new int[] {-1, 0, 1};

		for(int ry: range) {
			for(int rx: range) {
				if(!(rx == 0 && ry == 0)) {
					try {
						if(checkMan(x + rx, y + ry)) {
							coord_near.x = x + rx;
							coord_near.y = y + ry;
							return coord_near;
						}
					}
					catch(Exception ArrayIndexOutOfBoundsException) {
						continue;
					}
				}
			}
		}

		return coord_near;
	}
	
	/**  
	* Metodo che dati in input due valori interi X e Y, che stanno a rappresentare
	* le coordinate nella griglia, restituisce le coordinate X e Y del primo null disponibile.
	* @param x Coordinata X selezionata.
	* @param y Coordinata Y selezionata.
	* @return Coordinate, sotto forma di oggetto Point, del primo null adiacente disponibile.  
	*/ 
	public Point checkNearNull(int x, int y) {
		Point coord_near = new Point(-1, -1);

		int[] range = new int[] {-1, 0, 1};

		for(int ry: range) {
			for(int rx: range) {
				if(!(rx == 0 && ry == 0)) {
					try {
						if(checkNull(x + rx, y + ry)) {
							coord_near.x = x + rx;
							coord_near.y = y + ry;
							return coord_near;
						}
					}
					catch(Exception ArrayIndexOutOfBoundsException) {
						continue;
					}
				}
			}
		}

		return coord_near;
	}
	
	/**  
	* Metodo che dati in input due valori interi X e Y, che stanno a rappresentare
	* le coordinate nella griglia, restituisce le coordinate X e Y del primo Apple adiacente.
	* @param x Coordinata X selezionata.
	* @param y Coordinata Y selezionata.
	* @return Coordinate, sotto forma di oggetto Point, del primo Apple adiacente.  
	*/ 
	public Point checkNearFood(int x, int y) {
		Point coord_near = new Point(-1, -1);

		int[] range = new int[] {-1, 0, 1};

		for(int ry: range) {
			for(int rx: range) {
				if(!(rx == 0 && ry == 0)) {
					try {
						if(checkFood(x + rx, y + ry)) {
							coord_near.x = x + rx;
							coord_near.y = y + ry;
							return coord_near;
						}
					}
					catch(Exception ArrayIndexOutOfBoundsException) {
						continue;
					}
				}
			}
		}

		return coord_near;
	}
	
	/**  
	* Metodo indispensabile al funzionamento che permette il movimento delle unità all'interno
	* della griglia.
	*/ 
	public void movementObj() {
		List<Point> coordinate_check = new ArrayList<>();
				
		Man human;
		Monster monster;

		for(int x = 0; x < righe; x++) {
			for(int y = 0; y < colonne; y++) {
				Point cella_corrente = new Point(x, y);
				if(!(coordinate_check.contains(cella_corrente))){
					if(checkMan(x, y)) {
						Point cella_food = checkNearFood(x, y);
						Point cella_null = checkNearNull(x, y);

						human = (Man) Matrice[x][y].getObj();
						int stamina_hum = human.getStamina();
						
						if(cella_food.x != -1 && cella_food.y != -1 && stamina_hum > 0) {
							Point temp_1 = new Point(cella_food.x, cella_food.y);
							coordinate_check.add(temp_1);

							//Spostamento verso food con annesso aumento di stamina e spostamento dell'umano stesso

							human.setStamina(stamina_hum + 2);

							percentuale_food--;
							percentuale_null++;

							Matrice[x][y].setObj(null);
							Matrice[cella_food.x][cella_food.y].setObj(null);
							Matrice[cella_food.x][cella_food.y].setObj(human);
						}
						else if(cella_null.x != -1 && cella_null.y != -1 && stamina_hum > 0) {
							Point temp_2 = new Point(cella_null.x, cella_null.y);
							coordinate_check.add(temp_2);

							//Spostamento verso null con annessa dimunizione di stamina
							
							Matrice[x][y].setObj(null);
							Matrice[cella_null.x][cella_null.y].setObj(null);
							Matrice[cella_null.x][cella_null.y].setObj(human);

							human.setStamina(stamina_hum - 1);
						}
						else if(stamina_hum == 0) {
							//Morte dell'essere umano
							
							percentuale_man--;
							percentuale_null++;
							Matrice[x][y].setObj(null);
						}
						else {
							human.setStamina(stamina_hum - 1);

							//Abbassamento del livello di stamina da parte dell'unità essere umano
							
							Matrice[x][y].setObj(human);
						}
					}
					else if(checkMonster(x, y)) {
						Point cella_food = checkNearFood(x, y);
						Point cella_null = checkNearNull(x, y);

						monster = (Monster) Matrice[x][y].getObj();
						int stamina_mons = monster.getStamina();

						if(cella_food.x != -1 && cella_food.y != -1 && stamina_mons > 0) {
							Point temp_3 = new Point(cella_food.x, cella_food.y);
							coordinate_check.add(temp_3);

							//Spostamento verso food con annesso aumento di stamina e spostamento del virus

							monster.setStamina(stamina_mons + 2);

							percentuale_food--;
							percentuale_null++;

							Matrice[x][y].setObj(null);
							Matrice[cella_food.x][cella_food.y].setObj(null);
							Matrice[cella_food.x][cella_food.y].setObj(monster);
						}
						else if(cella_null.x != -1 && cella_null.y != -1 && stamina_mons > 0) {
							Point temp_4 = new Point(cella_null.x, cella_null.y);
							coordinate_check.add(temp_4);

							//Spostamento verso null con annessa dimunizione di stamina

							Matrice[x][y].setObj(null);
							Matrice[cella_null.x][cella_null.y].setObj(null);
							Matrice[cella_null.x][cella_null.y].setObj(monster);

							monster.setStamina(stamina_mons - 1);
						}
						else if(stamina_mons == 0) {
							//Morte del virus
							
							percentuale_monster--;
							percentuale_null++;
							Matrice[x][y].setObj(null);
						}
						else {
							monster.setStamina(stamina_mons - 1);
							
							//Abbassamento del livello di stamina da parte del virus
							
							Matrice[x][y].setObj(monster);
						}
					}
				}
			}
		}
	}
	
	/**  
	* Metodo che genera una nuova unità di natura Man all'interno della griglia se e solo se
	* i requisiti della riproduzione vengono soddisfatti. 
	*/ 
	public void spawnMan() {
		List<Point> coordinate_check = new ArrayList<>();

		Man human;
		Man human_supporto;

		Man son;

		boolean flag;

		for(int x = 0; x < righe; x++) {
			for(int y = 0; y < colonne; y++) {
				flag = false;
				Point cella_corrente = new Point(x, y);
				if(!(coordinate_check.contains(cella_corrente))){
					if(checkMan(x, y)) {
						human = (Man) Matrice[x][y].getObj();
						int stamina_hum = human.getStamina();
						if(stamina_hum > 5 && stamina_hum < 20) {
							Point cella_umano = checkNearMan(x, y);
							if(cella_umano.x != -1 && cella_umano.y != -1) {
								human_supporto = (Man) Matrice[cella_umano.x][cella_umano.y].getObj();
								int stamina_hum_1 = human_supporto.getStamina();
								if(stamina_hum_1 > 5 && stamina_hum_1 < 20 && !(coordinate_check.contains(cella_umano)) && !(coordinate_check.contains(cella_corrente))) {
									coordinate_check.add(cella_corrente);
									coordinate_check.add(cella_umano);
									for(int i = 0; i < righe; i++) {
										for(int j = 0; j < colonne; j++) {
											if(Matrice[i][j].getObj() == null && flag == false) {
												Point coord = new Point(i, j);
												coordinate_check.add(coord);
												son = new Man(coord, Stamina.getSTAMINA());
												Matrice[i][j] = new Cella(coord, son);
												percentuale_man++;
												percentuale_null--;
												flag = true;
												break;
											}
											else {
												continue;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**  
	* Metodo che genera una nuova unità di natura Monster all'interno della griglia se e solo se
	* i requisiti della clonazione vengono soddisfatti. 
	*/ 
	public void spawnMonster() {
		Monster mons;

		Monster bacterium;

		for(int x = 0; x < righe; x++) {
			for(int y = 0; y < colonne; y++) {
				if(checkMonster(x, y)) {
					mons = (Monster) Matrice[x][y].getObj();
					int stamina_mons = mons.getStamina();
					if(stamina_mons > 20) {
						for(int i = 0; i < righe; i++) {
							for(int j = 0; j < colonne; j++) {
								if(Matrice[i][j].getObj() == null) {
									mons.setStamina(10);
									Point coord = new Point(i, j);
									bacterium = new Monster(coord, 10);
									Matrice[i][j] = new Cella(coord, bacterium);
									percentuale_monster++;
									percentuale_null--;
								}
								else {
									continue;
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**  
	* Metodo che controlla se all'interno della griglia è possibile continuare processi
	* riproduttivi o movimenti, e in base a quest'ultimi restituire <b>True</b> o <b>False</b>. 
	* @return True o False a seconda della disponibilità di celle di natura null all'interno della griglia.
	*/ 
	public Boolean dangerOverpopulation(){
		List<Object> overpopulation_list = new ArrayList<>();

		for(int x = 0; x < righe; x++) {
			for(int y = 0; y < colonne; y++) {
				overpopulation_list.add(Matrice[x][y].getObj());
			}
		}

		return StreamSupport.stream(overpopulation_list.spliterator(), true).allMatch(element -> element == null);
	}
	
	/**  
	* Metodo che permette all'utente di visualizzare le statistiche relative al turno corrente.
	* @param numero_turno Il valore che descrive il numero del turno corrente. 
	*/ 
	public void percentageObj(int numero_turno) {
		int percentuale = colonne*righe;
		System.out.println("\nLa presenza degli oggetti al turno " + numero_turno + " nella matrice è: \n");
		System.out.println("• Food: \t"+((float)percentuale_food/percentuale)*100+"%");
		System.out.println("• Man: \t\t"+((float)percentuale_man/percentuale)*100+"%");
		System.out.println("• Monster: \t"+((float)percentuale_monster/percentuale)*100+"%");
		System.out.println("• null: \t"+((float)percentuale_null/percentuale)*100+"%\n");
	}

	@Override
	public String toString() {
		String var_stampa = "";
		for(int i = 0; i < righe; i++) {
			for(int j = 0; j < colonne; j++) {
				System.out.print("[ "+ Matrice[i][j].getObj() + " ]");
			}
			System.out.println();
		}
		return var_stampa;
	}
}
