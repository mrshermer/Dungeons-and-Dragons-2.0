import java.util.ArrayList;

public class MonsterBurnEffect extends MonsterEffect{
   private double effectDamage = 0;
   private int effectTime = 0;
   
   public MonsterBurnEffect(double damage){
      this.effectDamage = damage;
   }
   public ArrayList<Monster> performEffect(ArrayList<Monster> m, Monster h){
      System.out.println("Burn effect: Damage - " + effectDamage);
      System.out.println("*******************************");
      
      if(effectTime < 2){
         double monsterHealth = h.getMonsterHealth();
         double newMonsterHealth = monsterHealth - effectDamage;
        
         System.out.println(h.getMonsterName() + " health prior: " + h.getMonsterHealth());      
         h.setMonsterHealth(newMonsterHealth);
         System.out.println(h.getMonsterName() + " health after: " + h.getMonsterHealth());
         System.out.println("*******************************");

         effectTime++;
      }
      if(h.getMonsterHealth() <= 0){
         System.out.println(h.getMonsterName() + " health <= 0: monster will now be removed from the party");
         System.out.println("*******************************");
         h.clearMonsterEffect();
         m.remove(h);
         
      }
      if(effectTime >= 2){
         setMonsterEffectOver(true);
      }
      return m;
            
   }

}