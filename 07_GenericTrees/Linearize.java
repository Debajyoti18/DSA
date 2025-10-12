package GenericTrees;

public class Linearize {
    //Brute Force-O(n2)
    private static void linearize(Node node){
        for(Node chNode : node.children){
            linearize(chNode);
        }
        while (node.children.size() > 1) {
            Node lastNode = node.children.remove(node.children.size()-1);
            Node secondlastNode = node.children.get(node.children.size()-1);
            Node secondlastNodeTail = getTail(secondlastNode);
            secondlastNodeTail.children.add(lastNode); 
        }
    }

    private static Node getTail(Node root) {
       while (root.children.size() == 1) {
            root = root.children.get(0);
       }
       return root;
    }


    //linearize optimized - O(n)
    


}
