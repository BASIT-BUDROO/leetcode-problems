package StreetRobber;

public class StreetRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int alpha_A = nums[0]; // Max up to prior house
        int beta_A = Math.max(nums[0], nums[1]); // Max up to current house

        int current_first = Math.max(alpha_A, beta_A);

        for (int i = 2; i < nums.length - 1; i++) {
            current_first = Math.max(nums[i] + alpha_A, beta_A);
            alpha_A = beta_A;
            beta_A = current_first;
        }

        int alpha_B = nums[1]; // Max up to prior house
        int beta_B = Math.max(nums[1], nums[2]); // Max up to current house

        int current_second = Math.max(alpha_B, beta_B);

        for (int i = 3; i < nums.length; i++) {
            current_second = Math.max(nums[i] + alpha_B, beta_B);
            alpha_B = beta_B;
            beta_B = current_second;
        }
        return Math.max(current_first, current_second);
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        StreetRobber streetRobber = new StreetRobber();
        System.out.println(streetRobber.rob(nums));
    }

}
