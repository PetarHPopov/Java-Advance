package Stacks_And_Queues_Exercises;

import java.util.Scanner;

public class RecursiveFibonacci {
    static long[] tokens;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        tokens = new long[number + 1];

        long fibo = fibonacci(number);
        System.out.println(fibo);


    }

    private static long fibonacci(int number) {
        if (number < 2) {
            return 1;
        }
        if (tokens[number] != 0) {
            return tokens[number];
        }
        return tokens[number] = fibonacci(number - 1) + fibonacci(number - 2);
    }
}
