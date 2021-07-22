import java.util.ArrayList;
import java.util.Collections;

public class BrutalizerBangHeads implements MonsterAttack{
   public Party attack(Party h){
      double firstHeroHealth = 0;
      
      
      if(h.getHeroPartyList().size() == 1){
          Hero hero = (Hero)h.getHeroPartyList().get(0);
          firstHeroHealth = hero.getHeroHealth() - 4;
          System.out.println(hero.getHeroName() + " hero health prior: " + hero.getHeroHealth());
          hero.setHeroHealth(firstHeroHealth);
          System.out.println(hero.getHeroName() + " hero health after: " + hero.getHeroHealth());
          System.out.println("*******************************");
                    
          if(hero.getHeroHealth() <= 0){
              System.out.println(hero.getHeroName() + " health <= 0: monster will now be removed " + 
              "from the Hero party");
              System.out.println("*******************************");

              h.removeHeroFromParty(hero);
          }
      }
      else if(h.getHeroPartyList().size() > 1){
          Collections.sort(h.getHeroPartyList());

          Hero hero = (Hero)h.getHeroPartyList().get(0);
          Hero heroTwo = (Hero)h.getHeroPartyList().get(1);            
          firstHeroHealth = hero.getHeroHealth() - 4;
          double secondHeroHealth = heroTwo.getHeroHealth() - 4;
          
          System.out.println(hero.getHeroName() + " hero one health before: " + hero.getHeroHealth());
          hero.setHeroHealth(firstHeroHealth);
          System.out.println(hero.getHeroName() + " hero one health prior: " + hero.getHeroHealth());
          System.out.println("*******************************");
          
          System.out.println(heroTwo.getHeroName() + " hero two health before: " + heroTwo.getHeroHealth());
          heroTwo.setHeroHealth(secondHeroHealth);
          System.out.println(heroTwo.getHeroName() + " hero two health prior: " + heroTwo.getHeroHealth());
          System.out.println("*******************************");
          
          if(hero.getHeroHealth() <= 0){
            System.out.println(hero.getHeroName() + " health is <= 0: hero will now be removed from the party");
            System.out.println("*******************************");
            h.removeHeroFromParty(hero);
          }
          if(heroTwo.getHeroHealth() <= 0){
            System.out.println(heroTwo.getHeroName() + " health is <= 0: hero will now be removed from the party");
            System.out.println("*******************************");
            h.removeHeroFromParty(heroTwo);
          }
      }
      return h;
   }


}