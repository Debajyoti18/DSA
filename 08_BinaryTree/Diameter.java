public class Diameter {
    public static int diameter1(Node root){
        if(root == null){
            return 0;
        }
        int ld = diameter1(root.left);
        int rd = diameter1(root.right);
        int fact = height(root.left) + height(root.right) + 2;
        int dia = Math.max(fact,Math.max(ld, rd));
        return dia;
    }
}
