package SetsAndMapsAdvanced_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        TreeMap<String, Double> nameByAvg = new TreeMap<>();
        for (int i = 0; i < count; i++) {
            String name = reader.readLine();
              List<Double> grade = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());
            double sum = 0;

            for (Double aDouble : grade) {
               sum += aDouble;

            }
            double avg = sum / grade.size();

            nameByAvg.put(name, avg);

        }
        DecimalFormat df = new DecimalFormat("#.########################");
        for (String name : nameByAvg.keySet()) {
            System.out.println(String.format("%s is graduated with %s",name,df.format(nameByAvg.get(name))));
        }
    }
}
