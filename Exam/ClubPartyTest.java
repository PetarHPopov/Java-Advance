package Exam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClubPartyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String[] hallWhitReservation = scanner.nextLine().split("\\s+");

        ArrayDeque<String> halls = new ArrayDeque<>();
        List<Integer> currentHallReservations = new ArrayList<>();
    }
}
