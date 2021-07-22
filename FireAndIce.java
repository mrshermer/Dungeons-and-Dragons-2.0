import java.util.ArrayList;
import java.util.Scanner;

public class FireAndIce implements HeroAttacks{
   public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> m, Weapon w){
       Monster monster = m.get(getMonsterIndex(m));
       double attackDamage = 5;
       
       if(w != null){
          double weaponDamage = w.getWeaponDamage();
          monster.addToEffects(new MonsterBurnEffect((attackDamage + weaponDamage)));
          monster.addToEffects(new MonsterIceEffect());
       }
       else{
          monster.addToEffects(new MonsterBurnEffect((attackDamage)));
          monster.addToEffects(new MonsterIceEffect());
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