public class MazeCreationFactory{
  public MazeCreation createMaze(Object[][] maze, int currentLevel){
     MazeCreation mazee = null;
     
     if(currentLevel == 1){
         mazee = new Level1Maze(maze);
     }
     else if(currentLevel == 2){
         mazee = new Level2Maze(maze);
     }
     else if(currentLevel == 3){
         mazee = new Level3Maze(maze);
     }
     
     
     return mazee;
  }



}