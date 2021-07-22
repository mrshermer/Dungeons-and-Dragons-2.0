import java.util.Random;


public class PoisneousMonster extends Monster{
  private double mHealth = 20;  

   public void decideMonsterAttack(){
       Random random = new Random();
       //int poiAttack = random.nextInt(3) + 1;
       int poiAttack = 1; //change made on 7/14/2021
       
       if(poiAttack == 1){
          attackMove = new PoisneiousMonsterAcedicBurnAttack();
       }
       else if(poiAttack == 2){
          attackMove = new PoisneiousMonsterSludgeOfMudAttack();
       }
       else if(poiAttack == 3){
         attackMove = new  PoisneiousMonsterEnterSwampAttack();
       }
   }
   public String getMonsterName(){
      return "Poisneous Monster";
   }
   public double getMonsterHealth(){
      return mHealth;
   }
   public void setMonsterHealth(double mH){
      this.mHealth = mH;
   }


}