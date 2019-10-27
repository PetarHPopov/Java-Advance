package StreamsFilesAndDirectories_Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Desi Georgieva\\Desktop\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = null;

        try {
          inputStream = new FileInputStream(path) ;

          int oneByte = inputStream.read();
          while (oneByte >= 0){
              System.out.print(Integer.toBinaryString(oneByte )+ " ");
              oneByte = inputStream.read();
          }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }
}
