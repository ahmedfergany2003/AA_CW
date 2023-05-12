package task2;
import java.util.*;

public class CheckBothArrays {
    
    public static void main(String[] args) {
        // Create two arrays of Objects
        Object[] a = new Object[] {6, 7, 8, 9, 10, 11};
        Object[] b = new Object[] {10, 6, 11, 7, 9, 8};
        
        // Sort the arrays
        Arrays.sort(a);
        Arrays.sort(b);
        
        // Check if the sorted arrays are equal
        boolean returnVal1 = Arrays.equals(a, b);
        
        // Print the result of the comparison
        System.out.println("Array a and b equal?: " + returnVal1);
    }
}