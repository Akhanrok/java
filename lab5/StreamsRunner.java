package lab5;

import java.util.Scanner;

public class StreamsRunner {
    public static void main(String[] args){
        System.out.println("Введіть шлях до файлу: ");
        Scanner scanner = new Scanner(System.in);
        String inputPath = scanner.next();
        LongestLine.getLongestLine(inputPath);

        System.out.println("\nВведіть URL: ");
        String inputURL = scanner.next();
        TagCount.getNumberOfTags(inputURL);

        System.out.println("Введіть ключовий символ:");
        String key = scanner.next();
        System.out.println("Введіть шлях до файлу: ");
        String path = scanner.next();
        EncryptionDecryption.encryptAndDecrypt(key, path);
    }

}
