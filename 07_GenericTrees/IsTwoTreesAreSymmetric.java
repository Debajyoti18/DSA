package GenericTrees;

public class IsTwoTreesAreSymmetric {
    public static boolean isTwoTreesAreSymmetric(Node d1,Node d2){
        //check for first  root node's number of childern
        if (d1.children.size() != d2.children.size()) {
            return false;
        }
        // both roots have same number of children then check same number 
        //of children for thei childern also
        for(int i = 0; i < d1.children.size() ; i++){
            Node child_d1 = d1.children.get(i);
            Node child_d2 = d2.children.get(i);
            if(child_d1.val != child_d2.val){
                return false;
            }
        }
        //  number of children of children are also same then symmetric
        return true;
    }
}
