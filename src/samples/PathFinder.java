package samples;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeMap;

public class PathFinder {
    
    //directons w.r.t a cell
    private int[][] directions = new int[][]{
        {-1,0},  // left
        {0,1},   // right
        {1,0},   // down
        {0,-1}   // up
    };
    
    public static void main(String[] args) {
        TreeMap<Integer, String> tree = new TreeMap<Integer, String>();

        // * is vacant
        // # is obstacle
        String[][] grid = new String[][]{
            {"S","*","#","*"},
            {"#","*","#","*"},
            {"#","*","#","*"},
            {"#","#","*","E"},
        };

       
        PathFinder pathFinder = new PathFinder();
        Cell start = pathFinder.new Cell(0,0); // Init position of "S"
        Cell end = pathFinder.new Cell(3,3);   // Init position of "E"
        
        ArrayList<Cell> path = pathFinder.findPath(grid, start, end);
        System.out.println("Reached here:"+path.size());

        Cell item = path.getLast();
        int steps = 0;
        if(item.equals(end)){
            while (item.previous != null){
                item = item.previous;
                steps++;
            }
            System.out.println("Num of steps:"+steps);
        }else{
            System.out.println("Could not reach E");
        }

        
        for (Cell seg : path) {
            System.out.println(seg.toString());
        }
        
    }

    ArrayList<Cell> findPath(String[][] grid, Cell start, Cell end){
        //Hard coding for now
        int rows = grid.length;
        int cols = grid[0].length;
       

        ArrayDeque<Cell> q = new ArrayDeque<Cell>();
        q.push(start);

        //Visited Array
        ArrayList<Cell> visited = new ArrayList<Cell>();

        while(!q.isEmpty()){
            Cell current = q.pop();
            visited.add(current);

            if(current.equals(end)){
                System.out.println("Reached destination - breaking loop");
                break;
            }
        
            for (int[] dir : directions) {

                int kmax = 0;
                
                if(dir[0] != 0) {
                    kmax = rows;
                }else{
                    kmax = cols;
                }

                for(int i = 1; i<kmax; i++){

                }
                int x = current.x + dir[0];
                int y = current.y + dir[1];

                Cell cellToCheck = new Cell(x,y);

                if(cellToCheck.equals(end)){
                    System.out.println("Next is destination - breaking loop");
                    cellToCheck.previous = current;
                    q.push(cellToCheck);
                    break;
                }

            
                if(cellToCheck.isValidCell(rows, cols)
                    && !visited.contains(cellToCheck)){
                    //Add condition here
                    if(grid[cellToCheck.x][cellToCheck.y] == "*"){
                        cellToCheck.previous = current;
                        q.push(cellToCheck);
                    }
                }
            }

            //System.out.println("end of loop:"+q.size());
        }


        return visited;

    }

    

    

    /**
     * InnerPathFinder
     */
    public class Cell {
    
        private int x = 0;
        private int y = 0;
        Cell previous = null;

        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean isValidCell(int rMax, int cMax){
            return x>=0 && x<rMax && y>=0 && y<cMax;
        }

        public boolean isFollowUpJumpValid(int rMax, int cMax){
            return x>=0 && x<rMax && y>=0 && y<cMax;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Cell){
                Cell other = (Cell)obj;
                return other.x == this.x && other.y == this.y;
            }else{
                return false;
            }
        }

        @Override
        public String toString() {
            return "("+x+","+y+")";
        }


    }
}
