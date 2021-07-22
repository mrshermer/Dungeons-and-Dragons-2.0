import java.util.Random;

public class Level2Maze extends MazeCreation
{
   private Party party = null;

   public Level2Maze(Object[][] maze){
      initalMaze = maze;
   }
   public Object[][] constructMaze(){
      constructVerticalWalls();
      placeTraps();
      placeTraps();
      placeTreasureChests();
      placeTreasureChests();
      placeMonsters();
      placeMonsters();
      
      return initalMaze;
   }
   private void constructVerticalWalls(){
      initalMaze[1][9] = 'W';
      initalMaze[8][19] = 'F';
      initalMaze[1][1] = 'P';
      
      for(int r = 0; r < 9; r++){
         for(int c = 0; c < 20; c++){
            if(r >= 2 && r <= 6 && c == 2){
               initalMaze[r][c] = 'W';
            }
            else if(r == 5 && c >= 12 && c <= 13){
               initalMaze[r][c] = 'W';
            }
            
         }
      }
   }
   private void placeTraps(){
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
                  initalMaze[randomRowTrap][randomColTrap] = trapDecider();
                  valid = true;      
               }
            }
            randomRowTrap = randRowTrap.nextInt(9);
            randomColTrap = randColTrap.nextInt(20);
            mazeObject = initalMaze[randomRowTrap][randomColTrap];
            type = mazeObject.getClass().getSimpleName();
         }
   }
   private void placeTreasureChests(){
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
                  initalMaze[randomRowTreasure][randomColTreasure] = treasureDecider();
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
         Random randRowMonster = new Random();
         Random randColMonster = new Random();
         int localMonsterCount = 0;
         boolean valid = false;
         party = new Party();
         
         int randomRowMonster = randRowMonster.nextInt(9);
         int randomColMonster = randColMonster.nextInt(20);
         
         Object mazeObject = initalMaze[randomRowMonster][randomColMonster];
         String type = mazeObject.getClass().getSimpleName();
         
         while(!valid){
            if(type.equals("Character")){
               if((char)initalMaze[randomRowMonster][randomColMonster] == '*'){
                  if(localMonsterCount != 2){
                     party.addMonsterParty(monsterDecider());
                     localMonsterCount++;
                  }
                  if(localMonsterCount == 2){
                     initalMaze[randomRowMonster][randomColMonster] = party.getMonsterPartyList();
                     valid = true;
                  }
                        
               }
            }
            randomRowMonster = randRowMonster.nextInt(9);
            randomColMonster = randColMonster.nextInt(20);
            mazeObject = initalMaze[randomRowMonster][randomColMonster];
            type = mazeObject.getClass().getSimpleName();

         }
   }
    private Traps trapDecider(){
        Random trapRandom = new Random();
        Traps trap = null;
//        
        int randTrap = trapRandom.nextInt(3) + 1;
//        
        if(randTrap == 1){
           trap = new TransportationTrap();
        }
        else if(randTrap == 2){
           trap = new TransportToMonster();
        }
        else if(randTrap == 3){
           trap = new TrapSetBackToStart();
        }
        return trap;
// 
     }
       private TreasureChest treasureDecider(){
         Random treasureRandom = new Random();
         TreasureChest chest = null;
        
         int randTreasure = treasureRandom.nextInt(3) + 1;
        
        if(randTreasure == 1){
           chest = new LowLevelChest();
        }
        else if(randTreasure == 2){
           chest = new MediumTreasureChest();
        }
        else if(randTreasure == 3){
           chest = new HighLevelChest();
        }
        return chest;
     }
     private Monster monsterDecider(){
         Random monsterRandom = new Random();
         Monster monster = null;
        
         int randMonster = monsterRandom.nextInt(4) + 1;
        
        if(randMonster == 1){
           monster = new BrutalizerMonster();
        }
        else if(randMonster == 2){
           monster = new BugMonster();
        }
        else if(randMonster == 3){
           monster = new PoisneousMonster();
        }
        else if(randMonster == 4){
           monster = new SneakyMonster();
        }
        return monster;
        
     }
     

}