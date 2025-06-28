import java.util.Scanner;

interface IQueue{
    /** 
     * Inserts an item at the queue front.
     */
    public void enqueue(Object item)throws Exception;
    /**
     * Removes the object at the queue rear and returns it.
     */
    public Object dequeue ()throws Exception;
    /**
     * Tests if this queue is empty.
     */
    public boolean isEmpty();
    /**
     * Returns the number of elements in the queue
     */
    public int size();
}

public class LinkedListQueue implements IQueue {
class DNode{
    Object value;
    DNode next;

    public DNode(DNode n, Object v) {
        value = v;
        next = n;

    }

    public DNode() {
        this(null, null);
    }
}
    DNode header;
    DNode tail;
    int size = 0;

    public LinkedListQueue() {
        tail = null;

        header = new DNode(null, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        if(size == 1){
            Object temp2 = header.next.value;
            header.next = null;
            tail = null;
            size--;
            return temp2;
        }
        DNode temp = header.next;
        while(temp.next.next != null){
            temp = temp.next;
        }
        Object temp2 = temp.next.value;
        temp.next = null;
        tail = temp;
        size--;
        return temp2;
    }

    public void enqueue(Object o) throws Exception {
        DNode node = new DNode(null, o);
        if(tail == null) {
            header.next = node;
            tail = node;
            size++;
            return;
        }
        node.next = header.next;
        header.next = node;
        size++;
    }

    public Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return header.next.value;
    }

    public String to_String(){
        if(isEmpty()){
            return "[]";
        }
        String s = "[";
        DNode current = header.next;
        while (current != null) {
            s += current.value + ", ";
            current = current.next;
        }
        s = s.substring(0, s.length() - 2) + "]";
        return s;
    }

    public static void main(String[] args) {
        try {
            LinkedListQueue q2 = new LinkedListQueue();
            Scanner sc = new Scanner(System.in);
            String sin = sc.nextLine().replaceAll("\\[|\\]", "");
            String[] s = sin.split(", ");
            
            // Handle empty input case
            if (!sin.trim().isEmpty()) {
                for(int i = s.length-1; i >= 0 ; i--){
                    try {
                        q2.enqueue(Integer.parseInt(s[i]));
                    } catch (NumberFormatException e) {
                        System.out.println("Error");
                        return;
                    }
                }
            }
            
            String operation = sc.nextLine();
            switch (operation) {
                case "enqueue":
                    try {
                        int value = sc.nextInt();
                        q2.enqueue(value);
                        System.out.println(q2.to_String());
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;
                case "dequeue":
                    try {
                        q2.dequeue();
                        System.out.println(q2.to_String());
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;
                case "isEmpty":
                    System.out.println(q2.isEmpty() ? "True" : "False");
                    break;
                case "size":
                    System.out.println(q2.size());
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
