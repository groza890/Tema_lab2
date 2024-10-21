package problema4;

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți numărul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consumăm linia nouă rămasă după nextInt()

        for (int i = 0; i < n; i++) {
            System.out.print("Introduceți numele persoanei " + (i + 1) + ": ");
            String nume = scanner.nextLine();

            String cnp = "";
            boolean cnpValid = false;

            while (!cnpValid) {
                System.out.print("Introduceți CNP-ul persoanei " + (i + 1) + ": ");
                cnp = scanner.nextLine();
                cnpValid = validareCNP(cnp);

                if (!cnpValid) {
                    System.out.println("CNP-ul introdus nu este valid. Vă rugăm să încercați din nou.");
                }
            }

            int varsta = calculeazaVarstaDinCNP(cnp);

            System.out.println("Persoana " + (i + 1) + ": " + nume + ", CNP: " + cnp + ", Vârsta: " + varsta);
        }
        scanner.close();
    }

    public static boolean validareCNP(String cnp) {
        if (cnp.length() != 13) {
            return false;  
        }

        if (!cnp.matches("\\d{13}")) {
            return false;  
        }

        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false; 
        }

        return true;  
    }

    public static int calculeazaVarstaDinCNP(String cnp) {
        int anNastere = 0;
        char primaCifra = cnp.charAt(0);

        if (primaCifra == '1' || primaCifra == '2') {
            anNastere = 1900 + Integer.parseInt(cnp.substring(1, 3));
        } else if (primaCifra == '5' || primaCifra == '6') {
            anNastere = 2000 + Integer.parseInt(cnp.substring(1, 3));
        }

        int anulCurent = java.time.Year.now().getValue();

        return anulCurent - anNastere;
    }
}
