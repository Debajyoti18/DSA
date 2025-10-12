package 08_BinaryTree;

public class Main {
    public static void main(String[] args) {
         Integer[] preorder = {10, 20, null, null, 30, null, null};
       Node root = new ConstructBT().buildTree(preorder);

        System.out.println("Root value : " + root.val);
    }
}
