package day04;

import java.util.HashMap;
import java.util.Map;

public class PairFinder {

    public int findPairs(int[] arr) {
        Map<Integer, Integer> pair = new HashMap<>();
        for (int num: arr) {
            pair.put(num, pairs(arr, num));
        }
        return pair.values().stream().mapToInt(i->i).sum();
    }

    private int pairs(int[] arr, int num) {
        int count = 0;
        for(int act:arr) {
            if (num == act) {
                count++;
            }
        }
        return count / 2;
    }
}
