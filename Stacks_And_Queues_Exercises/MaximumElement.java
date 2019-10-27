package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1":
                    int element = Integer.parseInt(tokens[1]);
                    stack.push(element);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int maxElement = Collections.max(stack);
                    System.out.println(maxElement);
                    break;
            }
        }
    }

}
