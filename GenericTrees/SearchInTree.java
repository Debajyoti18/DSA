package GenericTrees;

public class SearchInTree {
    public static boolean  search(Node root , int data){
        if( root.val == data){
            return true;
        }
        for(Node child : root.children){
            boolean src = search(child, data);
            if(src){
                return true;
            }
        }
        return false;
    }
}
