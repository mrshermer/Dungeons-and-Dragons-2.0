import java.util.ArrayList;

public class SpinAttack implements HeroAttacks{
    public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> m, Weapon w){
        double attackDamage = 3;
        if(w != null){
            attackDamage = 3 + w.getWeaponDamage();
        }
        
        double monsterHealth = m.get(0).getMonsterHealth() - (attackDamage);
        System.out.println(m.get(0).getMonsterName() + " health prior: " + m.get(0).getMonsterHealth());        
        m.get(0).setMonsterHealth(monsterHealth);
        
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