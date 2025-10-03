package GenericTrees;

public class SearchInTree {
    public static boolean  search(Node root , int data){
        if( root.val == data){//first check for parents 
            return true;
        }
        for(Node child : root.children){
            boolean src = search(child, data);//check each child of the parent  
            if(src){
                return true;
            }
        }
        return false;
    }
}
