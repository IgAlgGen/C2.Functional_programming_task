import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ввведите текст: \n");
        textWordCounter(input);


    }

    public static void textWordCounter(Scanner scanner) {
        String string = scanner.nextLine();
        Map<String, Integer> wordCounts = new LinkedHashMap<>();

        Arrays.stream(string.split(" "))
                .forEach((String w) -> wordCounts.put(w, wordCounts.getOrDefault(w, 0) + 1));
        System.out.println("Слов в тексте: " + wordCounts.size());
        wordCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(System.out::println);


    }
}