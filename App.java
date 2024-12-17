import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> rGiocatore1 = new ArrayList<>();
        ArrayList<String> rGiocatore2 = new ArrayList<>();

        // Array di parole tra cui scegliere
        String[] parole = { "mare", "riso", "pane", "sale", "aria", "sole", "orto", "cane", "fiore", "rete" };

        // Gira per 5 turni
        for (int i = 1; i <= 5; i++) {

            System.out.println("Turno " + i);

            // Selezione casuale di una parola
            int indiceCasuale = random.nextInt(parole.length);
            String parolaEstratta = parole[indiceCasuale];

            System.out.println("La parola è: " + parolaEstratta);

            // Gira per 2 giocatori
            for (int giocatore = 1; giocatore <= 2; giocatore++) {

                System.out.println("Tocca al Giocatore " + giocatore);
                // Richiesta input all'utente
                System.out.println("Inserisci la tua risposta: ");
                String risposta = scanner.nextLine();

                // Verifica della risposta
                if (risposta.indexOf(parolaEstratta) != -1) {
                    System.out.println("Corretto, la parola " + risposta + " contiene la parola " + parolaEstratta);
                    
                    // Aggiunta della risposta nel rispettivo Array del giocatore
                    if (giocatore == 1) {
                        rGiocatore1.add(risposta);
                    } else {
                        rGiocatore2.add(risposta);
                    }
                } else {
                    System.out.println("Sbagliato, la parola " + risposta + " non contiene la parola " + parolaEstratta + "!");
                }
            }
        }
        scanner.close();
    }
}