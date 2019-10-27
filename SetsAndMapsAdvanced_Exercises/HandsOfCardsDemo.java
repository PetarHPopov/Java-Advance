package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCardsDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> handsOfCards = new LinkedHashMap<>();
        String input;
        while (!"JOKER".equals(input = reader.readLine())) {
            String[] firstPart = input.split(": ");
            String name = firstPart[0];
            List<String> card = Arrays.stream(firstPart[1].split(", ")).collect(Collectors.toList());

            if (!handsOfCards.containsKey(name)) {
                handsOfCards.put(name, new LinkedHashSet<>());
            }
            handsOfCards.get(name).addAll(card);
        }

        for (Map.Entry<String, Set<String>> entry : handsOfCards.entrySet()) {

            int totalPower = colaculatePowerCards(entry.getValue());

            System.out.println(String.format("%s: %d", entry.getKey(), totalPower));
        }
    }

    private static int colaculatePowerCards(Set<String> deck) {
        int sumPower = 0;
        for (String card : deck) {
            int power = 0;
            if (Character.isDigit(card.charAt(0)) && card.charAt(0) != '1') {
                power += card.charAt(0) - '0';
            } else {
                switch (card.charAt(0)) {
                    case '1':
                        power += 10;
                        break;
                    case 'J':
                        power += 11;
                        break;
                    case 'Q':
                        power += 12;
                        break;
                    case 'K':
                        power += 13;
                        break;
                    case 'A':
                        power += 14;
                        break;
                }
            }
            switch (card.charAt(card.length() - 1)) {
                case 'S':
                    power *= 4;
                    break;
                case 'H':
                    power *= 3;
                    break;
                case 'D':
                    power *= 2;
                    break;
            }
            sumPower += power;
        }


        return sumPower;
    }
}
