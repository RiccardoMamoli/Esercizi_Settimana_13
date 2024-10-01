package Esercizio_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Esercizio_1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci un numero: ");
        int N = sc.nextInt();
        sc.nextLine();

        Set<String> paroleDistinte = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();


        for (int i = 0; i < N; i++) {
            System.out.print("Inserisci la parola numero " + (i + 1) + ": ");
            String parola = sc.nextLine();


            if (!paroleDistinte.add(parola)) {
                paroleDuplicate.add(parola);
            }
        }


        System.out.println("\nParole duplicate: ");
        if (paroleDuplicate.isEmpty()) {
            System.out.println("Nessuna parola duplicata.");
        } else {
            for (String parola : paroleDuplicate) {
                System.out.println(parola);
            }
        }


        System.out.println("Numero di parole distinte: " + paroleDistinte.size());


        System.out.println("Elenco delle parole distinte: ");
        for (String parola : paroleDistinte) {
            System.out.println(parola);
        }

        sc.close();
    }
}
