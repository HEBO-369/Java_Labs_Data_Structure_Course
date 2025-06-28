// Jvdroid-main: lab4_3
import java.util.*;
import java.math.BigInteger;
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
            StringBuilder DoubleList = new StringBuilder("[");
            Node current = head ;
            while(current != null){
                DoubleList.append(current.data).append(current.next != null ? ", " : "");
                current = current.next;
            }
            DoubleList.append("]");
            return DoubleList.toString();

        }
    }
interface IpolynomialSolver{
    void setPolynomial(char poly , BigInteger[][] terms);
    String print(char poly);
    void clearPolynomail(char poly);
    float evaluatePolynomial(char poly,float value);
    BigInteger [][] add(char poly1 , char poly2);
    BigInteger [][] sub(char poly1 , char poly2);
    BigInteger [][] mul(char poly1 , char poly2);
}
class PolynomialSolver implements IpolynomialSolver{
    private Map < Character , DoubleLinkedList> pol = new HashMap<>();
    public void setPolynomial(char poly , BigInteger[][] terms){
        DoubleLinkedList listpoly = new DoubleLinkedList();
        boolean check = false;
        for (int i = 0; i < terms[0].length; i++) {
            if (!terms[0][i].equals(BigInteger.ZERO)) check = true;
            listpoly.add(terms[0][i]);
        } 
        if(!check && poly != 'R') throw new RuntimeException();
        pol.put(poly,listpoly);
    }
    public String print(char poly) {
        DoubleLinkedList listpoly = pol.get(poly);
        if (listpoly == null || listpoly.size() == 0) throw new RuntimeException();

        StringBuilder result = new StringBuilder();
        int degree = listpoly.size() - 1;

        for (int i = 0; i < listpoly.size(); i++) {
            BigInteger coeff = (BigInteger) listpoly.get(i);
            int exp = degree - i;

            if (coeff.equals(BigInteger.ZERO)) continue;

            if (result.length() > 0) {
                result.append(coeff.compareTo(BigInteger.ZERO) > 0 ? "+" : "");
            }

            if (exp == 0) {
                result.append(coeff);
            } else if (exp == 1) {
                if (coeff.equals(BigInteger.ONE)) result.append("x");
                else if (coeff.equals(BigInteger.valueOf(-1))) result.append("-x");
                else result.append(coeff).append("x");
            } else {
                if (coeff.equals(BigInteger.ONE)) result.append("x^").append(exp);
                else if (coeff.equals(BigInteger.valueOf(-1))) result.append("-x^").append(exp);
                else result.append(coeff).append("x^").append(exp);
            }
        }

        if (result.length() == 0) return "[]";
        return result.toString();
    }
    public void clearPolynomail(char poly){
        pol.remove(poly);
        System.out.print("[]");
    }
    public float evaluatePolynomial(char poly,float value){
        DoubleLinkedList eva = pol.get(poly);
        if(eva==null)throw new IndexOutOfBoundsException();
        BigInteger result = BigInteger.ZERO;
        for(int i = 0; i< eva.size();i++){
            BigInteger coeff = (BigInteger)eva.get(i);
            int power = eva.size()-i-1 ;
            result = result.add(coeff.multiply(BigInteger.valueOf((long)Math.pow(value,power))));
        }
        return result.floatValue();
    }
    public BigInteger [][] add(char poly1 , char poly2){
        DoubleLinkedList p1 = pol.get(poly1);
        DoubleLinkedList p2 = pol.get(poly2);

        if (p1 == null || p2 == null || p1.isEmpty() || p2.isEmpty())
            throw new RuntimeException();

        int size1 = p1.size();
        int size2 = p2.size();
        int maxSize = Math.max(size1, size2);
        BigInteger[][] result = new BigInteger[1][maxSize];

        for (int i = 0; i < maxSize; i++) {
            int index1 = i - (maxSize - size1);
            int index2 = i - (maxSize - size2);

            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ZERO;

            if (index1 >= 0) {
                a = (BigInteger) p1.get(index1);
            }

            if (index2 >= 0) {
                b = (BigInteger) p2.get(index2);
            }

            result[0][i] = a.add(b);
        }

        return result;
    }
    public BigInteger [][] sub(char poly1 , char poly2){
        DoubleLinkedList p1 = pol.get(poly1);
        DoubleLinkedList p2 = pol.get(poly2);

        if (p1 == null || p2 == null || p1.isEmpty() || p2.isEmpty())
            throw new RuntimeException();

        int size1 = p1.size();
        int size2 = p2.size();
        int maxSize = Math.max(size1, size2);
        BigInteger[][] result = new BigInteger[1][maxSize];

        for (int i = 0; i < maxSize; i++) {
            int index1 = i - (maxSize - size1);
            int index2 = i - (maxSize - size2);

            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ZERO;

            if (index1 >= 0) {
                a = (BigInteger) p1.get(index1);
            }

            if (index2 >= 0) {
                b = (BigInteger) p2.get(index2);
            }

            result[0][i] = a.subtract(b);
        }

        return result;
    }
    public BigInteger [][] mul(char poly1 , char poly2){
        DoubleLinkedList p1 = pol.get(poly1);
        DoubleLinkedList p2 = pol.get(poly2);
        BigInteger[][] result = new BigInteger[1][p1.size()+p2.size()-1];
        for (int i = 0; i < result[0].length; i++) result[0][i] = BigInteger.ZERO;

        for (int i = 0; i < p1.size(); i++) {
            for(int j = 0 ; j < p2.size();j++){
                BigInteger prod = ((BigInteger)p1.get(i)).multiply((BigInteger)p2.get(j));
                result[0][j+i] = result[0][j+i].add(prod);
            }
        }
        return result ;
    }
}
public class lab4_3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            PolynomialSolver adde = new PolynomialSolver();
            int count = 0;

            while (true) {
                String oparation = sc.next();
                switch (oparation) {
                    case "set":
                        char valu0 = sc.next().charAt(0);
                        if (valu0 != 'A' && valu0 != 'B' && valu0 != 'C') throw new RuntimeException();
                        String sin = sc.next().replaceAll("\\[|\\]", "");
                        String[] s = sin.split(",");
                        BigInteger[][] arr = new BigInteger[1][s.length];
                        if (s.length == 1 && s[0].isEmpty()) {
                            throw new IndexOutOfBoundsException();
                        } else {
                            for (int i = 0; i < s.length; ++i) {
                                arr[0][i] = new BigInteger(s[i].trim());
                            }
                        }
                        adde.setPolynomial(valu0, arr);
                        break;

                    case "print":
                        char valu1 = sc.next().charAt(0);
                        System.out.println(adde.print(valu1));
                        count++;
                        if (count == 3) return;
                        break;

                    case "add":
                        char valu2 = sc.next().charAt(0);
                        char valu3 = sc.next().charAt(0);
                        adde.setPolynomial('R', adde.add(valu2, valu3));
                        System.out.print(adde.print('R'));
                        return;

                    case "sub":
                        char valu4 = sc.next().charAt(0);
                        char valu5 = sc.next().charAt(0);
                        adde.setPolynomial('R', adde.sub(valu4, valu5));
                        System.out.print(adde.print('R'));
                        return;

                    case "mult":
                        char valu6 = sc.next().charAt(0);
                        char valu7 = sc.next().charAt(0);
                        adde.setPolynomial('R', adde.mul(valu6, valu7));
                        System.out.print(adde.print('R'));
                        return;

                    case "eval":
                        char valu8 = sc.next().charAt(0);
                        float valu9 = sc.nextFloat();
                        float evalResult = adde.evaluatePolynomial(valu8, valu9);
                        if (evalResult - (int) evalResult == 0)
                            System.out.print((int) evalResult);
                        else
                            System.out.print(evalResult);
                        return;

                    case "clear":
                        char valu10 = sc.next().charAt(0);
                        adde.clearPolynomail(valu10);
                        return;

                    default:
                        System.out.print("Error");
                }
            }
        } catch (Exception e) {
            System.out.print("Error");
        }
    }
}