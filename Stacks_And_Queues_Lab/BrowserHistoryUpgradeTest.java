package Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgradeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (!"Home".equals(input)) {
            if (input.equals("back")) {
                if (browser.size() > 1) {
                    String current = browser.pop();
                    forward.push(current);
                    System.out.println(browser.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (!forward.isEmpty()){
                    String current =  forward.pop();
                    browser.push(current);
                    System.out.println(current);
                }else {
                    System.out.println("no next URLs");
                }
            } else {
                browser.push(input);
                if (!forward.isEmpty()){
                    forward.clear();
                }
                System.out.println(input);
            }
            input = scanner.nextLine();
        }
    }
}
