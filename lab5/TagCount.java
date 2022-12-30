package lab5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagCount {
    public static void getNumberOfTags(String inputURL) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(inputURL))
                .GET()
                .build();
        String html = null;
        try {
            html = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        Pattern compile = Pattern.compile("<[A-Za-z0-9]+>");
        ArrayList<String> allTags = new ArrayList<>();

        Matcher matcher = compile.matcher(html);
        while (matcher.find()) {
            String group = matcher.group();
            if (!group.endsWith(">")) {
                group = group + ">";
            }
            allTags.add(group);
        }

        HashMap<String, Integer> countedTags = TagCount(allTags);

        System.out.println("\nСортування за іменем: ");
        countedTags.keySet().stream()
                .sorted(String::compareTo)
                .map(tag -> tag + " - " + countedTags.get(tag))
                .forEach(System.out::println);

        System.out.println("\nСортування за частотою появи: ");
        countedTags.keySet().stream()
                .sorted(Comparator.comparing(countedTags::get))
                .map(tag -> tag + " - " + countedTags.get(tag))
                .forEach(System.out::println);
    }

    private static HashMap<String, Integer> TagCount(List<String> tags) {
        HashMap<String, Integer> result = new HashMap<>();
        tags.forEach(tag -> result.put(tag, result.getOrDefault(tag, 0) + 1));
        return result;
    }
}


