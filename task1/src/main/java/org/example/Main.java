package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = in.nextInt();
        List<Integer> numbers = new ArrayList<>(n);
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            numbers.add(random.nextInt(-10, 10));
        }

        System.out.println("Input array: " + numbers);

        List<Integer> editedArray = numbers.stream()
                .filter(x -> x != 0 && x % 2 != 0)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> zeroNumbers = numbers.stream()
                .filter(x -> x == 0)
                .toList();

        editedArray.addAll(zeroNumbers);

        List<Integer> otherNumbers = numbers.stream()
                .filter(x -> x != 0 && x % 2 == 0)
                .sorted(Collections.reverseOrder())
                .toList();

        editedArray.addAll(otherNumbers);

        System.out.println("Edited array: " + editedArray);
    }
}