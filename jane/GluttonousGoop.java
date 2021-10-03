import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class GluttonousGoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger rows = sc.nextBigInteger();
        int columns = sc.nextInt();
        BigInteger steps = sc.nextBigInteger();
        int[][] grid = new int[rows.intValue()][];
        sc.nextLine();
        // Make grid from input
        for (int i = 0; i < grid.length; i++) {
            char[] line = sc.nextLine().toCharArray();
            int[] gridRow = new int[columns];
            for (int j = 0; j < columns; j++) {
                if (line[j] == '.') {
                    gridRow[j] = 0;
                } else {
                    gridRow[j] = 1;
                }
            }
            grid[i] = gridRow;
        }

        // Growing fungus
    }
}
