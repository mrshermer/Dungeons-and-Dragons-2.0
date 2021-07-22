import java.util.ArrayList;

public class TheStunner implements HeroAttacks {
  public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> m, Weapon w){
      double monsterDamage = 3.01;
      if(w!= null){
         monsterDamage = 3 + (int)(0.1 + w.getWeaponDamage());
      }
             
     
      System.out.println(m.get(0).getMonsterName() + " health prior: " + m.get(0).getMonsterHealth());
      m.get(0).setMonsterHealth(m.get(0).getMonsterHealth() - monsterDamage);
      
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