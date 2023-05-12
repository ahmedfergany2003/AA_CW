package task1;
import java.util.*;
public class RemoveDuplicates {
    // A static method that takes an array of characters and its length as input
    static void removeDuplicate(char str[], int length) {
        int index = 0;
        // Loop through each character in the array
        for (int i = 0; i < length; i++) {
            int j;
            // Loop through each character before the current character
            for (j = 0; j < i; j++) {
                // If the current character is the same as a previous character, break out of the inner loop
                if (str[i] == str[j]) {
                    break;}
            }
            // If the inner loop completed without finding a duplicate character, add the current character to the new array
            if (j == i) {
                str[index++] = str[i];}
        }
        // Print the new array without duplicates
        System.out.println("UNDUBLICATED ARRAY:");
        System.out.println(Arrays.copyOf(str, index));}
    public static void main(String[] args) {
        // Create an array of characters
        char str[] = {'a', 'r', 's', 't', 'w', 'u', 'v', 'r', 's', 't', 'a' , 'b', 'k', 'w'};
        int len = str.length;
        // Call the removeDuplicate method with the array and its length as input
        removeDuplicate(str, len);}
}