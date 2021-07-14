package com.atzy.test;

import java.util.HashSet;
import java.util.Set;


public class TestLeetCodeDemo {
    public static void main(String[] args) {
        int size = Solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(size);
    }
}

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> hash =  new HashSet<Character>();

        for (int i=0;i<s.length();i++){
            System.out.println(s.charAt(i));
            hash.add(s.charAt(i));
        }
        return hash.size();
    }
}