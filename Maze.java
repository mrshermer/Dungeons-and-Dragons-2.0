public class Maze
{
   private int currentLevel = 1;
   private Object[][] gameMaze = new Object[10][21];
   private MazeCreationFactory mazeFactory = null;
   
   public Maze(MazeCreationFactory mazeCreation){
      this.mazeFactory = mazeCreation;
   }
   
   
   public void setCurrentLevel(int currentLevel){
      this.currentLevel = currentLevel;
   }
   public void setMaze(Object[][] m){
      this.gameMaze = m;
   }
   
   public int getCurrentLevel(){
     return currentLevel;
   }
   public Object[][] getGameMaze(){
     return gameMaze;
   }
   public MazeCreation createMaze(Object[][] maze, int currentLevel){
      MazeCreation mC;
      
      mC = mazeFactory.createMaze(gameMaze, currentLevel);
      mC.constructMaze();
      
     gameMaze = mC.getInitialMaze();
      
      return mC;
   }
   public void displayMaze(){
      System.out.println();
      for(int a = 0; a < gameMaze.length; a++){
         for(int b = 0; b < gameMaze[a].length; b++){
            Object mazeObject = gameMaze[a][b];
            String type = mazeObject.getClass().getSimpleName();
            if(type.equals("Character")){
               if((char)gameMaze[a][b] == '*' || (char)gameMaze[a][b] == 'W' || (char)gameMaze[a][b] == 'P' || (char)gameMaze[a][b] == 'F' || (char)gameMaze[a][b] == '-' || (char)gameMaze[a][b] == '|'){
                        System.out.print(gameMaze[a][b]);
               }

            }
            else{
               System.out.print("*");
            }   
        }
         System.out.println();
      }
   }
   public void clearMazeAfterLevelComplete(){
      for(int a = 1; a < 9; a++){
         for(int b = 0; b < 20; b++){
            Object mazeObject = gameMaze[a][b];
            String type = mazeObject.getClass().getSimpleName();
            
             if(!type.equals("Character")){
                gameMaze[a][b] = '*';
             }
             else if(type.equals("Character") && (char)gameMaze[a][b] == 'P'){
                gameMaze[a][b] = '*';
             }
         }
      }
   }


}