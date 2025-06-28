import java.util.Scanner;
interface ILinkedList {
public void add(int index, Object element);
public void add(Object element);
public Object get(int index);
public void set(int index, Object element);
public void clear();
public boolean isEmpty();
public void remove(int index);
public int size();
public ILinkedList sublist(int fromIndex , int toIndex);
public boolean contains(Object o );
}
class DoubleLinkedList implements ILinkedList{
    private class Node{
        Object data ;
        Node next , prev ;
        Node(Object data){this.data = data ;}
    }
    private Node head,tail;
    private int size = 0 ;
    private Node getNode(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node current ;
        if(index < size/2){
            current = head ;
                for(int i =0 ; i<index; i++){
                    current = current.next;
                }

        }
        else{
            current = tail ;
            for(int i = size-1 ; i>index; i--){
                current = current.prev;
            }
        }
        return current;

    }
    public void add(int index, Object element){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        else {
            Node newNode = new Node(element);
            if(index == 0 ){
                newNode.next = head ;
                if(head != null)head.prev = newNode ;
                head = newNode ;
                if(size == 0 ) tail= newNode;
            }
            else if(index == size){
                tail.next = newNode ;
                newNode.prev = tail;
                tail = newNode ;
            }
            else{
                Node current = getNode(index);
                Node prev = current.prev ;
                prev.next = newNode ;
                newNode.next = current;
                newNode.prev = prev ;
                current.prev = newNode ;
            }
            size++;
        }
    }
    public void add(Object element){
        add(size,element);
    }
    public Object get(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node current = getNode(index);
        return current.data;
    }
    public void set(int index, Object element){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node current = getNode(index);
        current.data = element;
    }
    public void clear(){
        head = null ;
        tail = null ;
        size = 0 ;
    }
    public boolean isEmpty(){
        return size == 0 ;
    }
    public void remove(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node current = getNode(index);
        if(current.prev != null)current.prev.next=current.next;
        else head = current.next;
        if(current.next != null)current.next.prev = current.prev;
        else tail = current.prev ;
        size -- ;
    }
    public int size(){
        return size;
    }
    public ILinkedList sublist(int fromIndex , int toIndex){
        if(fromIndex<0 || toIndex>size || fromIndex > toIndex){
            throw new IndexOutOfBoundsException();
        }
        DoubleLinkedList sublist = new DoubleLinkedList();
        Node current = head ;
        for (int i = 0 ; i <= toIndex ; i++) {
            if(i>=fromIndex){
                sublist.add(current.data);
            }
            current = current.next ;
        }
        return sublist ;
    }
    public boolean contains(Object o ){
        Node current = head ;
        while(current != null ){
            if(current.data.equals(o)){
                return true ;
            }
            current = current.next;
        }
        return false ;
    }
    public String toString(){
        StringBuilder singleList = new StringBuilder("[");
        Node current = head ;
        while(current != null){
            singleList.append(current.data).append(current.next != null ? ", " : "");
            current = current.next;
        }
        singleList.append("]");
        return singleList.toString();

    }
}
public class lab4_2{
    public static void main(String[] args) {
        try{
        DoubleLinkedList Double = new DoubleLinkedList();
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");;
        if (s.length == 1 && s[0].isEmpty()){
        }
        else {
            for(int i = 0; i < s.length; ++i){
        	   Double.add(Integer.parseInt(s[i]));}
        }
        String oparation = sc.nextLine();
        switch (oparation) {
            case "add":
                int valu0 = sc.nextInt();
                Double.add(valu0);
                System.out.println(Double.toString());
                    break;
            case "addToIndex":
                int valu1 = sc.nextInt();
                int valu2 = sc.nextInt();
                Double.add(valu1 , valu2);
                System.out.println(Double.toString());
                break;
            case "get":
                int valu3 = sc.nextInt();
                System.out.println(Double.get(valu3));
                    break;
            case "set":
                int valu4 = sc.nextInt();
                int valu5 = sc.nextInt();
                Double.set(valu4,valu5);
                System.out.println(Double.toString());
                    break;
            case "clear" :
                Double.clear();
                System.out.println(Double.toString());
                    break;
            case "remove":
                int valu6 = sc.nextInt();
                Double.remove(valu6);
                System.out.println(Double.toString());
                    break;
            case "isEmpty":
                if(Double.isEmpty())System.out.println("True");
                else System.out.println("False");
                    break;
            case "sublist":
                int valu7 = sc.nextInt();
                int valu8 = sc.nextInt();
                System.out.println(Double.sublist(valu7,valu8).toString());
                    break;
                case "contains":
                    int valu9 = sc.nextInt();
                    if(Double.contains(valu9))System.out.println("True");
                    else System.out.println("False");
                        break;
            case "size":
                    System.out.println(Double.size());
                        break;
            default:
            System.out.println("Error");
        }} catch (Exception e ){System.out.println("Error");}
}}