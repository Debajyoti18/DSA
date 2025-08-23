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
    }

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

    
}
