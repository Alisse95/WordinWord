import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Array di parole tra cui scegliere
        String[] parole = { "mare", "riso", "pane", "sale", "aria", "sole", "orto", "cane", "fiore", "rete" };

        // Gira per 5 turni
        for (int i = 1; i <= 5; i++) {

            // Array per memorizzare le risposte dei giocatori
            ArrayList<String> rGiocatore1 = new ArrayList<>();
            ArrayList<String> rGiocatore2 = new ArrayList<>();

            System.out.println("Turno " + i);

            // Gira per 2 giocatori
            for (int giocatore = 1; giocatore <= 2; giocatore++) {

                // Selezione casuale di una parola
                int indiceCasuale = random.nextInt(parole.length);
                String parolaEstratta = parole[indiceCasuale];

                System.out.println("La parola è: " + parolaEstratta);

                System.out.println("Tocca al Giocatore " + giocatore);
                // Richiesta input all'utente
                System.out.println("Inserisci la tua risposta: ");
                String risposta = scanner.nextLine();

                // Verifica della risposta
                if (risposta.indexOf(parolaEstratta) != -1 && !risposta.equals(parolaEstratta)) {
                    System.out.println("Corretto!");

                    // Aggiunta della risposta nel rispettivo Array del giocatore
                    if (giocatore == 1) {
                        rGiocatore1.add(risposta);
                    } else {
                        rGiocatore2.add(risposta);
                    }

                } else {
                    System.out.println("Sbagliato!");
                }
            }

            // Verifica del vincitore
            if (rGiocatore1.size() > rGiocatore2.size()) {
                System.out.println("Il giocatore 1 ha vinto!");
            } else if (rGiocatore2.size() > rGiocatore1.size()) {
                System.out.println("Il giocatore 2 ha vinto!");
            } else {
                System.out.println("I due giocatori hanno pareggiato!");
            }
        }
        scanner.close();
    }
}