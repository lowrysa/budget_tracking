import java.util.Random;
import java.io.*;
import java.util.*;
public class practice {
    public static void main(String[] args) {
        //String line = "";
        String line = "s\td\ta";
        System.out.println(line);
        String sys[] = line.split("\t");
        System.out.println(sys.length);
        String file = "practice.txt";
        String file2 = "practicec.txt";
        String number1 = "1";
            String number2 = "2";
            String number3 = "3";
        try {
            BufferedWriter a = new BufferedWriter( new FileWriter(file));
            a.write("Samantha");
            a.append("sdfa");
            a.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            BufferedWriter b = new BufferedWriter( new FileWriter(file,true));
            b.append(" csq");
            b.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*ArrayList<String> copy = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(file));
            for (int i = 0; sc.hasNextLine(); i++) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("bingus:\t" + number1)) {
                    String[] splitLine = line.split("\t");
                    splitLine[1] = number2;
                    String g = splitLine[0] + "\t" + splitLine[1];
                    copy.add(g);
                } else if (line.equalsIgnoreCase("bingus:\t")) {
                    String g = line + number3;
                    copy.add(g);
                } else
                    copy.add(line);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter a = new BufferedWriter( new FileWriter(file2));
            for(int i =0; i <copy.size(); i++) {
                a.write(copy.get(i) + "\n");
            }
            a.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
    }
}
