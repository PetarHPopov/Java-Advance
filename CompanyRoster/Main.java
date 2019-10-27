package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Department.init();

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email = null;
            Integer age = null;

            if (tokens.length == 6) {
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
            } else if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    email = tokens[4];
                } else {
                    age = Integer.parseInt(tokens[4]);
                }
            }
            Department.add(new Employee(name,salary,position,department,email,age));
        }
        Department.printHighest();
    }
}
