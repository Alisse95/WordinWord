import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Array di parole tra cui scegliere
        String[] parole = { "mare", "riso", "pane", "sale", "aria", "sole", "orto", "cane", "fiore", "rete" };

        // ArrayList per memorizzare le risposte dei giocatori
        ArrayList<String> rGiocatore1 = new ArrayList<>();
        ArrayList<String> rGiocatore2 = new ArrayList<>();

        // Array per memorizzare il tempo impiegato dai giocatori
        long[] tGiocatore1 = new long[5];
        long[] tGiocatore2 = new long[5];

        // Inizio Partita
        System.out.println("--------------------------------");
        System.out.println("BENVENUTO NELLA PARTITA!");
        System.out.println("--------------------------------");

        // Gira per 5 turni
        for (int i = 1; i <= 5; i++) {

            System.out.println("Turno " + i);

            // Gira per 2 giocatori
            for (int giocatore = 1; giocatore <= 2; giocatore++) {

                // Selezione casuale di una parola
                int indiceCasuale = random.nextInt(parole.length);
                String parolaEstratta = parole[indiceCasuale];
                System.out.println("\nGiocatore " + giocatore);
                System.out.println("La parola è " + parolaEstratta);

                // Richiesta input all'utente
                System.out.print("Inserisci la tua risposta (Hai 10 secondi): ");

                // Risposta + Calcolo del tempo
                long inizioTempo = System.currentTimeMillis();
                String risposta = scanner.nextLine();
                long fineTempo = System.currentTimeMillis();
                long secondiTrascorsi = (fineTempo - inizioTempo) / 1000;

                // Aggiunta del tempo nel rispettivo Array del giocatore
                (giocatore == 1 ? tGiocatore1 : tGiocatore2)[i - 1] = secondiTrascorsi;

                // Verifica della risposta e del tempo
                if (risposta.indexOf(parolaEstratta) != -1 && !risposta.equals(parolaEstratta)
                        && secondiTrascorsi < 10) {
                    System.out.println("\nCorretto!\n");
                    (giocatore == 1 ? rGiocatore1 : rGiocatore2).add(risposta); // Aggiunta della risposta all'Array del
                                                                                // giocatore
                } else if (secondiTrascorsi > 10) {
                    System.out.println(
                            "\nTempo scaduto! Hai impiegato " + secondiTrascorsi + " secondi. Risposta non valida.\n");
                } else {
                    System.out.println("\nSbagliato!\n");
                }
            }
        }

        // Calcolo del tempo impiegato dai giocatori
        long sommaTempiGiocatore1 = 0;
        long sommaTempiGiocatore2 = 0;

        for (int sommaTempi = 0; sommaTempi < tGiocatore1.length; sommaTempi++) {
            sommaTempiGiocatore1 += tGiocatore1[sommaTempi];
            sommaTempiGiocatore2 += tGiocatore2[sommaTempi];
        }

        // Verifica del vincitore
        if (rGiocatore1.size() > rGiocatore2.size()) {
            System.out.println("Il Giocatore 1 ha vinto!");
        } else if (rGiocatore2.size() > rGiocatore1.size()) {
            System.out.println("Il Giocatore 2 ha vinto!");
        } else {
            if (sommaTempiGiocatore1 < sommaTempiGiocatore2) {
                System.out.println("Pareggio! Ma vince il Giocatore 1 perchè ha impiegato meno tempo nelle risposte!");
            } else if (sommaTempiGiocatore2 < sommaTempiGiocatore1) {
                System.out.println("Pareggio! Ma vince il Giocatore 2 perchè ha impiegato meno tempo nelle risposte!");
            } else {
                System.out.println("Pareggio! Avete impiegato lo stesso tempo nelle risposte!");
            }
        }

        scanner.close();
    }
}