package problema4;

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citim numărul de persoane
        System.out.print("Introduceți numărul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consumăm linia nouă rămasă după nextInt()

        // Procesăm fiecare persoană
        for (int i = 0; i < n; i++) {
            System.out.print("Introduceți numele persoanei " + (i + 1) + ": ");
            String nume = scanner.nextLine();

            String cnp = "";
            boolean cnpValid = false;

            // Continuăm să cerem CNP-ul până când este valid
            while (!cnpValid) {
                System.out.print("Introduceți CNP-ul persoanei " + (i + 1) + ": ");
                cnp = scanner.nextLine();
                cnpValid = validareCNP(cnp);

                if (!cnpValid) {
                    System.out.println("CNP-ul introdus nu este valid. Vă rugăm să încercați din nou.");
                }
            }

            // Calculăm vârsta
            int varsta = calculeazaVarstaDinCNP(cnp);

            // Afișăm informațiile pentru persoană
            System.out.println("Persoana " + (i + 1) + ": " + nume + ", CNP: " + cnp + ", Vârsta: " + varsta);
        }
        scanner.close();
    }

    // Funcție de validare a CNP-ului
    public static boolean validareCNP(String cnp) {
        if (cnp.length() != 13) {
            return false;  // Verificăm dacă CNP-ul are exact 13 caractere
        }

        if (!cnp.matches("\\d{13}")) {
            return false;  // Verificăm dacă toate caracterele sunt cifre
        }

        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false;  // Verificăm dacă prima cifră este 1, 2, 5 sau 6
        }

        return true;  // Dacă toate condițiile sunt îndeplinite, CNP-ul este valid
    }

    // Funcție pentru a calcula vârsta pe baza CNP-ului
    public static int calculeazaVarstaDinCNP(String cnp) {
        int anNastere = 0;
        char primaCifra = cnp.charAt(0);

        // Calculăm anul nașterii pe baza primei cifre
        if (primaCifra == '1' || primaCifra == '2') {
            anNastere = 1900 + Integer.parseInt(cnp.substring(1, 3));
        } else if (primaCifra == '5' || primaCifra == '6') {
            anNastere = 2000 + Integer.parseInt(cnp.substring(1, 3));
        }

        // Obținem anul curent
        int anulCurent = java.time.Year.now().getValue();

        // Calculăm vârsta
        return anulCurent - anNastere;
    }
}