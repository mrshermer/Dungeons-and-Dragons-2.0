import java.util.ArrayList;
import java.util.Scanner;

public class ArcneBlast implements HeroAttacks
{
   public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> m, Weapon w){
      Monster monster = m.get(getMonsterIndex(m));
      double monsterHealth = 0;
      double attackDamage = 4;
      
      if(w != null){
         double weaponDamage = w.getWeaponDamage();
         monsterHealth = monster.getMonsterHealth() - (weaponDamage + attackDamage);
      }
      else{
         monsterHealth = monster.getMonsterHealth() - attackDamage;
      }
      System.out.println(monster.getMonsterName() + " health prior: " + monster.getMonsterHealth());      
      monster.setMonsterHealth(monsterHealth);
      System.out.println(monster.getMonsterName() + " health after: " + monster.getMonsterHealth());
      System.out.println("*******************************");
      
      if(monster.getMonsterHealth() <= 0){
         System.out.println(monster.getMonsterName() + " health <= 0: monster will now be removed " + 
          "from the monster party");
         System.out.println("*******************************");
         m.remove(monster);
      }
      return m;      
   }
   public int getMonsterIndex(ArrayList<Monster> m){
      System.out.println("What monster choose for attack");
      System.out.println("*******************************");
      Scanner scan = new Scanner(System.in);
      
      for(int a = 0; a < m.size(); a++){
         System.out.println(a + ") " + m.get(a).getMonsterName());
      }
      int userPick = scan.nextInt();
      
      return userPick;
      
   }
}