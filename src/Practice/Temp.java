package Practice;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


    public static void main(String[] args) throws java.lang.Exception {
        FastReader fr = new FastReader();
        try {

            int test_cases = fr.nextInt();

            for (int i = 0; i < test_cases; i++) {

                int A = fr.nextInt();
                int B = fr.nextInt();
                int sum = -1;

                if (B - A + 1 <= 2) {
                    System.out.println(-1);
                    continue;
                }

                if (A >= 1e9 - 1) {
                    System.out.println(-1);
                    continue;
                }

                // Handling base case for N = 3
                if (B - A + 1 == 3) {
                    if ((A & 1) == 0) {
                        sum = A + 2;
                        System.out.println(A + " " + sum);
                    } else {
                        System.out.println(-1);
                    }
                    continue;
                }

                if ((A & 1) == 0) {
                    // A and A + 2 will satisfy all the conditions
                    // They have GCD of 2
                    // A and A + 2 are not equal
                    // A + A + 2 has minimum sum.
                    sum = A + 2;
                    System.out.println(A + " " + sum);
                } else {
                    // We will have to decide a pair between A, A+1, A+2, A+3
                    // IF A is divisible by three then pair will be A and A+3

                    // IF A == 1
                    if (A == 1) {
                        System.out.println(2 + " " + 4);
                        continue;
                    }

                    if (A % 3 == 0) {
                        sum = A + 3;
                        System.out.println(A + " " + sum);
                    } else {
                        sum = A + 3;
                        System.out.println(A + 1 + " " + sum);
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }
}
