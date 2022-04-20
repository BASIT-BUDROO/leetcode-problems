package SpeedTyping;

import java.util.*;
import java.io.*;

public class SpeedTyping {

    public void solve(String I, String P, int test_case) {
        if (P.length() < I.length()) {
            System.out.println("Case #" + test_case + ": IMPOSSIBLE");
            return;
        }
        int count = 0;
        int i_index = 0;
        int p_index = 0;
        while (i_index < I.length() && p_index < P.length()) {
            if (I.charAt(i_index) == P.charAt(p_index)) {
                count++;
                i_index++;
                p_index++;
            } else if (I.charAt(i_index) != P.charAt(p_index)) {
                p_index++;
            }
        }
        if (count == I.length()) {
            System.out.println(P.length() - I.length());
            System.out.println("Case #" + test_case + ": " + (P.length() - I.length()));
        } else {
            System.out.println("Case #" + test_case + ": IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        SpeedTyping solution = new SpeedTyping();
        try {
            Scanner scanner = new Scanner(System.in);
            int test_cases = scanner.nextInt();

            for (int i = 0; i < test_cases; i++) {
                String I = scanner.next();
                String P = scanner.next();
                solution.solve(I, P, i + 1);
            }

        } catch (Exception ignored) {
        }
    }
}
