package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,LinkedHashMap<String,List<String>>> people = new TreeMap<>();

        String line;
        while (!"end".equals(line = reader.readLine())){

            String[] tokens = line.split("\\s+");

            String [] ipArr = tokens[0].split("=");
            String ip = ipArr[1];
            String[] messageArr = tokens[1].split("=");
            String message = messageArr[1];
            String[] userArr = tokens[2].split("=");
            String user = userArr[1];

            people.putIfAbsent(user,new LinkedHashMap<>());
            people.get(user).putIfAbsent(ip,new ArrayList<>());
            people.get(user).get(ip).add(message);
        }
        people.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            int index = 0;
            for (Map.Entry<String, List<String>> entry : value.entrySet()) {
                System.out.printf("%s%s => %d",index++ == 0 ? "":", ",entry.getKey(),entry.getValue().size());
            }
            System.out.println(".");
        });
    }
}
