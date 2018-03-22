import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class Decoder {
    private static final String inputFileName = "input.txt";
    private static final String outputFileName = "output.txt";

    public static void main(String[] args) {
        Decoder decoder = new Decoder();
        TreeMap<Character, Integer> frequencyMap = new TreeMap<>();
        decoder.readFromFile(frequencyMap);

        decoder.writeToFile(frequencyMap);
    }

    private void readFromFile(TreeMap<Character, Integer> map) {
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(new File(inputFileName));
            System.out.println("File loaded!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != inputFile) {
            while (inputFile.hasNext()) {
                String str = inputFile.next();
                char[] charArray = str.toCharArray();
                countFrequency(charArray, map);
            }
            inputFile.close();
        }
    }

    private void countFrequency(char[] charArray, TreeMap<Character, Integer> map) {
        System.out.println(charArray);

        int counter;
        for (char c : charArray) {
            counter = 0;
            c = Character.toUpperCase(c);
            if (map.containsKey(c)) {
                counter = map.get(c);
            }
            map.put(c, ++counter);
            System.out.println(map);
        }
    }

    private void writeToFile(TreeMap<Character, Integer> map) {
        PrintWriter outputFile = null;
        try {
            outputFile = new PrintWriter(new FileOutputStream(outputFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != outputFile) {
            outputFile.println("Hello World");
            outputFile.close();
        }
    }
}
