import java.util.ArrayList;

public class GlobalHeal implements HeroAttacks {
   public ArrayList<Monster> heroAttack(ArrayList<Hero> hero, ArrayList<Monster> m, Weapon w){
      int newHeroHealth = 0; 
      
      if(w != null){
         newHeroHealth = 15 + (int)w.getWeaponDamage();
      }
      else{
         newHeroHealth = 15;
      }
           
      
      for(int a = 0; a < hero.size(); a++){
         if(hero.get(a).getHeroHealth() + newHeroHealth <= 100){
            System.out.println(hero.get(a).getHeroName() + " health prior: " + hero.get(a).getHeroHealth());
            hero.get(a).setHeroHealth(hero.get(a).getHeroHealth() + newHeroHealth);
            System.out.println(hero.get(a).getHeroName() + " health after: " + hero.get(a).getHeroHealth());
            System.out.println("*******************************");
         }
         else if(hero.get(a).getHeroHealth() + newHeroHealth >= 100){
            System.out.println("I'm sorry " + hero.get(a).getHeroName() + " your health could not be updated");
            System.out.println("As it would have gone over 100 health");
            System.out.println("*******************************");
         }
         
      }
      return m;
   }
}