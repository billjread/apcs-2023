package unit10;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Maze {
    private boolean solution;
    private char[][] maze;

    public Maze(int rows, int cols, String line) {
       maze = new char[rows][cols];
       int num = 0;
       
       for(int r = 0; r < maze.length; r++){
          for(int c = 0; c < maze[0].length; c++){
             maze[r][c] = line.charAt(num);
             num++;
          }
       }




    }

    public String getStart() {
                                                                                                                           int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('@');
                                                                                                                                 return "" + z / maze[0].length + " " + z % maze[0].length;
    }

    public String getEnd() {
                                                                                                                                 int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('$');
                                                                                                                           return "" + z / maze[0].length + " " + z % maze[0].length;
    }

      private void check(int r, int c) {
         if(r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] != '#'){
            if(maze[r][c] == 'v') {
               return;
            }
            
            if(maze[r][c] == '$'){
               solution = true;
            }
            
            else {
               maze[r][c] = 'v';
               check(r, c+1);
               check(r+1, c);
               check(r, c-1);
               check(r-1, c);
               maze[r][c] = '.';
            }
         }
    }

     public boolean hasSolution() {
        String start = getStart();
        String[] starter = start.split(" ");
        int rowCoord = Integer.parseInt(starter[0]);
        int colCoord = Integer.parseInt(starter[1]);
        check(rowCoord, colCoord);
        return solution;
    }



    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
    }

    public static void main(String[] args) {
        Maze example = new Maze(3, 3, "#.@.....$");
        check(example.hasSolution());

        Maze case1 = new Maze(5, 7, ".#.#....#.#.##@.....$#...#.##..#...");
        check(case1.hasSolution());

        Maze case2 = new Maze(4, 4, ".#.$.##..##.@..#");
        check(!case2.hasSolution());

        Maze test = new Maze(3, 3, "#.@.....$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#####$");
        check(!test.hasSolution());

        test = new Maze(3, 3, "##@#..#.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "#.@#.##.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#.##.$");
        check(!test.hasSolution());

        System.out.println("Happy Panda! \uD83D\uDC3C");

    }

}