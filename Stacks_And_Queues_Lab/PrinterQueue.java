package Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!"print".equals(line)) {
            if (!"cancel".equals(line)) {
                queue.offer(line);
            } else {
                if (queue.size() == 0) {
                    System.out.println("Printer is on standby");
                } else {
                    String input = queue.poll();
                    System.out.println("Canceled " + input);
                }
            }
            line = scanner.nextLine();
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
