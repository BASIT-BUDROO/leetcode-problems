package TwoCityScheduling;

import java.util.*;

public class TwoCityScheduling {
    public void twoCitySchedulingCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> a[1] - a[0]));

        for (int[] item : costs) {
            System.out.println("A: " + item[0] + " B: " + item[1] + " Diff: " + (item[1] - item[0]));
        }


    }

    public static void main(String[] args) {
        TwoCityScheduling sol = new TwoCityScheduling();
        int[][] Arr = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        sol.twoCitySchedulingCost(Arr);


    }
}
