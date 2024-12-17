import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Array di parole tra cui scegliere
        String[] parole = { "mare", "riso", "pane", "sale", "aria", "sole", "orto", "cane", "fiore", "rete" };

        for (int i = 1; i <= 5; i++) {

            System.out.println("Turno " + i);

            for (int giocatore = 1; giocatore <= 2; giocatore++) {

                System.out.println("Tocca al Giocatore " + giocatore);
                // Selezione casuale di una parola
                int indiceCasuale = random.nextInt(parole.length);
                String parolaEstratta = parole[indiceCasuale];

                System.out.println("La parola è: " + parolaEstratta);

                // Richiesta input all'utente
                System.out.println("Inserisci la tua risposta: ");
                String risposta = scanner.nextLine();

                // Verifica della risposta
                if (risposta.indexOf(parolaEstratta) != -1) {
                    System.out.println("Corretto, la parola " + risposta + " contiene la parola " + parolaEstratta);
                } else {
                    System.out.println(
                            "Sbagliato, la parola " + risposta + " non contiene la parola " + parolaEstratta + "!");
                }

            }

        }
        scanner.close();
    }
}
