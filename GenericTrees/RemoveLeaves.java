package GenericTrees;

public class RemoveLeaves {
    public static void removeLeaves(Node root){
            // Remove in Preorder for safe remove and 
        for(int i = root.children.size()-1;i >= 0; i--){
            Node currNode = root.children.get(i);
            if(currNode.children.size() == 0){
                root.children.remove(currNode);
            }
        }
        // Recurse for the childrens 
        for(Node child : root.children){
            removeLeaves(child);
        }

    }
}
