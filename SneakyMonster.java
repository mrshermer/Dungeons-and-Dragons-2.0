import java.util.Random;

public class SneakyMonster extends Monster{
   private double mHealth = 30;
  

   public void decideMonsterAttack(){
       Random random = new Random();
       int sneakAttack = random.nextInt(3) + 1;
      
        if(sneakAttack == 1){
           attackMove = new SneakyMonsterInvisibleAttack();
        }
        else if(sneakAttack == 2){
          attackMove = new SneakyMonsterTheStunner();
        }
        else if(sneakAttack == 3){
          attackMove = new  SneakyMonsterLeftRight();
        }
   }
   public String getMonsterName(){
      return "SneakyMonster";
   }
   public double getMonsterHealth(){
      return mHealth;
   }
   public void setMonsterHealth(double mH){
      this.mHealth = mH;
   }
}