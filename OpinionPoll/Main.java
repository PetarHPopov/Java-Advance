package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countPeople = Integer.parseInt(reader.readLine());

        List<Person> people = new ArrayList<>();

        while (countPeople-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person();

            person.setName(name);
            person.setAge(age);

            people.add(person);
        }
        people.stream().sorted((a,b)-> a.getName().compareTo(b.getName()))
                .filter(age -> age.getAge() > 30)
                .forEach(p -> System.out.println(p.toString()));
    }
}
