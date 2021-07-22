import java.util.ArrayList;

public class MageSurpriseAttack implements HeroAttacks{
   public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> m, Weapon w){
      double attackDamage = 3;
      if(w != null){
         attackDamage = w.getWeaponDamage() + 3;
      }      
      System.out.println(m.get(0).getMonsterName() + " health prior: " + m.get(0).getMonsterHealth());
      for(int a = 0; a < 3; a++){
          double monsterHealth = m.get(0).getMonsterHealth() - (attackDamage);
          m.get(0).setMonsterHealth(monsterHealth); 
      }
      System.out.println(m.get(0).getMonsterName() + " health after: " + m.get(0).getMonsterHealth());
      System.out.println("*******************************");
      
      if(m.get(0).getMonsterHealth() <= 0){
         System.out.println(m.get(0).getMonsterName() + " health is <= 0: monster will now be removed from the party");
         System.out.println("*******************************");
         m.remove(m.get(0));
      }
      return m;
   }
}