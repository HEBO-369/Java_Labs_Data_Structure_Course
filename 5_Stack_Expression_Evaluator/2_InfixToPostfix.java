import java.util.Scanner;

/**
 * Represents a linked list interface with common operations.
 */
interface ILinkedList {
    /**
     * Adds an element at the specified index.
     * @param index the position to add the element
     * @param element the element to be added
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, Object element);
    
    /**
     * Adds an element at the end of the list.
     * @param element the element to be added
     */
    public void add(Object element);
    
    /**
     * Gets the element at the specified index.
     * @param index the position of the element
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Object get(int index);
    
    /**
     * Replaces the element at the specified index.
     * @param index the position of the element to replace
     * @param element the new element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void set(int index, Object element);
    
    /**
     * Removes all elements from the list.
     */
    public void clear();
    
    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Removes the element at the specified index.
     * @param index the position of the element to remove
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void remove(int index);
    
    /**
     * Gets the size of the list.
     * @return the number of elements in the list
     */
    public int size();
    
    /**
     * Gets a sublist from the specified range.
     * @param fromIndex the starting index (inclusive)
     * @param toIndex the ending index (exclusive)
     * @return a new list containing the specified elements
     * @throws IndexOutOfBoundsException if the indices are out of range
     */
    public ILinkedList sublist(int fromIndex, int toIndex);
    
    /**
     * Checks if the list contains the specified element.
     * @param o the element to search for
     * @return true if the element is found, false otherwise
     */
    public boolean contains(Object o);
}

/**
 * A singly linked list implementation of the ILinkedList interface.
 */
class SingleLinkedList implements ILinkedList {
    /**
     * Represents a node in the linked list.
     */
    private class Node {
        /** The data stored in the node */
        Object data;
        /** Reference to the next node */
        Node next;
        
        /**
         * Creates a new node with the specified data.
         * @param data the data to store in the node
         */
        Node(Object data) {
            this.data = data;
        }
    }
    
    /** The head node of the list */
    private Node head;
    /** The size of the list */
    private int size = 0;
    
    /**
     * {@inheritDoc}
     */
    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node newNode = new Node(element);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void add(Object element) {
        add(size, element);
    }
    
    /**
     * {@inheritDoc}
     */
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    /**
     * {@inheritDoc}
     */
    public void set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }
    
    /**
     * {@inheritDoc}
     */
    public void clear() {
        head = null;
        size = 0;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * {@inheritDoc}
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node nextCurrent = current.next;
            current.next = nextCurrent.next;
        }
        size--;
    }
    
    /**
     * {@inheritDoc}
     */
    public int size() {
        return size;
    }
    
    /**
     * {@inheritDoc}
     */
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        SingleLinkedList sublist = new SingleLinkedList();
        Node current = head;
        for (int i = 0; i <= toIndex; i++) {
            if (i >= fromIndex) {
                sublist.add(current.data);
            }
            current = current.next;
        }
        return sublist;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Returns a string representation of the list.
     * @return a string containing the list elements
     */
    public String toString() {
        StringBuilder singleList = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            singleList.append(current.data).append(current.next != null ? ", " : "");
            current = current.next;
        }
        singleList.append("]");
        return singleList.toString();
    }
}

/**
 * Represents a stack interface with common operations.
 */
interface IStack {
    /**
     * Removes and returns the top element of the stack.
     * @return the top element
     * @throws IndexOutOfBoundsException if the stack is empty
     */
    public Object pop();
    
    /**
     * Returns the top element of the stack without removing it.
     * @return the top element
     * @throws IndexOutOfBoundsException if the stack is empty
     */
    public Object peek();
    
    /**
     * Pushes an element onto the top of the stack.
     * @param element the element to be pushed
     */
    public void push(Object element);
    
    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Gets the size of the stack.
     * @return the number of elements in the stack
     */
    public int size();
}

/**
 * A stack implementation using a singly linked list.
 */
