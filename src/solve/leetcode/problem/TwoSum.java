package solve.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/*
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] test1 = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(test1[0] + ", " + test1[1]);

        int[] test2 = twoSum.twoSum(new int[]{1, 0, -1}, -1);
        System.out.println(test2[0] + ", " + test2[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> lookup = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (lookup.containsKey(diff)) {
                indices[0] = lookup.get(diff) + 1;
                indices[1] = i + 1;
                break;
            } else {
                lookup.put(numbers[i], i);
            }
        }
        return indices;
    }
}
