package task6;

import java.util.*;

public class SC {

    // A set of words to check against
    private Set<String> lexicon;

    // A constructor that takes a set of words as input
    public SC(Set<String> lexicon) {
        this.lexicon = lexicon;
    }

    // A method that checks if a string is spelled correctly or not
    public List<String> check(String s) {
        // If the string is in the lexicon, return a list containing only the string
        if (lexicon.contains(s)) {
            return List.of(s);
        }
        // Otherwise, create a list of possible corrections
        List<String> corrections = new ArrayList<>();
        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Swap adjacent characters and check if the result is in the lexicon
            if (i < s.length() - 1) {
                String swapped = swap(s, i, i + 1);
                if (lexicon.contains(swapped)) {
                    corrections.add(swapped);
                }
            }
            // Insert a character between two adjacent characters and check if the result is in the lexicon
            for (char c = 'a'; c <= 'z'; c++) {
                String inserted = insert(s, i, c);
                if (lexicon.contains(inserted)) {
                    corrections.add(inserted);
                }
            }
            // Delete a character and check if the result is in the lexicon
            if (i < s.length()) {
                String deleted = delete(s, i);
                if (lexicon.contains(deleted)) {
                    corrections.add(deleted);
                }
            }
            // Replace a character with another character and check if the result is in the lexicon
            for (char c = 'a'; c <= 'z'; c++) {
                String replaced = replace(s, i, c);
                if (lexicon.contains(replaced)) {
                    corrections.add(replaced);
                }
            }
        }
        // Return the list of corrections
        return corrections;
    }

    // A helper method that swaps two characters in a string
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    // A helper method that inserts a character in a string
    private String insert(String s, int i, char c) {
        return s.substring(0, i) + c + s.substring(i);
    }

    // A helper method that deletes a character from a string
    private String delete(String s, int i) {
        return s.substring(0, i) + s.substring(i + 1);
    }

    // A helper method that replaces a character in a string with another character
    private String replace(String s, int i, char c) {
        return s.substring(0, i) + c + s.substring(i + 1);
    }

    public static void main(String[] args) {
        // Create a set of words to use as the lexicon
        Set<String> words = new HashSet<>();
        words.add("hello");
        words.add("world");
        words.add("java");
        words.add("code");
        words.add("programming");
        words.add("computer");
        words.add("science");
        words.add("algorithm");
        words.add("data");
        words.add("structure");
        words.add("database");
        words.add("software");
        words.add("engineering");
        words.add("network");
        words.add("security");
        words.add("encryption");
        words.add("authentication");
        words.add("authorization");
        words.add("virtualization");
        words.add("cloud");
        words.add("container");

        // Create a spell-checker object with the lexicon
        SC sc = new SC(words);

        // Test some strings with the spell-checker
        System.out.println(sc.check("secrity")); // [security]
        System.out.println(sc.check("authenitcation")); // [authentication]
        System.out.println(sc.check("claud")); // [java]
        System.out.println(sc.check("networc")); // [network]
        System.out.println(sc.check("happy")); // []
    }
}