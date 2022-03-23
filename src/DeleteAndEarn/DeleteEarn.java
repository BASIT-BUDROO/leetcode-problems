package DeleteAndEarn;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DeleteEarn {
    public static TreeMap<Integer, Integer> createFrequencyMap(int[] arr) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int j : arr) {
            if (tm.containsKey(j)) {
                tm.put(j, tm.get(j) + 1);
            } else {
                tm.put(j, 1);
            }
        }
        return tm;
    }

    public int deleteEarn(int[] nums) {
        int maximum = 0;
        int val1 = 0, val2 = 0;

        TreeMap<Integer, Integer> tm = DeleteEarn.createFrequencyMap(nums);
        Set<Map.Entry<Integer, Integer>> tm_set = tm.entrySet();
        Iterator<Map.Entry<Integer, Integer>> i = tm_set.iterator();
        Map.Entry<Integer, Integer> i1 = i.next();

        if (tm.size() == 1) {
            val1 = i1.getKey() * i1.getValue();
            return val1;
        }

        Map.Entry<Integer, Integer> i2 = i.next();
        if (tm.size() == 2) {
            val1 = i1.getKey() * i1.getValue();
            val2 = i2.getKey() * i2.getValue();
            if (i2.getKey() > i1.getKey() + 1) {
                return val1 + val2;
            } else {
                val2 = Math.max(val1, val2);
                return val2;
            }
        }

        val1 = i1.getKey() * i1.getValue();

        if (i2.getKey() > i1.getKey() + 1) {
            val2 = val1 + i2.getKey() * i2.getValue();
        } else {
            val2 = Math.max(val1, i2.getKey() * i2.getValue());
        }

        Map.Entry<Integer, Integer> entry;
        Map.Entry<Integer, Integer> prev_entry = i2;

        while (i.hasNext()) {
            entry = i.next();
            if (entry.getKey() > prev_entry.getKey() + 1) {
                maximum = entry.getKey() * entry.getValue() + val2;
            } else {
                maximum = Math.max(entry.getKey() * entry.getValue() + val1, val2);
            }
            val1 = val2;
            val2 = maximum;
            prev_entry = entry;
        }

        return maximum;
    }

    public static void main(String[] args) {
        DeleteEarn dp = new DeleteEarn();
        int[] arr = {2, 2, 3, 3, 3, 4};
        System.out.println(dp.deleteEarn(arr));
    }
}
