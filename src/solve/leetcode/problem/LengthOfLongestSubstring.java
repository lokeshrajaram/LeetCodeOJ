package solve.leetcode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters. For
 * example, the longest substring without repeating letters for "abcabcbb" is "abc", which the
 * length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Created by Lokee on 2/1/15.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("bpfbhmipx"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = 0;
        int newLength = 0;
        int startIndex = 0;
        char[] sequence = s.toCharArray();
        Set<Character> lookup = new HashSet<Character>();

        for (int i = 0; i < sequence.length; i++) {
            if (lookup.contains(sequence[i])) {
                if (newLength > length) {
                    length = newLength;
                }

                while (sequence[startIndex] != sequence[i]) {
                    lookup.remove(sequence[startIndex++]);
                }

                newLength = lookup.size();
                startIndex = (i - newLength) + 1;
            } else {
                lookup.add(sequence[i]);
                newLength++;
            }
        }

        if (newLength > length) {
            length = newLength;
        }

        return length;
    }

}
