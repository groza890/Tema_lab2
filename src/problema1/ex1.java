package problema1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        try {
            File file = new File("C:/Users/paul_/OneDrive/Documente/Faculta/Anul3/Programare Java/Lab2/src/problema1/judete_in.txt");
            Scanner fileScanner = new Scanner(file);

            String[] judete = new String[6];
            int index = 0;

            while (fileScanner.hasNextLine()) {
                judete[index] = fileScanner.nextLine();
                index++;
            }

            fileScanner.close();
            
            Arrays.sort(judete);
            System.out.println("Județele ordonate alfabetic sunt:");
            for (String judet : judete) {
                System.out.println(judet);
            }

            Scanner inputScanner = new Scanner(System.in);
            System.out.print("Introduceți județul căutat: ");
            String judetCautat = inputScanner.nextLine();

            int pozitie = Arrays.binarySearch(judete, judetCautat);

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

