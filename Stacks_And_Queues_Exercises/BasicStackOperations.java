package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int pushElement = numbers[0];
        int popElement = numbers[1];
        int element = numbers[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).limit(pushElement)
                .forEach(stack::push);

        for (int i = 0; i < popElement; i++) {
            stack.pop();
        }
        if (stack.contains(element)) {
            System.out.println("true");
        } else {
            int minElement = Integer.MAX_VALUE;
            if (stack.size() == 0){
                minElement = 0;
            }else {
                for (int i = 0; i < stack.size() ; i++) {
                    int num = stack.pop();
                    if (num < minElement){
                        minElement = num;
                    }
                }
            }
            System.out.println(minElement);
        }
    }
}
