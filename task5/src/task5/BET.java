package task5;

import java.util.*;

public class BET {
    // Node class for the expression tree
    private static class Node {
        String value; // the value stored in the node (either an operator or an operand)
        Node left, right; // pointers to the left and right child nodes

        // constructor for the Node class
        Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // ExpressionTree class for building and printing the expression tree
    class ExpressionTree {
        private Node root; // the root node of the expression tree
        private final Map<String, Double> variables; // a map of variable names to their values

        // constructor for the ExpressionTree class
        ExpressionTree(String expression) {
            this.root = buildTree(expression);
            this.variables = new HashMap<>();
        }

        // method for building the expression tree
        private Node buildTree(String expression) {
            Stack<Node> stack = new Stack<>();
            Stack<Character> opStack = new Stack<>(); // new stack for operators
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (c == ' ') {
                    continue;
                }
                if (c == '(') {
                    opStack.push(c); // push opening parenthesis to opStack
                    continue;
                }
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    opStack.push(c);
                    continue;
                }
                if (Character.isLetter(c) || Character.isDigit(c) || c == '.') {
                    String num = "";
                    while (i < expression.length() && (Character.isLetter(expression.charAt(i)) || Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        num += expression.charAt(i++);
                    }
                    i--;
                    Node node = new Node(num);
                    stack.push(node);
                    continue;
                }
                if (c == ')') {
                    while (!opStack.isEmpty() && opStack.peek() != '(') {
                        Node node = new Node(Character.toString(opStack.pop()));
                        node.right = stack.pop();
                        node.left = stack.pop();
                        stack.push(node);
                    }
                    opStack.pop(); // pop opening parenthesis
                    continue;
                }
                throw new IllegalArgumentException("Invalid character in expression: " + c);
            }
            while (!opStack.isEmpty()) {
                Node node = new Node(Character.toString(opStack.pop()));
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            }
            if (stack.size() != 1) {
                throw new IllegalArgumentException("Invalid expression");
            }
            return stack.pop();
        }

        // method for printing the expression tree
        private void printTree(Node node, int depth) {
            if (node == null) {
                return;
            }
            printTree(node.right, depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("   ");
            }
            System.out.println(node.value);
            printTree(node.left, depth + 1);
            if (depth == 0) {
                System.out.println("Root value: " + node.value);
            }
        }

        // public method for printing the expression tree
        void printTree() {
            printTree(this.root, 0);
        }

    }

    // main method for testing
    public static void main(String[] args) {
        String expression = "(* (- 8 9) (/ 10 2))";
        ExpressionTree tree = new BET().new ExpressionTree(expression);
        System.out.println("Expression tree:");
        tree.printTree();
    }
}