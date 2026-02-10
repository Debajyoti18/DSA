
class Tree {
    public ArrayList<Integer> diagonal(Node root) {
        // add your code here.
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        while( que.size() != 0){
            int size = que.size();
            while( size-- >0){
                Node rm = que.removeFirst();
                while( rm != null){
                    list.add(rm.data);
                    if(rm.left != null){
                        que.addLast(rm.left);
                    }
                    rm = rm.right;
                }
            }
        }
        return list;
    }
}