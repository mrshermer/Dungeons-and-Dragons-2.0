import java.util.ArrayList;

public class PullThenStaticShock implements HeroAttacks{
   public ArrayList<Monster> heroAttack(ArrayList<Hero> h, ArrayList<Monster> m, Weapon w){
      double damageToMonster = (2 + 0.2) + (3 + 0.5) + 0.50;
      
      System.out.println(m.get(0).getMonsterName() + " health prior: " + m.get(0).getMonsterHealth());
      m.get(0).setMonsterHealth(m.get(0).getMonsterHealth() - damageToMonster);
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