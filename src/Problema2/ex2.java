package Problema2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(new File("C:/Users/paul_/OneDrive/Documente/Faculta/Anul3/Programare Java/Lab2/src/Problema2/cantec_in.txt"));
            PrintStream flux_out = new PrintStream("C:/Users/paul_/OneDrive/Documente/Faculta/Anul3/Programare Java/Lab2/src/cantec_out.txt");

            Random rand= new Random();
            String line;
            String secventaFinala="la";

            while(scanner.hasNextLine()){
                line= scanner.nextLine();
                float NR_random= rand.nextFloat();

                if (NR_random< 0.1)
                {
                    line=line.toUpperCase();
                }

                String[] cuvinte = line.split(" ");
                int numar_cuvinte=cuvinte.length;

                String vocale="aeiouAEIOU";
                int numar_vocale=0;
                for(int i=0; i<line.length(); i++)
                {
                    if(vocale.indexOf(line.charAt(i))!=-1) {
                        numar_vocale++;
                    }
                }

                System.out.print(line+ " "+ numar_cuvinte+" "+ numar_vocale);
                flux_out.println(line+ " "+ numar_cuvinte+" "+ numar_vocale);

                if(line.endsWith(secventaFinala))
                {
                    System.out.print(" *");
                    flux_out.print(" *");
                }

                System.out.println();
                flux_out.flush();
            }

            flux_out.close();
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit");
            throw new RuntimeException(e);
        }
    }
}
