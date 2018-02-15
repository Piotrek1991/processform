package pl.dominisz;

import java.util.Random;

/**
 * http://dominisz.pl
 * 15.02.2018
 */
public class RandomPasswordGenerator {

    private static final String SYMBOLS = "!@#$%^&*()_+";
    private static final String NUMBERS = "1234567890";
    private static final String UPPERCASE_LETTERS = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String LOWERCASE_LETTERS = "qwertyuiopasdfghjklzxcvbnm";
    private static final String EMPTY = "";

    private static final Random RANDOM = new Random();

    public static String generate(int length, boolean useSymbols, boolean useNumbers,
                           boolean useUpperCase, boolean useLowerCase) {
        String alphabet = EMPTY;
        if (useSymbols) {
            alphabet += SYMBOLS;
        }
        if (useNumbers) {
            alphabet += NUMBERS;
        }
        if (useLowerCase) {
            alphabet += LOWERCASE_LETTERS;
        }
        if (useUpperCase) {
            alphabet += UPPERCASE_LETTERS;
        }
        if (alphabet.equals(EMPTY)) {
            alphabet = LOWERCASE_LETTERS;
        }
        StringBuilder password = new StringBuilder();
        int alphabetLength = alphabet.length();
        for (int i = 0; i < length; i++) {
            password.append(alphabet.charAt(RANDOM.nextInt(alphabetLength)));
        }
        return password.toString();
    }

}
