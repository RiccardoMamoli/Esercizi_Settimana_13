package Esercizio_2;

import java.util.*;

public class Esercizio_2 {

    public static List<Integer> generaListaCasuale(int N) {
        List<Integer> lista = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            lista.add(random.nextInt(101));
        }
        return lista;
    }

    public static List<Integer> invertiLista(List<Integer> lista) {
        List<Integer> listaInversa = new ArrayList<>(lista);
        Collections.reverse(listaInversa);
        return listaInversa;
    }

    public static void stampaPosizioni(List<Integer> lista, boolean pari) {
        System.out.println(pari ? "Elementi in posizioni pari:" : "Elementi in posizioni dispari:");
        for (int i = 0; i < lista.size(); i++) {
            if (pari && i % 2 == 0) {
                System.out.println("Posizione " + i + ": " + lista.get(i));
            } else if (!pari && i % 2 != 0) {
                System.out.println("Posizione " + i + ": " + lista.get(i));
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Dammi un numero");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> listaCasuale = generaListaCasuale(N);

        System.out.println("La lista casuale generata di " + N + " numeri è: ");
        System.out.println(listaCasuale);

        System.out.println("La lista invertita è: ");
        System.out.println(invertiLista(listaCasuale));

        stampaPosizioni(listaCasuale, true);
        stampaPosizioni(listaCasuale, false);
    }
}
