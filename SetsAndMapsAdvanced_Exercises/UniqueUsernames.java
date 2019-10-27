package SetsAndMapsAdvanced_Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countName = Integer.parseInt(reader.readLine());

        Set<String> setName = new LinkedHashSet<>();

        for (int name = 0; name < countName; name++) {
            String usersNames = reader.readLine();
            setName.add(usersNames);
        }
        setName.forEach(System.out::println);
    }
}
