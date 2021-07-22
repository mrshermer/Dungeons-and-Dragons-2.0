import java.util.ArrayList;

public class HealHealer implements HeroAttacks{
   public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> m, Weapon w){
      double healthPoints = 0;
      
      if(w != null){      
         healthPoints = 8 + w.getWeaponDamage();
      }
      else{
         healthPoints = 8;
      }
      
      for(int a = 0; a < hero.size(); a++){
         if(hero.get(a).getHeroName().equals("Healer")){
            System.out.println(hero.get(a).getHeroName() + " health prior: " + hero.get(a).getHeroHealth());
            double newHeroHealth = healthPoints;
            
            if(hero.get(a).getHeroHealth() + newHeroHealth <= 100){
               hero.get(a).setHeroHealth(hero.get(a).getHeroHealth() + healthPoints);
               System.out.println(hero.get(a).getHeroName() + " health after: " + hero.get(a).getHeroHealth());
               System.out.println("*******************************");
            }
            else{
               System.out.println("I'm sorry, Healer health will not be updated as it would be over the max health: 100");
               System.out.println("*******************************");
            }           
        }
      }
      return m;  
   }
}