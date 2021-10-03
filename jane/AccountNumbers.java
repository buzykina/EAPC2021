import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountNumbers {
    public static boolean validate(String input) {
        String number_str = "";
        for (int i = 0; i < input.length(); i++) {
            char current_char = input.charAt(i);
            int ascii = (int) current_char;
            int conv = ascii;
            if (ascii > 64 && ascii < 91) {
                conv = conv - 'A' + 10;
                number_str = number_str + conv;
            } else {
                conv = conv - '0';
                number_str = number_str + conv;
            }
        }
        BigInteger number = new BigInteger(number_str);
        return number.mod(BigInteger.valueOf(97)).equals(BigInteger.valueOf(1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String before4th = input.substring(0, 4);
        String after4th = input.substring(4);
        String newInput = after4th + before4th;
        boolean isCorrect = validate(newInput);
        if (isCorrect) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }

    }
}