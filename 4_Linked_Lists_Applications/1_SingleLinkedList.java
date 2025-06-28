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
class SingleLinkedList implements ILinkedList{
    private class Node{
        Object data ;
        Node next ;
        Node(Object data){this.data = data ;}
    }
    private Node head;
    private int size = 0 ;
    public void add(int index, Object element){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        else {
            Node newNode = new Node(element);
            if(index == 0 ){
                newNode.next = head ;
                head = newNode ;
            }
            else{
                Node current = head ;
                for(int i =0 ; i<index-1; i++){
                    current = current.next;
                }
                newNode.next = current.next ;
                current.next = newNode;
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
        Node current = head ;
        for (int i = 0; i < index; i++) {
            current = current.next ;
        }
        return current.data;
    }
    public void set(int index, Object element){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node current = head ;
        for (int i = 0; i < index; i++) {
            current = current.next ;
        }
        current.data = element;
    }
    public void clear(){
        head = null ;
        size = 0 ;
    }
    public boolean isEmpty(){
        return size == 0 ;
    }
    public void remove(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        if(index== 0 ){
            head = head.next ;
        }
        else{
        Node current = head ;
        for (int i = 1 ; i < index; i++) {
            current = current.next ;
        }
        Node nextCurrent = current.next;
        current.next = nextCurrent.next ;}
        size -- ;
    }
    public int size(){
        return size;
    }
    public ILinkedList sublist(int fromIndex , int toIndex){
        if(fromIndex<0 || toIndex>size || fromIndex > toIndex){
            throw new IndexOutOfBoundsException();
        }
        SingleLinkedList sublist = new SingleLinkedList();
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
public class lab4_1{
    public static void main(String[] args) {
        try{
        SingleLinkedList single = new SingleLinkedList();
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");;
        if (s.length == 1 && s[0].isEmpty()){

        }
        else {
            for(int i = 0; i < s.length; ++i){
        	   single.add(Integer.parseInt(s[i]));}
        }
        String oparation = sc.nextLine();
        switch (oparation) {
            case "add":
                int valu0 = sc.nextInt();
                single.add(valu0);
                System.out.println(single.toString());
                    break;
            case "addToIndex":
                int valu1 = sc.nextInt();
                int valu2 = sc.nextInt();
                single.add(valu1 , valu2);
                System.out.println(single.toString());
                break;
            case "get":
                int valu3 = sc.nextInt();
                System.out.println(single.get(valu3));
                    break;
            case "set":
                int valu4 = sc.nextInt();
                int valu5 = sc.nextInt();
                single.set(valu4,valu5);
                System.out.println(single.toString());
                    break;
            case "clear" :
                single.clear();
                System.out.println(single.toString());
                    break;
            case "remove":
                int valu6 = sc.nextInt();
                single.remove(valu6);
                System.out.println(single.toString());
                    break;
            case "isEmpty":
                if(single.isEmpty())System.out.println("True");
                else System.out.println("False");
                    break;
            case "sublist":
                int valu7 = sc.nextInt();
                int valu8 = sc.nextInt();
                System.out.println(single.sublist(valu7,valu8).toString());
                    break;
                case "contains":
                    int valu9 = sc.nextInt();
                    if(single.contains(valu9))System.out.println("True");
                    else System.out.println("False");
                        break;
            case "size":
                    System.out.println(single.size());
                        break;
            default:
            System.out.println("Error");
        }} catch (Exception e ){System.out.println("Error");}
}}