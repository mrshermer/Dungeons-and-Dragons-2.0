import java.util.ArrayList;
import java.util.Random;

public class PoisneiousMonsterEnterSwampAttack implements MonsterAttack{
   public Party attack(Party heroP){
      Random rand = new Random();
      int monsterChoice = rand.nextInt(10) + 1;
      
      
      Hero h = (Hero)heroP.getHeroPartyList().get(0);
      System.out.println(h.getHeroName() + " health prior: " + h.getHeroHealth());
      
      if(monsterChoice >= 0 && monsterChoice <= 5){
         h.setHeroHealth(h.getHeroHealth() - 3);
         System.out.println(h.getHeroName() + " health after: " + h.getHeroHealth());
         System.out.println("*******************************");
      }
      else if(monsterChoice > 5 && h.getHeroHealth() > 0){
         h.addToHeroEffects(new HeroStunEffect());
      }
      if(h.getHeroHealth() <= 0){
         System.out.println(h.getHeroName() + " health <= 0, the hero will now be removed from the party ");
         System.out.println("*******************************");

         heroP.removeHeroFromParty(h);
      }
      return heroP;
      
   }   
}