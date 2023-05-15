package ke.co.safaricom;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a message: ");
        String message = scanner.nextLine();

        System.out.print("Enter the key (1-25): ");
        int key = scanner.nextInt();

        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    public static String encrypt(String message, int key) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char encryptedChar = (char) (((c - base + key) % 26) + base);
                encryptedMessage.append(encryptedChar);
            } else {
                encryptedMessage.append(c);
            }
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String message, int key) {
        return encrypt(message, 26 - key); // Decrypting is same as encrypting with the complement key
    }
}
