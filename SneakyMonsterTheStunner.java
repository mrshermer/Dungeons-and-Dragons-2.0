import java.util.ArrayList;
import java.util.Random;

public class SneakyMonsterTheStunner implements MonsterAttack{
   public Party attack(Party hP){
      Hero hero = pickHero(hP);
      double newHeroHealth = hero.getHeroHealth() - (3.01);
      System.out.println(hero.getHeroName() + " health prior: " + hero.getHeroHealth());
      hero.setHeroHealth(newHeroHealth);
      System.out.println(hero.getHeroName() + " health after: " + hero.getHeroHealth());
      System.out.println("*******************************");

      
      if(hero.getHeroHealth() >= 0){
         hero.addToHeroEffects(new HeroStunEffect());
      }
      else{
         System.out.println(hero.getHeroName() + " health <= 0, the hero will now be removed from the party ");
         System.out.println("*******************************");

         hP.removeHeroFromParty(hero);
      }
      return hP;
   }
   private Hero pickHero(Party hP){
      Random rand = new Random();
      int monsterPick = rand.nextInt(hP.getHeroPartyList().size());
      Hero hero = null;
      
      for(int a = 0; a < hP.getHeroPartyList().size(); a++){
         if(a == monsterPick){
            hero = (Hero)hP.getHeroPartyList().get(a); 
         }  
      }     
      return hero;
   }
}