import java.util.Scanner;
interface IQueue {
    /** 
     * Inserts an item at the queue front.
     */
    public void enqueue(Object item) throws Exception;
    /**
     * Removes the object at the queue rear and returns it.
     */
    public Object dequeue() throws Exception;
    /**
     * Tests if this queue is empty.
     */
    public boolean isEmpty();
    /**
     * Returns the number of elements in the queue
     */
    public int size();
} 
public class ArrayQueue implements IQueue {
    int size ;
    Object[] array = new Object[1000];
    public ArrayQueue() {
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
            Object temp2 = array[0];
            for(int i = 0; i < size-1; i++){
                array[i] = array[i+1];}
            size--;
            return temp2;
        }
        Object temp2 = array[0];
        for(int i = 0; i < size-1; i++){
            array[i] = array[i+1];}
        size--;
        return temp2;
        }


    public void enqueue(Object o) throws Exception {
        array[size] = o;
        size++;
    }

    public String to_String(){
        if(isEmpty()){
            return "[]";
        }
        String s = "[";
        for(int i = size-1; i >= 0; i--){
            s += array[i] + ", ";
        }
        s = s.substring(0, s.length() - 2) + "]";
        return s;
    }

    public static void main(String[] args) {
        try {
            ArrayQueue q1 = new ArrayQueue();
            Scanner sc = new Scanner(System.in);
            String sin = sc.nextLine().replaceAll("\\[|\\]", "");
            String[] s = sin.split(", ");
            
            // Handle empty input case
            if (!sin.trim().isEmpty()) {
                for(int i = s.length-1; i >= 0 ; i--){
                    try {
                        q1.enqueue(Integer.parseInt(s[i]));
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
                        q1.enqueue(value);
                        System.out.println(q1.to_String());
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;
                case "dequeue":
                    try {
                        q1.dequeue();
                        System.out.println(q1.to_String());
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    break;
                case "isEmpty":
                    System.out.println(q1.isEmpty() ? "True" : "False");
                    break;
                case "size":
                    System.out.println(q1.size());
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }}
