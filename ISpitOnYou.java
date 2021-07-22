import java.util.ArrayList;

public class ISpitOnYou implements HeroAttacks{
   public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> monster, Weapon w){
      double damageToMonster = 0;
      if(w != null){
         damageToMonster = 2 + (0.2 + w.getWeaponDamage());
      }
      else{
         damageToMonster = 2.02;
      }
      System.out.println(monster.get(0).getMonsterName() + " health prior: " + monster.get(0).getMonsterHealth());      
      monster.get(0).setMonsterHealth(monster.get(0).getMonsterHealth() - damageToMonster);
      System.out.println(monster.get(0).getMonsterName() + " health after: " + monster.get(0).getMonsterHealth()); 
      System.out.println("*******************************");
      
      if(monster.get(0).getMonsterHealth() <= 0){
         System.out.println(monster.get(0).getMonsterName() + " health is <= 0: monster will now be removed from the party");
         System.out.println("*******************************");
         monster.remove(monster.get(0));
      }
      return monster;
   }
}