package lab7;

//Реалізувати завдання за допомогою lambda:
//знайти ті слова, які містять тільки символи латинського алфавіту;
//серед них знайти ті слова, які містять рівну кількість голосних та приголосних;
//на вхід подається рядок із словами. На виході – масив String.

//No need, to Лight 14 "lights" on a1 (light) night like tonightЧЧЧЧ!
//Бобер на березі з бобренятами бублики пік.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введіть рядок: \n");
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner.nextLine();

        inputString = inputString.replaceAll("[\"',.?!()-]","");
        inputString = inputString.replaceAll("[^a-zA-Z ]","0");
        inputString = inputString.replaceAll("[^\\s]*0\\S*","");
        inputString = inputString.replaceAll("\\s+", " ");

        String[] words = inputString.split(" ");
        Pattern pattern = Pattern.compile(" ");
        words = pattern.split(inputString);
        System.out.println("Слова, які містять тільки символи латинського алфавіту:\n" + Arrays.toString(words));
        ArrayList<String> result = new ArrayList<String>();

        Arrays.stream(words).forEach(word -> {
            AtomicInteger vowels = new AtomicInteger();
            AtomicInteger consonants = new AtomicInteger();
            char[] characters = word.toLowerCase().toCharArray();
            IntStream.range(0, characters.length)
                    .mapToObj(i -> characters[i])
                    .forEach((character) -> {
                        if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                            vowels.getAndIncrement();
                        }
                        else if(character != ' '){
                            consonants.getAndIncrement();
                        }
                    });
            if (vowels.get() == consonants.get()){
                result.add(word);
            }
        });
        System.out.println("Слова, які містять рівну кількість голосних та приголосних:\n" + result);
    }
}

