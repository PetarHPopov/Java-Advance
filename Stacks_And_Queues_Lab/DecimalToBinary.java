package Stacks_And_Queues_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class DecimalToBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (number == 0) {
            System.out.println(0);
        }
        while (number > 0) {
            int digit = number % 2;
            stack.push(digit);
            number /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
