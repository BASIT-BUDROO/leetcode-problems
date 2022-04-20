package Practice;

import java.util.*;

class Solution {
    public List<List<Integer>> getSorted(ArrayList<Integer> arr) {

        Map<Integer, Integer> tm = new HashMap<>();

        for (Integer element : arr) {
            if (tm.containsKey(element)) {
                tm.put(element, tm.get(element) + 1);
            }
            else {
                tm.put(element,1);
            }
        }

        List<List<Integer>> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            resultList.add(new ArrayList<>(Arrays.asList(entry.getKey(), entry.getValue())));
        }
        resultList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (!Objects.equals(o1.get(1), o2.get(1))) {
                    return o2.get(1).compareTo(o1.get(1));
                }
                else {
                    return o1.get(1).compareTo(o2.get(1));
                }
            }
        });

        for (List<Integer> element : resultList) {
            System.out.println(element);
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 3, 3, 4, 4, 4, 5, 5, 5, 7));
        solution.getSorted(list);
    }
}