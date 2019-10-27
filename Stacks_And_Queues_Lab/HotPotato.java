package Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> kidsName = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(kidsName::offer);

        int n = Integer.parseInt(scanner.nextLine());
        while (kidsName.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                String kid = kidsName.poll();
                kidsName.offer(kid);
            }
            String removeName = kidsName.poll();
            System.out.println("Removed " + removeName);
        }
        System.out.println("Last is " + kidsName.poll());
    }
}
