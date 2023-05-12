package task3;
import java.util.*;
public class ADT {
    // Declare two stacks to be used in the ADT
    Stack<Integer> red;
    Stack<Integer> blue;
    // Constructor to initialize the two stacks
    public ADT(Stack<Integer> red, Stack<Integer> blue) {
        this.red = red;
        this.blue = blue;}
    // Push a number onto the red stack
    public void rP(int data) {
        insert(data);}
    // Push a number onto the blue stack
    public void bP(int data) {
        insert(data);}
    // Helper method to insert a number into the appropriate stack
    public void insert(int data) {
        // If the red stack is empty, push the number onto it
        if (red.size() == 0) {
            red.push(data);
        } else {
            // Otherwise, move all the numbers from the red stack to the blue stack
            int r = red.size();
            for (int i = 0; i < r; i++) {
                blue.push(red.pop());}

            // Push the new number onto the red stack
            red.push(data);
            // Move all the numbers from the blue stack back to the red stack
            for (int i = 0; i < r; i++) {
                red.push(blue.pop());}
        }
    }
    // Remove and return the top number from the red stack
    public int pop() {
        if (red.size() == 0) {
            throw new NoSuchElementException("Empty");}
        return red.pop();}
    // Check if the red stack is empty
    public boolean isEmpty() {
        return red.size() == 0;}
    // Get the size of the red stack
    public int getSize() {
        return red.size();}
    // Display the contents of the red stack
    public void display() {
        System.out.print("\nStack: ");
        int s = getSize();
        if (s == 0) {
            System.out.print("Empty\n");
        } else {
            for (int i = s - 1; i >= 0; i--) {
                System.out.print(red.get(i) + " ");}
            System.out.println();}
    }
    // Main method to test the ADT
    public static void main(String argsl[]) {
        // Create two stacks and an instance of the ADT
        Stack<Integer> red = new Stack<Integer>();
        Stack<Integer> blue = new Stack<Integer>();
        ADT stack = new ADT(red, blue);
        Scanner sc = new Scanner(System.in);
        // Loop until the user chooses to exit
        while (true) {
            System.out.println("1. Blue stack push 2.Red stack push 3. pop 4.Get Size 5.Check Empty 6.Display 7.Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter number to insert: ");
                int num = sc.nextInt();
                stack.bP(num);
            } else if (choice == 2) {
                System.out.println("Enter number to insert: ");
                int num = sc.nextInt();
                stack.rP(num);
            } else if (choice == 3) {
                System.out.println("Pop: " + stack.pop());
            } else if (choice == 4) {
                System.out.println("Size: " + stack.getSize());
            } else if (choice == 5) {
                System.out.println(stack.isEmpty());
            } else if (choice == 6) {
                stack.display();
            } else {
                break;}
        }
    }
}