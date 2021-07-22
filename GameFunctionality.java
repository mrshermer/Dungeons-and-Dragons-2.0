import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class GameFunctionality{
   private int userRow = 1;
   private int userCol = 1;
   Party heroParty = new Party();
   Maze maze = new Maze(new MazeCreationFactory());
   Object[][] map = maze.getGameMaze();
   private Store store = new Store();
   private Weapon weapon = null;
   private ArrayList<Monster> mParty = null;
   
   public GameFunctionality(){
      
   }
   private void loadStore(){
      store.initlizeStoreInstanceVaribles();
      store.loadUpWeaponsToStore();
   }
   private void printWelcomeMessage(){
      System.out.println("Welcome to Hero vs Monsters 2.0");
      System.out.println("*******************************");
   }
   private void loadHerosInParty(){
      Scanner numScan = new Scanner(System.in);
      Scanner heroScan = new Scanner(System.in);
      int localCountHeros = 0; 
      HeroDeciderFactory hFactory = new HeroDeciderFactory();
      Hero h = null;
      String heroChoice = "";
      
      System.out.println("Please select a number for the number " 
      + " of heros you want in your party [Max 4]");
      
      int herosInParty = numScan.nextInt();
      while(herosInParty > 4){
         System.out.println("*******************************");
         System.out.println("I'm sorry, you've entered a number greater than the max");
         herosInParty = numScan.nextInt();
      }
      
      System.out.println("Please select the heros to place in your party ");
      listHeros();
      
      while(localCountHeros < herosInParty){
         heroChoice = heroScan.nextLine();
         h = hFactory.createHero(heroChoice);
         
         while(h == null){
            System.out.println("I'm sorry, that is not a valid hero. Please select again");
            listHeros();
            heroChoice = heroScan.nextLine();
            h = hFactory.createHero(heroChoice);
         }
         heroParty.addHeroToParty(h);
         localCountHeros++;
      }
   }
   public void gameFlow(){
      printWelcomeMessage();
      loadStore();
      loadHerosInParty();  
      equipWeaponsForHeros();
      loadGameMaze();
      startGame();
      
   }
   private void listHeros(){
      System.out.println("*******************************");
      System.out.println("Mage");
      System.out.println("Robot");
      System.out.println("Healer");
      System.out.println("Sorecor");
      System.out.println("Marksmen");
      System.out.println("*******************************");
   }
   private void loadGameMaze(){
      maze.createMaze(map, maze.getCurrentLevel());
      System.out.println("Lets Begin: Please see the Level " + maze.getCurrentLevel() + " Maze");
      System.out.println("Your party is designated as 'P' in the Maze");
      System.out.println("*******************************");      
      maze.displayMaze();
   }
   private void loadNewLevel(){
      maze.clearMazeAfterLevelComplete();
      maze.setCurrentLevel(maze.getCurrentLevel() + 1);
      if(maze.getCurrentLevel() <= 3){
         System.out.println("Congrats, you now have reached level: " + maze.getCurrentLevel());
         System.out.println("*******************************");
         maze.createMaze(map, maze.getCurrentLevel());
         userCol = 1;
         userRow = 1;
         store.levelUpAllWeapons();
      }
   }
   private void equipWeaponsForHeros(){
      Scanner scan = new Scanner(System.in);
      int uChoice = 0;
      
      for(int a = 0; a < heroParty.getHeroPartyList().size(); a++){
         Hero h = (Hero)heroParty.getHeroPartyList().get(a);
         
         System.out.println("Current Hero gold: " + h.getHeroGold());
         
         
         
         if(store.areWeaponsApplicableToHero(h)){
                  h.listHeroWeapons();
                  System.out.println(h.getHeroName() + " - You can now\n 1) Buy Weapons\n Note: If your weapon belt is full, you will be prompted to drop one of weapons"
                  + " before buying\n 2) Choose to proceed with no weapons");
                  System.out.println("*******************************"); 
                  uChoice = scan.nextInt();
         
                  while(uChoice > 3){
                     System.out.println("I'm sorry, please enter the choice specified below:");
                     System.out.println("*******************************");
                     System.out.println("You can now\n 1) Buy Weapons\n Note: If your weapon belt is full, you will be prompted to drop one of weapons"
                     + " before buying\n 2) Choose to proceed with no weapons");
                     uChoice = scan.nextInt();
                  }
                  if(uChoice == 1){
                     if(h.getWeaponSet().size() == 2){
                        System.out.println("Your weapon slot is full, you must forfeit one of your weapons to proceed\n" + 
                        " Are you sure you want to proceed?" + "\n 1) Yes\n 2) No");
                        System.out.println("*******************************");
                        uChoice = scan.nextInt();
                           if(uChoice == 1){
                              weapon = h.removeWeapons();
                              store.applyWeaponStatsAfterUserDropsWeapon(weapon.getWeaponName());
                              weapon = store.buyWeaponInStore(h);
                              h.addHeroWeapons(weapon);
                           } 
                      }
                  else{
                        while( store.areWeaponsApplicableToHero(h) && uChoice != 2 && h.getWeaponSet().size() != 2){
                           System.out.println("*******************************");
                           System.out.println("Also, you now have the option to buy a maximum of 2 weapons");
                           System.out.println("To exit: please enter 2) \n or it will exit once the maximum number of weapons is reached");
                           System.out.println("To continue press any number");
                           
                           System.out.println("*******************************");
                           uChoice = scan.nextInt();
                           if(uChoice != 2){
                                 weapon = store.buyWeaponInStore(h);
                                 h.addHeroWeapons(weapon);
                           }      
                        }
                 }
         }
         if(uChoice == 2){
               System.out.println("OK");
               System.out.println("*******************************");
         }
         
       }//end of if
 
       h.listHeroWeapons();
         
      }//end of for   
   }//end of method
   public void startGame(){
      Scanner scan = new Scanner(System.in);
      Scanner uMove = new Scanner(System.in);
      
      while(!gameOver()){
         
         System.out.println("Please enter in the amount of spaces you would like to move: max[6 spaces]");
         int userMoveSpaces = scan.nextInt();
         System.out.println("You will move " + userMoveSpaces);
         System.out.println("*******************************");
      
         System.out.println("Please enter which way you would like to move");
         System.out.println("Up) To move Up\nDown) To move down\nLeft) To move left\nRight) To move right");
         System.out.println("*******************************"); 
         String userMove = uMove.nextLine();
         
         if(userMove.equals("Up")){
            heroMovesUp(userMoveSpaces);
         }
         else if(userMove.equals("Down")){
            heroMovesDown(userMoveSpaces);
         }
         else if(userMove.equals("Right")){
            heroMovesRight(userMoveSpaces);
         }
         else if(userMove.equals("Left")){
            heroMovesLeft(userMoveSpaces);
         }
      }
   }
   public boolean gameOver(){
      boolean valid = false;
      if(heroParty.getHeroPartyList().size() == 0){
         System.out.println("Nooooo, you lost all the heros in your party have been dead");
         System.out.println("**********************************************************");
         valid = true;
      }
      else if(maze.getCurrentLevel() > 3){
         System.out.println("Nice, you made it all through the levels you won!!!");
         System.out.println("**********************************************************");
         valid = true;
      }
      return valid;
   }
   private void heroMovesUp(int numSpaces){
      System.out.println("You will now move up " + numSpaces + " spaces");
      System.out.println("*******************************");
      System.out.println("Current maze");
      maze.displayMaze();
      System.out.println("*******************************");
      
      for(int a = 1; a <= numSpaces; a++){
         if(map[userRow - 1][userCol] instanceof TreasureChest){
            TreasureChest tc = (TreasureChest)map[userRow - 1][userCol];
            tc.awardGold(heroParty);
            System.out.println("Congrats, you found a treasure chest. Each of your party will be awarded " + 
            tc.treasureGoldAmount() + " gold");
            System.out.println("*******************************");

            map[userRow - 1][userCol] = '*';
         } 
         if(map[userRow - 1][userCol] instanceof Traps){
            Traps traps = (Traps)map[userRow - 1][userCol];
            traps.performTrapEffect(userRow - 1, userCol, map);
            System.out.println("Oh no, you landed on a trap. The description of the trap is found below");
            System.out.println("*******************************");

            
            map[userRow - 1][userCol] = '*';
            userRow = traps.getUserRow();
            userCol = traps.getUserCol();
            
            while(map[userRow][userCol] instanceof Traps){
               System.out.println("Oh no, you landed on another trap. The description of the trap is found below");
               System.out.println("*******************************");
               
               
               traps = (Traps)map[userRow][userCol];
               
               traps.performTrapEffect(userRow, userCol, map);
               
               map[userRow][userCol] = '*';
                               
               userRow = traps.getUserRow();
               userCol = traps.getUserCol();
            }
            maze.setMaze(map);
            
         }
         if(map[userRow - 1][userCol] instanceof ArrayList<?> || map[userRow][userCol ] instanceof ArrayList<?>){
            System.out.println("Oh no, you encournted a party of monsters, prepare for an attack");
            System.out.println("*******************************");

            if(map[userRow - 1][userCol] instanceof ArrayList<?>){
               mParty = (ArrayList<Monster>)map[userRow - 1][userCol];
               map[userRow - 1][userCol] = '*';
            }
            else{
               mParty = (ArrayList<Monster>)map[userRow][userCol];
               map[userRow][userCol] = '*';   
            }
            attack();
            a = 9;
         }
         if((char)map[userRow - 1][userCol] == 'W'){
            System.out.println("You've hit a wall, the dice will now be re rolled again");
            System.out.println("*******************************");
            
            a = 9;
         }
         if((char)map[userRow - 1][userCol] == '-'){
            System.out.println("You've hit a wall, the dice will now be re rolled again");
            System.out.println("*******************************");
            a = 9;
         }
         if((char)map[userRow - 1][userCol] == 'F'){
            a = 9;
            loadNewLevel();
         }
         if(a <= numSpaces){
            map[userRow][userCol] = '*';
            userRow--;
            maze.setMaze(map);
         }          
      }
      map[userRow][userCol] = 'P';
      maze.setMaze(map);
      maze.displayMaze();    
    }
   private void heroMovesDown(int numSpaces){
      System.out.println("You will now move down " + numSpaces + " spaces");
      System.out.println("*******************************");
      System.out.println("Current maze");
      maze.displayMaze();
      System.out.println("*******************************");
      
      for(int a = 1; a <= numSpaces; a++){
         if(map[userRow + 1][userCol] instanceof TreasureChest){
            TreasureChest tc = (TreasureChest)map[userRow + 1][userCol];
            tc.awardGold(heroParty);
            System.out.println("Congrats, you found a treasure chest. Each of your party will be awarded " + 
            tc.treasureGoldAmount() + " gold");
            System.out.println("*******************************");

            map[userRow + 1][userCol] = '*';
         } 
         if(map[userRow + 1][userCol] instanceof Traps){
            System.out.println("Oh no, you landed on a trap. The description of the trap is found below");
            System.out.println("*******************************");
            
            Traps traps = (Traps)map[userRow + 1][userCol];
            traps.performTrapEffect(userRow + 1, userCol, map);
            

            
            map[userRow + 1][userCol] = '*';
            userRow = traps.getUserRow();
            userCol = traps.getUserCol();
            
            while(map[userRow][userCol] instanceof Traps){
               traps = (Traps)map[userRow][userCol];
               traps.performTrapEffect(userRow, userCol, map);
               System.out.println("Oh no, you landed on another trap. The description of the trap is found below");
               System.out.println("*******************************");

               map[userRow][userCol] = '*';
               userRow = traps.getUserRow();
               userCol = traps.getUserCol();
            }
            maze.setMaze(map);
            
         }
         if(map[userRow + 1][userCol] instanceof ArrayList<?> || map[userRow][userCol ] instanceof ArrayList<?>){
            System.out.println("Oh no, you encournted a party of monsters, prepare for an attack");
            System.out.println("*******************************");

            if(map[userRow + 1][userCol] instanceof ArrayList<?>){
               mParty = (ArrayList<Monster>)map[userRow + 1][userCol];
               map[userRow + 1][userCol] = '*';
            }
            else{
               mParty = (ArrayList<Monster>)map[userRow][userCol];
               map[userRow][userCol] = '*';   
            }
            attack();
            a = 9;
         }
         if((char)map[userRow + 1][userCol] == 'W'){
            System.out.println("You've hit a wall, the dice will now be re rolled again");
            System.out.println("*******************************");
            
            a = 9;
         }
         if((char)map[userRow + 1][userCol] == '-'){
            System.out.println("You've hit a wall, the dice will now be re rolled again");
            System.out.println("*******************************");
            a = 9;
         }
         if((char)map[userRow + 1][userCol] == 'F'){
            a = 9;
            loadNewLevel();
         }
         if(a <= numSpaces){
            map[userRow][userCol] = '*';
            userRow++;
            maze.setMaze(map);
         }          
      }
      map[userRow][userCol] = 'P';
      maze.setMaze(map);
      maze.displayMaze();  
   }
   private void heroMovesRight(int numSpaces){
      System.out.println("You will now move right " + numSpaces + " spaces");
      System.out.println("*******************************");
      System.out.println("Current maze");
      maze.displayMaze();
      System.out.println("*******************************");
      
      for(int a = 1; a <= numSpaces; a++){
         if(map[userRow][userCol + 1] instanceof TreasureChest){
            TreasureChest tc = (TreasureChest)map[userRow][userCol + 1];
            tc.awardGold(heroParty);
            System.out.println("Congrats, you found a treasure chest. Each of your party will be awarded " + 
            tc.treasureGoldAmount() + " gold");
            System.out.println("*******************************");

            map[userRow][userCol + 1] = '*';
         } 
         if(map[userRow][userCol + 1] instanceof Traps){
            Traps traps = (Traps)map[userRow][userCol + 1];
            traps.performTrapEffect(userRow, userCol + 1, map);
            System.out.println("Oh no, you landed on a trap. The description of the trap is found below");
            System.out.println("*******************************");

            
            map[userRow][userCol + 1] = '*';
            userRow = traps.getUserRow();
            userCol = traps.getUserCol();
            
            while(map[userRow][userCol] instanceof Traps){
               traps = (Traps)map[userRow][userCol];
               traps.performTrapEffect(userRow, userCol, map);
               System.out.println("Oh no, you landed on another trap. The description of the trap is found below");
               System.out.println("*******************************");

               map[userRow][userCol] = '*';
               userRow = traps.getUserRow();
               userCol = traps.getUserCol();
            }
            maze.setMaze(map);
            
         }
         if(map[userRow][userCol + 1] instanceof ArrayList<?> || map[userRow][userCol] instanceof ArrayList<?>){
            System.out.println("Oh no, you encournted a party of monsters, prepare for an attack");
            System.out.println("*******************************");

            if(map[userRow][userCol + 1] instanceof ArrayList<?>){
               mParty = (ArrayList<Monster>)map[userRow][userCol + 1];
               map[userRow][userCol + 1] = '*';
            }
            else{
               mParty = (ArrayList<Monster>)map[userRow][userCol];
               map[userRow][userCol] = '*';   
            }
            attack();
            a = 9;
         }
         if((char)map[userRow][userCol + 1] == 'W'){
            System.out.println("You've hit a wall, the dice will now be re rolled again");
            System.out.println("*******************************");
            
            a = 9;
         }
         if((char)map[userRow][userCol + 1] == '|'){
            System.out.println("You've hit a wall, the dice will now be re rolled again");
            System.out.println("*******************************");
            a = 9;
         }
         if((char)map[userRow][userCol + 1] == 'F'){
            a = 9;
            loadNewLevel();
         }
         if(a <= numSpaces){
            map[userRow][userCol] = '*';
            userCol++;
            maze.setMaze(map);
         }          
      }
      map[userRow][userCol] = 'P';
      maze.setMaze(map);
      maze.displayMaze();  
   }
   private void heroMovesLeft(int numSpaces){
      System.out.println("You will now move left " + numSpaces + " spaces");
      System.out.println("*******************************");
      System.out.println("Current maze");
      maze.displayMaze();
      System.out.println("*******************************");
      
      for(int a = 1; a <= numSpaces; a++){
         if(map[userRow][userCol - 1] instanceof TreasureChest){
            TreasureChest tc = (TreasureChest)map[userRow][userCol - 1];
            tc.awardGold(heroParty);
            System.out.println("Congrats, you found a treasure chest. Each of your party will be awarded " + 
            tc.treasureGoldAmount() + " gold");
            System.out.println("*******************************");

            map[userRow][userCol - 1] = '*';
         } 
         if(map[userRow][userCol - 1] instanceof Traps){
            Traps traps = (Traps)map[userRow][userCol - 1];
            traps.performTrapEffect(userRow, userCol - 1, map);
            System.out.println("Oh no, you landed on a trap. The description of the trap is found below");
            System.out.println("*******************************");

            
            map[userRow][userCol] = '*';
            userRow = traps.getUserRow();
            userCol = traps.getUserCol();
            
            while(map[userRow][userCol] instanceof Traps){
               traps = (Traps)map[userRow][userCol];
               traps.performTrapEffect(userRow, userCol, map);
               System.out.println("Oh no, you landed on another trap. The description of the trap is found below");
               System.out.println("*******************************");

               map[userRow][userCol] = '*';
               userRow = traps.getUserRow();
               userCol = traps.getUserCol();
            }
            maze.setMaze(map);
            
         }
         if(map[userRow][userCol - 1] instanceof ArrayList<?> || map[userRow][userCol] instanceof ArrayList<?>){
            System.out.println("Oh no, you encournted a party of monsters, prepare for an attack");
            System.out.println("*******************************");

            if(map[userRow][userCol - 1] instanceof ArrayList<?>){
               mParty = (ArrayList<Monster>)map[userRow][userCol - 1];
               map[userRow][userCol - 1] = '*';
            }
            else{
               mParty = (ArrayList<Monster>)map[userRow][userCol];
               map[userRow][userCol] = '*';   
            }
            attack();
            a = 9;
         }
         if((char)map[userRow][userCol - 1] == 'W'){
            System.out.println("You've hit a wall, the dice will now be re rolled again");
            System.out.println("*******************************");
            
            a = 9;
         }
         if((char)map[userRow][userCol - 1] == '|'){
            System.out.println("You've hit a wall, the dice will now be re rolled again");
            System.out.println("*******************************");
            a = 9;
         }
         if((char)map[userRow][userCol - 1] == 'F'){
            a = 9;
            loadNewLevel();
         }
         if(a <= numSpaces){
            map[userRow][userCol] = '*';
            userCol--;
            maze.setMaze(map);
         }          
      }
      map[userRow][userCol] = 'P';
      maze.setMaze(map);
      maze.displayMaze();  
   }
   public void attack(){
      HeroEffect heroEffects = null;
      MonsterEffect monsterEffects = null;
      Scanner scan = new Scanner(System.in);
      int weaponPick = 0;
      Weapon weapon = null;
      
      System.out.println("Let the attack began, prior to the attack all heros will be asked if they would like to purchase");
      System.out.println(" a weapon");
      System.out.println("*******************************");
      equipWeaponsForHeros();
      
      while(!isAttackSequenceOver()){
            for(int a = 0; a < heroParty.getHeroPartyList().size() && mParty.size() != 0; a++){
               Hero hero = (Hero)heroParty.getHeroPartyList().get(a);
               System.out.println(hero.getHeroName() + " your turn to attack, prior to attack. You will be assed " + 
               " if any monster effects are attached to you");
               System.out.println("*******************************");

               
               for(int b = 0; b < hero.getHeroEffects().size(); b++){
                  heroEffects = hero.getHeroEffects().get(b);
                  heroParty = heroEffects.performHeroEffect(heroParty, hero);
                  
                  if(heroEffects.getHeroEffectOver()){
                     hero.getHeroEffects().remove(b);
                     b--;
                  }
               }
               if(!hero.getHeroImmobilized() && hero.getHeroHealth() > 0){
                  System.out.println("Woud you like to choose to attack with a weapon, press 1)");
                  System.out.println("Or, if you would like to proceed with no weapon, press 2)");
                  System.out.println("*******************************");
                  weaponPick = scan.nextInt();
                  
                  if(weaponPick == 1 && hero.weaponsAvaibleOnHeroBelt()){
                    for(int c = 0; c < hero.getWeaponSet().size(); c++){
                         if(hero.getWeaponSet().get(c).getWeaponHealth() > 0){
                           System.out.println(c + ") " + hero.getWeaponSet().get(c).getWeaponName() + " Damage: " + hero.getWeaponSet().get(c).getWeaponDamage());
                         }
                     }
                      System.out.println("*******************************");
                     weaponPick = scan.nextInt();
                     weapon = hero.getWeaponSet().get(weaponPick);
                  }
                  else if(weaponPick == 1 && !hero.weaponsAvaibleOnHeroBelt()){
                     System.out.println("I'm sorry, your current weapons have depleted by the monster, or your hero\n" + 
                     " has no weapons equiped");
                      hero.listHeroWeapons();
                      weapon = null;
                  }
                  else if(weaponPick == 2){
                     weapon = null;
                  }
                  
                  hero.decideAttackMove();
                  mParty = hero.perfomHeroAttack(heroParty, mParty, weapon);
               }
               else{
                  System.out.println("I'm sorry, you can't attack as you've been immoblized for this turn");
                  System.out.println("*******************************");
               }
            }//end of for statement for hero
            if(mParty.size() != 0 && heroParty.getHeroPartyList().size() != 0){
               System.out.println("Monster attack turn");
               System.out.println("*******************************");
            }
            for(int a = 0; a < mParty.size()&& heroParty.getHeroPartyList().size() != 0; a++){
               Monster monster = (Monster)mParty.get(a);
                              
               for(int b = 0; b < monster.getMonsterEffects().size(); b++){
                  monsterEffects = monster.getMonsterEffects().get(b);
                  mParty = monsterEffects.performEffect(mParty, monster);
                  
                  if(monsterEffects.getMonsterEffectOver()){
                     monster.getMonsterEffects().remove(b);
                     b--;
                  }
               }
               if(!monster.isMonsterImmobilized() && monster.getMonsterHealth() > 0){
                  monster.decideMonsterAttack();
                  heroParty = monster.performMonsterAttack(heroParty);
               }
               else{
                  System.out.println(monster.getMonsterName() + " is stunned for one turn, the monster won't attack");
                  System.out.println("*******************************");
               }
               
            }              
            
      }//end of while staement
      if(heroParty.getHeroPartyList().size() != 0){
         heroParty.clearHeroEffects();
      }
   }
   private boolean isAttackSequenceOver(){
      boolean attackOver = false;
      
      if(heroParty.getHeroPartyList().size() == 0){
         attackOver = true;
      }
      if(mParty.size() == 0){
         attackOver = true;
         heroParty.awardGoldToAllHerosAfterDefeatMonster();
      }
      return attackOver;
   }
   
 }//end of class