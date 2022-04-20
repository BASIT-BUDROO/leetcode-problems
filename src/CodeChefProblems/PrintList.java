package CodeChefProblems;

public class PrintList {

    public static void main(String[] args) {
        int A = 22;
        int B = 11;
        int C = 57;
        int k;
        for (int i = 0; i < 100; i++) {
            k = (A ^ B) + (B ^ C) + (C ^ A);
            System.out.println(Integer.toBinaryString(i) + "\t\t\t" + k);
            A++;B++;C++;
        }
    }
}
