import java.util.ArrayList;
import java.util.Random;

public class PoisneiousMonsterSludgeOfMudAttack implements MonsterAttack{
   public Party attack(Party hP){
      Hero hero = pickHero(hP);
      hero.addToHeroEffects(new HeroPoisenEffect(2));
      
      return hP;
   }
   private Hero pickHero(Party hP){
      Hero hero = null;
      Random random = new Random();
      int monsterChoice = random.nextInt(hP.getHeroPartyList().size());
      
      for(int a = 0; a < hP.getHeroPartyList().size(); a++){
         if(a == monsterChoice){
           hero = (Hero)hP.getHeroPartyList().get(a);
         }
      }
      return hero;      
   }
}