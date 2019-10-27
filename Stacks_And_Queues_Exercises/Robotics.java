package Stacks_And_Queues_Exercises;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] roboData = scanner.nextLine().split(";");

        String[] robots = new String[roboData.length];
        int[] workTime = new int[roboData.length];
        int[] processTime = new int[roboData.length];

        for (int i = 0; i < roboData.length; i++) {
            robots[i] = roboData[i].split("-")[0];
            workTime[i] = Integer.parseInt(roboData[i].split("-")[1]);
        }

        String[] timeData = scanner.nextLine().split(":");

        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startTime = hours * 3600 + minutes * 60 + seconds;

        int time = 0;

        ArrayDeque<String> products = new ArrayDeque<>();

        String currentProduct = scanner.nextLine();

        while (!currentProduct.equals("End")) {
            products.offer(currentProduct);
            currentProduct = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            time++;

            String product = products.pollFirst();
            boolean isAssigned = false;

            for (int i = 0; i < robots.length; i++) {
                if (processTime[i] == 0) {
                    processTime[i] = workTime[i];
                    printTask(robots[i], startTime + time, product);
                    isAssigned = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }
            if (!isAssigned) {
                products.offer(product);
            }
        }
    }

    private static void printTask(String robot, int time, String product) {
        int h = (time / 3600) % 24;
        int m = time % 3600 / 60;
        int s = time / 60;

        DecimalFormat format = new DecimalFormat("00");
        System.out.println(String.format("%s - %s [%s:%s:%s]"
                ,robot,product,format.format(h),format.format(m),format.format(s)));
    }
}
