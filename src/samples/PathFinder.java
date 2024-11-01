package samples;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class PathFinder {
    
    //directons w.r.t a cell
    private int[][] directions = new int[][]{
        {-1,0},  // left
        {0,1},   // right
        {1,0},   // down
        {0,-1}   // up
    };
    
    public static void main(String[] args) {
        
        // * is vacant
        // # is obstacle
        String[][] grid = new String[][]{
            {"E","*","*","*"},
            {"#","*","#","*"},
            {"#","*","#","*"},
            {"#","S","*","*"},
        };

       
        PathFinder pathFinder = new PathFinder();

        Cell start = pathFinder.new Cell(0, 0);//pathFinder.new Cell(0,0); // Init position of "S"
        Cell end = pathFinder.new Cell(0,0);   // Init position of "E"

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == "S"){
                    start.x = i;
                    start.y = j; 
                }

                if(grid[i][j] == "E"){
                    end.x = i;
                    end.y = j; 
                }
            }
        }

        
        
        ArrayList<Cell> path = pathFinder.findPath(grid, start, end);
        System.out.println("Reached here:"+path.size());

        Cell item = path.getLast();
        int steps = 0;
        if(item.equals(end)){
            while (item.previous != null){
                item = item.previous;
                System.out.println(item.toString());
                steps++;
            }
            System.out.println("Num of steps:"+steps);
        }else{
            System.out.println("Could not reach E");
        }

        
        for (Cell seg : path) {
            //System.out.println(seg.toString());
        }
        
    }

    ArrayList<Cell> findPath(String[][] grid, Cell start, Cell end){
        //Hard coding for now
        int rows = grid.length;
        int cols = grid[0].length;
        boolean hasReachedEnd = false;
       
        

        ArrayDeque<Cell> q = new ArrayDeque<Cell>();
        q.push(start);

        //Visited Array
        ArrayList<Cell> visited = new ArrayList<Cell>();

        while(!q.isEmpty()){
            Cell current = q.pop();
            visited.add(current);

            if(current.equals(end) || hasReachedEnd){
                System.out.println("Reached destination - breaking loop");
                break;
            }
        
            for (int[] dir : directions) {

                int kmax = 0;
                
                if(dir[0] != 0) {
                    kmax = cols;
                }else{
                    kmax = rows;
                }

                for(int jump = 1; jump<kmax-1; jump++){

                    int x = current.x + dir[0] * jump;
                    int y = current.y + dir[1] * jump;

                    Cell cellToCheck = new Cell(x,y);

                    if(cellToCheck.isValidCell(rows, cols)
                        //&& !visited.contains(cellToCheck)
                        //&& !q.contains(cellToCheck)
                        ){

                        if(jump > 1 && grid[cellToCheck.x][cellToCheck.y] == "*"){
                            System.out.println("jumped and landed at ("+cellToCheck.x+","+cellToCheck.y+") by "+jump);
                            cellToCheck.x+=dir[0];
                            cellToCheck.y+=dir[1];

                            if(!cellToCheck.isValidCell(rows, cols)) continue;
                        
                        }

                        if(!visited.contains(cellToCheck) && !q.contains(cellToCheck)){
                            //Add condition here
                            if(grid[cellToCheck.x][cellToCheck.y] == "*"){
                                cellToCheck.previous = current;
                                q.add(cellToCheck);
                            }

                            else if(grid[cellToCheck.x][cellToCheck.y] == "E"){
                                cellToCheck.previous = current;
                                q.push(cellToCheck);
                                hasReachedEnd = true;
                                break;
                            }
                        }

                        
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
