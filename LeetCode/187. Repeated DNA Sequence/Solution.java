package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kalpak
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA,
 * it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */


public class Solution {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> sequence = new HashSet<>();
        Set<String> repeatedSequence = new HashSet<>();

        for(int i = 0; i < s.length() - 9; i++) {
            String dnaSeq = s.substring(i, i+10);

            if(sequence.add(dnaSeq) == false) {
                // the dnaSequence is already seen and the current sequence is a repetition
                repeatedSequence.add(dnaSeq);
            }
        }

        return new ArrayList<>(repeatedSequence);
    }
}
