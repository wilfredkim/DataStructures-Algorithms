package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackDatastructure {

    public static void main(String... args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        // it searches by indexes!!!!!
        System.out.println(stack.search(2));

        // Default initialization of Stack
        Stack stack1 = new Stack();

        // Initialization of Stack
        // using Generics
        Stack<String> stack2 = new Stack<String>();

        // pushing the elements
        stack1.push(4);
        stack1.push("All");
        stack1.push("Geeks");

        stack2.push("Geeks");
        stack2.push("For");
        stack2.push("Geeks");

        // Printing the Stack Elements
        System.out.println(stack1);
        System.out.println(stack2);
        System.out.println(stack2.peek());

    }

    public String balancedBrackerChallenge(String s) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == '{' || chr == '(' || chr == '[') {
                characters.push(chr);
            } else if (characters.isEmpty()) {
                return "NO";
            } else if (chr == '}') {
                char peek = characters.peek();
                if (peek == '{') {
                    characters.pop();
                } else {
                    return "NO";
                }
            } else if (chr == ')') {
                char peek = characters.peek();
                if (peek == '(') {
                    characters.pop();
                } else {
                    return "NO";
                }
            } else if (chr == ']') {
                char peek = characters.peek();
                if (peek == '[') {
                    characters.pop();
                } else {
                    return "NO";
                }
            }
        }
        return !characters.isEmpty() ? "NO" : "YES";
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here


        int h1Sum = 0, h2Sum = 0, h3Sum = 0;
        Stack<Integer> h1Stack = new Stack<>();
        Stack<Integer> h2Stack = new Stack<>();
        Stack<Integer> h3Stack = new Stack<>();
        if (h1.size() > 0) {
            for (int i = h1.size() - 1; i >= 0; i--) {
                h1Sum += h1.get(i);
                h1Stack.push(h1Sum);
            }
        }
        if (h2.size() > 0) {
            for (int i = h2.size() - 1; i >= 0; i--) {
                h2Sum += h2.get(i);
                h2Stack.push(h2Sum);
            }
        }

        if (h3.size() > 0) {
            for (int i = h3.size() - 1; i >= 0; i--) {
                h3Sum += h3.get(i);
                h3Stack.push(h3Sum);
            }
        }
        int[] arr = {h1Sum, h2Sum, h3Sum};
        System.out.println(Arrays.toString(arr));
        while (true) {

            // If any stack is empty
            if (h1Stack.isEmpty() || h2Stack.isEmpty() || h3Stack.isEmpty())
                return 0;

            h1Sum = h1Stack.peek();
            h2Sum = h2Stack.peek();
            h3Sum = h3Stack.peek();

            // If sum of all three stack are equal.
            if (h1Sum == h2Sum && h2Sum == h3Sum)
                return h1Sum;

            // Finding the stack with maximum sum and
            // removing its top element.
            if (h1Sum >= h2Sum && h1Sum >= h3Sum)
                h1Stack.pop();
            else if (h2Sum >= h1Sum && h2Sum >= h3Sum)
                h2Stack.pop();
            else if (h3Sum >= h2Sum && h3Sum >= h1Sum)
                h3Stack.pop();
        }

    }


    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int h1Sum = 0, h2Sum = 0;

        if (a.size() > 0) {
            for (int i = a.size() - 1; i >= 0; i--) {
                stack1.push(a.get(i));
            }
        }
        if (b.size() > 0) {
            for (int i = b.size() - 1; i >= 0; i--) {
                stack2.push(b.get(i));
            }
        }
        System.out.println("Stack One:::::::" + stack1);
        System.out.println("Stack Two:::::::" + stack2);
        int count = 0;
        int sum = 0;
        while (true) {
            if (!stack1.isEmpty()) {
                h1Sum = stack1.peek();
            }
            if (!stack2.isEmpty()) {
                h2Sum = stack2.peek();
            }
            System.out.println("h1Sum:::::::" + h1Sum);
            System.out.println("h2Sum:::::::" + h2Sum);
            System.out.println("Sum:::::::" + sum);
            if (sum <= maxSum && (h1Sum + h2Sum + sum) <= maxSum) {
                sum = sum + h1Sum + h2Sum;
                if (!stack1.isEmpty()) {
                    stack1.pop();
                    count++;
                }
                if (!stack2.isEmpty()) {
                    stack2.pop();
                    count++;
                }

            } else if (sum <= maxSum && (h1Sum + sum) <= maxSum && (h1Sum + h2Sum + sum) > maxSum) {
                sum = sum + h1Sum;
                if (!stack1.isEmpty()) {
                    stack1.pop();
                    count++;
                }

            } else if (sum <= maxSum && (h2Sum + sum) <= maxSum && (h1Sum + h2Sum + sum) > maxSum) {
                sum = sum + h2Sum;
                if (!stack2.isEmpty()) {
                    stack2.pop();
                    count++;
                }

            } else {
                return count;
            }


        }

    }
    public int solve(int maxSum, List<Integer> a, List<Integer> b) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for(int i=0; i<a.size(); i++){
            st1.push(a.get(i));
        }
        for(int i=0; i<b.size(); i++){
            st2.push(b.get(i));
        }
        int lengthB=0;
        int sum = 0;
        while(lengthB<b.size() && (sum+b.get(lengthB)) <= maxSum ){
            sum += b.get(lengthB);
            lengthB++;
        }
        int maxScore = lengthB;
        for(int i=0; i<a.size(); i++){
            sum += a.get(i);
            while( sum > maxSum && lengthB > 0){
                lengthB--;
                sum -= b.get(lengthB);
            }
            if(sum>maxSum){
                break;
            }
            maxScore = Math.max( maxScore,lengthB + i+1 );
        }
        return maxScore;
    }


}
