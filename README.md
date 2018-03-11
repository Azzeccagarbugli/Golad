# Golad
Progetto software per il corso di **Programmazione L-31** realizzato per l'anno accademico **2017/2018** a cura di Francesco Coppola

## Cos'è Golad?

> Si vuole realizzare un gioco simile al **Gioco della vita**.
>
> Il gioco si svolge su una griglia bidimensionale in cui vi sono animali di due specie differenti e alimenti di un solo tipo. Una cella può contenere un solo animale o un solo alimento.
> 
> Lo stato del gioco, dato dalla distribuzione degli animali e degli alimenti sulla griglia, evolve con il tempo.
>
> Le due specie animali si differenziano per il meccanismo riproduttivo: o si accoppiano o si clonano.
>
> Le regole che gli animali devono rispettare sono le seguenti:
>
>- Si spostano di una casella per volta.
>- Quando si spostano su una cella con un alimento, lo mangiano e aumentano la loro capacità di spostarsi (cioè la loro vita) di due unità. Gli alimenti si trovano nella griglia in posizioni casuali e con una densità di al più 50% della griglia.
>- Alla nascita hanno una aspettativa di vita di 10 spostamenti.
>- Una unità di alimentazione aggiunge 2 spostamenti alla vita dell'animale.
>- Un animale in grado di clonarsi, se ha più di 20 spostamenti si clona e la sua vita si riduce a 10 spostamenti.
>- Un animale in grado di accopiarsi, se ha più di 5 spostamenti e meno di 20, si può accoppiare con un altro individuo vicino (cella adiacente).
>- Se un animale ha 0 spostamenti muore.
>
> Scrivere un programma che, distribuiti un certo numero di individui e alimenti casualmente sulla griglia, produca il numero e il tipo degli individui dopo un certo numero di spostamenti.

Data questa specifica consegna Golad, dopo l'inserimento del numero di turni specificato dall'utente, riesce a produrre le statistiche relative a quel turno mostrando inoltre la disposizione delle diverse unità presenti nel gioco all'interno della griglia.