class MyStack implements IStack {
    /** The size of the stack */
    private int size = 0;
    /** The underlying linked list */
    private SingleLinkedList stack = new SingleLinkedList();
    
    /**
     * Gets the underlying linked list.
     * @return the linked list representing the stack
     */
    public SingleLinkedList getStack() {
        return stack;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * {@inheritDoc}
     */
    public Object pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            Object x = stack.get(0);
            stack.remove(0);
            size--;
            return x;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public Object peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else {
            return stack.get(0);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void push(Object element) {
        stack.add(0, element);
        size++;
    }
    
    /**
     * {@inheritDoc}
     */
    public int size() {
        return size;
    }
}

/**
 * Represents an interface for evaluating mathematical expressions.
 */
interface IExpressionEvaluator {
    /**
     * Converts an infix expression to postfix notation.
     * @param expression the infix expression
     * @return the postfix expression
     * @throws IllegalArgumentException if the expression is invalid
     */
    public String infixToPostfix(String expression);
    
    /**
     * Evaluates a postfix expression.
     * @param expression the postfix expression
     * @return the result of the evaluation
     * @throws IllegalArgumentException if the expression is invalid
     */
    public int evaluate(String expression);
}

/**
 * A class for evaluating mathematical expressions.
 */
class Evaluator implements IExpressionEvaluator {
    /**
     * Checks if the given expression is valid.
     * @param expr the expression to validate
     * @return true if the expression is valid, false otherwise
     */
    public boolean isValidExpression(String expr) {
        expr = expr.replaceAll("\\s+", "");
        if (expr.isEmpty()) return false;
        char[] t = expr.toCharArray();
        int p = 0;
        char prev = ' ';
        for (int i = 0; i < t.length; i++) {
            char c = t[i];
            if ("abc+-*/^()".indexOf(c) == -1) return false;
            if (c == '(') p++;
            else if (c == ')') {
                p--;
                if (p < 0) return false;
            }
            if (i > 0) {
                boolean prevOpnd = prev == 'a' || prev == 'b' || prev == 'c';
                boolean currOpnd = c == 'a' || c == 'b' || c == 'c';
                boolean prevOpr = "+-*/^".indexOf(prev) != -1;
                boolean currOpr = "+-*/^".indexOf(c) != -1;
    
                if (prevOpnd && currOpnd) return false;
                if (prevOpr && currOpr) {
                    if (!(c == '-' && (prev == '(' || prevOpr))) return false;
                }
                if (prev == '(' && currOpr && c != '-') return false;
                if (prevOpr && c == ')') return false;
            }
            prev = c;
        }
        boolean lastValid = prev == 'a' || prev == 'b' || prev == 'c' || prev == ')';
        return lastValid && p == 0;
    }
    
    /**
     * Gets the precedence of an operator.
     * @param c the operator
     * @return the precedence level
     */
    private int precendence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '^') {
            return 3;
        } else {
            return -1;
        }
    }
    
    /**
     * Checks if an operator is right-associative.
     * @param c the operator
     * @return true if right-associative, false otherwise
     */
    private boolean isRightAssociative(char c) {
        return c == '^';
    }
        /** The stack used for expression evaluation */
    private MyStack stack = new MyStack();
    /** The resulting postfix expression */
    private String posfix = "";
    /** The values for variables a, b, and c */
    public String a, b, c;

