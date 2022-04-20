package CodeChefProblems;

import java.io.*;
import java.util.*;

public class ChefAndRecipe {
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        try {
            int test_cases = fr.nextInt();

            for (int i = 0; i < test_cases; i++) {

                HashMap<Integer, Integer> hashmap = new HashMap<>();
                int N = fr.nextInt();
                int[] recipe = new int[N];
                for (int j = 0; j < N; j++) {
                    recipe[j] = fr.nextInt();
                }

                for (int j = 0; j < N; j++) {
                    if (!hashmap.containsKey(recipe[j])) {
                        hashmap.put(recipe[j], 1);
                    } else {
                        hashmap.put(recipe[j], hashmap.get(recipe[j]) + 1);
                    }
                }

                HashMap<Integer, Integer> distinctHM = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
                    if (!distinctHM.containsKey(entry.getValue())) {
                        distinctHM.put(entry.getValue(), 1);
                    } else {
                        System.out.println("NO");
                        break;
                    }
                }

                // Checking if frequency is distinct
                HashMap<Integer, Boolean> visited = new HashMap<>();
                if (hashmap.size() == distinctHM.size()) {
                    int curr_ind = 1;
                    while (curr_ind < N) {
                        while (recipe[curr_ind] != recipe[curr_ind - 1]) {
                            curr_ind++;
                        }
                        if (!visited.containsKey(recipe[curr_ind - 1])) {
                            visited.put(recipe[curr_ind - 1], true);
                            curr_ind++;
                            continue;
                        } else {
                            if (visited.get(recipe[curr_ind - 1])) {
                                System.out.println("NO");
                                break;
                            }
                        }
                        System.out.println("YES");
                    }

                }

            }
        } catch (Exception ignored) {
        }
    }
}
