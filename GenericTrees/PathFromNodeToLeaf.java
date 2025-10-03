package GenericTrees;

import java.util.ArrayList;
import java.util.List;

public class PathFromNodeToLeaf {
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
