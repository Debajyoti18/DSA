

import java.util.*;

public class ConstructBT {
    public Node root;
    public ConstructBT(){} 
    public ConstructBT(Integer[] preorder) {
        Node root = buildTree(preorder);
    }
    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // method to build binary tree
    public Node buildTree(Integer[] preorder) {
        if (preorder == null || preorder.length == 0 || preorder[0] == null) 
            return null;

        Node root = new Node(preorder[0]);
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        int index = 1;

        while (!stack.isEmpty() && index < preorder.length) {
            Pair top = stack.peek();

            if (top.state == 1) {
                if (preorder[index] != null) {
                    Node left = new Node(preorder[index]);
                    top.node.left = left;
                    stack.push(new Pair(left, 1));
                }
                top.state++;
                index++;
            } 
            else if (top.state == 2) {
                if (index < preorder.length && preorder[index] != null) {
                    Node right = new Node(preorder[index]);
                    top.node.right = right;
                    stack.push(new Pair(right, 1));
                }
                top.state++;
                index++;
            } 
            else {
                stack.pop();
            }
        }

        return root;
    }
}
// Construct BT from inorder and preorder
/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        int  n = inorder.length;
        return build(preorder,0,n-1,inorder,0,n-1);
    }
    public static Node build(int[] pre,int psi,int pei,int[] in,int isi,int iei){
        if(isi > iei || psi > pei){
            return null;
        }
        // create root node from preorder because preorder's first element is root
        Node root = new Node(pre[psi]);
        // find the index of root in inorder
        int idx = isi;
        while( in[idx] != pre[psi]){
            idx++;
        }
        // calculate the total elements in left subtree
        int totalEle = idx - isi;
        // recursively build left and right subtrees
        //leftpre = psi+1 to psi+totalEle
        //lefin = isi to idx-1
        //rightpre = psi+totalEle+1 to pei
        //rightin = idx+1 to iei
        root.left = build(pre,psi+1,psi+totalEle,in,isi,idx-1);
        root.right = build(pre,psi+totalEle+1,pei,in,idx+1,iei);
        return  root;
    }
}
//construct BT from inorder and postorder
class Solution2 {
    public static Node buildTree(int inorder[], int postorder[]) {
        // code here
        int  n = inorder.length;
        return build(postorder,0,n-1,inorder,0,n-1);
    }
    public static Node build(int[] post,int psi,int pei,int[] in,int isi,int iei){
        if(isi > iei || psi > pei){
            return null;
        }
        // create root node from postorder because postorder's last element is root
        Node root = new Node(post[pei]);
        // find the index of root in inorder
        int idx = isi;
        while( in[idx] != post[pei]){
            idx++;
        }
        // calculate the total elements in left subtree
        int totalEle = idx - isi;
        // recursively build left and right subtrees
        //leftpost = psi to psi+totalEle-1
        //lefin = isi to idx-1
        //rightpost = psi+totalEle to pei-1
        //rightin = idx+1 to iei
        root.left = build(post,psi,psi+totalEle-1,in,isi,idx-1);
        root.right = build(post,psi+totalEle,pei-1,in,idx+1,iei);
        return  root;
    }
}