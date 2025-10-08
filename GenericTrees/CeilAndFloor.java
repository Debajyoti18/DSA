package GenericTrees;

public class CeilAndFloor {
    static int ceilNode = Integer.MIN_VALUE , floorNode = Integer.MAX_VALUE;
        public static void CeilAndFloor(Node root , int data){
            // Smallest of All larger elements
            if(root.val > data ){
                if ( root.val < ceilNode){
                        ceilNode = root.val;
                }
            }
            // Largest of All the Smallest elements
             if(root.val < data ){
                if ( root.val > floorNode){
                        floorNode = root.val;
                }
            }
            for(Node chilNode : root.children){
                CeilAndFloor(chilNode, data);
            }

        }
}
