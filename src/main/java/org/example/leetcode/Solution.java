package org.example.leetcode;

import lombok.var;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        int[] arr = new int[]{15, 79, 20, 142, 78, 54, 67, 98};
        int[] ascendingArray = new int[]{15, 20, 50, 54, 67, 79, 78, 98, 142};
        int[] descendingArray = new int[]{200, 198, 150, 120, 100, 78, 50, 16, 13, 7, 8, 0};
        int target = 50;
        System.out.println("Linear Search>>>>>>>>>>>>>>>>>>" + linearSearch(arr, target));
        System.out.println("Binary Search Ascending Array Loops>>>>>>>>>>>>>>>>>>" + binarySearchLoops(ascendingArray, target));
        System.out.println("Binary Search Descending Array Loops>>>>>>>>>>>>>>>>>>" + binarySearchLoops(descendingArray, target));
        System.out.println("Binary Search Ascending Array Recursion>>>>>>>>>>>>>>>>>>" + binarySearchRecursion(ascendingArray, target));
        System.out.println("Binary Search Descending Array Recursion>>>>>>>>>>>>>>>>>>" + binarySearchRecursion(descendingArray, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[]{0, 0};

        for (int i = 0; i < nums.length; i++) { //Time complexity O(n^2)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return new int[]{0, 0};

    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        var sArr = s.split("");
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < sArr.length; i++) {
            for (int j = i + 1; j < sArr.length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    hashSet.add(s.substring(i, j));
                    break;
                }


            }
        }
        int size = 0;

        for (String set : hashSet) {
            if (set.length() > size) {
                size = set.length();
            }
        }
        return size;
    }

    public static int linearSearch(int[] arr, int target) {
        //Time COmplexity here (0(1)
        if (arr.length == 0) {
            return -1;

        }
        //Time COmplexity here (0(n)
        //n represent the size of array.//number of elements in an array!
        //worst case if the number is last in array or does not exist!!
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchLoops(int[] arr, int target) {
        //sorted array in descending or ascending
        //best scenario  -> when first middle is equal to the target.
        //worst case scenario -> (0(log(n))
        int start = 0;
        int end = arr.length - 1;
        return binarySearchUsingLoops(arr, target, start, end);
    }

    public static int binarySearchRecursion(int[] arr, int target) {
        //sorted array in descending or ascending
        //best scenario  -> when first middle is equal to the target.
        //worst case scenario -> (0(log(n))
        int start = 0;
        int end = arr.length - 1;
        boolean isAscending = arr[start] < arr[end];
        return recursiveBinarySearch(arr, target, start, end, isAscending);
    }

    private static int binarySearchUsingLoops(int[] arr, int target, int start, int end) {
        if (arr.length == 0) {
            return -1;
        }
        boolean isAscending = arr[start] < arr[end];
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (isAscending) {
                if (target < arr[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (target > arr[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }


        }
        return -1;
    }

    private static int recursiveBinarySearch(int[] arr, int target, int start, int end, boolean isAscending) {

        int middle = start + (end - start) / 2;
        if (arr[middle] == target) {
            return middle;
        }
        if (isAscending) {
            if (target < arr[middle]) {
                return recursiveBinarySearch(arr, target, start, middle - 1, isAscending);

            }
            if (target > arr[middle]) {
                return recursiveBinarySearch(arr, target, middle + 1, end, isAscending);
            }
        } else {
            if (target < arr[middle]) {
                return recursiveBinarySearch(arr, target, middle + 1, end, isAscending);
            }
            if (target > arr[middle]) {
                return recursiveBinarySearch(arr, target, start, middle - 1, isAscending);
            }

        }


        return -1;

    }


    public int[] twoSum2(int[] nums, int target) {

        if (nums == null || nums.length < 2)
            return new int[]{0, 0};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[]{0, 0};
    }
}
