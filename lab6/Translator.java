package lab6;

import java.util.*;

public class Translator {
    private final HashMap<String, String> dict;

    public Translator() {
        dict = new HashMap<>();
    }

    public void add(String eng, String ukr) {
        dict.put(eng, ukr);
    }

    public void addFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть слово англійською: \n");
        String eng = scanner.nextLine();
        System.out.print("Введіть переклад: \n");
        String ukr = scanner.nextLine();
        dict.put(eng,ukr);
    }

    public String translate(String input) {
        input = input.replaceAll("[^a-zA-Z ]", "");
        String[] words = input.split("\\s+");
        StringBuilder output = new StringBuilder();
        for(String word : words) {
            String value = dict.get(word);
            if(value != null) {
                output.append(" ").append(value);
            } else {
                return null;
            }
        }
        return output.toString().trim();
    }
    public void printDict() {
        System.out.print("Словник: \n");
        for (String key : dict.keySet()) {
            System.out.println(key + " - " + dict.get(key));
        }
        System.out.println("\n");
    }
}
