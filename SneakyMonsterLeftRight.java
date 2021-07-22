import java.util.ArrayList;

public class SneakyMonsterLeftRight implements MonsterAttack{
  public Party attack(Party hP){
      double leftAttack = 4.01;
      double rightAttack = 5.01;
      Hero h = (Hero)hP.getHeroPartyList().get(0);
      
      double newHeroHealth = h.getHeroHealth() - (leftAttack + rightAttack);
      
      System.out.println(h.getHeroName() + " health prior: " + h.getHeroHealth());
      h.setHeroHealth(newHeroHealth);
      System.out.println(h.getHeroName() + " health after: " + h.getHeroHealth());
      System.out.println("*******************************");

      
      if(h.getHeroHealth() <= 0){
         System.out.println(h.getHeroName() + " health <= 0, the hero will now be removed from the party ");
         System.out.println("*******************************");

         hP.removeHeroFromParty(h);
      }
      return hP;
  }

}