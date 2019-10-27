package Exercises_Streams_Files_and_Directories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) throws IOException {

        String inPath ="C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedReader reader = null;

        try {
             reader = Files.newBufferedReader(Paths.get(inPath));

             String line = reader.readLine();

             while (line != null){
                 long sum = 0;
//                 for (char c : line.toCharArray()) {
//                     sum += c;
//                 }
                 for (int i = 0; i < line.length(); i++) {
                     sum += line.charAt(i);
                 }
                 System.out.println(sum);
                 line = reader.readLine();
             }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null){
                reader.close();
            }
        }
    }
}
