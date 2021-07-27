import java.util.Random;
import java.io.*;
import java.util.*;
public class practice {
    public static void main(String[] args) {
        String line = "";
        String file = "practice.txt";
        try {
            BufferedWriter a = new BufferedWriter( new FileWriter(file));
            a.write("Sam");
            a.write("bingus");
            a.write("")
            a.close();
        } catch (Exception e) {
            return;
        }

        try {
            Scanner b = new Scanner(new File(file));
            String c = b.nextLine();
			String[] splitLine = c.split("\t");
			System.out.println(splitLine[0]);
            System.out.println(splitLine[1]);

        } catch (Exception e) {
            return;
        }

    }
}
