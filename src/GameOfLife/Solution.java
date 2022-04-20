package GameOfLife;

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1 || s.length() == numRows) {
            return s;
        }

        Map<Integer, StringBuilder> map = new TreeMap<>();
        StringBuilder str = new StringBuilder();

        boolean down = true;
        int rowNum = 0;

        for (int j = 0; j < numRows; j++) {
            map.put(j, new StringBuilder());
        }

        for (int i = 0; i < s.length(); i++) {
            if (rowNum <= numRows - 1 && down) {
                map.get(rowNum).append(s.charAt(i));
                if (rowNum == numRows - 1) {
                    down = false;
                    rowNum--;
                } else {
                    rowNum++;
                }
            }

            else if (rowNum >= 0 && !down) {

                map.get(rowNum).append(s.charAt(i));
                if (rowNum == 0) {
                    down = true;
                    rowNum++;
                } else {
                    rowNum--;
                }
            }

        }

        for (Map.Entry<Integer, StringBuilder> entry : map.entrySet()) {
            str.append(entry.getValue());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.convert("PAYPALISHIRING", 100);
        System.out.println(result);
    }
}