public class PrintKLevelDown {
   // Intuition : To print all nodes at a given level k, we can use a recursive approach.
    public static void printKLevelDown(Node root, int k) {
        // base case: if the node is null or k is negative, return
        if(root == null || k < 0){
            return;
        }
        // if k is 0, print the current node's value
        if(k == 0){
            System.out.print(root.val + " ");
            return;
        }
        // recursively call the function for left and right children with k decremented by 1
        printKLevelDown(root.left, k-1);
        printKLevelDown(root.right, k-1);
    }

    // Helper method to construct binary tree from array
    public static Node constructBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        Node root = new Node(arr[0]);
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Helper method to parse input string into Integer array
    private static Integer[] parseInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new Integer[0];
        }
        
        String[] parts = input.split(",");
        Integer[] result = new Integer[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].trim();
            if (part.equals("null") || part.isEmpty()) {
                result[i] = null;
            } else {
                try {
                    result[i] = Integer.parseInt(part);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input at position " + i + ": " + part);
                    return new Integer[0];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        while (true) {
            System.out.println("\nEnter tree values separated by commas (e.g., '1,2,3,null,4,5')");
            System.out.println("Or type 'exit' to quit:");
            
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            Integer[] treeArray = parseInput(input);
            if (treeArray.length == 0) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            Node root = constructBinaryTree(treeArray);
            
            System.out.println("\nBinary Tree created from input: " + java.util.Arrays.toString(treeArray));
            
            // Get the level to print
            System.out.println("\nEnter the level to print (0 or positive number):");
            int level;
            try {
                level = Integer.parseInt(scanner.nextLine().trim());
                if (level < 0) {
                    System.out.println("Level cannot be negative. Please enter a non-negative number.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid level input. Please enter a valid number.");
                continue;
            }

            System.out.println("\nNodes at level " + level + ":");
            printKLevelDown(root, level);
            System.out.println("\n");

            // Visual representation of the tree structure
            System.out.println("Tree Structure (level-order):");
            printTreeStructure(root);
        }
        
        scanner.close();
    }

    // Helper method to print tree structure
    private static void printTreeStructure(Node root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("Level " + level + ": ");
            
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                System.out.print(current.val + " ");
                
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            System.out.println();
            level++;
        }
    }
}
