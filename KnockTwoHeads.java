import java.util.ArrayList;

public class KnockTwoHeads implements HeroAttacks {
    
   public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> m, Weapon w){
       double weaponDamage = 0.0;
       double attackDamage = 2;
       double monsterHealth = 0;
       
       if(m.size() == 1){
          if(w != null){
             attackDamage = w.getWeaponDamage() + 2;
          }          
          
          monsterHealth = m.get(0).getMonsterHealth() - (attackDamage);
          System.out.println(m.get(0).getMonsterName() + " health prior: " + m.get(0).getMonsterHealth());
          m.get(0).setMonsterHealth(monsterHealth);
          System.out.println(m.get(0).getMonsterName() + " health after: " + m.get(0).getMonsterHealth());
          System.out.println("*******************************");
          
          if(m.get(0).getMonsterHealth() <= 0){
            System.out.println(m.get(0).getMonsterName() + " health after: " + m.get(0).getMonsterHealth());
            System.out.println("*******************************");
            m.remove(m.get(0));
          }
       }
       else if(m.size() >= 2){
          attackDamage = 3;
          if(w != null){
            attackDamage = 3 + w.getWeaponDamage();
          }
          
          for(int a = 0; a < 2; a++){
             monsterHealth = m.get(a).getMonsterHealth() - (attackDamage);
             System.out.println(m.get(a).getMonsterName() + " health prior: " + m.get(a).getMonsterHealth());
             m.get(a).setMonsterHealth(monsterHealth);
             System.out.println(m.get(a).getMonsterName() + " health after: " + m.get(a).getMonsterHealth());
             System.out.println("*******************************");
          }
       }
       return m;  
   }
}