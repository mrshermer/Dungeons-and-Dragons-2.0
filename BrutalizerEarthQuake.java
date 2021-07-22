import java.util.ArrayList;

public class BrutalizerEarthQuake implements MonsterAttack{
   public Party attack(Party h){
      Hero hero = null;
      
      double newHeroHealth = 0;
      
      for(int a = 0; a < h.getHeroPartyList().size(); a++){
         hero = (Hero)h.getHeroPartyList().get(a);
         System.out.println(hero.getHeroName() + " hero health prior " + hero.getHeroHealth());
         newHeroHealth = hero.getHeroHealth() - 3;
         hero.setHeroHealth(newHeroHealth);
         System.out.println(hero.getHeroName() + " hero health after " + hero.getHeroHealth());
         System.out.println("*******************************");
          
         
         if(hero.getHeroHealth() <= 0){
            System.out.println(hero.getHeroName() + " hero health <= 0: hero will be removed from the party ");
            System.out.println("*******************************");
            h.removeHeroFromParty(hero);
            a--;
         }
      }
      return h;
   }

}