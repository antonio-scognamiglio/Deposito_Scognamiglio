package sintassi_base.es07.operatori_logici;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int readInt(Scanner s, String prompt) {
        System.out.print(prompt);
        if (!s.hasNextInt())
            throw new InputMismatchException();
        return s.nextInt();
    }

    static double readDouble(Scanner s, String prompt) {
        System.out.print(prompt);
        if (!s.hasNextDouble())
            throw new InputMismatchException();
        return s.nextDouble();
    }

    static boolean canPerformBuy(int eta, double saldo, double prezzo) {
        if (eta >= 18 && saldo >= prezzo) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int eta = readInt(scanner, "Inserisci eta cliente: ");
            double saldo = readDouble(scanner, "Inserisci saldo: ");
            double prezzo = readDouble(scanner, "Inserisci prezzo prodotto: ");

            boolean canBuy = canPerformBuy(eta, saldo, prezzo);
            if (canBuy)
                System.out.println("Acquisto autorizzato.");
            else
                System.out.println("Acquisto non autorizzato.");
        } catch (InputMismatchException e) {
            System.out.println("Valore non valido.");
        } finally {
            scanner.close();
        }
    }

}