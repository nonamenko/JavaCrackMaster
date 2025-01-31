import java.util.Scanner;

public class JavaCrackMaster {

    // Function to obfuscate characters
    private static char obfuscate(char c) {
        return (char) (c ^ 0x5A);
    }

    // Function to get the obfuscated correct password
    private static String getObfuscatedPassword() {
        String password = "SecurePass123";
        StringBuilder obfPassword = new StringBuilder();
        for (char c : password.toCharArray()) {
            obfPassword.append(obfuscate(c));
        }
        return obfPassword.toString();
    }

    // Function to check the password
    private static boolean checkPassword(String input) {
        String obfuscatedPassword = getObfuscatedPassword();
        StringBuilder obfInput = new StringBuilder();
        for (char c : input.toCharArray()) {
            obfInput.append(obfuscate(c));
        }
        return obfInput.toString().equals(obfuscatedPassword);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to JavaCrackMaster!");
        System.out.print("Please enter the activation password: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        // Small delay to complicate analysis
        try {
            Thread.sleep(500); // 500 milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (checkPassword(input)) {
            System.out.println("Congratulations! You have cracked JavaCrackMaster.");
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }
}
