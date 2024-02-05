package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an even number of dice rolls: ");
        int n = in.nextInt();
        if(n / 2 != 0) {
            n--;
        }

        Random random = new Random();
        int[] sequenceOfFirstPlayer = new int[3];
        int[] sequenceOfSecondPlayer = new int[3];

        for (int i = 0; i < 3; i++) {
            sequenceOfFirstPlayer[i] = random.nextInt(1, 6);
            sequenceOfSecondPlayer[i] = random.nextInt(1, 6);
        }

        int countOfExperiments = 10000;
        int[] sequence = new int[n];
        int countOfWinByFirstPlayer = 0;
        int countOfWinBySecondPlayer = 0;
        int countOfDraw = 0;

        for (int i = 0; i < countOfExperiments; i++) {
            for (int j = 0; j < n; j++) {
                sequence[j] = random.nextInt(1, 6);
            }

            int countPointsByFirst = 0;
            int countPointsBySecond = 0;
            for (int j = 0; j < n - 2; j++) {
                if(sequence[j] == sequenceOfFirstPlayer[0] && sequence[j + 1] == sequenceOfFirstPlayer[1]
                        && sequence[j + 2] == sequenceOfFirstPlayer[2]) {
                    countPointsByFirst++;
                    j += 3;
                }
            }

            for (int j = 0; j < n - 2; j++) {
                if(sequence[j] == sequenceOfSecondPlayer[0] && sequence[j + 1] == sequenceOfSecondPlayer[1]
                        && sequence[j + 2] == sequenceOfSecondPlayer[2]) {
                    countPointsBySecond++;
                    j += 3;
                }
            }

            if(countPointsByFirst > countPointsBySecond) {
                countOfWinByFirstPlayer++;
            } else if (countPointsByFirst == countPointsBySecond) {
                countOfDraw++;
            } else {
                countOfWinBySecondPlayer++;
            }
        }

        double probabilityOfWinFirst = (double) countOfWinByFirstPlayer / countOfExperiments;
        double probabilityOfWinSecond = (double) countOfWinBySecondPlayer / countOfExperiments;
        double probabilityOfDraw = (double) countOfDraw / countOfExperiments;

        System.out.println("Input data: number of dice rolls: " + n + "\n" +
                "the sequence of the first player: " + Arrays.toString(sequenceOfFirstPlayer)+ "\n" +
                "the sequence of the second player: " + Arrays.toString(sequenceOfSecondPlayer)+ "\n");

        System.out.println("The probability of the first player scoring more points than the opponent: " + probabilityOfWinFirst);
        System.out.println("The probability of the second player scoring more points than the opponent: " + probabilityOfWinSecond);
        System.out.println("The probability of a draw: " + probabilityOfDraw);
    }
}