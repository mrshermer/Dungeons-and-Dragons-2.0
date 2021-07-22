import java.util.Random;

public class BugMonster extends Monster{
   private double mHealth = 10;

   public void decideMonsterAttack(){
      Random rand = new Random();
      int monsterChoice = rand.nextInt(3) + 1;
      
      if(monsterChoice == 1){
         attackMove = new BugsMonsterBugsInPantsAttack();
      }
      else if(monsterChoice == 2){
         attackMove = new BugsMonsterBugsRedFireAnts();
      }
      else if(monsterChoice == 3){
         attackMove = new BugsMonsterTheFamaine();
      }
   }
   public String getMonsterName(){
      return "Bugs";
   }
   public double getMonsterHealth(){
      return mHealth;
   }
   public void setMonsterHealth(double mH){
      this.mHealth = mH;
   }


}