package KClosestPoints;

import java.util.*;

public class Solution {
    static class CustomPair implements Comparator<CustomPair> {
        int distance;
        int a;
        int b;

        CustomPair(int distance, int a, int b) {
            this.distance = distance;
            this.a = a;
            this.b = b;
        }

        public CustomPair() {

        }

        @Override
        public int compare(CustomPair o1, CustomPair o2) {
            int val = o2.distance - o1.distance;
            return Integer.compare(val, 0);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<CustomPair> priorityQueue = new PriorityQueue<>(new CustomPair());

        for (int[] point : points) {
            int distance = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
            int a = point[0];
            int b = point[1];
            priorityQueue.add(new CustomPair(distance, a, b));
        }
        for (int j = 0; j < k; j++) {
            CustomPair pair = priorityQueue.poll();
            assert pair != null;
            result[j][0] = pair.a;
            result[j][1] = pair.b;
        }

        return result;
    }
}
