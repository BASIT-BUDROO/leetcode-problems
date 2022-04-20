package CodeChefProblems;

import java.io.*;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class CodeChef {
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {

            int test_cases = fr.nextInt();

            for (int i = 0; i < test_cases; i++) {
                int X = fr.nextInt();
                int Y = fr.nextInt();

                if (X == 1 || Y == 1 || ((X & 1) == 1 && (Y & 1) == 1)) {
                    bw.write("-1");
                    bw.write("\n");
                } else {

                    // X is even and Y is even
                    if ((X & 1) == 0 && (Y & 1) == 0) {
                        for (int k = 0; k < X / 2; k++) {
                            bw.write("a");
                        }
                        for (int k = 0; k < Y; k++) {
                            bw.write("b");
                        }
                        for (int k = 0; k < X / 2; k++) {
                            bw.write("a");
                        }
                        //
                        bw.write("\n");
                        //
                        for (int k = 0; k < Y / 2; k++) {
                            bw.write("b");
                        }
                        for (int k = 0; k < X; k++) {
                            bw.write("a");
                        }
                        for (int k = 0; k < Y / 2; k++) {
                            bw.write("b");
                        }
                        bw.write("\n");
                        //
                    } else {

                        char even_char;
                        int even_count = 0;
                        char odd_char;
                        int odd_count = 0;

                        if ((X & 1) == 0) {
                            even_char = 'a';
                            odd_char = 'b';
                            even_count = X;
                            odd_count = Y;
                        } else {
                            even_char = 'b';
                            odd_char = 'a';
                            even_count = Y;
                            odd_count = X;
                        }

                        for (int k = 0; k < even_count / 2; k++) {
                            bw.write(even_char);
                        }
                        for (int k = 0; k < odd_count; k++) {
                            bw.write(odd_char);
                        }
                        for (int k = 0; k < even_count / 2; k++) {
                            bw.write(even_char);
                        }
                        bw.write("\n");
                        //

                        for (int k = 0; k < odd_count / 2; k++) {
                            bw.write(odd_char);
                        }
                        for (int k = 0; k < even_count / 2; k++) {
                            bw.write(even_char);
                        }
                        //
                        bw.write(odd_char);
                        //
                        for (int k = 0; k < even_count / 2; k++) {
                            bw.write(even_char);
                        }
                        for (int k = 0; k < odd_count / 2; k++) {
                            bw.write(odd_char);
                        }
                        bw.write("\n");
                    }

                }
                bw.flush();
            }
        } catch (Exception ignored) {
        }
    }
}
