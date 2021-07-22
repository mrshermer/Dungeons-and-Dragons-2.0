import java.util.ArrayList;
import java.util.Collections;

public class BugsMonsterTheFamaine implements MonsterAttack{
   public Party attack(Party heroParty){
     
      Collections.sort(heroParty.getHeroPartyList());
      
      Hero hero = (Hero)heroParty.getHeroPartyList().get(0);
      
      System.out.println("You have been burned and bitten" + hero.getHeroName());
      System.out.println("*******************************");
      
      hero.addToHeroEffects(new HeroBurnEffect(2));
      hero.addToHeroEffects(new HeroBiteEffect(2));
      
      Collections.sort(heroParty.getHeroPartyList(), Collections.reverseOrder());
      
      return heroParty;
   }
}   