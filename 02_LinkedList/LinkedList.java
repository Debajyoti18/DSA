import java.lang.*;
import java.io.*;
import java.util.*;
 class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class LinkedList {
    Node head;
    Node tail;
    int size;

    // Add Node in last -> O(1)
    void addLast(int val) {
         Node newnode = new Node(val);
         if(size == 0){       
            head = tail = newnode;
        }else{
            tail.next = newnode;
            tail = tail.next;
        }
        size++;
       
    }

    // Add Node in Front -> O(1)
    public void addFirst(int val) {
        Node newnode = new Node(val);
        if(size == 0){
            head = tail = newnode;
        }else{
            head.next = newnode;
            head = newnode;
        }
        size++;
    }

    // Add At Given Index -> O(N) Worst Case
    public void addAt(int idx, int val) {
         if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
            return;
        }
         Node newnode = new Node(val);
         newnode.data = val;
       if(idx == 0){
        head = newnode;
        head = head.next;
       }
       else if(idx == size){
        tail = newnode;
        tail = tail.next;
       }else{
        Node temp = getNodeAt( idx-1);
        newnode.next = temp.next;
        temp.next = newnode;
       }
       size++;

    }

    // Traverse Linked List -> O(N)
    public void display() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        
    }

    // Get First Element -> O(1)
    public int getFirst() {
        if(head == null){
            return -1;
        }
        return head.data;
        
    }

    // Get Last Element -> O(1) { Provided Tail Pointer }
    public int getLast() {
        if(tail == null){
            return -1;
        }
        return tail.data;
        
    }

    // Get Element at given index -> O(N) Worst Case
    public int getAt(int idx) {
        if(idx == 0){
           return getFirst();
        }else if(idx == size){
           return getLast();
        }else{
            Node t = head;
            for(int i=0;i<idx;i++){
                t = t.next;
            }
            return t.data;  
        }
       
    }

    // Get Node at given Index -> O(N)
    public Node getNodeAt(int idx) {
      Node t = head;
            for(int i=0;i<idx;i++){
                t = t.next;
            }
            return t;  
    }

    // Remove Last Element -> O(N) {Singly Linked List}
    public void removeLast() {
        
    }
       

    // Remove Element at Given Index -> O(N) Worst Case
    public void removeAt(int idx) {
       
    }
    
    // Display Linked List in Reverse using Recursion:
    // O(N) Time, O(N) Recursion Call Stack Space
    public void displayReverse(Node curr){
     
    }
}