package EserciziSingleton.facile;

public class Facile {
    public static void main(String[] args) {
        Termostato termostato1 = Termostato.getInstance();
        termostato1.setTemperatura(99);
        Termostato termostato2 = Termostato.getInstance();
        termostato2.setTemperatura(50);
        System.out.println("Temperatura termostato1:" + termostato1.getTemperatura());
        System.out.println("Temperatura termostato2:" + termostato2.getTemperatura());
    }
}
