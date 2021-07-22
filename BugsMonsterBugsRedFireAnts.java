import java.util.ArrayList;
import java.util.Random;

public class BugsMonsterBugsRedFireAnts implements MonsterAttack{
   public Party attack(Party hParty){
            
      Hero hero = monsterChooses(hParty);
      
      System.out.println("A monster burn effect has been placed on you: " + hero.getHeroName());
      System.out.println("*******************************");
      
      hero.addToHeroEffects(new HeroBurnEffect(3));
      
      return hParty;
   }
   private Hero monsterChooses(Party h){
      Random random = new Random();
      Hero hero = null;
      int monsterChoice = random.nextInt(h.getHeroPartyList().size());
      
      for(int a = 0; a < h.getHeroPartyList().size(); a++){
         if(a == monsterChoice){
            hero = (Hero)h.getHeroPartyList().get(a);
         }
      }
      
      return hero;
   }
}