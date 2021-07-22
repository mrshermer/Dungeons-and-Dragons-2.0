import java.util.ArrayList;

public class Gotcha implements HeroAttacks{
   public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> m, Weapon w){
      double damageToMonster = 0;
      
      if(w!= null){
         damageToMonster = 1 + (0.1 + w.getWeaponDamage());
      }
      else{
         damageToMonster = 1.01;
      }
      Monster monster = m.get(0);
      System.out.println(monster.getMonsterName() + " monster health prior: " + monster.getMonsterHealth());
      monster.setMonsterHealth(monster.getMonsterHealth() - damageToMonster);
      System.out.println(monster.getMonsterName() + " monster health after: " + monster.getMonsterHealth());
      System.out.println("*******************************");
      
      if(monster.getMonsterHealth() <= 0){
         System.out.println(monster.getMonsterName() + " health <= 0: monster will now be removed from the party");
         System.out.println("*******************************");
         
         m.remove(monster);
      }
      return m;      
   }
}