package zerbitzuak;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author lomana.markel
 */
public class Exekutagarria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Konektau h1 = new Konektau(1); //zabaldu odoo
        Konektau h2 = new Konektau(0); //logeau bertan

        Scanner in = new Scanner(System.in);
        String B_E;//hau eztoi

        while (true) {
            System.out.print("Programa hasi nahi duzu? B/E ");
            B_E = in.next().toUpperCase();

            if (Objects.equals(B_E, "B")) {
                System.out.println("Sartu da");
                break;
            } else if(Objects.equals( B_E, "E")){
                System.out.println("Eskerrik asko programa erabiltzearren");
                System.exit(0);
            }
        }
        h1.start(); //prozesua hasteko
        h2.start();

        try {
            h1.join();
            h2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
