package es01.veicoli;

import java.util.Scanner;

import es01.veicoli.models.Auto;
import es01.veicoli.models.Moto;
import es01.veicoli.models.Veicolo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Avvio del programma...");

        // 1. Inizializziamo lo Scanner
        Scanner scanner = new Scanner(System.in);

        // 2. Chiamiamo la funzione passandogli lo scanner come argomento
        // testSwitchCase(scanner);
        // printEvenNumber();
        // testDoWhile(scanner);
        // testDoWhileWizard(scanner);

        Veicolo a = new Auto("Fiat", "Panda", 5);
        Veicolo m = new Moto("Ducati", "Monster");

        a.descrivi();
        a.muovi();

        m.descrivi();
        m.muovi();
        // È buona pratica chiudere lo scanner alla fine
        scanner.close();
    }

    public static void testSwitchCase(Scanner scanner) {
        System.out.println("Inserisce un numero da 1 a 12 per indicare il mese dell'anno:");

        int input = scanner.nextInt();

        switch (input) {
            case 1:
                System.out.println("Gennaio");
                break;
            case 2:
                System.out.println("Febbraio");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.println("Aprile");
                break;
            case 5:
                System.out.println("Maggio");
                break;
            case 6:
                System.out.println("Giugno");
                break;
            case 7:
                System.out.println("Luglio");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Settembre");
                break;
            case 10:
                System.out.println("Ottobre");
                break;
            case 11:
                System.out.println("Novembre");
                break;
            case 12:
                System.out.println("Dicembre");
                break;
            default:
                System.out.println("Il valore inserito non è valido");
        }
    }

    public static void printEvenNumber() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " è pari");
            }
        }
    }

    public static void testDoWhile(Scanner scanner) {
        System.out.println("Inserisci un numero che vuoi decrementare");

        int input = scanner.nextInt();

        do {
            input--;
            System.out.println(input);

        } while (input > 0);
    }

    public static void testDoWhileWizard(Scanner scanner) {
        int input;
        do {
            System.out.println("1 - Inserisci");
            System.out.println("2 - Visualizza");
            System.out.println("3 - Esci");
            input = scanner.nextInt();
        } while (input != 0);
    }

}