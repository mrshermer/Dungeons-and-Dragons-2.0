import java.util.ArrayList;
import java.util.Collections;

public class SneakyMonsterInvisibleAttack implements MonsterAttack{
   public Party attack(Party hP){
      Collections.sort(hP.getHeroPartyList());
      Hero h = (Hero)hP.getHeroPartyList().get(0);
      
      double newHeroHealth = h.getHeroHealth() - 2.05;
      System.out.println(h.getHeroName() + " health after: " + h.getHeroHealth());      
      h.setHeroHealth(newHeroHealth);
      System.out.println(h.getHeroName() + " health after: " + h.getHeroHealth());
      System.out.println("*******************************");
      
      Collections.sort(hP.getHeroPartyList(), Collections.reverseOrder());
      
      if(h.getHeroHealth() <= 0){
         System.out.println(h.getHeroName() + " health <= 0, the hero will now be removed from the party ");
         System.out.println("*******************************");
         hP.removeHeroFromParty(h);
      }      
      return hP;
   }

}