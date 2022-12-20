package lab6;

import java.util.Scanner;

public class TranslatorRunner {
    public static void main(String[] args) {
        Translator translator = new Translator();
        translator.add("blue","синій");
        translator.add("green","зелений");
        translator.add("orange","помаранчевий");
        translator.add("yellow","жовтий");
        translator.add("purple","фіолетовий");

        translator.printDict();
        translator.addFromKeyboard();
        translator.printDict();
        System.out.println("yellow, orange: " + translator.translate("yellow, orange"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть текст: ");
        String toTranslate = scanner.nextLine();
        if (translator.translate(toTranslate) != null) {
            System.out.print("Переклад: " + translator.translate(toTranslate));
        } else {
            System.out.print("Помилка");
        }
    }
}