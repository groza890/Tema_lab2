package problema3;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citirea șirului principal
        System.out.print("Introduceți șirul inițial: ");
        String sirInitial = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(sirInitial);

        // Citirea șirului de inserat
        System.out.print("Introduceți șirul pe care doriți să-l inserați: ");
        String sirDeInserat = scanner.nextLine();

        // Citirea poziției la care se va insera
        System.out.print("Introduceți poziția la care doriți să inserați șirul: ");
        int pozitieInserare = scanner.nextInt();

        // Inserarea șirului la poziția specificată
        if (pozitieInserare >= 0 && pozitieInserare <= stringBuilder.length()) {
            stringBuilder.insert(pozitieInserare, sirDeInserat);
            System.out.println("Șirul rezultat după inserare: " + stringBuilder.toString());
        } else {
            System.out.println("Poziția de inserare este invalidă.");
        }

        // Citirea datelor pentru ștergere
        System.out.print("Introduceți poziția de la care doriți să ștergeți: ");
        int pozitieStergere = scanner.nextInt();
        System.out.print("Introduceți numărul de caractere pe care doriți să le ștergeți: ");
        int numarCaractere = scanner.nextInt();

        // Ștergerea porțiunii specificate din șir
        if (pozitieStergere >= 0 && pozitieStergere < stringBuilder.length() &&
                pozitieStergere + numarCaractere <= stringBuilder.length()) {
            stringBuilder.delete(pozitieStergere, pozitieStergere + numarCaractere);
            System.out.println("Șirul rezultat după ștergere: " + stringBuilder.toString());
        } else {
            System.out.println("Poziția de ștergere sau numărul de caractere este invalid.");
        }
        scanner.close();
    }
}
