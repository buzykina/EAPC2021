import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InvertedDeck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger nrOfCards = sc.nextBigInteger();
        sc.nextLine();
        String[] times = sc.nextLine().split(" ");
        List<BigInteger> currentOrder = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            currentOrder.add(new BigInteger(times[i]));
        }
        BigInteger previous = currentOrder.get(0);
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < currentOrder.size(); i++) {
            if (startIndex == -1 || endIndex != -1) {
                if (currentOrder.get(i).compareTo(previous) == 1 || currentOrder.get(i).compareTo(previous) == 0) {
                    previous = currentOrder.get(i);
                } else {
                    if (startIndex != -1) {
                        System.out.println("impossible");
                        return;
                    }
                    startIndex = currentOrder.indexOf(currentOrder.get(i - 1));
                    previous = currentOrder.get(i);
                }
            } else {
                if (currentOrder.get(i).compareTo(previous) == -1 || currentOrder.get(i).compareTo(previous) == 0) {
                    previous = currentOrder.get(i);
                } else {
                    endIndex = i;
                }

            }
        }
        if (startIndex == -1) {
            System.out.println("1, 1");
            return;
        }

        List<BigInteger> toBeChecked = currentOrder.subList(startIndex, endIndex);
        BigInteger descPrevious = toBeChecked.get(0);
        for (int i = 1; i < toBeChecked.size(); i++) {
            if (toBeChecked.get(i).compareTo(descPrevious) == -1 || toBeChecked.get(i).compareTo(descPrevious) == 0) {
                descPrevious = toBeChecked.get(i);
            } else {
                System.out.println("impossible");
                return;
            }
        }

        System.out.println((startIndex + 1) + ", " + (endIndex + 1));

    }
}
