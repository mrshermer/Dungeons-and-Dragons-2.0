import java.util.ArrayList;

public class StaticShock implements HeroAttacks{
   public ArrayList<Monster> heroAttack(ArrayList<Hero> h, ArrayList<Monster> m, Weapon w){
       double monsterDamage = (3 + 0.5) + 0.50;
       
       Monster monster = m.get(0);
       System.out.println(m.get(0).getMonsterName() + " health prior: " + m.get(0).getMonsterHealth());
       
       monster.setMonsterHealth(m.get(0).getMonsterHealth() - monsterDamage);
       
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