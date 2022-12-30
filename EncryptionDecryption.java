package lab5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EncryptionDecryption {
    private static char key;

    public static char getKey() {
        return key;
    }

    private static void setKey(char key) {
        EncryptionDecryption.key = key;
    }

    public static void encryptAndDecrypt(String key, String filePath) {
        Path path = Path.of(filePath);
        setKey(key.charAt(0));
        List<String> text;
        try {
            text = Files.readAllLines(path);
            System.out.println("\nШифрування: " + encrypt(path));
            System.out.println("Дешифрування: " + decrypt(path, String.valueOf(text)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(Path path) throws IOException {
        try(Reader reader = new Reader(Files.newBufferedReader(path))) {
            StringBuilder builder = new StringBuilder();
            char[] cbuf = new char[1024];
            while(true) {
                int r = reader.read(cbuf);
                if(r == -1) {
                    break;
                }
                builder.append(cbuf, 0, r);
            }
            return builder.toString();
        }
    }

    public static String decrypt(Path path, String text) throws IOException {
        try(Writer writer = new Writer(Files.newBufferedWriter(path))) {
            writer.write(text);
        }
        return text;
    }
}