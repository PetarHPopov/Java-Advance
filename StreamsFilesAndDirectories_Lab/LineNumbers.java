package StreamsFilesAndDirectories_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String inPath = "C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outPath = "C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\out.txt";

        BufferedReader reader = null;
        PrintWriter printWriter = null;

        try {
            reader = Files.newBufferedReader(Paths.get(inPath));
            printWriter = new PrintWriter(outPath);

            String line = reader.readLine();
            int count = 1;
            while (line != null) {

                printWriter.println(count + ". " + line);

                line = reader.readLine();
                count++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
        }

    }
}
