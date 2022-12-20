package lab1;

//Знайти ті слова, які містять тільки символи латинського алфавіту. 
//Серед них знайти ті слова, які містять рівну кількість голосних та приголосних. 
//На вхід подається рядок із словами. На виході – масив String.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
	    System.out.print("Введіть рядок: \n");
        Scanner scanner = new Scanner(System. in);
        String inputString = scanner.nextLine();
        
        inputString = inputString.replaceAll("[\"',.?!()-]","");
        inputString = inputString.replaceAll("[^a-zA-Z ]","0");
        inputString = inputString.replaceAll("[^0\\s]*0\\S*","");
        inputString = inputString.replaceAll("\\s+", " ");
 
        String[] words = inputString.split(" ");
        Pattern pattern = Pattern.compile(" ");
        words = pattern.split(inputString);
        System.out.println("Слова, які містять тільки символи латинського алфавіту:\n" + Arrays.toString(words));
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < words.length; ++i) {
        	int vowels = 0, consonants = 0;
        	char[] ch = words[i].toCharArray();
        	for (int j = 0; j < ch.length; j++) {
        		if (ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u') {
                    ++vowels;
                }
                else if(ch[j] != ' '){
                    ++consonants;
                }
        	}
        	if (vowels == consonants){
        		result.add(words[i]);
    		}
        }
        System.out.println("Слова, які містять рівну кількість голосних та приголосних:\n" + result);
	}
}
