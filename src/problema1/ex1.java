package problema1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        try {
            // Citirea județelor din fișier
            File file = new File("C:/Users/paul_/OneDrive/Documente/Faculta/Anul3/Programare Java/Lab2/src/problema1/judete_in.txt");
            Scanner fileScanner = new Scanner(file);

            // Stocăm toate județele într-un tablou de String-uri
            String[] judete = new String[6];
            int index = 0;

            // Citim judetul din fisier si il adaugam in vector
            while (fileScanner.hasNextLine()) {
                judete[index] = fileScanner.nextLine();
                index++;
            }

            // Închidem fișierul
            fileScanner.close();

            // Sortam judetele
            Arrays.sort(judete);
            //Afisarea judetelor
            System.out.println("Județele ordonate alfabetic sunt:");
            for (String judet : judete) {
                System.out.println(judet);
            }

            // Citirea județului de la tastatură pentru căutare
            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Introduceți județul căutat: ");
            String judetCautat = inputScanner.nextLine();

            // Căutarea binară a județului în vectorul sortat
            int pozitie = Arrays.binarySearch(judete, judetCautat);

            // Verificăm dacă județul a fost găsit
            if (pozitie >= 0) {
                System.out.println("Județul " + judetCautat + " se află pe poziția " + pozitie + " în vectorul ordonat.");
            } else {
                System.out.println("Județul " + judetCautat + " nu a fost găsit în lista de județe.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit.");
            e.printStackTrace();
        }
    }
}

