import java.util.Random;

public class BrutalizerMonster extends Monster{
   private double mHealth = 30;  

   public void decideMonsterAttack(){
      Random rand = new Random();
      int monsterAttack = rand.nextInt(3) + 1;
           
       if(monsterAttack == 1){
          attackMove = new BrutalizerBangHeads();      
       }
      else if(monsterAttack == 2){
         attackMove = new BrutalizerKnockThemOnHead();
      }
      else if(monsterAttack == 3){
          attackMove = new BrutalizerEarthQuake();
      }
   }
   public String getMonsterName(){
      return "Brutalizer";
   }
   public double getMonsterHealth(){
      return mHealth;
   }
   public void setMonsterHealth(double mH){
      this.mHealth = mH;
   }
}