package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, Integer> userByDuration = new TreeMap<>();
        Map<String, Set<String>> userByIP = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String IP = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            userByDuration.putIfAbsent(user, 0);
            userByDuration.put(user, userByDuration.get(user) + duration);
            userByIP.putIfAbsent(user, new TreeSet<>());
            userByIP.get(user).add(IP);

        }
        userByDuration.forEach((k, v) -> {
            System.out.print(String.format("%s: %d [", k, v));
            System.out.print(String.join(", ", userByIP.get(k)));
            System.out.println("]");
        });

    }
}
