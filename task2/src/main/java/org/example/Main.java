package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = in.nextInt();
        List<Integer> numbers = new ArrayList<>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            numbers.add(random.nextInt(0, 10));
        }

        Set<Integer> result = new HashSet<>();

        int maxCount = 1;
        for (int i = 0; i < n; i++) {
            int count = 1;
            int currentNumber = numbers.get(i);

            for (int j = i + 1; j < n; j++) {
                if(numbers.get(j) == currentNumber) {
                    count++;
                }
            }

            if(count > maxCount) {
                maxCount = count;
                result.clear();
                result.add(numbers.get(i));
            } else if(count == maxCount) {
                result.add(numbers.get(i));
            }
        }

        System.out.println("Input array: " + numbers);
        System.out.println("The most repeated number(s): " + result);

    }
}