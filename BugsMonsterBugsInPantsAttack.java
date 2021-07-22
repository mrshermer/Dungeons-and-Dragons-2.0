import java.util.ArrayList;
import java.util.Random;

public class BugsMonsterBugsInPantsAttack implements MonsterAttack{
   public Party attack(Party h){
           
      Hero hero = monsterChooseHero(h);
      System.out.println(hero.getHeroName() + " hero health prior " + hero.getHeroHealth());
      
      for(int a = 0; a < 2; a++){
         hero.setHeroHealth(hero.getHeroHealth() - 3);
      }
      System.out.println(hero.getHeroName() + " hero health after " + hero.getHeroHealth());
      System.out.println("*******************************");
      
      if(hero.getHeroHealth() <= 0){
         System.out.println(hero.getHeroName() + " health <= 0: hero will now be removed from the party ");
         System.out.println("*******************************");
         h.removeHeroFromParty(hero);
      }
      return h;
   }
   private Hero monsterChooseHero(Party h){
      Random random = new Random();
      int monsterChoice = random.nextInt(h.getHeroPartyList().size());
      Hero hero = null;
      
      for(int a = 0; a < h.getHeroPartyList().size(); a++){
         if(a == monsterChoice){
            hero = (Hero)h.getHeroPartyList().get(a);
         }
      }
      return hero;
   }

}