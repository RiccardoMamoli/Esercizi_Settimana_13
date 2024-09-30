package Esercizio_1;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;


class Esercizio_1 {
    private int[] array;
    private static final Logger logger = LoggerFactory.getLogger(Esercizio_1.class);

    public Esercizio_1 (int size) {
        array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10) + 1;
        }
    }

    public void stampaArray() {
        for ( int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }}

    public void aggiornaArray(int posizione, int valore) {
        if (posizione >= 0 && posizione < array.length) {
            array[posizione] = valore;
        } else {
            throw new ArrayIndexOutOfBoundsException("Posizione fuori dai limiti");
        }

    }









    public static void main (String[] args) {
        Esercizio_1 sol = new Esercizio_1(5);
        sol.stampaArray();

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Inserisci un numero: ");
                int numero = sc.nextInt();
                if (numero == 0) {
                    System.out.print("Programma terminato");
                    break;
                }

                System.out.print("Inserisci la posizione: ");
                int posizione = sc.nextInt();
                sol.aggiornaArray(posizione, numero);
                sol.stampaArray();
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }
    }
}
