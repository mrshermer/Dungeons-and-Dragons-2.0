import java.util.Random;

public class Level1Maze extends MazeCreation
{  
     private Party party = null;     
     
     public Level1Maze(Object[][] maze){
        initalMaze = maze;
     }
          
      public Object[][] constructMaze(){
        placeBorders();
        constructInitialMaze();
        constructVerticalWalls();
        constructHorizontalWalls();
        placeTrap();
        placeTreasureChest();
        placeMonsters();
        placeMonsters();
        
        return initalMaze;
      }
      private void placeBorders(){
         for(int a = 0; a < initalMaze.length; a++){
            for(int b = 0; b < initalMaze[a].length; b++){
               if(a == 0 && b >= 0 && b <= initalMaze[a].length){
                     initalMaze[a][b] = '-';
               }
               if(a < initalMaze.length && b == 0){
                     initalMaze[a][b] = '|';
               }
               if(a < initalMaze.length && b == initalMaze[a].length - 1){
                     initalMaze[a][b] = '|';
               }
               if(a == initalMaze.length - 1 && b < initalMaze[a].length - 1){
                     initalMaze[a][b] = '-';
               }
            }
         }
      }
      private void constructInitialMaze(){
         
         for(int r = 1; r < initalMaze.length - 1; r++){
            for(int c = 1; c < initalMaze[r].length - 1; c++){
               initalMaze[r][c] = '*';
            }
         }
         initalMaze[8][19] = 'F';
         initalMaze[1][1] = 'P';
      }
      private void constructVerticalWalls(){
         for(int r = 0; r < 9; r++){
            for(int c = 0; c < 20; c++){
               if(r == 4 && c > 0 && c <= 2){
                  initalMaze[r][c] = 'W';
               }
               else if(r== 4 && c >= 6 && c <= 12){
                   initalMaze[r][c] = 'W';
               }
               else if(r== 4 && c >= 16 && c < 20){
                   initalMaze[r][c] = 'W';
                }
            }
         }
      }
      private void constructHorizontalWalls(){
         for(int r = 0; r < 9; r++){
            for(int c = 0; c < 20; c++){
               if(r == 1 && c == 9){
                  initalMaze[r][c] = 'W';
               }
               else if(r >= 3 && r <= 5 && c == 9){
                  initalMaze[r][c] = 'W';
               }
               else if(r == 8 && c == 9){
                  initalMaze[r][c] = 'W';
               }
            }
         }
      }
      private void placeTrap(){
         Random randRowTrap = new Random();
         Random randColTrap = new Random();
         boolean valid = false;
      
         int randomRowTrap = randRowTrap.nextInt(9);
         int randomColTrap = randColTrap.nextInt(20);
         
         Object mazeObject = initalMaze[randomRowTrap][randomColTrap];
         String type = mazeObject.getClass().getSimpleName();
         
         while(!valid){
            if(type.equals("Character")){
               if((char)initalMaze[randomRowTrap][randomColTrap] == '*'){
                
                  initalMaze[randomRowTrap][randomColTrap] = new TransportationTrap(); 
                  valid = true;
               }  
            }
            randomRowTrap = randRowTrap.nextInt(9);
            randomColTrap = randColTrap.nextInt(20);
            mazeObject = initalMaze[randomRowTrap][randomColTrap];
            type = mazeObject.getClass().getSimpleName();

         }
      }
      private  void placeTreasureChest(){
         Random randRowTreasure = new Random();
         Random randColTreasure = new Random();
         boolean valid = false;
         
         int randomRowTreasure = randRowTreasure.nextInt(9);
         int randomColTreasure = randColTreasure.nextInt(20);
         
         Object mazeObject = initalMaze[randomRowTreasure][randomColTreasure];
         String type = mazeObject.getClass().getSimpleName();
         
         while(!valid){
            if(type.equals("Character")){
               if((char)initalMaze[randomRowTreasure][randomColTreasure] == '*'){
                  initalMaze[randomRowTreasure][randomColTreasure] = new LowLevelChest(); 
                  valid = true;
               }  
            }
            randomRowTreasure = randRowTreasure.nextInt(9);
            randomColTreasure = randColTreasure.nextInt(20);
            mazeObject = initalMaze[randomRowTreasure][randomColTreasure];
            type = mazeObject.getClass().getSimpleName();
         }
      }
      private void placeMonsters(){
         party = new Party();
         
         Random randRowMonster = new Random();
         Random randColMonster = new Random();
         boolean valid = false;
         
         int randomRowMonster = randRowMonster.nextInt(9);
         int randomColMonster = randColMonster.nextInt(20);
         
         Object mazeObject = initalMaze[randomRowMonster][randomColMonster];
         String type = mazeObject.getClass().getSimpleName();
         
         while(!valid){
            if(type.equals("Character")){
               if((char)initalMaze[randomRowMonster][randomColMonster] == '*'){
                  party.addMonsterParty(new BugMonster());
                  initalMaze[randomRowMonster][randomColMonster] = party.getMonsterPartyList();
                  valid = true;
               }  
            }
            randomRowMonster = randRowMonster.nextInt(9);
            randomColMonster = randColMonster.nextInt(20);
            mazeObject = initalMaze[randomRowMonster][randomColMonster];
            type = mazeObject.getClass().getSimpleName();
         }
      }
}