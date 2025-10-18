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
        static class DiaPair{
            int ht;
            int dia;
        }
        public static DiaPair diameter2(Node root){
            if(root == null){
                DiaPair d = new DiaPair();
                d.ht = -1; // 0 for node, -1 for edge
                d.dia = 0; 
                return d;
            }
            DiaPair lp = diameter2(root.left);
            DiaPair rp = diameter2(root.right);
            DiaPair myDiaPair = new DiaPair();
            myDiaPair.ht  = Math.max(lp.ht, rp.ht);
            int factoneitherside = lp.ht + rp.ht + 2;
            myDiaPair.dia = Math.max(factoneitherside, Math.max(lp.dia, rp.dia));
            return myDiaPair;
        }
