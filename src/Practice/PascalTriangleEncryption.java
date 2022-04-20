package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleEncryption {
    /*
    Given a list of integers (size = n) Encrypt this list using pascals triangle algorithm.
    Algorithm is as follows:
    1. Take two adjacent items of the list and sum them. Example A[0] + A[1], A[1] + A[2], ...
    2. After this step you will have n-1 integers.
    3. Repeat step 1 un-till you have only 2 numbers and return right most digits of the two numbers from Left to right

    Constraints: While summing if number is 2 digit take only right most digit and sum it. i.e., you should not sum
                 two-digit numbers as it is.
     */

    public String pascalEncryption(List<Integer> list) {
        int iter_count = list.size() - 1;
        int i=0;
        while (list.size() != 2) {
            int sum = list.get(0) % 10 + list.get(1) % 10;
            list.add(sum);
            list.remove(0);
            if (i + 1 == iter_count) {
                list.remove(0);
                iter_count = iter_count - 1;
                i = 0;
            } else {
                i++;
            }
        }
        int first = list.get(0) % 10;
        int second = list.get(1) % 10;
        return Integer.toString(first) + second;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(20, 39, 42, 81));
        PascalTriangleEncryption pascalTriangleEncryption = new PascalTriangleEncryption();
        System.out.println(pascalTriangleEncryption.pascalEncryption(list));

    }

}
