package org.example.algorithms;

import java.util.Arrays;

public class Algorithms {


    public int[] bubbleSortAlgorithms(int[] nums) {

        //This is the most inefficient algorithm
        // input -> 8,5,3,5,4
        //output -> 3,4,5,5,8
        int length = nums.length;
        for (int i = 0; i < length - 1; ++i) {
            for (int j = 0; j < length - 1 - i; ++j) {
                if (nums[j + 1] < nums[j]) {
                    int swap = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = swap;

                }

            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public int[] selectionSortAlgorithms(int[] nums) {
        //better than bubble sort
        //running time in independent of ordering elements
        int length = nums.length;
        if (length < 1)
            return nums;

        for (int i = 0; i <= length - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= length - 1; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }

            }

            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;

        }
        System.out.println(Arrays.toString(nums));

        return nums;

    }


    public int[] insertionSortAlgorithms(int[] nums) {
        //relatively good for small lists
        //relatively good for partially sorted lists
        int length = nums.length;
        if (length < 1)
            return nums;
        for (int i = 0; i <= length - 1; i++) {
            int current = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > current) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = current;

        }
        System.out.println(Arrays.toString(nums));

        return nums;
    }


    //stable and unstable sorts
    //it two elements are the same , then sorted algorithm should the original order -> stable sort
    //it two elements are the same , then sorted algorithm does not maintain  the original order -> unstable sort
}
