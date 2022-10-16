package org.example.algorithms;

import lombok.var;

import java.util.*;

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

    public boolean binarySearch(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] == x) {
                return true;

            } else if (x < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
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


    public int[] mergeSortAlgorithmEasy(int[] nums) {
        return mergeSortEasy(nums, 0, nums.length - 1, new int[nums.length]);

    }

    private int[] mergeSortEasy(int[] nums, int leftStart, int rightEnd, int[] temp) {
        if (leftStart >= rightEnd) {
            return nums;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSortEasy(nums, leftStart, middle, temp);
        mergeSortEasy(nums, middle + 1, rightEnd, temp);
        return mergeHalves(nums, leftStart, rightEnd, temp);
    }

    private int[] mergeHalves(int[] nums, int leftStart, int rightEnd, int[] temp) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftStart + 1;
        int size = (rightEnd - leftEnd) + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightStart) {
            if (nums[left] <= nums[right]) {
                temp[index] = nums[left];
                left++;

            } else {
                temp[index] = nums[right];
                right++;
            }
            index++;
        }
        System.arraycopy(nums, left, temp, index, leftEnd - left + 1);
        System.arraycopy(nums, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, nums, leftStart, size);
        return nums;
    }


    public int[] mergeSortAlgorithms(int[] nums) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        return mergeSort(nums, start, end);
    }

    private int[] mergeSort(int[] nums, int start, int end) {
        if (start > end) {
            var middle = (int) Math.floor((start + end) / 2);
            mergeSort(nums, start, middle);
            mergeSort(nums, (middle + 1), end);
            merge(nums, start, (middle), end);
        }
        return nums;
    }

    private void merge(int[] data, int start, int mid, int end) {
        int sizeOfLeft = mid - start + 1;
        int sizeOfRight = end - mid;
        int[] left = new int[sizeOfLeft];
        int[] right = new int[sizeOfRight];
        for (int i = 0; i < sizeOfLeft; i++) {
            left[i] = data[start + i]; // be careful here
        }
        for (int j = 0; j < sizeOfRight; j++) {
            right[j] = data[mid + 1 + j]; // be careful
        }
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if ((j >= sizeOfRight) || (i < sizeOfLeft && left[i] <= right[j])) {
                data[k] = left[i];
                i++;
            } else {
                data[k] = right[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(data));

    }

    public int solution(int[] A, int[] B, int X, int Y) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= X && B[i] >= Y) {
                count++;
            }
        }
        return count;
    }


    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i <= length - 1; i++) {
            int current = nums[i];
            System.out.println("i value::::::::::::" + current);
            int j = i - 1;
            while (j >= 0 && nums[j] > current) {
                nums[j + 1] = nums[j];

                j = j - 1;
            }
            System.out.println("j value::::::::::::" + nums[j]);

            nums[j + 1] = current;

        }
        return new int[]{};
    }

    public static long maximumQuality(List<Integer> packets, int channels) {
        // Write your code here
        int length = packets.size();

        double answer = 0;
        if (length == channels) {
            for (int i = 0; i < length; i++) {
                answer += packets.get(i);
            }
            return (long) answer;
        }
        Collections.sort(packets);

        for (int i = length - channels + 1; i < length; i++) {
            answer += packets.get(i);
        }

        length = length - channels;
        if (length % 2 == 0) {
            // odd
            answer += packets.get(length / 2);
        } else {
            //even
            double value = packets.get(length / 2) + packets.get((length / 2) + 1);
            answer += value / 2;
        }
        return (long) Math.ceil(answer);
    }


    public long findTotalImbalance(List<Integer> rank) {
        long mImbalance = 0;
        int r = 0;
        TreeSet<Integer> mImbalanceSet = new TreeSet<>();
        while (r < rank.size() - 1) {
            mImbalanceSet.clear();
            mImbalanceSet.add(rank.get(r));
            long currentImbalance = 0;
            for (int i = r + 1; i < rank.size(); i++) {
                Integer e = rank.get(i);
                mImbalanceSet.add(e);
                Integer f = mImbalanceSet.lower(e);
                Integer c = mImbalanceSet.higher(e);
                if (f == null) {
                    currentImbalance += ((c - e) > 1 ? 1 : 0);
                } else if (c == null) {
                    currentImbalance += (((e - f) > 1) ? 1 : 0);
                } else {
                    currentImbalance += (c - f) > 1 ? -1 : 0;
                    currentImbalance += (((c - e) > 1) ? 1 : 0);
                    currentImbalance += ((e - f)) > 1 ? 1 : 0;
                }
                mImbalance += currentImbalance;
            }
            r++;
        }

        return mImbalance;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] mark = new int[500];
        int len = s.length(), en = 0, mx = 0, cnt = 0;

        for (int st = 0; st < len; st++) {
            if (mark[s.charAt(st)] > 0) {
                for (; en < st; en++) {
                    if (s.charAt(en) == s.charAt(st)) {
                        en++;
                        break;
                    }

                    cnt--;
                    mark[s.charAt(en)]--;
                }
            } else {
                cnt++;
                mark[s.charAt(st)]++;
                mx = Math.max(mx, cnt);
            }
        }

        return mx;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        int size = nums.length;
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sublist = new ArrayList<>();
                        sublist.add(nums[i]);
                        sublist.add(nums[j]);
                        sublist.add(nums[k]);
                        lists.add(sublist);
                    }

                }
            }

        }
        return lists;
    }

//stable and unstable sorts
//it two elements are the same , then sorted algorithm should the original order -> stable sort
//it two elements are the same , then sorted algorithm does not maintain  the original order -> unstable sort
}
