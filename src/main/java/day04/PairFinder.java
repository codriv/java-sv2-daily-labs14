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

    public int findPairsTwo(int[] arr) {
        int count = 0;
        for (int num: arr) {
            count += pairs(arr, num);
        }
        return count;
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

    public static void main(String[] args) {
        int[] tomb = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        PairFinder pf = new PairFinder();
        System.out.println(pf.findPairs(tomb));
        System.out.println(pf.findPairsTwo(tomb));
    }
}
