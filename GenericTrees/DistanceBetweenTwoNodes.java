package GenericTrees;

import java.util.ArrayList;

public class DistanceBetweenTwoNodes {
    public static int distanceBetweenTwoNodes(Node d1 , Node d2){
            ArrayList<Node> p1 =  pathFromRootToElement(d1, d1.val);//find paths for first node
            ArrayList<Node> p2 =  pathFromRootToElement(d2, d2.val);//find paths for second node
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

            return i+j;
    }
    
}
