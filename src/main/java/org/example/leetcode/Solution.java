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
        int[] mountainArray = new int[]{0, 1, 0};
        int[] nums = {86, 64, 15, 13, 10, 6, 2, 3, 0, 0, 1, 7, 412, -300};
        int target = 50;
        System.out.println("Mountain Peek>>>>>>>>>>>>>>>>>>" + peekIndexMountainArray(mountainArray));

        System.out.println("Linear Search>>>>>>>>>>>>>>>>>>" + linearSearch(arr, target));
        System.out.println("Binary Search Ascending Array Loops>>>>>>>>>>>>>>>>>>" + binarySearchLoops(ascendingArray, target));
        System.out.println("Binary Search Descending Array Loops>>>>>>>>>>>>>>>>>>" + binarySearchLoops(descendingArray, target));
        System.out.println("Binary Search Ascending Array Recursion>>>>>>>>>>>>>>>>>>" + binarySearchRecursion(ascendingArray, target));
        System.out.println("Binary Search Descending Array Recursion>>>>>>>>>>>>>>>>>>" + binarySearchRecursion(descendingArray, target));
        System.out.println("Bubble Sort Algorithmn>>>>>>>>>>>>>>>> " + Arrays.toString(bubbleSortAlgorithmn(nums)));
        System.out.println("Bubble Sort Algorithmn II>>>>>>>>>>>>>>>> " + Arrays.toString(bubbleSortAlgorithmnII(nums)));
        System.out.println("Selection Sort Algorithmn II>>>>>>>>>>>>>>>> " + Arrays.toString(selectionSortAlgorithm(nums)));
        System.out.println("Insertion Sort Algorithmn II>>>>>>>>>>>>>>>> " + Arrays.toString(insertionSortAlgorithmn(nums)));
        System.out.println("MERGE Sort Algorithmn II>>>>>>>>>>>>>>>> " + Arrays.toString(mergeSort(nums)));
        System.out.println("QUICK Sort Algorithmn II>>>>>>>>>>>>>>>> " + Arrays.toString(quickSort(nums)));

        testMethod();

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

    public static int peekIndexMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if (arr.length == 0) {
            return -1;
        }
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] > arr[middle + 1]) {
                end = middle;
            } else {
                start = middle + 1;
            }


        }
        return start;

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


    public static int[] bubbleSortAlgorithmn(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    //swap
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
    public  static  int  sortArray(int [] nums){
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                if (nums[j + 1] > nums[j] && nums[j-1]> nums[j]) {
                    return j;
                }
            }
        }
        return  -1;
    }

    public static int[] bubbleSortAlgorithmnII(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int z = 0; z < nums.length - 1; z++) {
                if (nums[z] > nums[z + 1]) {
                    int temp = nums[z + 1];
                    nums[z] = nums[z + 1];
                    nums[z + 1] = temp;
                }
            }

        }
        return nums;
    }

    public static int[] selectionSortAlgorithm(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }

                int temp = nums[minIndex];
                nums[minIndex] = nums[j];
                nums[j] = temp;

            }
        }
        return nums;

    }

    public static int[] insertionSortAlgorithmn(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    public static int[] mergeSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;

            }
            k++;
        }
        //possibility that one array is not complete!!
        while (i < left.length) {
            mix[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            mix[k] = right[j];
            j++;
            k++;
        }
        return mix;
    }

    private static int[] quickSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        return quickSortAlg(nums, low, high);

    }

    private static int[] quickSortAlg(int[] nums, int low, int high) {
        if (nums.length <= 1)
            return nums;
        if (low >= high) {
            return nums;
        }
        int start = low;
        int end = high;
        int middle = start + (end - start) / 2;
        int pivot = nums[middle];
        while (start <= end) {
            while (nums[start] < pivot) {
                start++;
            }

            while (nums[end] > pivot) {
                end--;
            }
            if (nums[start] >= nums[end]) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        quickSortAlg(nums, low, end);
        quickSortAlg(nums, start, high);
        return nums;


    }

    public String replaceWord(String input, String replacer) {
        String transactionID ="AAAAB2763A22";
        int firstPos = input.indexOf("~*STAN=") + "~*STAN=".length();
        int lastPos = input.indexOf("~*", firstPos);
        System.out.println("firstPos>>>>>>>>>>>>>>>>"+firstPos);
        System.out.println("lastPos>>>>>>>>>>>>>>>>"+lastPos);
        input = input.substring(0, firstPos) + replacer + input.substring(lastPos);
        String messageType = "MessageType=REVERSAL";
        input = input.replace("MessageType=NORMAL", messageType);
        String OriginalMsgID = "OriginalMessageID=~*";
        String OriginalMsgIDRev = "OriginalMessageID=" + transactionID + "~*";
        input = input.replace(OriginalMsgID, OriginalMsgIDRev);
        return input;
    }

    public static void testMethod(){
        StringBuilder sbSql = new StringBuilder(1024);
        String firstQuery = "select OT.TRAN_ID from OD_TXN_MASTER OD join OD_THIRDPARTY_TRANSACTIONS OT on(OD.OD_REF_NO=OT.TRAN_ID) WHERE OD.OD_FUNCTION_ID in(";
        String otherQuery = " AND  OD.OD_STATUS=? AND OT.DATECREATED < (CURRENT_TIMESTAMP - NUMTODSINTERVAL(?, 'SECOND')) AND OT.NEXTSEND < (CURRENT_TIMESTAMP) AND OT.QUERY_STATUS=? AND OT.TRANSACTION_STATUS=0 and OT.TRANSACTION_REF is not null AND OT.NO_OF_QUERIES<? FETCH FIRST ? ROWS ONLY";
        sbSql.append(firstQuery);
        String od ="CRMOB,CRB2B,SAFPOST,CRTILL";
        String[] functionCodes = od.split(",");
        for (int i = 0; i < functionCodes.length; i++) {
            if (i > 0)
                sbSql.append(",");
            sbSql.append(" ?");
        }
        sbSql.append(" ) ");
        sbSql.append(otherQuery);

        System.out.println(sbSql);
    }


}
