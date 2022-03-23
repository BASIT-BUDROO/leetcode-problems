package JumpGame;

public class JumpGame {
    public void canJump(int[] nums) {
        int[] dp = new int[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] >= nums.length - 1 - i) {
                dp[i] = 1;

            } else {
                int minimum = Integer.MAX_VALUE;
                for (int j = i + 1; j <= nums.length - 2; j++) {
                    if (nums[i] >= j - i && dp[j] != 0) {
                        if (dp[j] + 1 < minimum) {
                            minimum = dp[j] + 1;
                        }
                    }
                }
                if (minimum != Integer.MAX_VALUE) {
                    dp[i] = minimum;
                } else {
                    dp[i] = 0;
                }
            }
        }
        System.out.println(dp[0]);
    }

    public static void main(String[] args) {
        JumpGame sol = new JumpGame();
        int[] arr = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        sol.canJump(arr);
    }

}
