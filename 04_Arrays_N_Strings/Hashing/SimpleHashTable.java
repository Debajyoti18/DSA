package Hashing;

import java.util.*;

public class SimpleHashTable {
    
    // Simple Node class for key-value pairs
    class Node {
        String key;
        int value;
        Node next;
        
        Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private Node[] table;
    private int size;
    
    // Constructor
    public SimpleHashTable(int capacity) {
        table = new Node[capacity];
        size = 0;
    }
    
    // Simple hash function
    private int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }
    
    // Insert key-value pair
    public void put(String key, int value) {
        int index = hash(key);
        
        // If bucket is empty, create new node
        if (table[index] == null) {
            table[index] = new Node(key, value);
            size++;
            return;
        }
        
        // Search in chain for existing key
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // Update existing key
                return;
            }
            if (current.next == null) break;
            current = current.next;
        }
        
        // Add new node at end of chain
        current.next = new Node(key, value);
        size++;
    }
    
    // Get value by key
    public int get(String key) {
        int index = hash(key);
        Node current = table[index];
        
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        
        return -1; // Key not found
    }
    
    // Remove key
    public boolean remove(String key) {
        int index = hash(key);
        
        if (table[index] == null) {
            return false;
        }
        
        // If first node matches
        if (table[index].key.equals(key)) {
            table[index] = table[index].next;
            size--;
            return true;
        }
        
        // Search in chain
        Node current = table[index];
        while (current.next != null) {
            if (current.next.key.equals(key)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        
        return false; // Key not found
    }
    
    // Display the hash table
    public void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < table.length; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = table[i];
            if (current == null) {
                System.out.println("empty");
            } else {
                while (current != null) {
                    System.out.print("[" + current.key + "=" + current.value + "]");
                    if (current.next != null) System.out.print(" -> ");
                    current = current.next;
                }
                System.out.println();
            }
        }
        System.out.println("Size: " + size + "\n");
    }
    
    // Main method with example
    public static void main(String[] args) {
        SimpleHashTable ht = new SimpleHashTable(5);
        
        System.out.println("=== Simple Hash Table Demo ===\n");
        
        // Insert some values
        ht.put("apple", 10);
        ht.put("banana", 20);
        ht.put("cherry", 30);
        ht.put("date", 40);
        ht.put("fig", 50); // This might cause collision
        
        ht.display();
        
        // Get values
        System.out.println("Get 'banana': " + ht.get("banana"));
        System.out.println("Get 'grape': " + ht.get("grape"));
        
        // Update value
        ht.put("apple", 100);
        System.out.println("\nAfter updating apple to 100:");
        ht.display();
        
        // Remove a key
        ht.remove("banana");
        System.out.println("After removing 'banana':");
        ht.display();
    }
}