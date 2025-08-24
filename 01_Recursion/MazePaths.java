import java.util.ArrayList;

public class MazePaths {
    public static void main(String[] args) {
    
        ArrayList<String> result = ratInMaze(1,1,3,3);

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (String p : result) {
                System.out.print(p + " ");
            }
            System.out.println();
        }


        ArrayList<String> res = withDigonalJumps(1,1,3,3);
        if (res.isEmpty()) {
            System.out.println(-1);
        } else {
            for (String p : res) {
                System.out.print(p + " ");
            }
            System.out.println();
        }


    }
    ///////////////////  NO DIGONAL JUMPS //////////////////
        //Time -O(4 power n*n) : less efficient more stack calls .space O(n*n)
    private static ArrayList<String> ratInMaze(int sc, int sr, int dc, int dr) {
        if(sr == dr && sc == dc){
             ArrayList<String> result = new ArrayList<>();
             result.add("");
             return result;
        }
         ArrayList<String> res = new ArrayList<>();
        if(sc < dc){
             ArrayList<String> hpaths = ratInMaze(sc+1, sr, dc, dr);
             for(String s: hpaths){
                res.add("h"+s);
             }
        }
        if(sr < dr){
             ArrayList<String> vpaths = ratInMaze(sc, sr+1, dc, dr);
             for(String s: vpaths){
                res.add("v"+s);
             }
        }
        return res;
    }

    //  DIGONAL JUMPS ALLOWED//
    private static ArrayList<String> withDigonalJumps(int sc,int sr ,int dc, int dr){
        if(sr == dr && sc == dc){
             ArrayList<String> result = new ArrayList<>();
             result.add("");
             return result;
        }
        
         ArrayList<String> res = new ArrayList<>();
         // horrizontal moves
        for(int i = 1; i <=  dc - sc ; i++){
             ArrayList<String> hpaths = ratInMaze(sc+i, sr, dc, dr);
             for(String s : hpaths){
                res.add("h" + i + s);//hh1 hh2 hh3
             }

        }
        // vertical moves
        for(int i = 1; i <=  dr - sr ; i++){
             ArrayList<String> vpaths = ratInMaze(sc, sr+i, dc, dr);
             for(String s : vpaths){
                res.add("v" + i + s);//vv1 vv2 vv3
             }

        }
        //digonal moves
        for(int i = 1; i <=  dc - sc  && i<= dr - sr; i++){
             ArrayList<String> dpaths = ratInMaze(sc+i, sr+i, dc, dr);
             for(String s : dpaths){
                res.add("d" + i + s);
             }

        } 
        return  res;

    }

    
}
