package Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();

        Collections.addAll(children, kids);

        int round = 1;

        while (children.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                String kid = children.poll();
                children.offer(kid);
            }
            if (isPrime(round)){
                String kid = children.peek();
                System.out.println("Prime " + kid);
            }else {
                String kid = children.poll();
                System.out.println("Removed " + kid);
            }
            round ++;
        }
        System.out.println("Last is " + children.poll());
    }
    private static boolean isPrime(int num){
        if (num == 1){
            return false;
        }
        for (int i = 2; i < num  ; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
