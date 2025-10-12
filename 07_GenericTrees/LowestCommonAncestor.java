package GenericTrees;

import java.util.ArrayList;

public class LowestCommonAncestor {

    public static  int  lowestCommonAncestor(Node root ,int x, int y){
            ArrayList<Node> p1 =  pathFromRootToElement(root, x);//find paths for first node
            ArrayList<Node> p2 =  pathFromRootToElement(root, y);//find paths for second node
            //traverse form last paths 
            int i = p1.size() - 1;
            int j = p2.size() - 1;
            //check for the each elemnts one by one and bifurcate at the lca point 
            while ( i >= 0  && j >= 0 && p1.get(i) == p2.get(j)) {
                i--;
                j--;
            }
            
            i++;
            j++;

            return p1.get(i).val;
    }

    public static ArrayList<Node>  pathFromRootToElement(Node root,int data){
        if(root.val == data){
            ArrayList<Node> list = new ArrayList<>();
            list.add(root);
            return list;
        }
        // if root is not equal the find in chidren
        for(Node child : root.children){
            ArrayList<Node> res = pathFromRootToElement(child, data);
            if(res.size() > 0){
                //if any of the child have the element and so have the path then add root to it and return
                res.add(root);
                return res;
            }
        }
        // if still not found in children then return empty path
        return new ArrayList<>();
    }

}
