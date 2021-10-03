
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ExpeditiousCubing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        double[] times_int = Stream.of(line1.split(" ")).mapToDouble(Double::parseDouble).toArray();
        String line2 = sc.nextLine();
        double target = Double.parseDouble(line2);

        double min = Arrays.stream(times_int).min().getAsDouble();
        double max = Arrays.stream(times_int).max().getAsDouble();

        double sumOfAll = times_int[0] + times_int[1] + times_int[2] + times_int[3];
        double worstCase = (sumOfAll - min) / 3;
        double bestCase = (sumOfAll - max) / 3;

        if (target >= worstCase) {
            System.out.println("infinite");
        } else if (target < bestCase) {
            System.out.println("impossible");
        } else {
            double withoutMinMax = sumOfAll - min - max;
            double finalTry = 3 * target - withoutMinMax;
            double finalTryRounded = Math.round(finalTry * 100.0) / 100.0;
            System.out.println(finalTryRounded);
        }

    }
}