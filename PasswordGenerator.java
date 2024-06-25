import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        int length = 12; // default length
        System.out.println(generatePassword(length));
    }

    public static String generatePassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("Password length must be at least 4 characters");
        }

        StringBuilder password = new StringBuilder(length);
        String allowBase = PASSWORD_ALLOW_BASE;

        // at least one lower case letter
        password.append(getRandomChar(CHAR_LOWER));
        // at least one upper case letter
        password.append(getRandomChar(CHAR_UPPER));
        // at least one digit
        password.append(getRandomChar(NUMBER));
        // at least one special character
        password.append(getRandomChar(OTHER_CHAR));

        // fill in remaining length
        for (int i = 4; i < length; i++) {
            password.append(getRandomChar(allowBase));
        }

        return password.toString();
    }

    private static char getRandomChar(String input) {
        int index = random.nextInt(input.length());
        return input.charAt(index);
    }
}
