package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] line = scanner.nextLine().split("\\s+");
        int offerElement = Integer.parseInt(line[0]);
        int pollElement = Integer.parseInt(line[1]);
        int element = Integer.parseInt(line[2]);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(offerElement)
                .forEach(queue::offer);

        for (int i = 0; i < pollElement; i++) {
            queue.poll();
        }
        if (queue.contains(element)){
            System.out.println("true");
        }else {
            int minElement;
            if (queue.size() == 0 ){
                minElement = 0;
            }else {
                minElement = Collections.min(queue);
            }
            System.out.println(minElement);
        }
    }
}
