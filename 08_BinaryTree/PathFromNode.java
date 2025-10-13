import java.util.ArrayList;

public class PathFromNode {
      static ArrayList<Integer> paths;
      public static boolean pathFromRoot(Node root , int data ){
        if( root == null ){
            return false;
        }
        if(root.data == data){
            paths.add(data);
            return true;
        }
        boolean lfc = pathFromRoot(root.left, data);
        if(lfc){
              paths.add(data);
            return true;  
        }
         boolean rfc = pathFromRoot(root.right, data);
        if(rfc){
             paths.add(data);
            return true;
        }
        return false;
      }
}