    /**
     * Converts an infix expression to postfix notation.
     * @param expression the infix expression to convert
     * @return the postfix expression
     * @throws IllegalArgumentException if the expression contains invalid characters
     */
    public String infixToPostfix(String expression) {
        char prev = ' ';
        String s = expression.replaceAll("--", "+");
        char[] infix = s.toCharArray();
        for (char c : infix) {
            if (c == '+' && (prev == '^' || prev == '*' || prev == '/')) continue;
            if (c == '+' && stack.size() == 0 && posfix.length() == 0) continue;

            if (c == 'a' || c == 'b' || c == 'c') {
                posfix += c;
            } else if (c == '(' || c == ')' || c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (stack.size() != 0 && !stack.peek().equals('(') &&
                            precendence(c) <= precendence((char) stack.peek())) {
                        posfix += (Character) stack.pop();
                    }
                    stack.pop();
                } else {
                    while (stack.size() != 0 && !stack.peek().equals('(') &&
                            ((!isRightAssociative(c) && precendence(c) <= precendence((char) stack.peek())) ||
                                    (isRightAssociative(c) && precendence(c) < precendence((char) stack.peek())))) {
                        posfix += (Character) stack.pop();
                    }
                    stack.push(c);
                }
            } else {
                throw new IllegalArgumentException("Error");
            }
            prev = c;
        }
        while (stack.size() != 0) {
            posfix += (Character) stack.pop();
        }
        return posfix;
    }

    /**
     * Evaluates a postfix expression.
     * @param expression the postfix expression to evaluate
     * @return the result of the evaluation
     * @throws IllegalArgumentException if the expression is invalid or contains division by zero
     */
    public int evaluate(String expression) {
        MyStack stack1 = new MyStack();
        int x1, x2;
        char[] s = expression.toCharArray();
        for (char x : s) {
            if (x == 'a') stack1.push(Integer.parseInt(a));
            else if (x == 'b') stack1.push(Integer.parseInt(b));
            else if (x == 'c') stack1.push(Integer.parseInt(c));
            else if (x == '+') {
                if (stack1.size() == 1) {
                    x1 = (int) stack1.pop();
                    stack1.push(x1);
                } else {
                    x1 = (int) stack1.pop();
                    x2 = (int) stack1.pop();
                    stack1.push((int) x2 + (int) x1);
                }
            } else if (x == '-') {
                if (stack1.size() == 1) {
                    x1 = (int) stack1.pop();
                    stack1.push(-x1);
                } else {
                    x1 = (int) stack1.pop();
                    x2 = (int) stack1.pop();
                    stack1.push((int) x2 - (int) x1);
                }
            } else if (x == '/') {
                x1 = (int) stack1.pop();
                x2 = (int) stack1.pop();
                stack1.push((int) x2 / (int) x1);
            } else if (x == '*') {
                x1 = (int) stack1.pop();
                x2 = (int) stack1.pop();
                stack1.push((int) x2 * (int) x1);
            } else if (x == '^') {
                x1 = (int) stack1.pop();
                x2 = (int) stack1.pop();
                if (x1 == 0 & x2 == 0) {
                    throw new IllegalArgumentException("Error");
                }
                int x3 = (int) Math.pow(x2, x1);
                stack1.push(x3);
            } else {
                throw new IllegalArgumentException("Error");
            }
        }
        if (stack1.size() == 1) {
            return (int) stack1.pop();
        } else {
            throw new IllegalArgumentException("Error");
        }
    }
}

/**
 * Main class for running the expression evaluator.
 */
public class lab52 {
    /**
     * Main method that reads input and evaluates expressions.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Evaluator pro = new Evaluator();
            String sin = sc.nextLine();
            if (!pro.isValidExpression(sin)) {
                throw new IllegalArgumentException("Error");
            }

            String posfix = pro.infixToPostfix(sin);
            if (sin.charAt(sin.length() - 1) != 'a' && sin.charAt(sin.length() - 1) != 'b' && 
                sin.charAt(sin.length() - 1) != 'c' && sin.charAt(sin.length() - 1) != ')') {
                throw new IllegalArgumentException("Error");
            }

            String a = sc.nextLine().replaceAll("a=", "");
            String b = sc.nextLine().replaceAll("b=", "");
            String c = sc.nextLine().replaceAll("c=", "");

            pro.a = a;
            pro.b = b;
            pro.c = c;
            int sum = pro.evaluate(posfix);
            System.out.println(posfix);
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}