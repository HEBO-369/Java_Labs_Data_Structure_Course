import java.util.*;

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
            size--;
            stack.remove(0);
            return stack;
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
 * Main class for demonstrating stack operations.
 */
public class lab51 {
    /**
     * Main method that reads input and performs stack operations.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            MyStack stack0 = new MyStack();
            Scanner sc = new Scanner(System.in);
            
            // Read and parse the initial stack elements
            String sin = sc.nextLine().replaceAll("\\[|\\]", "");
            String[] s = sin.split(", ");
            int[] arr = new int[s.length];
            
            if (s.length == 1 && s[0].isEmpty()) {
                arr = new int[]{};
            } else {
                for (int i = 0; i < s.length; ++i) {
                    arr[i] = Integer.parseInt(s[i]);
                }
            }
            
            // Push elements onto the stack in reverse order
            for (int i = arr.length - 1; i >= 0; i--) {
                stack0.push(arr[i]);
            }
            
            // Read and execute the operation
            String in = sc.nextLine();
            switch (in) {
                case "push":
                    int num = sc.nextInt();
                    stack0.push(num);
                    System.out.print(stack0.getStack());
                    break;
                case "pop":
                    stack0.pop();
                    System.out.print(stack0.getStack());
                    break;
                case "peek":
                    System.out.print(stack0.peek());
                    break;
                case "isEmpty":
                    if (stack0.isEmpty()) {
                        System.out.print("True");
                    } else {
                        System.out.print("False");
                    }
                    break;
                case "size":
                    System.out.print(stack0.size());
                    break;
                default:
                    System.out.println("Error");
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}